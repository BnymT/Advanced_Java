package generics.interfaces.example;

public class CustomerRepo implements Repositoey<Customer> {

    @Override
    public void save(Customer object) {

    }

    @Override
    public Customer find() {
        return null;
    }
}
