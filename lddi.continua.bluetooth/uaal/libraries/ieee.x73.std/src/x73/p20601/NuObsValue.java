
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
    @ASN1Sequence ( name = "NuObsValue", isSet = false )
    public class NuObsValue implements IASN1PreparedElement {
            
        @ASN1Element ( name = "metric-id", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private OID_Type metric_id = null;
                
  
        @ASN1Element ( name = "state", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private MeasurementStatus state = null;
                
  
        @ASN1Element ( name = "unit-code", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private OID_Type unit_code = null;
                
  
        @ASN1Element ( name = "value", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private FLOAT_Type value = null;
                
  
        
        public OID_Type getMetric_id () {
            return this.metric_id;
        }

        

        public void setMetric_id (OID_Type value) {
            this.metric_id = value;
        }
        
  
        
        public MeasurementStatus getState () {
            return this.state;
        }

        

        public void setState (MeasurementStatus value) {
            this.state = value;
        }
        
  
        
        public OID_Type getUnit_code () {
            return this.unit_code;
        }

        

        public void setUnit_code (OID_Type value) {
            this.unit_code = value;
        }
        
  
        
        public FLOAT_Type getValue () {
            return this.value;
        }

        

        public void setValue (FLOAT_Type value) {
            this.value = value;
        }
        
  
                    
        
        public void initWithDefaults() {
            
        }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(NuObsValue.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

            
    }
            