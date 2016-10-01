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
 * Copyright 2012-2016 the original author or authors.
 */
package org.assertj.core.api.abstract_;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.test.TestFailures.failBecauseExpectedAssertionErrorWasNotThrown;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class AbstractAssert_asInputStream_Test {

  @Test
  public void should_allow_to_perform_InputStream_assertions_on_InputStream_variable_declared_as_Object() {
    Object inputstreamAsObject = new ByteArrayInputStream(new byte[] {0xa});
    assertThat(inputstreamAsObject).asInputStream().hasSameContentAs(new ByteArrayInputStream(new byte[] {0xa}));
  }

  @Test
  public void should_fail_as_variable_runtime_type_is_not_InputStream() {
    // GIVEN
    Object greatAuthor = "Terry Pratchett";
    // WHEN
    try {
      assertThat(greatAuthor).asInputStream().hasSameContentAs(new ByteArrayInputStream(new byte[] {0xa}));
    } catch (AssertionError e) {
      // THEN
      assertThat(e).hasMessageContaining(format("Expecting:%n" +
                                                " <\"Terry Pratchett\">%n" +
                                                "to be an instance of:%n" +
                                                " <java.io.InputStream>%n" +
                                                "but was instance of:%n" +
                                                " <java.lang.String>"));
      return;
    }
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
}