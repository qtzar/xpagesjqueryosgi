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

package com.jquery.plugin.components;

import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.resource.ScriptResource;
import com.jquery.plugin.resources.Resources;

public class UIJquery extends UIComponentBase {
    
    public static final String RENDERER_TYPE = "com.jquery.plugin.Jquery";
    public static final String COMPONENT_TYPE = "com.jquery.plugin.UIJquery";
    public static final String COMPONENT_FAMILY = "com.jquery.plugin";
    
    private String jqueryurl;
    
    public UIJquery() {
        setRendererType(RENDERER_TYPE);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
    
    public String getJqueryurl() {
        if (null != this.jqueryurl) {
            return this.jqueryurl;
        }
        ValueBinding _vb = getValueBinding("jqueryurl");
        if (_vb != null) {
            return (String) _vb.getValue(FacesContext.getCurrentInstance());
        } 
        return null;
    }

    public void setJqueryurl(String jqueryurl) {
        this.jqueryurl = jqueryurl;
    }
    
    public ScriptResource findJqueryurl(FacesContext context) {
        String jqueryurl = getJqueryurl();
        if(StringUtil.isEmpty(jqueryurl)) { 
        	return Resources.jqueryLocalJS;
        }
        return new ScriptResource(jqueryurl,true);
    }
    
    @Override
    public void restoreState(FacesContext _context, Object _state) {
        Object _values[] = (Object[]) _state;
        super.restoreState(_context, _values[0]);
        this.jqueryurl = (String)_values[1];
    }

    @Override
    public Object saveState(FacesContext _context) {
        Object _values[] = new Object[2];
        _values[0] = super.saveState(_context);
        _values[1] = jqueryurl;
        return _values;
    }
}