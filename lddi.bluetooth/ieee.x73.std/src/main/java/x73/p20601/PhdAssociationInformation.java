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
package x73.p20601;
//
// This file was generated by the BinaryNotes compiler.
// See http://bnotes.sourceforge.net 
// Any modifications to this file will be lost upon recompilation of the source ASN.1. 
//

import org.bn.*;
import org.bn.annotations.*;
import org.bn.annotations.constraints.*;
import org.bn.coders.*;
import org.bn.types.*;




    @ASN1PreparedElement
    @ASN1Sequence ( name = "PhdAssociationInformation", isSet = false )
    public class PhdAssociationInformation implements IASN1PreparedElement {
            
        @ASN1Element ( name = "protocol-version", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private ProtocolVersion protocol_version = null;
                
  
        @ASN1Element ( name = "encoding-rules", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private EncodingRules encoding_rules = null;
                
  
        @ASN1Element ( name = "nomenclature-version", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private NomenclatureVersion nomenclature_version = null;
                
  
        @ASN1Element ( name = "functional-units", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private FunctionalUnits functional_units = null;
                
  
        @ASN1Element ( name = "system-type", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private SystemType system_type = null;
                
  @ASN1OctetString( name = "" )
    
        @ASN1Element ( name = "system-id", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private byte[] system_id = null;
                
  
        @ASN1Element ( name = "dev-config-id", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private ConfigId dev_config_id = null;
                
  
        @ASN1Element ( name = "data-req-mode-capab", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private DataReqModeCapab data_req_mode_capab = null;
                
  
        @ASN1Element ( name = "option-list", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private AttributeList option_list = null;
                
  
        
        public ProtocolVersion getProtocol_version () {
            return this.protocol_version;
        }

        

        public void setProtocol_version (ProtocolVersion value) {
            this.protocol_version = value;
        }
        
  
        
        public EncodingRules getEncoding_rules () {
            return this.encoding_rules;
        }

        

        public void setEncoding_rules (EncodingRules value) {
            this.encoding_rules = value;
        }
        
  
        
        public NomenclatureVersion getNomenclature_version () {
            return this.nomenclature_version;
        }

        

        public void setNomenclature_version (NomenclatureVersion value) {
            this.nomenclature_version = value;
        }
        
  
        
        public FunctionalUnits getFunctional_units () {
            return this.functional_units;
        }

        

        public void setFunctional_units (FunctionalUnits value) {
            this.functional_units = value;
        }
        
  
        
        public SystemType getSystem_type () {
            return this.system_type;
        }

        

        public void setSystem_type (SystemType value) {
            this.system_type = value;
        }
        
  
        
        public byte[] getSystem_id () {
            return this.system_id;
        }

        

        public void setSystem_id (byte[] value) {
            this.system_id = value;
        }
        
  
        
        public ConfigId getDev_config_id () {
            return this.dev_config_id;
        }

        

        public void setDev_config_id (ConfigId value) {
            this.dev_config_id = value;
        }
        
  
        
        public DataReqModeCapab getData_req_mode_capab () {
            return this.data_req_mode_capab;
        }

        

        public void setData_req_mode_capab (DataReqModeCapab value) {
            this.data_req_mode_capab = value;
        }
        
  
        
        public AttributeList getOption_list () {
            return this.option_list;
        }

        

        public void setOption_list (AttributeList value) {
            this.option_list = value;
        }
        
  
                    
        
        public void initWithDefaults() {
            
        }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(PhdAssociationInformation.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

            
    }
            