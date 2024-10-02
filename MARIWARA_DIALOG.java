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

        while (true) {
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
            String purchasedItems = "";

            JOptionPane.showMessageDialog(null, "Welcome to Mariwara Store");

            while (true) {
                String menu = "Choose the product you want to purchase:\n"
                        + "1. Kwek-kwek ------ $20\n"
                        + "2. Choco Lanay ---- $35\n"
                        + "3. Tawas ---------- $45\n"
                        + "4. Iphone promax -- $12\n"
                        + "5. Papaitan ------- $315";

                String choiceInput = JOptionPane.showInputDialog(menu + "\nEnter Item number (1-5):");
                choice = -1;

                if (choiceInput != null && choiceInput.length() == 1) {
                    char charChoice = choiceInput.charAt(0);
                    if (charChoice >= '1' && charChoice <= '5') {
                        choice = Character.getNumericValue(charChoice);
                    }
                }

                if (choice == -1) {
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select a valid item (1-5).");
                    continue;
                }

                String quantityInput = JOptionPane.showInputDialog("Enter the quantity:");
                quantity = 0;

                if (quantityInput != null && quantityInput.length() > 0) {
                    boolean validQuantity = true;
                    for (int i = 0; i < quantityInput.length(); i++) {
                        if (!Character.isDigit(quantityInput.charAt(i))) {
                            validQuantity = false;
                            break;
                        }
                    }
                    if (validQuantity) {
                        quantity = Integer.parseInt(quantityInput);
                    }
                }

                if (quantity <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid quantity (positive integer).");
                    continue;
                }

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

                String moreItemsInput = JOptionPane.showInputDialog("Do you want to buy more items? (1 for Yes, 0 for No):");
                if (moreItemsInput != null && (moreItemsInput.equals("1") || moreItemsInput.equals("0"))) {
                    choice = Integer.parseInt(moreItemsInput);
                    if (choice == 0) {
                        break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
                }
            }

            JOptionPane.showMessageDialog(null, "Your total purchase is: $" + totalAmount);

            int attempts = 3;
            boolean sufficientCash = false;

            for (int i = 0; i < attempts; i++) {
                String cashInput = JOptionPane.showInputDialog("Enter the amount of cash:");

                if (cashInput != null && cashInput.length() > 0) {
                    boolean validCash = true;
                    for (int j = 0; j < cashInput.length(); j++) {
                        if (!Character.isDigit(cashInput.charAt(j)) && cashInput.charAt(j) != '.') {
                            validCash = false;
                            break;
                        }
                    }
                    if (validCash) {
                        cash = Double.parseDouble(cashInput);
                        if (cash >= totalAmount) {
                            sufficientCash = true;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient cash. You have " + (attempts - i - 1) + " attempt(s) left.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid cash amount.");
                    }
                }
            }

            if (!sufficientCash) {
                JOptionPane.showMessageDialog(null, "Failed to provide sufficient cash after 3 attempts. Restarting from the main menu.");
                continue;
            }

            double change = cash - totalAmount;
            JOptionPane.showMessageDialog(null, "Your change is: $" + change);

            int receipt;
            while (true) {
                String receiptInput = JOptionPane.showInputDialog("Do you want a receipt? (1 for Yes, 0 for No):");
                if (receiptInput != null && (receiptInput.equals("1") || receiptInput.equals("0"))) {
                    receipt = Integer.parseInt(receiptInput);
                    break;
                }
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
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

            if (receipt == 1) {
                JOptionPane.showMessageDialog(null, receiptDetails);
            } else {
                JOptionPane.showMessageDialog(null, "Thank you for shopping! No receipt requested.");
            }

            allTransactions += "Transaction " + (transactionCount + 1) + ":\n" + receiptDetails + "\n";
            transactionCount++;

            int newCustomer;
            while (true) {
                String newCustomerInput = JOptionPane.showInputDialog("Is there a new customer? (1 for Yes, 0 for No):");
                if (newCustomerInput != null && (newCustomerInput.equals("1") || newCustomerInput.equals("0"))) {
                    newCustomer = Integer.parseInt(newCustomerInput);
                    break;
                }
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter 1 for Yes or 0 for No.");
            }

            if (newCustomer == 0) {
                break;
            }
        }

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
