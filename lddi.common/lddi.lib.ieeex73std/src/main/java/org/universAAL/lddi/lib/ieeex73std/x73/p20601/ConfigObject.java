/*
    Copyright 2007-2014 TSB, http://www.tsbtecnologias.es
    Technologies for Health and Well-being - Valencia, Spain

    See the NOTICE file distributed with this work for additional
    information regarding copyright ownership

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */
package org.universAAL.lddi.lib.ieeex73std.x73.p20601;
//

// This file was generated by the BinaryNotes compiler.
// See http://bnotes.sourceforge.net 
// Any modifications to this file will be lost upon recompilation of the source ASN.1. 
//

import org.universAAL.lddi.lib.ieeex73std.org.bn.*;
import org.universAAL.lddi.lib.ieeex73std.org.bn.annotations.*;
import org.universAAL.lddi.lib.ieeex73std.org.bn.annotations.constraints.*;
import org.universAAL.lddi.lib.ieeex73std.org.bn.coders.*;
import org.universAAL.lddi.lib.ieeex73std.org.bn.types.*;

@ASN1PreparedElement
@ASN1Sequence(name = "ConfigObject", isSet = false)
public class ConfigObject implements IASN1PreparedElement {

	@ASN1Element(name = "obj-class", isOptional = false, hasTag = false, hasDefaultValue = false)

	private OID_Type obj_class = null;

	@ASN1Element(name = "obj-handle", isOptional = false, hasTag = false, hasDefaultValue = false)

	private HANDLE obj_handle = null;

	@ASN1Element(name = "attributes", isOptional = false, hasTag = false, hasDefaultValue = false)

	private AttributeList attributes = null;

	public OID_Type getObj_class() {
		return this.obj_class;
	}

	public void setObj_class(OID_Type value) {
		this.obj_class = value;
	}

	public HANDLE getObj_handle() {
		return this.obj_handle;
	}

	public void setObj_handle(HANDLE value) {
		this.obj_handle = value;
	}

	public AttributeList getAttributes() {
		return this.attributes;
	}

	public void setAttributes(AttributeList value) {
		this.attributes = value;
	}

	public void initWithDefaults() {

	}

	private static IASN1PreparedElementData preparedData = CoderFactory.getInstance()
			.newPreparedElementData(ConfigObject.class);

	public IASN1PreparedElementData getPreparedData() {
		return preparedData;
	}

}
