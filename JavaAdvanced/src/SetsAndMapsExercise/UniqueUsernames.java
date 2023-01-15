package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> setName = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            setName.add(name);
        }
        for (String name : setName){
            System.out.println(name);
        }
    }
}
