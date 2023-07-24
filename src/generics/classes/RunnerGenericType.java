package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class RunnerGenericType {

    public static void main(String[] args) {

        // Generics ile hangi data type ini kullanacagimiza karar verebiliyoruz
        // Java 7'den sonra sag tarafta data type ini belirlemeye gerek kalmadi.
        GenericClass<String> obj1 = new GenericClass<>();
        obj1.setField("Generic Types");
        String str = obj1.getField(); // CTE vermedi, CAST problemi kalmadi, ClassCastException i da engelledi.

        //--------------------------------------

        GenericClass<String> obj2 = new GenericClass<>();
        // obj2.setField(123); // Generics tur guvenligini saglar

        GenericClass<Integer> obj3 = new GenericClass<>();
        obj3.setField(123);

        Integer integer = obj3.getField();

        // GenericClass<double> obj4 = new GenericClass<double>(); // sadece NON-PRIMITIVE

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        // list.add(12);
        String s = list.get(0);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Generics", 54);
        // map.put(54, "String");


        // ------------------------ Generic Class Two Param ------------------------ //

        GenericClassTwoParam<String, Double> myMap = new GenericClassTwoParam<>("Generics" , 12.3);
        GenericClassTwoParam<Integer, Integer> myMap2 = new GenericClassTwoParam<>(12, 34);

    }
}
