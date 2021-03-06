/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2018 the original author or authors.
 */
package org.assertj.swing.driver;

import static org.assertj.swing.edt.GuiActionRunner.execute;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.swing.JList;

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.cell.JListCellReader;

/**
 * Returns the {@code String} that represents the single selection of a given {@code JList}. This query is executed in
 * the event dispatch thread (EDT).
 *
 * @author Alex Ruiz
 */
final class JListSelectionValueQuery {
  static final Object NO_SELECTION_VALUE = new Object();

  @RunsInEDT
  static @Nullable Object singleSelectionValue(final @Nonnull JList<?> list, final @Nonnull JListCellReader cellReader) {
    return execute(() -> {
      int selectedIndex = list.getSelectedIndex();
      return (selectedIndex >= 0) ? cellReader.valueAt(list, selectedIndex) : NO_SELECTION_VALUE;
    });
  }

  private JListSelectionValueQuery() {
  }
}
