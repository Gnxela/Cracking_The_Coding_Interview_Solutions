package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

public class q3_6 {

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Bill"));
        shelter.enqueue(new Cat("Meanie"));
        shelter.enqueue(new Dog("Bolt"));
        shelter.enqueue(new Dog("Steve"));

        System.out.println(shelter.dequeueDog().name);
        System.out.println(shelter.dequeueDog().name);
    }

    static class AnimalShelter {

        private SNode<Animal> linkedList;

        public void enqueue(Animal a) {
            if (linkedList == null) {
                linkedList = new SNode<>(a);
            } else {
                linkedList.appendToTail(a);
            }
        }

        public Animal dequeueAny() {
            if (linkedList == null) throw new NullPointerException();
            Animal animal = linkedList.data;
            linkedList = linkedList.next;
            return animal;
        }

        public Cat dequeueCat() {
            if (linkedList == null) throw new NullPointerException();
            SNode<Animal> current = linkedList;
            if (current.data instanceof Cat) {//Check the first entry because out loop below looks ahead so it can remove the node when it finds it. Wouldn't be needed in a doubly linked list.
                linkedList = current.next;
                return (Cat) current.data;
            }
            while (current.next != null) {
                if (current.next.data instanceof Cat) {
                    Cat c = (Cat) current.next.data;
                    current.next = current.next.next;
                    return c;
                }
                current = current.next;
            }
            return null;
        }

        public Dog dequeueDog() {
            if (linkedList == null) throw new NullPointerException();
            SNode<Animal> current = linkedList;
            if (current.data instanceof Dog) {
                linkedList = current.next;
                return (Dog) current.data;
            }
            while (current.next != null) {
                if (current.next.data instanceof Dog) {
                    Dog c = (Dog) current.next.data;
                    current.next = current.next.next;
                    return c;
                }
                current = current.next;
            }
            return null;

        }


    }

    static abstract class Animal {
        String name;

        public Animal(String name) {
            this.name = name;
        }

        public abstract void call();

    }

    static class Dog extends Animal {

        public Dog(String name) {
            super(name);
        }

        @Override
        public void call() {
            System.out.println("Bark!");
        }
    }

    static class Cat extends Animal {

        public Cat(String name) {
            super(name);
        }

        @Override
        public void call() {
            System.out.println("Meow!");
        }
    }

}



