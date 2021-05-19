package world.srv.yeahbutstill.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import world.srv.yeahbutstill.data.Person;
import world.srv.yeahbutstill.repository.PersonRepository;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // perlu menambahkan behavior ke mock object
        Mockito.when(personRepository.selectById("dani"))
                .thenReturn(new Person("dani", "Dani"));
        var person = personService.get("dani");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("dani", person.getId());
        Assertions.assertEquals("Dani", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Dani");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Dani", person.getName());
        Assertions.assertNotNull(person.getId());

        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Dani"));
    }
}
