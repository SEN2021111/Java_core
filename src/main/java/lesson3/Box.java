package lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<T>();

    public int getWeight() {
        int weightFruits = 0;
        for (int i = 0; i < fruits.size(); i++) {
            weightFruits += fruits.get(i).getWeight();
        }
        return weightFruits;
    }

    public void add(T fruit) {
        this.fruits.add(fruit);
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void moveTo(Box box) {
        ArrayList emptyBox = new ArrayList();
        emptyBox.addAll(box.fruits);
        box.fruits.clear();
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
        this.fruits.addAll(emptyBox);
    }
}