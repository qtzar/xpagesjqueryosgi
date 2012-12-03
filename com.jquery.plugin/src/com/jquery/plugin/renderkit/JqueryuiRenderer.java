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
import com.jquery.plugin.components.UIJqueryui;


public class JqueryuiRenderer extends FacesRenderer {
	
    @Override
	public void decode(FacesContext context, UIComponent component) {
    }

    @Override
	public boolean getRendersChildren() {
        return true;
    }
    
    @Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

    	UIJqueryui jqueryui = (UIJqueryui)component;
    	
    	boolean rendered = component.isRendered();
    	if(!rendered) {
    		return;
    	}

    	UIViewRootEx vex = (UIViewRootEx)context.getViewRoot();
    	
    	vex.addEncodeResource(jqueryui.findjqueryUrl(context));
    	vex.addEncodeResource(jqueryui.findjqueryuiUrl(context));
    	vex.addEncodeResource(jqueryui.findjqueryuiTheme(context));
    	
    }

    @Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
    }

    @Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
    }
}
