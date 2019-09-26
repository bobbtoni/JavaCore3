package lesson1;

public class Apple extends Fruit {

    public Apple(double w) {
        super.setWeight(w);
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }
}
