/*
 * Created on May 31, 2009
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
package org.fest.swing.core;

import static org.assertj.core.util.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Identifies the "main" thread.
 * 
 * @author Alex Ruiz
 */
class MainThreadIdentifier {
  @Nullable
  Thread mainThreadIn(@Nonnull Thread[] threads) {
    for (Thread t : threads) {
      if (isMain(checkNotNull(t))) {
        return t;
      }
    }
    return null;
  }

  private boolean isMain(@Nonnull Thread thread) {
    return "main".equalsIgnoreCase(thread.getName());
  }
}
