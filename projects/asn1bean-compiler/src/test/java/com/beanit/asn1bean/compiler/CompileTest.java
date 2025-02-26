/*
 * Copyright 2012 The ASN1bean Authors
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
 */
package com.beanit.asn1bean.compiler;

import org.junit.jupiter.api.Test;

public class CompileTest {

  private static final String GENERATED_SRC_DIR = "src/test/java-gen";
  private static final String ROOT_PACKAGE_NAME = "com.beanit.asn1bean.compiler";
  String[] args;

  // uncomment this test to regenerate BerEmbeddedPdv class:
  // @Test
  // public void testCompilingEmbeddedPdv() throws Exception {
  // args = new String[] { "-o", "../asn1bean/src/main/java/", "-p", "com.beanit.asn1bean.ber",
  // "-f",
  // "src/test/resources/embedded-pdv.asn" };
  // Compiler.main(args);
  // }

  @Test
  public void testCompilingTagging() throws Exception {
    args =
        new String[] {
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/tagging-test.asn",
          "-dv"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingCompileTests() throws Exception {

    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/compile-test.asn",
          "-l"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingModules() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/modules1.asn",
          "src/test/resources/modules2.asn"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingIsoPresentationLayer() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/iso-presentation-layer.asn",
          "-l"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingX690BerExample() throws Exception {
    args =
        new String[] {
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/x690-ber-example.asn",
          "-dv"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingMobile() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/mobile/PKIXExplicit88.asn",
          "src/test/resources/mobile/PKIXImplicit88.asn",
          "src/test/resources/mobile/RSPDefinitionsV2.2.asn",
          "-l"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingMobile2() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/mobile/PEDefinitionsV2.3.1.asn",
          "-l"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingVariousTests() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/various-tests.asn",
          "-l"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingInformationObjectClasses() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/information-object-class.asn"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingExtensionTest() throws Exception {
    args =
        new String[] {
          "-dv",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/extension-test1.asn"
        };
    Compiler.main(args);
  }

  @Test
  public void testCompilingExtensionTest2() throws Exception {
    args =
        new String[] {
          "-dv",
          "-e",
          "-o",
          GENERATED_SRC_DIR,
          "-p",
          ROOT_PACKAGE_NAME,
          "-f",
          "src/test/resources/extension-test2.asn"
        };
    Compiler.main(args);
  }

  @Test
  public void testCdr() throws Exception {
    args =
            new String[] {
                    "-dv",
                    "-e",
                    "-o",
                    GENERATED_SRC_DIR,
                    "-p",
                    ROOT_PACKAGE_NAME,
                    "-f",
                    "src/test/resources/cdr.asn"
            };
    Compiler.main(args);
  }

  @Test
  public void testIMSChargingDataTypes() throws Exception {
    args =
            new String[] {
                    "-dv",
                    "-e",
                    "-o",
                    GENERATED_SRC_DIR,
                    "-p",
                    ROOT_PACKAGE_NAME,
                    "-f",
                    "src/test/resources/cdr/IMSChargingDataTypes.asn",
                    "src/test/resources/cdr/GenericChargingDataTypes.asn",
                    "src/test/resources/cdr/MAP-CommonDataTypes.asn",
                    "src/test/resources/cdr/MAP-ER-DataTypes.asn",
                    "src/test/resources/cdr/MAP-SS-Code.asn",
                    "src/test/resources/cdr/MAP-SS-DataTypes.asn",
                    "src/test/resources/cdr/MAP-ExtensionDataTypes.asn",
                    "src/test/resources/cdr/MAP-TS-Code.asn",
                    "src/test/resources/cdr/MAP-BS-Code.asn",
                    "src/test/resources/cdr/Remote-Operation-Notation.asn",
                    "src/test/resources/cdr/CMIP-1.asn"
            };
    Compiler.main(args);
  }
}
