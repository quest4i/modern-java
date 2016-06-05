package cc.quest4i.modernjava.e01;

/**
 * Created by samyeong-gu on 2016. 6. 5..
 */
public class OopAndFpExample {


    public static void main(String[] args) {

    }



    interface Calculation {

        int calculate(final int num1, final int num2);
    }


    class Addtion implements Calculation {

        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    }


    class Subtraction implements Calculation {

        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    }


    class Multiplication implements Calculation {

        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    }


    class Division implements Calculation {

        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    }

    class CalculatorService {

        private final Calculation addition;
        private final Calculation subtraction;
        private final Calculation multiplication;
        private final Calculation division;

        public CalculatorService(final Calculation addition, final Calculation subtraction, final Calculation multiplication, final Calculation division) {
            this.addition = addition;
            this.subtraction = subtraction;
            this.multiplication = multiplication;
            this.division = division;
        }

        public int add(final int num1, final int num2) {
            if (num1 > 10 && num2 < num1) {  // boilerplate code
                return addition.calculate(num1, num2);
            } else {
                throw new IllegalArgumentException("Invalid input num1: " + num1 + ", num2: " + num2);  // boilerplate code
            }
        }
    }
}
