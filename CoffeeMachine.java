package machine;
import java.util.Scanner;
import java.lang.Integer;

public class CoffeeMachine {
    int waterAmount = 400;
    int milkAmount = 540;
    int beanAmount = 120;
    int cups = 9;
    int money = 550;
    /* to display my inventory. This is useful because I have to show my inventory at least twice 
    in each run of the program */
    public static void inventory(CoffeeMachine machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.waterAmount + " of water");
        System.out.println(machine.milkAmount + " of milk");
        System.out.println(machine.beanAmount + " of beans");
        System.out.println(machine.cups + " of cups");
        System.out.println(machine.money + " of money\n");
    }
    /* A function to allow the user to buy coffee and update the inventory using 
    amounts specified in the instructions */
    public static void buy(CoffeeMachine machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String coffeeType = scanner.next();
        switch (coffeeType) {
            case "1":
				if (machine.waterAmount >= 250) {
					machine.waterAmount = machine.waterAmount - 250;
					System.out.println("I have enough resources, making you a coffee!\n");
				} else { 
					System.out.println("Sorry, not enough water"); 
					break;}
                machine.beanAmount = machine.beanAmount - 16;
                machine.cups = machine.cups - 1;
                machine.money = machine.money + 4;
                break;
            case "2":
                if (machine.waterAmount >= 350) {
					machine.waterAmount = machine.waterAmount - 350;
					System.out.println("I have enough resources, making you a coffee!\n");
				} else { 
					System.out.println("Sorry, not enough water"); 
					break;}
                machine.milkAmount = machine.milkAmount - 75;
                machine.beanAmount = machine.beanAmount - 20;
                machine.cups = machine.cups - 1;
                machine.money = machine.money + 7;
                break;
            case "3":
                if (machine.waterAmount >= 200) { 
					machine.waterAmount = machine.waterAmount - 200;
					System.out.println("I have enough resources, making you a coffee!\n");
				} else {
					System.out.println("Sorry, not enough water"); 
					break;
				}
                machine.milkAmount = machine.milkAmount - 100;
                machine.beanAmount = machine.beanAmount - 12;
                machine.cups = machine.cups - 1;
                machine.money = machine.money + 6;
                break;
            default:
                break;
        }
        
    }
    // updates the variable money
    public static void take(CoffeeMachine machine) {
        System.out.println("I gave you " + machine.money + "\n");
        machine.money = machine.money - machine.money;
    }
    // updates the inventory with amounts specified by the user
    public static void fill(CoffeeMachine machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:"); 
        int waterFill = scanner.nextInt();
        machine.waterAmount = machine.waterAmount + waterFill;
        System.out.println("Write how many ml of milk do you want to add:"); 
        int milkFill = scanner.nextInt();
        machine.milkAmount = machine.milkAmount + milkFill;  
        System.out.println("Write how many grams of coffee beans do you want to add:"); 
        int beanFill = scanner.nextInt();
        machine.beanAmount = machine.beanAmount + beanFill;
        System.out.println("Write how many disposable cups of coffee do you want to add:" );
        int cupFill = scanner.nextInt();
        machine.cups = machine.cups + cupFill;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println();
        String action = "";
        
		while (!action.equals("exit")) {
			System.out.println("Write action (buy, fill, take, remaining, exit):"); 
			action = scanner.next();
			switch (action) {
				case "buy":
					buy(coffeeMachine);
					break;
				case "fill":
					fill(coffeeMachine);					
					break;
				case "take":
					take(coffeeMachine);
					break;
				case "remaining":
					inventory(coffeeMachine);
					break;
				case "exit":
					break;
				default:
					System.out.println("Sorry, I didn't get that. Try again");
					break; 
			}
        }
 
        
        
    }
}
