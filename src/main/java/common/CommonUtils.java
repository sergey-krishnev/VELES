package common;

public class CommonUtils {

    public static boolean isEnabled = true;

    public static void say(String phrase) {
        System.out.println("/////////VELES///////// " + phrase);
    }

    public static void log(String info) {
        if (isEnabled) {
            System.out.println("||LOG INFORMATION||: " + info);
        }
    }

}
