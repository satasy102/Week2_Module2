package Animal;
import Fruit.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Cluck cluck";
    }

    @Override
    public String howToEat() {
        return "Nho long. Luoc chin roi an";
    }
}
