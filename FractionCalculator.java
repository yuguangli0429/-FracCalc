import java.util.*;

public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("This program is a fractional calculator");
        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q tp quit");
        System.out.println("Please enter your fraction in the form of a/b, where a and b are integers");

        boolean booleanResult = true;
        boolean yes = true;
        Fraction neg = new Fraction(-1);
        Fraction zero = new Fraction();
        Fraction result = new Fraction(1,1);
        while (yes) {
            int bug = 0;
            String operation = getOperation();
            Fraction fac1 = getFraction();
            Fraction fac2 = getFraction();
            if (fac2.equals(zero) && operation.equals("/")) {
                bug = 1;
            } else {
                if (operation.equals("=")) {
                    booleanResult = fac1.equals(fac2);
                } else if (operation.equals("+")) {
                    result = fac1.add(fac2);
                } else if (operation.equals("-")) {
                    result = fac1.subtract(fac2);
                } else if (operation.equals("/")) {
                    result = fac1.divide(fac2);
                } else if (operation.equals("*")) {
                    result = fac1.multiply(fac2);
                }
            }

            //Print results
            if (bug == 0) {
                if (result.getDenominator() < 0) {
                    result.numerator = result.numerator*(-1);
                    result.denominator = result.denominator*(-1);
                }

                if (result.getNumerator() ==0) {
                    System.out.println(fac1 + " " + operation + " " + fac2 + " = " + "0");
                }
                else if (result.getNumerator() % result.getDenominator() == 0) {
                    System.out.println(fac1+" "+ operation+" "+ fac2 + " = " + (result.getNumerator()/result.getDenominator()));
                }
                else{
                    System.out.println(fac1 + " " + operation + " " + fac2 + " = " + result);
                }
            } else {
                System.out.println("Can not divide by 0, please try again");
            }
        }

    }

    public static String getOperation() {
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.print("Please enter an operation (+, -, *, /, =, or Q to quit):");
        String operation = input.nextLine();
        int n = 0;
        while (n < 1) {
            if (operation.equals("Q")) {
                System.exit(0);
            } else if (operation.equals("+") || operation.equals("-") || operation.equals("/") || operation.equals("*") || operation.equals("=")) {
                n++;
            } else {
                System.out.println("Invalid input, please enter an operation (+, -, *, /, =, or Q to quit):");
                operation = input.nextLine();
            }
        }
        return operation;
    }
    public static boolean validFraction(String fraction) {
        boolean valid = true;
        if (fraction.contains("/")) {
        fraction = fraction.replace("/", "");
        }

        if (fraction.contains("-")) {
        fraction = fraction.replace("-", "");
        }

        if (fraction.matches("[0-9]+")) {
            valid = true;
        } else {valid = false;}

        return valid;
    }

    public static Fraction getFraction() {
        System.out.print("Please enter a Fraction (a/b) or integer (a): ");
        String numDe = input.nextLine();

        while (!validFraction(numDe)) {
            System.out.print("Invalid Fraction, Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            numDe = input.nextLine();
        }

        int num = 0;
        int De = 0;

        if (numDe.contains("/")) {
            num = Integer.parseInt(numDe.substring(0, numDe.indexOf("/")));
            De = Integer.parseInt(numDe.substring(numDe.indexOf("/")+1, numDe.length()));
        } else {
            num = Integer.parseInt(numDe);
            De = 1;
        }

        Fraction numDeF = new Fraction(num, De);
        return numDeF;
    }
}
