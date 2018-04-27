public class MyServiceImpl {
    public String getName()
    {
        return name;
    }
    void initMethod()
    {
        System.out.println("name:"+name);
    }
    public void setName(String name) {
        this.name = name;
    }

    private String name;
    MyServiceImpl(){
        System.out.println("MyServiceImpl");
    }
}
