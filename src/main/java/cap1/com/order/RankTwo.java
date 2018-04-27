package cap1.com.order;

import org.springframework.stereotype.Component;

@Component
public class RankTwo  implements  Ranks{

    private String rank = "RankTwo";

    public String toString(){
        return this.rank;
    }
}
