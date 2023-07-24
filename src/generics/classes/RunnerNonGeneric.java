package generics.classes;

public class RunnerNonGeneric {

    public static void main(String[] args) {
         // 2 tane farkli object olusturalim
        NonGenericType obj1 = new NonGenericType();
        NonGenericType obj2 = new NonGenericType();

        obj1.setField("Advanced Java"); // field String ile set ettik
        obj2.setField(123); // field integer ile set ettik

        String string = (String) obj1.getField(); // CTE(Compile Time Error) --> CAST problem
        System.out.println(string);

        String str = (String) obj2.getField(); // CTE(Compile Time Error) --> CAST problem, CAST ten sonra CTE yok
        System.out.println(str); // ClassCastException

    }
}
