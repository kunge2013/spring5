package cap1.applicationEvent;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent{
    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test ) {
        super(new Object[]{source,address,test});
        this.address = address;
        this.test = test;
    }
}
