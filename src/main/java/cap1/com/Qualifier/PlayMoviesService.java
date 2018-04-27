package cap1.com.Qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

@Component
@Scope(value ="singleton" )
public class PlayMoviesService {

    @Resource
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    private  Set<MovieCatalog> movieCatalogs;
    @Autowired
    @Qualifier("commandy")
    private MovieCatalog actionCatalog;

    private MovieCatalog movieCatalog;

    public void setMovieCatalogs(Set<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    public Object getMovieCatalogs(){
         return movieCatalogs;
   }
   public MovieCatalog showMovie(){
        return  movieCatalog;
   }

    public MovieCatalog showMovie2(){
        return  actionCatalog;
    }
   @Autowired
   public void  prepare(@Qualifier("main")MovieCatalog movieCatalog){
       this.movieCatalog = movieCatalog;
   }
}
