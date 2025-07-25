public record Person(String name, int id) implements PersonInterface {

    public Person(String name, int id) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        this.id = id;
    }
    @Override
    public void PrintPersonDetails() {
        System.out.println("Person name is " + this.name + " and age is " + this.id);
    }
}
