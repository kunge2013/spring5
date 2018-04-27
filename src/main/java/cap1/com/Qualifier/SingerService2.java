package cap1.com.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SingerService2 {
    @Autowired
    private Singer2 singer2;
    @Qualifier("operaSinger2")
    public String sing(){
        return singer2.sing("song lyrics");
    }
}
