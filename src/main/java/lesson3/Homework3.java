package lesson3;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println("-- Задание №1 --");
        String[] str = {"a", "b", "c", "d"};
        printArr(str);
        swap(str, 0, 2);
        printArr(str);

        Integer[] ints = {1, 2, 3, 4};
        printArr(ints);
        swap(ints, 1, 2);
        printArr(ints);

        System.out.println("-- Задание №2 --");

        Box<Apple> boxApple = new Box<Apple>();
        Box<Orange> boxOrange = new Box<Orange>();

        boxApple.add(new Apple(200));
        boxApple.add(new Apple(100));
        boxOrange.add(new Orange(250));

        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());

        //try {
        //    boxOrange.add(new Apple(150));
        //    //boxApple.add(new Orange(250));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        System.out.println(boxApple.compare(boxOrange));

        boxApple.moveTo(boxOrange);

        System.out.println(boxApple.getWeight());
        System.out.println(boxOrange.getWeight());
    }

    static <T> void swap(T[] arr, int i, int j) {
        T obj = arr[i];
        arr[i] = arr[j];
        arr[j] = obj;
    }

    static <T> void printArr(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("------");
    }
}
