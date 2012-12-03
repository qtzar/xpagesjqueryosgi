/*
 * � Copyright GBS Inc 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.jquery.plugin.resources;


import com.ibm.xsp.resource.DojoModulePathResource;
import com.jquery.plugin.Activator;
import com.jquery.plugin.library.JQueryLibrary;

public class ModulePath extends DojoModulePathResource {
	public final static String NAMESPACE = JQueryLibrary.LIBRARY_RESOURCE_NAMESPACE;

	public ModulePath() {
		super(NAMESPACE, "/.ibmxspres/." + NAMESPACE + "/" + Activator.getVersion());
	}

}
