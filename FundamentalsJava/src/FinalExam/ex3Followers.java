package FinalExam;

import java.util.*;

public class ex3Followers {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        Map<String, List<Integer>> usernameMap = new LinkedHashMap<>();
        String command = scanner.nextLine();
        int countFollowers = 0;
        int likes = 0;
        int comment = 0;
        while (!command.equals("Log out")){
            //o	"New follower: {username}"
            //o	"Like: {username}: {count}"
            //o	"Comment: {username}"
            //o	"Blocked: {username}"
            String username = command.split(": ")[1];
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            if (command.contains("New follower")){
                if (usernameMap.containsKey(username)){
                    command = scanner.nextLine();
                    continue;
                }
                usernameMap.put(username,list);
                countFollowers++;
            } else if (command.contains("Like")) {
                int countLikes = Integer.parseInt(command.split(": ")[2]);
                if (!usernameMap.containsKey(username)){
                    list.set(0, countLikes);
                    usernameMap.put(username,list);
                    countFollowers++;
                }else{
                    countLikes += usernameMap.get(username).get(0);
                    usernameMap.get(username).set(0,countLikes);
                }
            }else if (command.contains("Comment")){
                if (!usernameMap.containsKey(username)){
                    comment = 1;
                    list.set(1, comment);
                    usernameMap.put(username,list);
                    countFollowers++;
                }else {
                    usernameMap.get(username).set(1,comment = comment + 1);
                }
            } else if (command.contains("Blocked")) {
                if (usernameMap.containsKey(username)){
                    usernameMap.remove(username);
                    countFollowers--;
                }else{
                    System.out.printf("%s doesn't exist.%n",username);
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("%d followers%n", countFollowers);
        for (Map.Entry<String, List<Integer>> entry : usernameMap.entrySet()) {
            //o	"{count} followers
            //{username}: {likes+comments}
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().get(0) + entry.getValue().get(1));
        }

    }
}
