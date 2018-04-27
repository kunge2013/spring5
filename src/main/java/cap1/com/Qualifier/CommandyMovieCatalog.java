package cap1.com.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "commandy")
public class CommandyMovieCatalog implements MovieCatalog {
    @Override
    public String moveType() {
        return "Commandy";
    }
}
