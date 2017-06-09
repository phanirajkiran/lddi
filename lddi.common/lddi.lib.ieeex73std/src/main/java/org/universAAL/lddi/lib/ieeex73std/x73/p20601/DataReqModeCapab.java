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
@ASN1Sequence(name = "DataReqModeCapab", isSet = false)
public class DataReqModeCapab implements IASN1PreparedElement {

	@ASN1Element(name = "data-req-mode-flags", isOptional = false, hasTag = false, hasDefaultValue = false)

	private DataReqModeFlags data_req_mode_flags = null;

	@ASN1Element(name = "data-req-init-agent-count", isOptional = false, hasTag = false, hasDefaultValue = false)

	private INT_U8 data_req_init_agent_count = null;

	@ASN1Element(name = "data-req-init-manager-count", isOptional = false, hasTag = false, hasDefaultValue = false)

	private INT_U8 data_req_init_manager_count = null;

	public DataReqModeFlags getData_req_mode_flags() {
		return this.data_req_mode_flags;
	}

	public void setData_req_mode_flags(DataReqModeFlags value) {
		this.data_req_mode_flags = value;
	}

	public INT_U8 getData_req_init_agent_count() {
		return this.data_req_init_agent_count;
	}

	public void setData_req_init_agent_count(INT_U8 value) {
		this.data_req_init_agent_count = value;
	}

	public INT_U8 getData_req_init_manager_count() {
		return this.data_req_init_manager_count;
	}

	public void setData_req_init_manager_count(INT_U8 value) {
		this.data_req_init_manager_count = value;
	}

	public void initWithDefaults() {

	}

	private static IASN1PreparedElementData preparedData = CoderFactory.getInstance()
			.newPreparedElementData(DataReqModeCapab.class);

	public IASN1PreparedElementData getPreparedData() {
		return preparedData;
	}

}
