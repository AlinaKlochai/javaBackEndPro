package lesson_01.task_03;

// Есть счётчик (целочисленный).
// Есть три потока.
// Каждый поток в цикле должен увеличить миллион раз
// значение счётчика на единицу. Вывести значение счётчика в консоль.

public class Main {

    public static int counter;

    public static void main(String[] args) {

        MyTread myTread1 = new MyTread();
        MyTread myTread2 = new MyTread();

        myTread1.start();
        myTread2.start();

        for (int i = 0; i < 1_000_000; i++) {
            counter++;
        }

        try {
            myTread1.join();
            myTread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Counter value: " + counter);
    }
}
