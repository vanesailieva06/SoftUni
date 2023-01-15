package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPeople = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < countPeople; i++) {
            String[] people = scanner.nextLine().split(" ");
            String name = people[0];
            int age = Integer.parseInt(people[1]);
            Person person = new Person(name,age);
            personList.add(person);
        }
        personList.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
