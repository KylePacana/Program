/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariwara_dialog;

import javax.swing.JOptionPane;

/**
 *
 * @author Student
 */
public class MARIWARA_DIALOG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String allTransactions = "";
        int transactionCount = 0;

        while (true) {  // Loop to restart for new customers
            int choice;
            int num1 = 20;
            int num2 = 35;
            int num3 = 45;
            int num4 = 12;
            int num5 = 315;
            int quantity = 0;
            double cash = 0.0;
            double totalAmount = 0.0;
            double result;

            // String to store purchased items for the receipt
            String purchasedItems = "";

            JOptionPane.showMessageDialog(null, "Welcome to Mariwara Store");

            while (true) {  // Loop to handle product selection
                // Show product options
                String menu = "Choose the product you want to purchase:\n"
                        + "1. Kwek-kwek ------ $20\n"
                        + "2. Choco Lanay ---- $35\n"
                        + "3. Tawas ---------- $45\n"
                        + "4. Iphone promax -- $12\n"
                        + "5. Papaitan ------- $315";

                // Ask for item choice and validate
                String choiceInput = JOptionPane.showInputDialog(menu + "\nEnter Item number (1-5):");

                try {
                    choice = Integer.parseInt(choiceInput);

                    if (choice < 1 || choice > 5) {
                        JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid item (1-5).");
                        continue; // Restart the loop for product selection
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number (1-5).");
                    continue; // Restart the loop for product selection
                }

                // Ask for quantity and validate
                String quantityInput = JOptionPane.showInputDialog("Enter the quantity:");

                try {
                    quantity = Integer.parseInt(quantityInput);

                    if (quantity <= 0) {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid quantity (positive integer).");
                        continue; // Restart the loop for product selection
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                    continue; // Restart the loop for product selection
                }

                // Process the chosen item
                switch (choice) {
                    case 1:
                        result = num1 * quantity;
                        totalAmount += result;
                        purchasedItems += "Kwek-kwek x" + quantity + " = $" + result + "\n";
                        break;
                    case 2:
                        result = num2 * quantity;
                        totalAmount += result;
                        purchasedItems += "Choco Lanay x" + quantity + " = $" + result + "\n";
                        break;
                    case 3:
                        result = num3 * quantity;
                        totalAmount += result;
                        purchasedItems += "Tawas x" + quantity + " = $" + result + "\n";
                        break;
                    case 4:
                        result = num4 * quantity;
                        totalAmount += result;
                        purchasedItems += "Iphone promax x" + quantity + " = $" + result + "\n";
                        break;
                    case 5:
                        result = num5 * quantity;
                        totalAmount += result;
                        purchasedItems += "Papaitan x" + quantity + " = $" + result + "\n";
                        break;
                }

                // Ask if they want to buy more items
                String moreItemsInput = JOptionPane.showInputDialog("Do you want to buy more items? (1 for Yes, 0 for No):");
                try {
                    choice = Integer.parseInt(moreItemsInput);
                    if (choice == 0) {
                        break;  // Exit the product selection loop
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
                }
            }

            // Show final total
            JOptionPane.showMessageDialog(null, "Your total purchase is: $" + totalAmount);

            // Ask for the amount of cash and ensure it's sufficient, with validation
            int attempts = 3;  // Number of attempts allowed
            boolean sufficientCash = false;

            for (int i = 0; i < attempts; i++) {
                String cashInput = JOptionPane.showInputDialog("Enter the amount of cash:");

                try {
                    cash = Double.parseDouble(cashInput);

                    if (cash >= totalAmount) {
                        sufficientCash = true;
                        break;  // Sufficient cash, exit the loop
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient cash. You have " + (attempts - i - 1) + " attempt(s) left.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid cash amount.");
                }
            }

            if (!sufficientCash) {
                JOptionPane.showMessageDialog(null, "Failed to provide sufficient cash after 3 attempts. Restarting from the main menu.");
                continue;  // Restart the program from the main menu
            }

            // Calculate change and display
            double change = cash - totalAmount;
            JOptionPane.showMessageDialog(null, "Your change is: $" + change);

            // Ask if they want a receipt
            int receipt;
            while (true) {
                String receiptInput = JOptionPane.showInputDialog("Do you want a receipt? (1 for Yes, 0 for No):");
                try {
                    receipt = Integer.parseInt(receiptInput);
                    break; // Valid input
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
                }
            }

            String receiptDetails = "****** RECEIPT ********\n";
            receiptDetails += "Mariwara Store\n";
            receiptDetails += "Roxas Digos City\n";
            receiptDetails += "Items Purchased:\n";
            receiptDetails += purchasedItems;
            receiptDetails += "Total amount: $" + totalAmount + "\n";
            receiptDetails += "Cash provided: $" + cash + "\n";
            receiptDetails += "Change: $" + change + "\n";
            receiptDetails += "**************************\n";

            // Show receipt
            if (receipt == 1) {
                JOptionPane.showMessageDialog(null, receiptDetails);
            } else {
                JOptionPane.showMessageDialog(null, "Thank you for shopping! No receipt requested.");
            }

            // Append the current transaction to the allTransactions string
            allTransactions += "Transaction " + (transactionCount + 1) + ":\n" + receiptDetails + "\n";
            transactionCount++;  // Increment the transaction count

            // Ask if there's a new customer
            int newCustomer;
            while (true) {
                String newCustomerInput = JOptionPane.showInputDialog("Is there a new customer? (1 for Yes, 0 for No):");
                try {
                    newCustomer = Integer.parseInt(newCustomerInput);
                    break; // Valid input
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
                }
            }

            if (newCustomer == 0) {
                break;  // End the program if no new customer
            }
        }

        // At the end of the day, show summary of all transactions
        if (transactionCount == 0) {
            JOptionPane.showMessageDialog(null, "No transactions occurred today.");
        } else {
            String summary = "****** SUMMARY OF TRANSACTIONS ********\n";
            summary += "Total transactions: " + transactionCount + "\n";
            summary += allTransactions;

            JOptionPane.showMessageDialog(null, summary);
        }

        JOptionPane.showMessageDialog(null, "Thank you for using Mariwara Store!");
    }
}