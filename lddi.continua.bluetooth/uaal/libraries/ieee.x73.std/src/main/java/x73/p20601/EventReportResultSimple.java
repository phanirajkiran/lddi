
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
    @ASN1Sequence ( name = "EventReportResultSimple", isSet = false )
    public class EventReportResultSimple implements IASN1PreparedElement {
            
        @ASN1Element ( name = "obj-handle", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private HANDLE obj_handle = null;
                
  
        @ASN1Element ( name = "currentTime", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private RelativeTime currentTime = null;
                
  
        @ASN1Element ( name = "event-type", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private OID_Type event_type = null;
                
  @ASN1Any( name = "" )
    
        @ASN1Element ( name = "event-reply-info", isOptional =  false , hasTag =  false  , hasDefaultValue =  false  )
    
	private byte[] event_reply_info = null;
                
  
        
        public HANDLE getObj_handle () {
            return this.obj_handle;
        }

        

        public void setObj_handle (HANDLE value) {
            this.obj_handle = value;
        }
        
  
        
        public RelativeTime getCurrentTime () {
            return this.currentTime;
        }

        

        public void setCurrentTime (RelativeTime value) {
            this.currentTime = value;
        }
        
  
        
        public OID_Type getEvent_type () {
            return this.event_type;
        }

        

        public void setEvent_type (OID_Type value) {
            this.event_type = value;
        }
        
  
        
        public byte[] getEvent_reply_info () {
            return this.event_reply_info;
        }

        

        public void setEvent_reply_info (byte[] value) {
            this.event_reply_info = value;
        }
        
  
                    
        
        public void initWithDefaults() {
            
        }

        private static IASN1PreparedElementData preparedData = CoderFactory.getInstance().newPreparedElementData(EventReportResultSimple.class);
        public IASN1PreparedElementData getPreparedData() {
            return preparedData;
        }

            
    }
            