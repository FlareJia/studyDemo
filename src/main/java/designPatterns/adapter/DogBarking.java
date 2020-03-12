package designPatterns.adapter;

public class DogBarking implements Dog {
    @Override
    public void barking() {
        System.out.println("dog barking!!!");
    }
}
