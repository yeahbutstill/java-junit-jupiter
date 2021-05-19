package world.srv.yeahbutstill.repository;

import world.srv.yeahbutstill.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);


}
