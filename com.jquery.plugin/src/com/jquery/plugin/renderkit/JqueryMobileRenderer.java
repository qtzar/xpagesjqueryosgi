/*
 * © Copyright IBM Corp. 2010
 * © Copyright Declan Sciolla-Lynch 2011
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

package com.jquery.plugin.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.ibm.xsp.component.UIViewRootEx;
import com.ibm.xsp.renderkit.FacesRenderer;
import com.jquery.plugin.components.UIJqueryMobile;
import com.jquery.plugin.resources.Resources;


public class JqueryMobileRenderer extends FacesRenderer {
	
    @Override
	public void decode(FacesContext context, UIComponent component) {
    }

    @Override
	public boolean getRendersChildren() {
        return true;
    }
    
    @Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

    	UIJqueryMobile jquerymobile = (UIJqueryMobile)component;
    	
    	boolean rendered = component.isRendered();
    	if(!rendered) {
    		return;
    	}

    	UIViewRootEx vex = (UIViewRootEx)context.getViewRoot();
    	
    	vex.addEncodeResource(jquerymobile.findjqueryUrl(context));
    	vex.addEncodeResource(jquerymobile.findjquerymobileUrl(context));
    	vex.addEncodeResource(Resources.jqueryMobileTheme);
    	
    }

    @Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
    }

    @Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
    }
}
