package homeworks.lesson_01.inTwoThread;


public class Main {

    private static int counter;

    public static synchronized void increment() {
        counter++;
    }

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

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        for (int i = 1; i < 1_000_001; i++) {
            if(i % 21 == 0 && containsNumber3(i)) {
                increment();
            }
        }

        try {
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The number of numbers that are divisible by 21 and contain the digit 3 between 1 and 2_000_000 in two thread:  " + counter);
    }
}
