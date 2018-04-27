package cap3.edit;

import cap3.edit.edit.ExoticTypeEditor;
import cap3.edit.edit.LongPropertyEditor;
import cap3.edit.type.ExoticType;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry propertyEditorRegistry) {
        propertyEditorRegistry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());
        propertyEditorRegistry.registerCustomEditor(Long.class, new LongPropertyEditor());
    }
}
