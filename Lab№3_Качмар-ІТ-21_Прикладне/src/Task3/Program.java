package Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static Task3.StudentsUtil.*;

public class Program {
    public static void main(final String[] args) {
        //Створити List студентів з оцінками з трьох предметів (Фізика, Математика, Англійська мова). Завдання:
        final List<Student> students = new ArrayList<>();

        final Subject art = new Subject("art", new Mark(10));
        final Subject bio = new Subject("bio", new Mark(12));
        final Subject math = new Subject("math", new Mark(2));
        final Subject english = new Subject("english", new Mark(3));
        final Subject physics = new Subject("physics", new Mark(4));
        final List<Subject> subjects = new ArrayList<>();
        subjects.add(math);
        subjects.add(english);
        final List<Subject> subjects2 = new ArrayList<>();
        subjects2.add(art);
        subjects2.add(bio);

        students.add(new Student(0,"Dmytro", "Andriychak", "Romanovych", subjects));
        students.add(new Student(1,"Oleh", "Kobernyk", "Stepanovych", subjects2));
        students.add(new Student(2,"Nastya", "Stepanyk", "Olehivna", subjects));

        // метод для виведення студентів з усіма їхніми оцінками.
        print(students);//initial state

        // метод для добавлення нового предмету усім студентам.
        addSubject(students, physics);

        // метод для виведення студентів з усіма їхніми оцінками.
        print(students);//After adding Subject to all Students

        // Вивести дані студента з найвищим середнім балом
        System.out.println("Best Student: ");
        final Student bestStudent = getBestStudent(students);
        System.out.println("The Best Student: " + bestStudent.getStudentName()
                + ", AvgMark: " + bestStudent.getAvgMark());

        //● Вивести Map де ключем буде унікальний ідентифікатор, а значенням - оцінки із заданого предмету (предмет задається через аргумент методу).
        final Map<Integer, Student> studentMap = new TreeMap<>();
        for(int i = 0; i < 3; i++) {
            studentMap.put(i, students.get(i));
        }
        // метод для виведення студентів з усіма їхніми оцінками.
        print(studentMap);


        System.out.println("Lab 3");
        //метод для перетворення List вхідних даних (List<Student>) у List<StudentSimple>;
        System.out.println("Transform List<Student> to List<StudentSimple>");
        printSimple(transform(students));
        //метод для видалення усіх студентів з середнім балом < 3;
        System.out.println("Delete bad students where average mark is less than 3 ");
        printSimple(transform(deleteBadStudents(students)));
        //метод для виведення усіх оцінок з Англійської Мови без повторень;
        System.out.println("Print all English marks");
        printEnglishMarks(getEnglishMark(students));
        //метод для сортування списку студентів за прізвищем, іменем та по-батькові;
        System.out.println("Sort students");
        print(sortStudents(students));
        //метод для знаходження студента з найвищим середнім балом;
        System.out.println("Best student : ");
        System.out.println(getBestStudentStream(students));
        //метод який буде повертати прізвища усіх студентів через дефіс.
        System.out.println("Add '-' between last name and return this string");
        System.out.println(addHyphen(students));


    }


}