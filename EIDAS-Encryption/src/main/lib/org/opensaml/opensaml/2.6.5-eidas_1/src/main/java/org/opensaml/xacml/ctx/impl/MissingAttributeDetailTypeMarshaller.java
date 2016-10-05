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

package org.opensaml.xacml.ctx.impl;

import org.opensaml.xacml.ctx.MissingAttributeDetailType;
import org.opensaml.xacml.impl.AbstractXACMLObjectMarshaller;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.MarshallingException;
import org.w3c.dom.Element;

/** Marshaller for {@link MissingAttributeDetailType} objects. */
public class MissingAttributeDetailTypeMarshaller extends AbstractXACMLObjectMarshaller {

    /** Constructor. */
    public MissingAttributeDetailTypeMarshaller() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param targetNamespaceURI the namespace URI of either the schema type QName or element QName of the elements this
     *            marshaller operates on
     * @param targetLocalName the local name of either the schema type QName or element QName of the elements this
     *            marshaller operates on
     */
    protected MissingAttributeDetailTypeMarshaller(String targetNamespaceURI, String targetLocalName) {
        super(targetNamespaceURI, targetLocalName);
    }

    /** {@inheritDoc} */
    protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
        MissingAttributeDetailType madt = (MissingAttributeDetailType) xmlObject;

        if (madt.getAttributeId() != null) {
            domElement.setAttributeNS(null, MissingAttributeDetailType.ATTRIBUTE_ID_ATTRIB_NAME, madt.getAttributeId());
        }

        if (madt.getDataType() != null) {
            domElement.setAttributeNS(null, MissingAttributeDetailType.DATA_TYPE_ATTRIB_NAME, madt.getDataType());
        }

        if (madt.getIssuer() != null) {
            domElement.setAttributeNS(null, MissingAttributeDetailType.ISSUER_ATTRIB_NAME, madt.getIssuer());
        }
    }
 
}