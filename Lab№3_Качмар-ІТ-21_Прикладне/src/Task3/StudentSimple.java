package Task3;

public class StudentSimple {
    private String studentName;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(final String studentName) {
        this.studentName = studentName;
    }

    public StudentSimple(final String studentName) {
        this.studentName = studentName;
    }

    public StudentSimple(final Integer id, final String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "StudentSimple {" +
                "id=" + id + ", " +
                "studentName='" + studentName + '\'' +
                '}';
    }
}