package Task3;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String studentName;
    private String studentLastName;
    private String studentMiddleName;
    private List<Subject> subjects = new LinkedList<>();
    //● Додати до класу Студент унікальний ідентифікатор.
    private Integer id;


    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(final String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentMiddleName() {
        return studentMiddleName;
    }

    public void setStudentMiddleName(final String studentMiddleName) {
        this.studentMiddleName = studentMiddleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public double getAvgMark() {
        double avg = 0.0;
        int count = 0;
        for(final Subject sb: this.subjects) {
            count++;
            avg += sb.getMark().getMark();
        }
        return avg / count;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(final String studentName) {
        this.studentName = studentName;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(final List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(final Subject subject) {
        boolean subjectExist = false;
        for (final Subject sb: this.subjects) {
            if (sb.getSubject().equals(subject.getSubject())) {
                subjectExist = true;
            }
        }
        if (!subjectExist) {
            this.subjects.add(subject);
        }
    }

    public Mark getEnglishMark() {
        for (final Subject sb: subjects) {
            if (sb.getSubject().equals("english")) {
                return sb.getMark();
            }
        }
        return null;
    }

    public Student(final String studentName, final List<Subject> subjects) {
        this.studentName = studentName;
        this.subjects = subjects;
    }

    public Student(final Integer id, final String studentName, final List<Subject> subjects) {
        this.id = id;
        this.studentName = studentName;
        this.subjects = subjects;
    }

    public Student(final Integer id, final String studentName, final String studentLastName, final String studentMiddleName, final List<Subject> subjects) {
        this.id = id;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentMiddleName = studentMiddleName;
        this.subjects = subjects;

    }

    //● метод для виведення студента з усіма оцінками.
    @Override
    public String toString() {
        return "Student{" +
                "studentFirstName='" + studentName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentMiddleName='" + studentMiddleName + '\'' +
                ", subjects=" + subjects +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Student student = (Student) o;
        return Objects.equals(studentName, student.studentName) && Objects.equals(studentLastName, student.studentLastName) && Objects.equals(studentMiddleName, student.studentMiddleName) && Objects.equals(subjects, student.subjects) && Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, studentLastName, studentMiddleName, subjects, id);
    }
}