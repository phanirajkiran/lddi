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
    @ASN1Sequence ( name = "ScaleRangeSpec32", isSet = false )
    public class ScaleRangeSpec32 implements IASN1PreparedElement {
            
        @ASN1Element ( name = "lower-absolute-value", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private FLOAT_Type lower_absolute_value = null;
                
  
        @ASN1Element ( name = "upper-absolute-value", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private FLOAT_Type upper_absolute_value = null;
                
  
        @ASN1Element ( name = "lower-scaled-value", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private INT_U32 lower_scaled_value = null;
                
  
        @ASN1Element ( name = "upper-scaled-value", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private INT_U32 upper_scaled_value = null;
                
  
        
        public FLOAT_Type getLower_absolute_value () {
            return this.lower_absolute_value;
        }

        

        public void setLower_absolute_value (FLOAT_Type value) {
            this.lower_absolute_value = value;
        }
        
  
        
        public FLOAT_Type getUpper_absolute_value () {
            return this.upper_absolute_value;
        }

        

        public void setUpper_absolute_value (FLOAT_Type value) {
            this.upper_absolute_value = value;
        }
        
  
        
        public INT_U32 getLower_scaled_value () {
            return this.lower_scaled_value;
        }

        

        public void setLower_scaled_value (INT_U32 value) {
            this.lower_scaled_value = value;
        }
        
  
        
        public INT_U32 getUpper_scaled_value () {
            return this.upper_scaled_value;
        }

        

        public void setUpper_scaled_value (INT_U32 value) {
            this.upper_scaled_value = value;
        }
        
  
                    
        
        public void initWithDefaults() {
            
        }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ScaleRangeSpec32.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

            
    }
            