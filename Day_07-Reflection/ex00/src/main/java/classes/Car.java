package classes;

import java.util.StringJoiner;

public class Car {
    private String model;
    private String color;
    private long price;


    public Car() {
        this.model = "Default";
        this.color = "Default";
        this.price = 0;
    }

    public Car(String model, String color, long price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public long growPrice(int value) {
        this.price += value;
        return price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("model='" + model + "'")
                .add("color='" + color + "'")
                .add("price=" + price)
                .toString();
    }
}
