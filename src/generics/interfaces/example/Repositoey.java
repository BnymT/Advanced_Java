package generics.interfaces.example;

public interface Repositoey<T> {

    void save(T object);
    T find();
}
