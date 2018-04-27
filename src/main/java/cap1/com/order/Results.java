package cap1.com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Results {
    @Autowired
    private List<Ranks> ranks ;
    @Override
    public String toString(){
        return ranks.toString();
    }
}
