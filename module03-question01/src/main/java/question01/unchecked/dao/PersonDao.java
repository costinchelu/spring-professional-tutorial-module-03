package question01.unchecked.dao;

import question01.unchecked.ds.Person;
import question01.unchecked.exception.DaoFilesystemException;
import question01.unchecked.exception.PersonInvalidException;
import question01.unchecked.exception.PersonStoreException;

public class PersonDao {
    public void save(Person person) {
        if (!valid(person))
            throw new PersonInvalidException();

        if (!filesystemActive(person))
            throw new DaoFilesystemException();

        if (!store(person))
            throw new PersonStoreException();
    }

    private boolean valid(Person person) {
        return false;
    }

    private boolean store(Person person) {
        return false;
    }

    private boolean filesystemActive(Person person) {
        return false;
    }
}
