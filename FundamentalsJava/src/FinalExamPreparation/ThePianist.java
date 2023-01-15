package FinalExamPreparation;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();
        //List<String> list = new ArrayList<>();
        String tune = "";
        String composer = "";
        for (int i = 1; i <= n; i++) {
            String[] pieceArr = scanner.nextLine().split("\\|");
            String piece = pieceArr[0];
            composer = pieceArr[1];
            tune = pieceArr[2];
            List<String> list = new ArrayList<>();
            list.add(composer);
            list.add(tune);
            piecesMap.put(piece,list);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            //Add|{piece}|{composer}|{key}":
            //o	You need to add the given piece with the information about it to the other pieces and print:
            //{piece} by {composer} in {key} added to the collection!
            //o	If the piece is already in the collection, print:
            //"{piece} is already in the collection!"
            if (command.contains("Add")) {
                String currentPiece = command.split("\\|")[1];
                String currentComposer = command.split("\\|")[2];
                composer = currentComposer;
                String currentTune = command.split("\\|")[3];
                tune = currentTune;
                List<String> currentList = new ArrayList<>();
                currentList.add(currentComposer);
                currentList.add(currentTune);
                if (!piecesMap.containsKey(currentPiece)) {
                    piecesMap.put(currentPiece, currentList);
                    System.out.printf("%s by %s in %s added to the collection!%n", currentPiece, currentComposer,
                            currentTune);
                } else {
                    System.out.printf("%s is already in the collection!%n", currentPiece);
                }
            } else if (command.contains("Remove")) {
                //•	"Remove|{piece}":
                //o	If the piece is in the collection, remove it and print:
                //"Successfully removed {piece}!"
                //o	Otherwise, print:
                //"Invalid operation! {piece} does not exist in the collection."
                String currentPiece = command.split("\\|")[1];
                if (piecesMap.containsKey(currentPiece)) {
                    piecesMap.remove(currentPiece);
                    System.out.printf("Successfully removed %s!%n", currentPiece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                }
            } else if (command.contains("ChangeKey")) {
                //•	"ChangeKey|{piece}|{new key}":
                //o	If the piece is in the collection, change its key with the given one and print:
                //"Changed the key of {piece} to {new key}!"
                //o	Otherwise, print:
                //"Invalid operation! {piece} does not exist in the collection."
                String currentPiece = command.split("\\|")[1];
                String newKey = command.split("\\|")[2];
                List<String> newList = new ArrayList<>();
                if (piecesMap.containsKey(currentPiece)) {
                    newList.add(composer);
                    newList.add(newKey);
                    piecesMap.replace(currentPiece,newList);
                    System.out.printf("Changed the key of %s to %s!%n", currentPiece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", currentPiece);
                }
            }
            command = scanner.nextLine();
        }
        //print -> "{Piece} -> Composer: {composer}, Key: {key}"
        for (Map.Entry<String, List<String>> entry : piecesMap.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0)
                    ,entry.getValue().get(1));
        }


    }
}
