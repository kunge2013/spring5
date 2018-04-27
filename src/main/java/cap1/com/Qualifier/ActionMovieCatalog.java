package cap1.com.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Qualifier(value = "main")
@Component
public class ActionMovieCatalog implements  MovieCatalog {
    @Override
    public String moveType() {
        return "Action";
    }
}
