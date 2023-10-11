import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeOrderSystem {
    private List<Coffee> order = new ArrayList<>();

    public static void main(String[] args) {
        CoffeeOrderSystem orderSystem = new CoffeeOrderSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1 - Order coffee");
            System.out.println("2 - Total cost");
            System.out.println("3 - Finish order");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    orderSystem.orderCoffee();
                    break;
                case 2:
                    orderSystem.displayTotalCost();
                    break;
                case 3:
                    orderSystem.finishOrder();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    public void orderCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a coffee type:");
        System.out.println("1 - Espresso");
        System.out.println("2 - Latte");
        int coffeeChoice = scanner.nextInt();

        Coffee coffee = null;
        switch (coffeeChoice) {
            case 1:
                coffee = new Espresso();
                break;
            case 2:
                coffee = new Latte();
                break;
            default:
                System.out.println("Invalid coffee choice. Please select a valid option.");
        }

        if (coffee != null) {
            coffee = addCondiments(coffee);
            order.add(coffee);
            System.out.println(coffee.getDescription() + " added to the order.");
        }
    }

    public Coffee addCondiments(Coffee coffee) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Add condiment:");
            System.out.println("1 - Milk");
            System.out.println("2 - Sugar");
            System.out.println("3 - Caramel");
            System.out.println("4 - Finish");
            int condimentChoice = scanner.nextInt();

            switch (condimentChoice) {
                case 1:
                    coffee = new MilkDecorator(coffee);
                    break;
                case 2:
                    coffee = new SugarDecorator(coffee);
                    break;
                case 3:
                    coffee = new CaramelDecorator(coffee);
                    break;
                case 4:
                    return coffee; // Finish adding condiments
                default:
                    System.out.println("Invalid condiment choice. Please select a valid option.");
                    break;
            }
        }
    }

    public void displayTotalCost() {
        double totalCost = order.stream().mapToDouble(Coffee::cost).sum();
        System.out.println("Total cost of the order: $" + totalCost);
    }

    public void finishOrder() {
        System.out.println("Order complete. Thank you!");
        System.exit(0);
    }
}
