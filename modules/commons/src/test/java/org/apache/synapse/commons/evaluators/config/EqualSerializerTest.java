/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.commons.evaluators.config;

import org.apache.synapse.commons.evaluators.Evaluator;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.om.OMElement;
import org.custommonkey.xmlunit.XMLTestCase;

public class EqualSerializerTest extends XMLTestCase {

    private EqualSerializer serializer = new EqualSerializer();
    private EqualFactory fac = new EqualFactory();

    public void testHeaderEqualSerializer() {
        String input = "<equal xmlns=\"http://ws.apache.org/ns/synapse\" type=\"header\" source=\"foo\" value=\"bar\"/>";

        try {
            Evaluator eval = fac.create(AXIOMUtil.stringToOM(input));
            OMElement output = serializer.serialize(null, eval);
            assertXMLEqual(input, output.toString());
        } catch (Exception e) {
            fail("Error while parsing the input XML");
        }
    }

    public void testParameterEqualSerializer() {
        String input = "<equal xmlns=\"http://ws.apache.org/ns/synapse\" type=\"param\" source=\"foo\" value=\"bar\"/>";

        try {
            Evaluator eval = fac.create(AXIOMUtil.stringToOM(input));
            OMElement output = serializer.serialize(null, eval);
            assertXMLEqual(input, output.toString());
        } catch (Exception e) {
            fail("Error while parsing the input XML");
        }
    }

    public void testURLEqualSerializer() {
        String input = "<equal xmlns=\"http://ws.apache.org/ns/synapse\" type=\"url\" value=\"http://foo.org\"/>";

        try {
            Evaluator eval = fac.create(AXIOMUtil.stringToOM(input));
            OMElement output = serializer.serialize(null, eval);
            assertXMLEqual(input, output.toString());
        } catch (Exception e) {
            fail("Error while parsing the input XML");
        }
    }

    public void testURLEqualSerializer2() {
        String input = "<equal xmlns=\"http://ws.apache.org/ns/synapse\" type=\"url\" value=\"http://foo.org\" source=\"protocol\"/>";

        try {
            Evaluator eval = fac.create(AXIOMUtil.stringToOM(input));
            OMElement output = serializer.serialize(null, eval);
            assertXMLEqual(input, output.toString());
        } catch (Exception e) {
            fail("Error while parsing the input XML");
        }
    }
}
