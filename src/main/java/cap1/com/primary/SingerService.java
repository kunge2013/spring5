package cap1.com.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingerService {
    @Autowired
    private Singer singer;
    public String sing(){
        return singer.sing("song lyrics");
    }
}
