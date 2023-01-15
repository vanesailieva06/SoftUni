package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Scanner scanner = new Scanner(System.in);
        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);
        String command = scanner.nextLine();
        int sum = 0;
        while (!"END".equals(command)){
            String commandName = command.split("_")[0];
            int value = Integer.parseInt( command.split("_")[1]);
            Method method = clazz.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt,value);
            System.out.println(field.get(blackBoxInt));
            command = scanner.nextLine();
        }
    }
}
