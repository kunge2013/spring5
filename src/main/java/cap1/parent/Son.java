package cap1.parent;

public class Son extends  Father{
    private String name;

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
