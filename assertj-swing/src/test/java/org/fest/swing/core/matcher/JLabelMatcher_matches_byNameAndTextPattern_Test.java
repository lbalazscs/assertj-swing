/*
 * Created on Jul 16, 2008
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
 * Copyright @2008-2013 the original author or authors.
 */
package org.fest.swing.core.matcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fest.swing.test.builder.JLabels.label;

import java.util.regex.Pattern;

import javax.swing.JLabel;

import org.fest.swing.test.core.EDTSafeTestCase;
import org.junit.Test;

/**
 * Tests for {@link JLabelMatcher#matches(java.awt.Component)}.
 * 
 * @author Alex Ruiz
 */
public class JLabelMatcher_matches_byNameAndTextPattern_Test extends EDTSafeTestCase {
  @Test
  public void should_return_true_if_name_is_equal_to_expected_and_text_matches_pattern() {
    JLabelMatcher matcher = JLabelMatcher.withName("label").andText(Pattern.compile("Hel.*"));
    JLabel label = label().withName("label").withText("Hello").createNew();
    assertThat(matcher.matches(label)).isTrue();
  }
}
