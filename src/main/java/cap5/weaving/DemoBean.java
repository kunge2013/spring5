package cap5.weaving;

import java.util.concurrent.TimeUnit;

public class DemoBean {
    public void run1() {
        System.out.println("run1...");
    }
    public void run2() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("run2...");
    }
}
