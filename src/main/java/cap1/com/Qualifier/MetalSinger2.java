package cap1.com.Qualifier;

//@Qualifier("metalSinger2")
//@Component
public class MetalSinger2 implements Singer2 {
    @Override
    public String sing(String lyrics) {
        return "I am singing with DIO voice: "+lyrics;
    }
}
