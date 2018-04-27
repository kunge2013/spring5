package cap1.com.primary;

import org.springframework.stereotype.Component;

@Component
public class MetalSinger implements Singer{
    @Override
    public String sing(String lyrics) {
        return "I am singing with DIO voice: "+lyrics;
    }
}
