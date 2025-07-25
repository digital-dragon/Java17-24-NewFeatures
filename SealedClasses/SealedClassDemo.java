public class SealedClassDemo {
    public static void main(String[] args) {
        Pop pop = new Pop();
        pop.tellMeAboutIt();
        Tea tea = new Tea();
        tea.tellMeAboutIt();
        Coffee coffee = new Coffee();
        coffee.tellMeAboutIt();
        Espresso espresso = new Espresso();
        espresso.tellMeAboutIt();
    }
}
