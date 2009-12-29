/*
 * Created on Dec 28, 2009
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2009 the original author or authors.
 */
package org.fest.swing.data;

import org.junit.Test;

/**
 * Tests for <code>{@link TableCellInRowByValue#rowWithValue(String...)}</code>.
 *
 * @author Alex Ruiz
 */
public class TableCellInRowByValue_rowWithValue_Test {

  @Test(expected = NullPointerException.class)
  public void should_throw_error_if_array_of_values_is_null() {
    String[] values = null;
    TableCellInRowByValue.rowWithValue(values);
  }
}