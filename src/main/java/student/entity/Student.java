package student.entity;

public class Student {

    private final Integer studentID;

    private final String name;

    public Student(Integer studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                '}';
    }
}
