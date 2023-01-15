package AssociativeArrEx;

import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        List<String> materialsList= Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        Map<String, Integer> items = new HashMap<>();
        Map<String, Integer> junk = new HashMap<>();
        while (true){
            for (int i = 0; i < materialsList.size(); i+=2) {
                String materials = materialsList.get(i + 1).toLowerCase();
                int value = Integer.parseInt(materialsList.get(i));
                items.put(materials,value);
                if (materials.equals("shards") || materials.equals("fragments") || materials.equals("motes")){
                    if (items.containsKey(materials)) {
                        int currentQuantity = value + items.get(materials);
                        currentQuantity = value;
                    }
                    if (value == 250){
                        if (materials.equals("shards")){
                            System.out.println("Shadowmourne obtained!");
                        }else if (materials.equals("fragments")){
                            System.out.println("Valanyr obtained!");
                        }else if (materials.equals("motes")){
                            System.out.println("Dragonwrath obtained!");
                        }
                        items.put(materials, value - 250);
                    }
                }else{
                    if (items.containsKey(materials)) {
                        int currentQuantity = value + items.get(materials);
                        currentQuantity = value;
                    }
                    junk.put(materials, value);
                }
            }
            materialsList = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
        }
    }
}
