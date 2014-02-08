/*
 * Created on Nov 29, 2009
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2009-2013 the original author or authors.
 */
package org.fest.swing.driver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fest.swing.core.MouseButton.LEFT_BUTTON;
import static org.fest.swing.test.core.CommonAssertions.assertThatErrorCauseIsDisabledComponent;
import static org.fest.swing.test.core.CommonAssertions.assertThatErrorCauseIsNotShowingComponent;
import static org.fest.swing.test.core.CommonAssertions.failWhenExpectingException;

import javax.swing.JTree;

import org.fest.swing.test.recorder.ClickRecorder;
import org.fest.swing.test.recorder.ClickRecorderManager;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for {@link JTreeDriver#clickRow(JTree, int)}.
 * 
 * @author Alex Ruiz
 */
public class JTreeDriver_clickRow_Test extends JTreeDriver_clickCell_TestCase {
  @Rule
  public ClickRecorderManager clickRecorder = new ClickRecorderManager();

  @Test
  public void should_click_cell() {
    showWindow();
    ClickRecorder recorder = clickRecorder.attachDirectlyTo(tree);
    int row = 5;
    driver.clickRow(tree, row);
    recorder.clicked(LEFT_BUTTON).timesClicked(1);
    assertThat(rowAt(recorder.pointClicked())).isEqualTo(row);
  }

  @Test
  public void should_throw_error_if_JTree_is_disabled() {
    disableTree();
    try {
      driver.clickRow(tree, 0);
      failWhenExpectingException();
    } catch (IllegalStateException e) {
      assertThatErrorCauseIsDisabledComponent(e);
    }
  }

  @Test
  public void should_throw_error_if_JTree_is_not_showing_on_the_screen() {
    try {
      driver.clickRow(tree, 0);
      failWhenExpectingException();
    } catch (IllegalStateException e) {
      assertThatErrorCauseIsNotShowingComponent(e);
    }
  }
}
