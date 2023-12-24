import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Person {
    String name;
    int day, month, year;

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            people.add(new Person(name, day, month, year));
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // 연도를 먼저 비교
                if (p1.year != p2.year)
                    return p1.year - p2.year;
                // 같으면 달을 비교
                if (p1.month != p2.month)
                    return p1.month - p2.month;
                // 같으면 날짜를 비교
                return p1.day - p2.day;
            }
        });

        System.out.println(people.get(n - 1).name);
        System.out.println(people.get(0).name);
    }
}
