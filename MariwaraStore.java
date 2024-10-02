/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariwara.store;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class MariwaraStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int choice;
        int num1 = 20;
        int num2 = 35;
        int num3 = 45;
        int num4 = 12;
        int num5 = 315;
        int quantity;
        double yes;
        double totalAmount = 0.0;
        double result;

        System.out.println("Welcome to Mariwara Store");

        do {
            // Show product options
            System.out.println("Choose the product you want to purchase, type the number of the product you want to purchase:");
            System.out.println("1. Kwek-kwek ------ $20");
            System.out.println("2. Choco Lanay ---- $35");
            System.out.println("3. Tawas ---------- $45");
            System.out.println("4. Iphone promax -- $12");
            System.out.println("5. Papaitan ------- $315");

            // Ask for item choice and validate
            do {
                System.out.println("Enter Item:");
                choice = input.nextInt();
                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice! Please select a valid item (1-5).");
                }
            } while (choice < 1 || choice > 5);  // Keep asking until a valid choice is entered

            // Process the chosen item
            switch (choice) {
                case 1:
                    System.out.println("Enter the quantity:");
                    quantity = input.nextInt();
                    result = num1 * quantity;
                    totalAmount += result;
                    System.out.println("Your total for Kwek-kwek is: $" + result);
                    break;

                case 2:
                    System.out.println("Enter the quantity:");
                    quantity = input.nextInt();
                    result = num2 * quantity;
                    totalAmount += result;
                    System.out.println("Your total for Choco Lanay is: $" + result);
                    break;

                case 3:
                    System.out.println("Enter the quantity:");
                    quantity = input.nextInt();
                    result = num3 * quantity;
                    totalAmount += result;
                    System.out.println("Your total for Tawas is: $" + result);
                    break;

                case 4:
                    System.out.println("Enter the quantity:");
                    quantity = input.nextInt();
                    result = num4 * quantity;
                    totalAmount += result;
                    System.out.println("Your total for Iphone promax is: $" + result);
                    break;

                case 5:
                    System.out.println("Enter the quantity:");
                    quantity = input.nextInt();
                    result = num5 * quantity;
                    totalAmount += result;
                    System.out.println("Your total for Papaitan is: $" + result);
                    break;
            }

            // Ask if they want to buy more
            System.out.println("Do you want to buy more items? (1 for Yes, 0 for No)");
            choice = input.nextInt();
        } while (choice == 1);  // Continue loop if they want to buy more items

        // Show final total
        System.out.println("Your total purchase is: $" + totalAmount);

        // Ask for the amount of cash and ensure it's sufficient
        do {
            System.out.println("Enter the amount of cash:");
            yes = input.nextDouble();

            if (yes < totalAmount) {
                System.out.println("Insufficient cash. Please enter an amount equal to or greater than the total purchase.");
            }
        } while (yes < totalAmount);

        // Calculate change and display
        double change = yes - totalAmount;
        System.out.println("Your change is: $" + change);

        // Ask if they want a receipt
        System.out.println("Do you want a receipt? (1 for Yes, 0 for No)");
        int receipt = input.nextInt();

        if (receipt == 1) {
            System.out.println("****** RECEIPT ******");
            System.out.println("Mariwara Store");
            System.out.println("Roxas Digos City");
            System.out.println("Total amount: $" + totalAmount);
            System.out.println("Cash provided: $" + yes);
            System.out.println("Change: $" + change);
            System.out.println("************************");
        } else {
            System.out.println("Thank you for shopping! No receipt requested.");
        }

        System.out.println("Thank you for visiting Mariwara Store!");
    }

}
