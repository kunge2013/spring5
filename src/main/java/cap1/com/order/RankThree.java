package cap1.com.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class RankThree implements  Ranks{
    private String rank = "RankThree";

    public String toString(){
        return this.rank;
    }
}
