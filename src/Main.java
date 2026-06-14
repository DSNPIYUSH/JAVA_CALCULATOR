import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        boolean running = true;
        System.out.println("Simple Java Calculator");
        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                System.out.println("\nEnter an operation (+, -, *, /) or 'q' to quit:");
                String op = scanner.nextLine().trim();
            if (op.equalsIgnoreCase("q")) {
                running = false;
                continue;
            }
            if (!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")) {
                System.out.println("Invalid operator. Try again.");
                continue;
            }
            try {
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Enter second number: ");
                double b = Double.parseDouble(scanner.nextLine().trim());
                double result = switch (op) {
                    case "+" -> calculator.add(a, b);
                    case "-" -> calculator.subtract(a, b);
                    case "*" -> calculator.multiply(a, b);
                    case "/" -> calculator.divide(a, b);
                    default -> 0;
                };
                System.out.println("Result: " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered. Try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        }
        System.out.println("Goodbye!");
    }
}