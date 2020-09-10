import java.io.*;
import java.util.*;

public class FileWork {

    //Подсчитайте количество различных слов в файле.
    static Map<String, Integer> GetMap(String name) throws IOException {
        Map<String, Integer> map = new HashMap<>();

        File file = new File(name);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку

        String string = reader.readLine();

        while (string != null) {
            String[] list = string.split(" ");
            for (String item : list) {
                String s = item.toUpperCase();
                if (map.containsKey(s)) {
                    Integer value;
                    value = map.get(s);
                    map.put(s, ++value);
                } else
                    map.put(s, 1);
            }

            string = reader.readLine();

        }
        fr.close();

        //System.out.println(map);
        return map;
    }

    public static int count(String name) throws IOException {
        Map<String, Integer> map = GetMap(name);
        return map.size();
    }

    public static void orderList(String name) throws IOException {
        Map<String, Integer> map = GetMap(name);

        ArrayList<String> list = new ArrayList<>();

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        Map.Entry<String, Integer> pair = iterator.next();
        String key = pair.getKey();
        while (iterator.hasNext()) {
            pair = iterator.next();
            key = pair.getKey();
            list.add(key);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (compareTo(list.get(j), list.get(j + 1)) > 0) {
                    String t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                }
            }
        }

        //Collections.sort(list);
        System.out.println(list);
    }


    public static void numberOfValue(String name) throws IOException {
        Map<String, Integer> map = GetMap(name);
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> pair = iterator.next();
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println("Слово " + key.toLowerCase() + " встречается " + value + " раз");
        }
    }

    public static void reverseFile(String name) throws IOException {
        ArrayList<String> fileString = fileByString(name);


        for (int i = fileString.size() - 1; i >= 0; i--) {
            System.out.println(fileString.get(i));
        }


    }

    static ArrayList<String> fileByString(String name) throws IOException {
        File file = new File(name);
        //создаем объект FileReader для объекта File
        FileReader fr = new FileReader(file);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        ArrayList<String> fileString = new ArrayList<>();
        String string = reader.readLine();

        while (string != null) {
            fileString.add(string);

            string = reader.readLine();

        }
        fr.close();
        return fileString;
    }

    public static void chooseString(String name) throws IOException {
        ArrayList<String> fileString = fileByString(name);
        System.out.print("Введите номер строки: ");
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        if (index < 0 || index > fileString.size()) {
            System.out.print("Неверно введен номер ");
            return;
        }
        System.out.println(fileString.get(index));

    }


    public static int compareTo(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if (s1.length() > s2.length())
            return 1;
        if (s1.compareTo(s2) < 0) // s1.length() >= s2.length()
            return -1;

        return 1;
    }
}