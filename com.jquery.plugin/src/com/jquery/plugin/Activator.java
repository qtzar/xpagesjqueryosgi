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
package com.jquery.plugin;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.ibm.commons.Platform;
import com.ibm.commons.util.StringUtil;

public class Activator extends Plugin {
	public static String PLUGIN_ID = Activator.class.getPackage().getName();
	public static boolean _debug = false;
	public static boolean _global = false;
	public static Activator instance;

	public Activator() {
		instance = this;
	}

	private static String version;

	public static String getVersion() {
		if (version == null) {
			version = (String) instance.getBundle().getHeaders().get("Bundle-Version");
		}
		return version;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		PLUGIN_ID = Activator.class.getPackage().getName();
		System.out.println("Plugin " + PLUGIN_ID + " Loaded.");
		initDebug();
		initGlobal();
	}

	public static Activator getDefault() {
		return instance;
	}

	public static boolean isGlobal() {
		return _global;
	}

	public static boolean isDebug() {
		return _debug;
	}

	public static final String GLOBAL_KEY = "xsp.osgi.global.id";

	private void initGlobal() {
		try {
			String prop = Platform.getInstance().getProperty(GLOBAL_KEY); // $NON-NLS-1$
			if (StringUtil.isEmpty(prop)) {
				prop = System.getProperty(GLOBAL_KEY); // $NON-NLS-1$
				if (StringUtil.isEmpty(prop)) {
					prop = com.ibm.xsp.model.domino.DominoUtils.getEnvironmentString(GLOBAL_KEY);
				}
			}
			if (StringUtil.isNotEmpty(prop)) {
				String[] ids = StringUtil.splitString(prop, ',');
				for (String curId : ids) {
					if (PLUGIN_ID.equalsIgnoreCase(curId.trim())) {
						_global = true;
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		if (_global) {
			System.out.println("Plugin " + Activator.PLUGIN_ID + " is global mode.");
		}
	}

	public static final String DEBUG_KEY = "xsp.osgi.debug.id";

	private void initDebug() {
		try {
			String prop = Platform.getInstance().getProperty(DEBUG_KEY); // $NON-NLS-1$
			if (StringUtil.isEmpty(prop)) {
				prop = System.getProperty(DEBUG_KEY); // $NON-NLS-1$
				if (StringUtil.isEmpty(prop)) {
					prop = com.ibm.xsp.model.domino.DominoUtils.getEnvironmentString(GLOBAL_KEY);
				}
			}
			if (StringUtil.isNotEmpty(prop)) {
				String[] ids = StringUtil.splitString(prop, ',');
				for (String curId : ids) {
					if (PLUGIN_ID.equalsIgnoreCase(curId.trim())) {
						_debug = true;
					}
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		if (_debug) {
			System.out.println("Plugin " + Activator.PLUGIN_ID + " is in debug mode.");
		}
	}
}