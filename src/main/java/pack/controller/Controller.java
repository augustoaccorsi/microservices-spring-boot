package pack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pack.model.Person;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    private List<Person> persons = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Spring Boot World";
    }

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPledge(@RequestBody Person person) {
        person.setId(nextId.incrementAndGet());
        persons.add(person);
        return person;
    }

    @GetMapping("person")
    public List<Person> getAllPersons() {
        return persons;
    }

    @GetMapping("/person/{id}")
    public Person getSinglePerson(@PathVariable long id) throws IllegalArgumentException {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new IllegalArgumentException();
    }

    @PostMapping("/person/{id}")
    public Person editSinglePerson(@PathVariable long id, @RequestBody Person newPerson) throws IllegalArgumentException {
        for (Person person : persons) {
            if (person.getId() == id) {
                persons.remove(person);
                newPerson.setId(id);
                persons.add(newPerson);
                return newPerson;
            }
        }
        throw new IllegalArgumentException();
    }

    //Create Exception Handier
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Request ID not found")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler(){
        //Nothing to do
    }
}