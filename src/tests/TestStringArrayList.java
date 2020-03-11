package tests;

import homework.StringArrayList;

public class TestStringArrayList {

    public static void main(String[] args) {
        StringArrayList list = new StringArrayList(10);

        try {
            list.add(1, "cat");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Error");
        }

        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Error");
        }

        list.add("cat");
        System.out.println(list.remove("Cat"));
        System.out.println(list.remove("cat"));

        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        try {
            list.get(-2);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Error");
        }
        try {
            list.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Error");
        }
        System.out.println(list);
        list.add(5, "cat");
        System.out.println(list);
        System.out.println(list.remove(5));
        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            list.remove(0);
        }
        System.out.println(list);
        
        list = new StringArrayList(2);
        String[] strArray = {"aes", "bassefj","cs33", "d32", "aest67", "23232", "aesbbn+", "aesss",
                             "8+9aes","aesr2", "09-tt3", "3aes", "aessssss", "bddfds"};
        for(String s:strArray){
            list.add(s);
        }
        System.out.println(list);
        System.out.println("The number of elements in list: " + list.size());
        System.out.println(list.containsPrefix("aes"));
        System.out.println(list.containsPrefix("ss"));
    }

}

