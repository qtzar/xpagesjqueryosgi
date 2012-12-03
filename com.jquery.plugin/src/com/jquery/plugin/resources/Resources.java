/*
 * © Copyright GBS Inc 2011
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

import java.util.IdentityHashMap;
import javax.faces.context.FacesContext;

import com.ibm.xsp.component.UIViewRootEx;
import com.ibm.xsp.resource.Resource;
import com.ibm.xsp.resource.ScriptResource;
import com.ibm.xsp.resource.StyleSheetResource;

public class Resources {
	// jQuery
	 public static final ScriptResource jqueryLocalJS = new ScriptResource(ResourceProvider.RESOURCE_PATH +"js/jquery-1.7.1.min.js", true);
	 
	// jQuery UI 
	 public static final ScriptResource jqueryuiLocalJS = new ScriptResource(ResourceProvider.RESOURCE_PATH +"js/jquery-ui-1.8.18.custom.min.js", true);
	 public static final StyleSheetResource jqueryuiTheme = new StyleSheetResource(ResourceProvider.RESOURCE_PATH + "css/ui/smoothness/jquery-ui.css");
	 
	// jQuery Mobile 
	 public static final ScriptResource jqueryMobileLocalJS = new ScriptResource(ResourceProvider.RESOURCE_PATH +"js/jquery.mobile-1.0.1.min.js", true);
	 public static final StyleSheetResource jqueryMobileTheme = new StyleSheetResource(ResourceProvider.RESOURCE_PATH + "css/mobile/jquery.mobile-1.0.1.min.css");
	 
	public static void addAllEncodeResources() {

	}

	public static void addEncodeResources(FacesContext context, Resource[] resources) {
		UIViewRootEx rootEx = (UIViewRootEx) context.getViewRoot();
		addEncodeResources(rootEx, resources);
	}

	public static void addEncodeResources(UIViewRootEx rootEx, Resource[] resources) {
		if (resources != null) {
			for (Resource resource : resources) {
				addEncodeResource(rootEx, resource);
			}
		}
	}

	public static void addEncodeResource(FacesContext context, Resource resource) {
		UIViewRootEx rootEx = (UIViewRootEx) context.getViewRoot();
		addEncodeResource(rootEx, resource);
	}

	@SuppressWarnings("unchecked")
	public static void addEncodeResource(UIViewRootEx rootEx, Resource resource) {
		IdentityHashMap<Resource, Boolean> m = (IdentityHashMap<Resource, Boolean>) rootEx.getEncodeProperty("genesis.EncodeResource");
		if (m == null) {
			m = new IdentityHashMap<Resource, Boolean>();
		} else {
			if (m.containsKey(resource)) {
				return;
			}
		}
		m.put(resource, Boolean.TRUE);

		rootEx.addEncodeResource(resource);
	}

}
