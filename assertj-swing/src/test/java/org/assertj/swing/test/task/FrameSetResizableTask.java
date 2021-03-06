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
package org.assertj.swing.test.task;

import static org.assertj.swing.edt.GuiActionRunner.execute;

import java.awt.Frame;

import javax.annotation.Nonnull;

import org.assertj.swing.annotation.RunsInEDT;

/**
 * Makes a {@code Frame} resizable. This task is executed in the event dispatch thread (EDT).
 * 
 * @author Alex Ruiz
 */
public final class FrameSetResizableTask {
  @RunsInEDT
  public static void setResizable(final @Nonnull Frame frame, final boolean resizable) {
    execute(() -> frame.setResizable(resizable));
  }

  private FrameSetResizableTask() {
  }
}
