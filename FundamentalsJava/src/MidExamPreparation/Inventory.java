package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList
                        ());
        String input = scanner.nextLine();
        while(!input.equals("Craft!")){
            String command = input.split(" - ")[0];
            String item = input.split(" - ")[1];
            if (command.equals("Collect")){
                if (isExists(itemsList,item)){
                    input = scanner.nextLine();
                    continue;
                }else{
                    itemsList.add(item);
                }
            }else if (command.equals("Drop")){
                if (isExists(itemsList,item)){
                    itemsList.remove(item);
                }
            }else if (command.equals("Combine Items")){
                String oldItem = item.split(":")[0];
                String newItem = item.split(":")[1];
                if (isExists(itemsList,oldItem)){
                    for (int i = 0; i < itemsList.size(); i++) {
                        if (oldItem.contains(itemsList.get(i))){
                            itemsList.add(i + 1, newItem);
                        }
                    }
                    //itemsList.add(newItem);
                }
            }else if (command.equals("Renew")){
                if (isExists(itemsList,item)){
                    itemsList.remove(item);
                    itemsList.add(item);
                }
            }
            input = scanner.nextLine();
        }
        System.out.print(itemsList.toString().replace("[","").replace("]", ""));
    }

    public static boolean isExists(List<String> items, String item){
        for (int i = 0; i < items.size() ; i++) {
            if (item.contains(items.get(i))){
                return true;
            }
        }
        return false;
    }
}
