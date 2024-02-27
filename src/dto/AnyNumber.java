package dto;

public abstract class AnyNumber {
    double real;
    double imaginary;

    AnyNumber(double real, double imaginary) throws NumberFormatException {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
}
