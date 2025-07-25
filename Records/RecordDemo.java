public class RecordDemo {

    public static void main(String[] args) throws InterruptedException {
        Person person1 = new Person("person1", 1);
        Person person2 = new Person("PERSON2", 2);
        Person person3 = new Person("pEARSON3", 3);
        person1.PrintPersonDetails();
        person2.PrintPersonDetails();
        person2.PrintPersonDetails();
    }
}
