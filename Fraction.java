import java.util.InputMismatchException;

public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int num, int de) {
        if (de == 0) {
            throw new IllegalArgumentException("Denominator can not be zero");
        }
        else if (de < 0) {
            this.numerator = -1*num;
            this.denominator = -1*de;
        }
        else {
            this.numerator = num;
            this.denominator = de;
        }
    }

    public Fraction(int num) {
        this.numerator = num;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;

    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return Integer.toString(numerator) + '/' + Integer.toString(denominator);
    }

    public double toDouble() {
         int i = (numerator/denominator);
         Double d = i*1.0;
         return d;
    }

    public Fraction add(Fraction other) {
        Fraction ans = new Fraction(this.numerator*other.denominator + this.denominator*other.numerator,this.denominator*other.denominator);
        ans.toLowestTerms();
        return ans;
    }

    public Fraction subtract(Fraction other) {
        Fraction ans = new Fraction(((this.numerator*other.denominator) - (this.denominator*other.numerator)),(this.denominator*other.denominator));
        //ans.toLowestTerms();
        return ans;
    }

    public Fraction multiply(Fraction other) {
        Fraction ans = new Fraction((this.numerator*other.numerator), (this.denominator*other.denominator));
        ans.toLowestTerms();
        return ans;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException();
        } else {
            Fraction ans = new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
            ans.toLowestTerms();
            return ans;
        }
    }

    public boolean equals(Object other) {
        if (other instanceof  Fraction) {
            Fraction newOther = (Fraction) other;
            return (this.numerator*newOther.denominator == this.denominator*newOther.numerator);
        }
        else {throw new InputMismatchException("Please enter a Fraction");}
    }

    public void toLowestTerms(){
        if (this.numerator != 0) {
            int gcd = gcd(this.numerator, this.denominator);
            this.numerator = this.numerator / gcd;
            this.denominator = this.denominator / gcd;
        } else {this.numerator = 0;}

    }
     public static int gcd(int a, int b) {
        while (a!=0 && b!=0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
     }
}
