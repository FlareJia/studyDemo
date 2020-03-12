package designPatterns.adapter;

public class Main {
    public static void main(String[] args) {

        DogBarking dogBarking = new DogBarking();
        DogAdapter dogAdapter = new DogAdapter(dogBarking);
        // dog imate mew
        dogAdapter.mewing();
    }
}
