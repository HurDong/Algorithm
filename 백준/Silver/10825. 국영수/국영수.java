import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    String name;
    int korean;
    int english;
    int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();
            students.add(new Student(name, korean, english, math));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.korean == s2.korean) {
                    if (s1.english == s2.english) {
                        if (s1.math == s2.math) {
                            return s1.name.compareTo(s2.name);
                        }
                        return Integer.compare(s2.math, s1.math);
                    }
                    return Integer.compare(s1.english, s2.english);
                }
                return Integer.compare(s2.korean, s1.korean);
            }
        });

        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}
