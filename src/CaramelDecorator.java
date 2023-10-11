public class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }

    public double cost() {
        return coffee.cost() + 0.75;
    }
}