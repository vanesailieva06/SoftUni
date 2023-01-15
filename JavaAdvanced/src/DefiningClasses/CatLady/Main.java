package DefiningClasses.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,Cat> catsMap = new HashMap<>();
        while (!input.equals("End")){
            String breed = input.split(" ")[0];
            String name = input.split(" ")[1];
            Cat cat = null;
            if (breed.equals("Siamese")){
                double earSize = Double.parseDouble(input.split(" ")[2]);
                cat = new Siamese(name,earSize);
            } else if (breed.equals("StreetExtraordinaire")) {
               double decibels = Double.parseDouble(input.split(" ")[2]);
               cat = new StreetExtraordinaire(name,decibels);
            } else if (breed.equals("Cymric")) {
                double furLength = Double.parseDouble(input.split(" ")[2]);
                cat = new Cymric(name,furLength);
            }
            catsMap.put(name,cat);
            input = scanner.nextLine();
        }
        String nameToSearch = scanner.nextLine();
        if (catsMap.containsKey(nameToSearch)){
            System.out.println(catsMap.get(nameToSearch));
        }

    }
}
