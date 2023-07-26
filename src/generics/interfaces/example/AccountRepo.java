package generics.interfaces.example;

public class AccountRepo implements Repositoey<Account> {

    @Override
    public void save(Account object) {

    }

    @Override
    public Account find() {
        return null;
    }
}

