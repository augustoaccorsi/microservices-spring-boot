package pack.model;

public class Person {
    private long id;
    private String name;
    private String idea;

    public Person() {

    }

    public void Person(long id, String name, String idea) {
        this.id = id;
        this.name = name;
        this.idea = idea;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }
}