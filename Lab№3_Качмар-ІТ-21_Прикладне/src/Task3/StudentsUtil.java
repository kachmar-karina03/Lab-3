package Task3;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsUtil {
    //● метод для добавлення нового предмету усім студентам.
    public static List<Student> addSubject(final List<Student> students, final Subject subject) {
        for (final Student st: students) {
            st.addSubject(subject);
        }

        return students;
    }

    public static void print(final List<Student> students) {
        System.out.println("Students List: ");
        for (final Student st: students) {
            System.out.println(st.toString());
        }
    }

    public static void printEnglishMarks(final List<Mark> marks) {
        System.out.println("English Marks: ");
        for (final Mark m: marks) {
            System.out.println(m.getMark());
        }
    }

    public static void print(final Map<Integer, Student> studentMap) {
        System.out.println("Students Map: ");
        System.out.println(studentMap);
    }

    public static void printSimple(final List<StudentSimple> students) {
        System.out.println("StudentsSimple List: ");
        for (final StudentSimple st: students) {
            System.out.println(st.toString());
        }
    }

    //● студент з найвищим середнім балом
    public static Student getBestStudent(final List<Student> students) {
        double bestAvgMark = 0.0;
        Student bestStudent = null;
        for (final Student student : students) {
            if (bestStudent == null) {
                bestAvgMark = student.getAvgMark();
                bestStudent = student;
            }
            if (student.getAvgMark() > bestAvgMark) {
                bestAvgMark = student.getAvgMark();
                bestStudent = student;
            }
        }
        return bestStudent;
    }

    public static List<StudentSimple> transform(final List<Student> students) {
        return students.stream()
                .map(student -> new StudentSimple(student.getId(), student.getStudentName()))
                .collect(Collectors.toList());
    }

    public static List<Student> deleteBadStudents(final List<Student> students) {
        return students.stream()
                .filter(student -> student.getAvgMark() > 3)
                .collect(Collectors.toList());
    }

    public static List<Mark> getEnglishMark(final List<Student> students) {
        return students.stream()
                .filter(student -> student.getEnglishMark() != null)
                .map(student -> student.getEnglishMark())
                .distinct()
                .collect(Collectors.toList())
                ;
    }

    public static List<Student> sortStudents(final List<Student> students) {
        return students.stream()
                .sorted((o1, o2) -> {
                    return (o1.getStudentLastName() != o2.getStudentLastName()) ?
                            o1.getStudentLastName().compareTo(o2.getStudentLastName())
                            :
                            (o1.getStudentName() != o2.getStudentName()) ?
                                    o1.getStudentName().compareTo(o2.getStudentName())
                                    :
                                    o1.getStudentMiddleName().compareTo(o2.getStudentMiddleName());
                }).collect(Collectors.toList());
    }

    public static String getBestStudentStream(final List<Student> students) {
        return students.stream()
                .reduce((a, b) -> a.getAvgMark() > b.getAvgMark() ? a : b)
                .get()
                .toString();
    }

    public static String addHyphen(final List<Student> students) {
        return students.stream()
                .map(student -> student.getStudentLastName())
                .reduce((s1, s2) -> s1 + "-" + s2).orElse("");
    }


}