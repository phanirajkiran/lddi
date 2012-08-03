package x73.p20601.dim;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;



/**
 * Subclauses 6.3.2 through 6.3.9 describe the classes of the personal health device DIM. Each subclause uses
the following format:
-  The nomenclature code used to identify the class. This code is used during the configuration event to
report the class for each object and allows the manager to learn whether the object being specified is
numeric, RT-SA, or any of the other classes.
- The attributes defined by the class.
- The methods available.
-  The potential events generated by objects instantiated from the class.
-  The available services such as getting or setting attributes.
 * @author lgigante
 *
 */
public abstract class DIM {

	
	protected Hashtable<Integer, Object> objects;
	
	
	public DIM(){
		
		objects = new Hashtable<Integer, Object>(); // Handle | Numeric
		
	}
	
	public void addObjecttoDim(int handle, Object obj){
		objects.put(handle, obj);
	}
	
	public Object getObjectfromDim(int handle){
		return objects.get(handle);
	}
	
	
	public abstract int getNomenclatureCode();
	
}
