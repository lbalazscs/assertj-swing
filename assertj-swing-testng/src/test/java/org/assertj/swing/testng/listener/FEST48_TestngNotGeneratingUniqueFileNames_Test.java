/*
 * Created on Feb 15, 2009
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
 * Copyright @2009 the original author or authors.
 */
package org.assertj.swing.testng.listener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.testng.listener.ScreenshotFileNameGenerator.screenshotFileNameFrom;
import static org.fest.util.Arrays.array;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for issue <a href="https://kenai.com/jira/browse/FEST-48" target="_blank">FEST-48</a>.
 * 
 * @author Alex Ruiz
 */
public class FEST48_TestngNotGeneratingUniqueFileNames_Test {

  private TestResultStub testResult;

  @Before
  public void setUp() {
    testResult = new TestResultStub();
  }

  @Test
  public void should_generate_different_file_names_using_parameter_values() {
    testResult.getMethod().setMethodName("myMethod");
    testResult.getTestClass().setName("MyClass");
    assertThat(screenshotFileNameFrom(testResult)).isEqualTo("MyClass.myMethod.png");
    testResult.setParameters(array("one", "two"));
    assertThat(screenshotFileNameFrom(testResult)).isEqualTo("MyClass.myMethod.one.two.png");
  }

  @Test
  public void should_generate_file_names_even_if_parameter_value_is_null() {
    testResult.getMethod().setMethodName("myMethod");
    testResult.getTestClass().setName("MyClass");
    testResult.setParameters(array("one", null));
    assertThat(screenshotFileNameFrom(testResult)).isEqualTo("MyClass.myMethod.one.[null].png");
  }
}
