
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
    @ASN1Sequence ( name = "ScanReportPerFixed", isSet = false )
    public class ScanReportPerFixed implements IASN1PreparedElement {
            
        @ASN1Element ( name = "person-id", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private PersonId person_id = null;
                
  
@ASN1SequenceOf( name = "obs-scan-fixed", isSetOf = false ) 

    
        @ASN1Element ( name = "obs-scan-fixed", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private java.util.Collection<ObservationScanFixed>  obs_scan_fixed = null;
                
  
        
        public PersonId getPerson_id () {
            return this.person_id;
        }

        

        public void setPerson_id (PersonId value) {
            this.person_id = value;
        }
        
  
        
        public java.util.Collection<ObservationScanFixed>  getObs_scan_fixed () {
            return this.obs_scan_fixed;
        }

        

        public void setObs_scan_fixed (java.util.Collection<ObservationScanFixed>  value) {
            this.obs_scan_fixed = value;
        }
        
  
                    
        
        public void initWithDefaults() {
            
        }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(ScanReportPerFixed.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

            
    }
            