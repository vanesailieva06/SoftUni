package TextProcessingEx;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String[] path = scanner.nextLine().split("\\\\");
        String file = path[path.length - 1];
        String name = file.split("\\.")[0];
        String extension = file.split("\\.")[1];
        System.out.printf("File name: %s%n",name);
        System.out.printf("File extension: %s", extension);
    }
}
