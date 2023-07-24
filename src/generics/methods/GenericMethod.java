package generics.methods;

import java.util.Arrays;

public class GenericMethod {

    public static void main(String[] args) {

        Integer[] intArr = {2, 3, 8, 99, 55};
        Double[] doubleArr = {1.3, 35.6, 99.9, 0.5};
        String[] stringArr = {"Java", "Generics", "Hayatimizi", "Kolaylastirir"};

        System.out.println("---------- Generic Olmayan Bir Method ----------");
        printArr(intArr);
        printArr(doubleArr);
        printArr(stringArr);

        System.out.println("---------- Generic Bir Method ----------");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("---------- Sonuc Donduren Generic Method ----------");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(stringArr));

        System.out.println("---------- Iki parametreli Generic Method ----------");
        printArrayAndObject(intArr, "String");
        printArrayAndObject(intArr, 12);
    }

    // Array leri yazdirmak icim Generic olmayan method
    public static void printArr(Integer[] arr) {
        Arrays
                .stream(arr)
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    // Overloading
    public static void printArr(Double[] arr) {
        Arrays
                .stream(arr)
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    // Overloading
    public static void printArr(String[] arr) {
        Arrays
                .stream(arr)
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    // Generic olarak
    public static <T> void printArray(T[] arr) {
        Arrays
                .stream(arr)
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    // Geriye sonuc donduren generic method
    public static <T> T getFirst(T[] arr) {
        T first = arr[0];
        return first;
    }

    // Birden fazla parametreli Generic Method
    public static <T, U> void printArrayAndObject(T[] array, U object) {

        // array[0] = object; // T ve U data type lari farkli olabilir

        Arrays
                .stream(array)
                .forEach(t -> System.out.print(t + " "));
        System.out.print("----------" + object);
        System.out.println();
    }


}
