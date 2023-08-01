package ge.gtu.stud;

public class Groupe
{
    String speciality="";
    String num = "";
    int id =0;
    public Groupe(String speciality, String num ,  int id )
    {
        this.speciality=speciality;
        this.num = num;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNum() {
        return num;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public String  toString()
    {
        return num;
    }
}
