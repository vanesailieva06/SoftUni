package FinalExamPreparation;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] citiesArr = scanner.nextLine().split("\\|\\|");
        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();
        String cities = citiesArr[0];
        int count = 0;
        int sumPopulation = 0;
        int sumGold = 0;
        while (!cities.equals("Sail")){
            int population = Integer.parseInt(citiesArr[1]);
            int gold = Integer.parseInt(citiesArr[2]);
            List<Integer> list = new ArrayList<>();
            list.add(population);
            list.add(gold);
            if (citiesMap.containsKey(cities)){
                citiesMap.get(cities).set(0, sumPopulation += population);
                citiesMap.get(cities).set(1, sumGold += gold);
                citiesArr = scanner.nextLine().split("\\|\\|");
                cities = citiesArr[0];
                continue;
            }
            citiesMap.put(cities,list);
            count++;
            citiesArr = scanner.nextLine().split("\\|\\|");
            cities = citiesArr[0];
            sumPopulation = population;
            sumGold = gold;
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String townName = command.split("=>")[1];
            if (command.contains("Plunder")) {
                //•	"Plunder=>{town}=>{people}=>{gold}"
                //o	You have successfully attacked and plundered the town,
                // killing the given number of people and stealing the respective amount of gold.
                int killedPeople = Integer.parseInt(command.split("=>")[2]);
                int stealMoney = Integer.parseInt(command.split("=>")[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", townName, stealMoney, killedPeople);
                if (citiesMap.get(townName).get(0) - killedPeople <= 0 || citiesMap.get(townName).get(1) - stealMoney <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", townName);
                    citiesMap.remove(townName);
                    command = scanner.nextLine();
                    count = count - 1;
                    continue;
                } else {
                    citiesMap.get(townName).set(0, citiesMap.get(townName).get(0) - killedPeople);
                    citiesMap.get(townName).set(1, citiesMap.get(townName).get(1) - stealMoney);
                }
                //o	For every town you attack print this message:
                // "{town} plundered! {gold} gold stolen, {people} citizens killed."
                //o	If any of those two values (population or gold) reaches zero, the town is disbanded.
                //	You need to remove it from your collection of targeted cities and print the following message:
                // "{town} has been wiped off the map!"
                //o	There will be no case of receiving more people or gold than there is in the city.
            } else if (command.contains("Prosper")) {
                //•	"Prosper=>{town}=>{gold}"
                //o	There has been dramatic economic growth in the given city, increasing its treasury by the given amount of gold.
                int addedGold = Integer.parseInt(command.split("=>")[2]);
                if (addedGold < 0){
                    System.out.println("Gold added cannot be a negative number!");
                    command = scanner.nextLine();
                    continue;
                }else{
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n" ,
                            addedGold, townName,citiesMap.get(townName).get(1) + addedGold);
                    citiesMap.get(townName).set(1,citiesMap.get(townName).get(1) + addedGold);
                }
                //o	The gold amount can be a negative number, so be careful.
                // If a negative amount of gold is given, print: "Gold added cannot be a negative number!"
                // and ignore the command.
                //o	If the given gold is a valid amount, increase the town's gold reserves by the respective amount
                // and print the following message:
                //"{gold added} gold added to the city treasury. {town} now has {total gold} gold."
            }
            command = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",count);
        for (Map.Entry<String, List<Integer>> entry : citiesMap.entrySet()) {
            System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",entry.getKey(),
                    entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
