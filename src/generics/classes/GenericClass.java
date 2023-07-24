package generics.classes;

// Generic olarak PRIMITIVE data type lar KULLANILAMAZ!
public class GenericClass<T> {

    /*
    E --> Element, collection gibi yapılarda kullanılır
    K --> Key
    V --> Value
    N --> Number
    T --> Type
    S,U,V , vb --> 2., 3. ve 4. tipler için
     */

    private T field;

    // Getter - Setter

    public T getField() {
        return field;
    }

    public void setField(T field) {
        this.field = field;
    }
}
