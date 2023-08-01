package ge.gtu.stud;

public class LStudent {
    int id;
    String fName;
    String lName;
    int age;
    int grId;
    String num;
    String spec;

    public LStudent(int id, String fName, String lName, int age, int grId, String num, String spec) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.grId = grId;
        this.num = num;
        this.spec = spec;
    }

    public int getGrId() {
        return grId;
    }

    public void setGrId(int grId) {
        this.grId = grId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
