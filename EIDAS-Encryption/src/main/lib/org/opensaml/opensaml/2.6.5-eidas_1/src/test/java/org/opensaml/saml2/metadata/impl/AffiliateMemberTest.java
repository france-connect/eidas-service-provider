/*
 * Licensed to the University Corporation for Advanced Internet Development, 
 * Inc. (UCAID) under one or more contributor license agreements.  See the 
 * NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The UCAID licenses this file to You under the Apache 
 * License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.saml2.metadata.impl;

import javax.xml.namespace.QName;

import org.opensaml.common.BaseSAMLObjectProviderTestCase;
import org.opensaml.common.xml.SAMLConstants;
import org.opensaml.saml2.metadata.AffiliateMember;

/**
 * Test case for creating, marshalling, and unmarshalling
 * {@link org.opensaml.saml2.metadata.impl.AffiliateMemberImpl}.
 */
public class AffiliateMemberTest extends BaseSAMLObjectProviderTestCase {
    
    protected String expectedMemberID;
    
    public AffiliateMemberTest(){
        singleElementFile = "/data/org/opensaml/saml2/metadata/impl/AffiliateMember.xml";
    }
    
    /** {@inheritDoc} */
    protected void setUp() throws Exception {
        super.setUp();

        expectedMemberID = "urn:example.org:members:foo";
    }

    /** {@inheritDoc} */
    public void testSingleElementUnmarshall() {
        AffiliateMember member = (AffiliateMember)unmarshallElement(singleElementFile);
        
        String memberID = member.getID();
        assertEquals("Affiliation memeber ID was " + memberID + ", expected " + expectedMemberID, expectedMemberID, memberID);
    }

    /** {@inheritDoc} */
    public void testSingleElementMarshall() {
        QName qname = new QName(SAMLConstants.SAML20MD_NS, AffiliateMember.DEFAULT_ELEMENT_LOCAL_NAME, SAMLConstants.SAML20MD_PREFIX);
        AffiliateMember member = (AffiliateMember) buildXMLObject(qname);
        
        member.setID(expectedMemberID);
        
        assertEquals(expectedDOM, member);
    }

}