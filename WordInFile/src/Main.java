import java.io.*;

public class Main {

    public static void main(String[] args) {


        try {
            System.out.println("Задание 1");
            System.out.println("Подсчитайте количество различных слов в файле");
            System.out.println(FileWork.count("E:/Java/Task 2/WordInFile/src/test.txt"));

            System.out.println(" ");

            System.out.println("Задание 2");
            System.out.println("Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту)");
            FileWork.orderList("E:/Java/Task 2/WordInFile/src/test.txt");

            System.out.println(" ");

            System.out.println("Задание 3");
            System.out.println("Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле");
            FileWork.numberOfValue("E:/Java/Task 2/WordInFile/src/test.txt");

            System.out.println("Задание 4");
            System.out.println("Выведите на экран все строки файла в обратном порядке");
            FileWork.reverseFile("E:/Java/Task 2/WordInFile/src/test.txt");

            System.out.println("Задание 6");
            System.out.println("Выведите на экран строки, номера которых задаются пользователем в произвольном порядке");
            FileWork.chooseString("E:/Java/Task 2/WordInFile/src/test.txt");


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
