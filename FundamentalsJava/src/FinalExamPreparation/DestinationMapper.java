package FinalExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int travelPoints = 0;
        List<String> destinationList = new ArrayList<>();
        while (matcher.find()){
            String destination = matcher.group("destination");
            destinationList.add(destination);
            travelPoints += destination.length();
        }
        System.out.println("Destinations: " + String.join(", ", destinationList));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
