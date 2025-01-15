package question01.unchecked;

import question01.unchecked.dao.PersonDao;
import question01.unchecked.ds.Person;

public class Runner {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();

        personDao.save(person);
    }
}
