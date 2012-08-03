
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
    @ASN1BoxedType ( name = "SystemType" )
    public class SystemType implements IASN1PreparedElement {
    
        @ASN1Element ( name = "SystemType", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )            

            private BITS_32 value = null;
            
            public SystemType() {
            }

            public SystemType(BITS_32 value) {
                this.value = value;
            }
            
            public void setValue(BITS_32 value) {
                this.value = value;
            }
            
            public BITS_32 getValue() {
                return this.value;
            }

	    public void initWithDefaults() {
	    }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(SystemType.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

    }
            