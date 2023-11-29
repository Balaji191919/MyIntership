import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final List<Expense> expenses = new ArrayList<>();
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    viewExpenseSummaries();
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Expense Tracker Menu:");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. View Expense Summaries");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = s.nextLine();

        System.out.print("Enter expense amount: ");
        double amount = s.nextDouble();
        s.nextLine();

        System.out.print("Enter expense category: ");
        String category = s.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        Expense newExpense = new Expense(description, amount, category);
        expenses.add(newExpense);

        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("Expense List:");
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    private static void viewExpenseSummaries() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }

        Map<String, Double> categorySummaries = new HashMap<>();
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();
            categorySummaries.put(category, categorySummaries.getOrDefault(category, 0.0) + amount);
        }

        System.out.println("Expense Summaries:");
        for (Map.Entry<String, Double> entry : categorySummaries.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static class Expense {
        private String description;
        private double amount;
        private String category;

        public Expense(String description, double amount, String category) {
            this.description = description;
            this.amount = amount;
            this.category = category;
        }

        public String getDescription() {
            return description;
        }

        public double getAmount() {
            return amount;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Description: " + description + ", Amount: " + amount + ", Category: " + category;
        }
    }
}