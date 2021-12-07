package utility;

public class Random {

    public static String getRandomEmail() {
        java.util.Random randomGenerator = new java.util.Random();
        int randomInt = randomGenerator.nextInt(1000);
        return "username" + randomInt + "@gmail.com";

    }
}
