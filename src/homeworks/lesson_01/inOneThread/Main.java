package homeworks.lesson_01.inOneThread;

public class Main {

    private static int counter;
    public static boolean containsNumber3(int number){
        while (number > 0){
            if (number % 10 == 3){
                return true;
            }
            number = number / 10;
        }
        return false;
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 2_000_000; i++) {
            if(i % 21 == 0 && containsNumber3(i) ){
                counter++;
            }
        }

        System.out.println("The number of numbers that are divisible by 21 and contain the digit 3 between 1 and 2_000_000: " + counter);
    }
}
