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

/**
 * 
 */

package org.opensaml.saml2.metadata.impl;

import org.opensaml.saml2.metadata.AssertionConsumerService;
import org.opensaml.saml2.metadata.AttributeConsumingService;
import org.opensaml.saml2.metadata.SPSSODescriptor;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.schema.XSBooleanValue;
import org.w3c.dom.Attr;

/**
 * A thread safe Unmarshaller for {@link org.opensaml.saml2.metadata.SPSSODescriptor} objects.
 */
public class SPSSODescriptorUnmarshaller extends SSODescriptorUnmarshaller {

    /** {@inheritDoc} */
    protected void processChildElement(XMLObject parentSAMLObject, XMLObject childSAMLObject)
            throws UnmarshallingException {
        SPSSODescriptor descriptor = (SPSSODescriptor) parentSAMLObject;

        if (childSAMLObject instanceof AssertionConsumerService) {
            descriptor.getAssertionConsumerServices().add((AssertionConsumerService) childSAMLObject);
        } else if (childSAMLObject instanceof AttributeConsumingService) {
            descriptor.getAttributeConsumingServices().add((AttributeConsumingService) childSAMLObject);
        } else {
            super.processChildElement(parentSAMLObject, childSAMLObject);
        }
    }

    /** {@inheritDoc} */
    protected void processAttribute(XMLObject samlObject, Attr attribute) throws UnmarshallingException {
        SPSSODescriptor descriptor = (SPSSODescriptor) samlObject;

        if (attribute.getLocalName().equals(SPSSODescriptor.AUTH_REQUESTS_SIGNED_ATTRIB_NAME)) {
            descriptor.setAuthnRequestsSigned(XSBooleanValue.valueOf(attribute.getValue()));
        } else if (attribute.getLocalName().equals(SPSSODescriptor.WANT_ASSERTIONS_SIGNED_ATTRIB_NAME)) {
            descriptor.setWantAssertionsSigned(XSBooleanValue.valueOf(attribute.getValue()));
        } else {
            super.processAttribute(samlObject, attribute);
        }
    }
}