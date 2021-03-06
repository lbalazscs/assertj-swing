/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.swing.junit.xml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.junit.xml.XmlAttribute.name;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for <code>{@link XmlAttributes#iterator()}</code>.
 * 
 * @author Alex Ruiz
 */
public class XmlAttributes_iterator_Test {

  private XmlAttributes attributes;

  @Before
  public void setUp() {
    attributes = XmlAttributes.attributes(name("firstName").value("Leia"), name("lastName").value("Organa"));
  }

  @Test
  public void should_Return_All_Attributes_In_A_Iterator() {
    Iterator<XmlAttribute> iterator = attributes.iterator();
    List<XmlAttribute> attributeList = new ArrayList<XmlAttribute>();
    while (iterator.hasNext())
      attributeList.add(iterator.next());
    assertThat(attributeList).containsExactly(name("firstName").value("Leia"), name("lastName").value("Organa"));
  }
}
