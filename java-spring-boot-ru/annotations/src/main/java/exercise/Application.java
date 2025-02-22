package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {

            if (method.isAnnotationPresent(Inspect.class)) {

                if (method.getReturnType().getName().length() > 5) {
                    System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType().getName().split("\\.")[2]);
                }
                System.out.println("Method " + method.getName() + " returns a value of type " + method.getReturnType().getName());
            }
        }
        // END
    }
}
