
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }


public boolean isPositive(int number) {
        return number > 0;
    }

    public String describeNumber(int number) {
    if (number > 100) {
        return "Large number";
    }
    return null; // deliberately returns nothing for numbers 100 or below
}
}
