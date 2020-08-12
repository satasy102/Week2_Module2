import Animal.Animal;
import Animal.Tiger;
import Animal.Chicken;
import Fruit.Edible;

import Fruit.Fruit;
import Fruit.Orange;
import Fruit.Apple;

class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibles = (Chicken) animal;
                System.out.println(edibles.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}