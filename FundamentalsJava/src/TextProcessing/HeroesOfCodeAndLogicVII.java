package TextProcessing;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] heroesArr = scanner.nextLine().split(" ");
            String heroName = heroesArr[0];
            int hp = Integer.parseInt(heroesArr[1]);
            int mp = Integer.parseInt(heroesArr[2]);
            List<Integer> list = new ArrayList<>();
            list.add(hp);
            list.add(mp);
            heroesMap.put(heroName,list);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String heroName = command.split(" - ")[1];
            if (command.contains("CastSpell")) {
                int neededMp = Integer.parseInt(command.split(" - ")[2]);
                String spellName = command.split(" - ")[3];
                if (heroesMap.get(heroName).get(1) > neededMp){
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,
                            Math.abs(heroesMap.get(heroName).get(0) - neededMp));
                    heroesMap.get(heroName).set(1, Math.abs(heroesMap.get(heroName).get(1) - neededMp));
                }else{
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName, spellName);
                }
            } else if (command.contains("TakeDamage")) {
                int damage = Integer.parseInt(command.split(" - ")[2]);
                String attacker = command.split(" - ")[3];
                if (heroesMap.get(heroName).get(0) > damage){
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",heroName,
                            damage, attacker,Math.abs(heroesMap.get(heroName).get(0) - damage));
                    heroesMap.get(heroName).set(0,Math.abs(heroesMap.get(heroName).get(0) - damage));
                }else{
                    System.out.printf("%s has been killed by %s!%n",heroName, attacker);
                    heroesMap.remove(heroName);
                }
            }else if (command.contains("Recharge")) {
                int amount = Integer.parseInt(command.split(" - ")[2]);
                int totalAmount = amount + heroesMap.get(heroName).get(1);
                int diff = 0;
                if (totalAmount > 200){
                    totalAmount = 200;
                    diff = 200 - heroesMap.get(heroName).get(1);
                }else {
                    diff = amount;
                }
                heroesMap.get(heroName).set(1,totalAmount);
                System.out.printf("%s recharged for %d MP!%n",heroName, diff);

            } else if (command.contains("Heal")) {
                int healthAmount = Integer.parseInt(command.split(" - ")[2]);
                int totalAmount = healthAmount + heroesMap.get(heroName).get(0);
                int diff = 0;
                if (totalAmount > 100){
                    diff = 100 - heroesMap.get(heroName).get(0);
                    totalAmount = 100;
                }else {
                    diff = healthAmount;
                }
                heroesMap.get(heroName).set(0,totalAmount);
                System.out.printf("%s healed for %d HP!%n",heroName,diff);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<Integer>> listEntry : heroesMap.entrySet()) {
            System.out.printf("%s%n",listEntry.getKey());
            System.out.printf(" HP: %d%n",listEntry.getValue().get(0));
            System.out.printf(" MP: %d%n",listEntry.getValue().get(1));
        }

    }
}
