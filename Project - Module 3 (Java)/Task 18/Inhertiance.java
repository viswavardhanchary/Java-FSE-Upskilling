class Animal {
    void makeSound() {
        System.out.println("BBB.BBB.BBB");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("BARK");
    }
}

public class Inhertiance {
    public static void main(String[] args) {
       Animal a = new Animal();
       a.makeSound();
       Dog d = new Dog();
       d.makeSound();
    }    
}
