package org.example;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Eater eater = new Animal();

        feedEater(animal);
        feedEater(eater);

        feedEater(new Eater() {
            @Override
            public void eat(String food) {
                System.out.println("Anonymous Animal is eating => " + food);
            }
        });

        feedEater((food) -> { System.out.println("Anonymous Animal is eating => " + food); });

        feedEater(food -> System.out.println("Anonymous Animal is eating => " + food));
    }

    public static void feedEater(Eater eater) {
        eater.eat("meat");
    }
}

interface Eater {
    void eat(String food);
}

class Animal implements Eater {

    @Override
    public void eat(String food) {
        System.out.println("Animal is eating => " + food);
    }

    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void run() {
        System.out.println("Animal is running");
    }
}