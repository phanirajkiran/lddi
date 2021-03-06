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
package org.universAAL.lddi.lib.ieeex73std.x73.p20601.dim;

public interface GET_Service {

	/**
	 * The manager may request the MDS object attributes of the agent in which
	 * case the manager shall send the Remote Operation Invoke | Get command
	 * (see roiv-cmip-get in A.10.2) with the reserved handle value of 0. The
	 * agent shall respond by reporting its MDS object attributes to the manager
	 * using the Remote Operation Response | Get response (see rors-cmip-get in
	 * A.10.2). In the response to a Get MDS Object command, only attributes
	 * implemented by the agent are returned.
	 */
	public void GET();

}
