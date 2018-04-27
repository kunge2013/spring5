package cap1.applicationEvent;

import org.springframework.context.ApplicationListener;

public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }


    public void onApplicationEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        Object o  = event.getSource();
        System.out.println("notify appropriate parties via notificationAddress..." + o);
        if(o instanceof  Object[]){
            Object[] obj = (Object[] )o;
            System.out.println(obj[0]);
            System.out.println(obj[1]);
            System.out.println(obj[2]);
        }

    }
}
