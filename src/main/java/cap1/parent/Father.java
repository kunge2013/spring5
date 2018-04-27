package cap1.parent;

public abstract class Father {
    protected String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void toTxt() {
        System.out.println(version+","+name);
    }
}
