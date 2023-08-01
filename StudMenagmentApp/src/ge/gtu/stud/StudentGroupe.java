package ge.gtu.stud;

public class StudentGroupe {
    int id;
    int studentId;
    int GroupId;

    public StudentGroupe(int id, int studentId, int groupId) {
        this.id = id;
        this.studentId = studentId;
        GroupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }
}
