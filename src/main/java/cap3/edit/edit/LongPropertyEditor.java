package cap3.edit.edit;

import java.beans.PropertyEditorSupport;

public class LongPropertyEditor  extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text +"long 可以进行格式转换");
        this.setValue(Long.valueOf(text));
    }

}
