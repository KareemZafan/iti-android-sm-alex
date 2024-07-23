package iti.app.org;

public class Calculator {
    //todo
    /*
     * add
     * div
     * sub
     * mul
     * sqrt
     * mod
     * */

    public double add(double a, double b) {

        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double div(double a, double b) {
        double res = 0;

        if (b != 0) {
            res = a / b;
            if (res == 0) return Math.abs(res);
            return res;
        }

        throw new ArithmeticException("Division by zero!!!");
    }

    public double mul(double a, double b) {
        double res = a * b;
        if (res == 0) return Math.abs(res);
        return res;
    }

    public double getSquareRoot(double a) {
        return Math.sqrt(a);
    }

    public int getModulus(int a, int b) {
        return Math.floorMod(a, b);
    }

}
