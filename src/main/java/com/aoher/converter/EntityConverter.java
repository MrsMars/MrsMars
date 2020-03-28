package com.aoher.converter;

import com.aoher.model.abstracts.AbstractBean;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.Map;

@FacesConverter(value = "entityConverter", forClass = AbstractBean.class)
public class EntityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        return value == null ? null : getAttributesFrom(uiComponent).get(value);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null && !"".equals(value)) {
            AbstractBean entity = (AbstractBean) value;

            if (entity.getId() != null) {
                addAttribute(uiComponent, entity);

                return entity.getId() != null ? String.valueOf(entity.getId()) : String.valueOf(value);
            }
        }
        return "";
    }

    private void addAttribute(UIComponent component, AbstractBean abstractBean) {
        getAttributesFrom(component).put(abstractBean.getId().toString(), abstractBean);
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
