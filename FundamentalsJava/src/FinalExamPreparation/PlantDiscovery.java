package FinalExamPreparation;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plantsMap = new LinkedHashMap<>();
        for (int i = 1; i <= n ; i++) {
            String plantInfo[] = scanner.nextLine().split("<->");
            String plantType = plantInfo[0];
            double rarity = Double.parseDouble(plantInfo[1]);
            List<Double> list = new ArrayList<>();
            double rating = 0;
            list.add(rarity);
            list.add(rating);
            if (plantsMap.containsKey(plantType)){
                plantsMap.get(plantType).set(0, rarity);
                continue;
            }
            plantsMap.put(plantType,list);
        }
        String command = scanner.nextLine();
        List<Double> numList = new ArrayList<>();
        double totalRating = 0;
        while (!command.equals("Exhibition")){
            //•	"Rate: {plant} - {rating}" – add the given rating to the plant (store all ratings)
            //•	"Update: {plant} - {new_rarity}" – update the rarity of the plant with the new one
            //•	"Reset: {plant}" – remove all the ratings of the given plant
            String plantName = command.split(": ")[1].split(" - ")[0];
            if (command.contains("Rate")){
                double rating = Double.parseDouble(command.split(": ")[1].split(" - ")[1]);
                plantsMap.get(plantName).set(1, rating);
            }else if (command.contains("Update")){
                double newRarity = Double.parseDouble(command.split(": ")[1].split(" - ")[1]);
                plantsMap.get(plantName).set(0,newRarity);
            }else if (command.contains("Reset")){
                plantsMap.get(plantName).set(1, 0.0);
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Double>> entry : plantsMap.entrySet()) {
            //- {plant_name1}; Rarity: {rarity}; Rating: {average_rating}
            System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0),
                    entry.getValue().get(1));
        }

    }
}
