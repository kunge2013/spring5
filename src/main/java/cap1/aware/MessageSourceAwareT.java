package cap1.aware;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.util.Locale;

public class MessageSourceAwareT implements MessageSourceAware {
    static MessageSource messageSource;
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static Object getMessage(String name){
        return messageSource.getMessage(name,new Object[]{},Locale.CHINA);
    }
}
