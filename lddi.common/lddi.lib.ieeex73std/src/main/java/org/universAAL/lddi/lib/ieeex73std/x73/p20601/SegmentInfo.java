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
@ASN1Sequence(name = "SegmentInfo", isSet = false)
public class SegmentInfo implements IASN1PreparedElement {

	@ASN1Element(name = "seg-inst-no", isOptional = false, hasTag = false, hasDefaultValue = false)

	private InstNumber seg_inst_no = null;

	@ASN1Element(name = "seg-info", isOptional = false, hasTag = false, hasDefaultValue = false)

	private AttributeList seg_info = null;

	public InstNumber getSeg_inst_no() {
		return this.seg_inst_no;
	}

	public void setSeg_inst_no(InstNumber value) {
		this.seg_inst_no = value;
	}

	public AttributeList getSeg_info() {
		return this.seg_info;
	}

	public void setSeg_info(AttributeList value) {
		this.seg_info = value;
	}

	public void initWithDefaults() {

	}

	private static IASN1PreparedElementData preparedData = CoderFactory.getInstance()
			.newPreparedElementData(SegmentInfo.class);

	public IASN1PreparedElementData getPreparedData() {
		return preparedData;
	}

}
