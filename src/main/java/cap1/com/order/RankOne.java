package cap1.com.order;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("a")
public class RankOne implements Ranks {
    private String rank = "RankOne";

    public String toString(){
        return this.rank;
    }
}
