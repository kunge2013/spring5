package cap5.java;

public class LianjiaObj implements  Person {
    @Override
    public String sing(String name) {
        System.out.println("链家买房子的 "+name+"歌！！");
        return "链家买房子的，谢谢大家！";
    }

    @Override
    public String dance(String name) {
        System.out.println("链家买房子的"+name+"舞！！");
        return "链家买房子的，多谢各位观众！";
    }
}
