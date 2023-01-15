package MidExamPreparation;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] roomsArr = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        boolean isDead = false;
        for (int i = 0; i < roomsArr.length; i++) {
            String[] room = roomsArr[i].split(" ");
            String command = room[0];
            int value = Integer.parseInt(room[1]);
            if (command.equals("potion")){
                int totalHealth = health + value;// 90 + 30 = 120
                if (totalHealth > 100){
                    int currentHealth = 100;
                    int diffHealth = currentHealth - health;
                    health = currentHealth;
                    System.out.printf("You healed for %d hp.%n", diffHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                }else{
                    health = totalHealth;
                    System.out.printf("You healed for %d hp.%n", value);
                    System.out.printf("Current health: %d hp.%n", totalHealth);
                }

            }else if (command.equals("chest")){
                bitcoins += value;
                System.out.printf("You found %d bitcoins.%n", value);
            }else {
                health = health - value;
                if(health > 0){
                    System.out.printf("You slayed %s.%n", command);
                }else{
                    System.out.printf("You died! Killed by %s.%n",command );
                    System.out.printf("Best room: %d%n", i + 1);
                    isDead = true;
                    if (isDead){
                        break;
                    }
                }
            }
        }
        if (!isDead){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }
}
