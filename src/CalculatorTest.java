class CalculatorTest {
    static int passed = 0;
    static int failed = 0;
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        test("Add", calculator.add(2, 3), 5.0);
        test("Subtract", calculator.subtract(2, 3), -1.0);
        test("Multiply", calculator.multiply(2, 3), 6.0);
        test("Divide", calculator.divide(6, 3), 2.0);
        try {
            calculator.divide(1, 0);
            System.out.println("FAIL: Divide by zero should throw an exception");
            failed++;
        } catch (IllegalArgumentException e) { // CHANGED: Now matches the thrown exception
            System.out.println("PASS: Divide by zero throws exception");
            passed++;
        }
        System.out.println("\nResults: " + passed + " passed, " + failed + " failed");
    }
    static void test(String name, double actual, double expected) {
        if (actual == expected) {
            System.out.println("PASS: " + name);
            passed++;
        } else {
            System.out.println("FAIL: " + name + " (expected " + expected + ", got " + actual + ")");
            failed++;
        }
    }
}