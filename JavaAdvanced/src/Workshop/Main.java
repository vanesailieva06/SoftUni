package Workshop;

public class Main {
    public static void main(String[] args) {
        SmartArray array = new SmartArray();
        array.add(2);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(9);
        array.remove(2);
        array.contains(9);
        array.add(1, 10);
        array.forEach(System.out::println);
    }
}
