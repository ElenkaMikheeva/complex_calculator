package dto;

public class ComplexNumber extends AnyNumber {
    public ComplexNumber(double real, double imaginary) throws NumberFormatException {
        super(real, imaginary);
    }

    public ComplexNumber(String s) throws NumberFormatException {
        super(0, 0);

        if (!s.endsWith("i")) {
            throw new NumberFormatException("incorrect complex number");
        }
        s = s.substring(0, s.length() - 1);

        boolean needNegateReal = false;
        if (s.startsWith("-")) {
            needNegateReal = true;
            s = s.substring(1);
        }

        String[] ss = s.split("\\+");
        // если удалось разбить строку по плюсу, значит мнимая часть положительная
        if (ss.length == 2) {
            imaginary = Double.parseDouble(ss[1]);
        } else {
            ss = s.split("-");
            // если удалось разбить строку по минусу, значит мнимая часть отрицательная
            if (ss.length == 2) {
                imaginary = -Double.parseDouble(ss[1]);
            } else {
                // иначе число имеет не верный формат
                throw new NumberFormatException("incorrect complex number");
            }
        }

        real = Double.parseDouble(ss[0]);
        if (needNegateReal) {
            real = -real;
        }
    }

    @Override
    public String toString() {
        // форматируем действительную часть в строку
        String s = String.format("%01.3f", this.real);
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith(",")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith("0")) {
            s = "";
        }
        // если мнимая часть не равна нулю, форматируем и её
        if (this.imaginary != 0) {
            if (this.imaginary > 0 && !s.isEmpty()) {
                // минус выведится и сам
                s += "+";
            }
            // форматируем мнимую часть в строку
            s = String.format("%s%01.3f", s, this.imaginary);
            while (s.endsWith("0")) {
                s = s.substring(0, s.length() - 1);
            }
            if (s.endsWith(",")) {
                s = s.substring(0, s.length() - 1);
            }
            if (s.endsWith("1")) {
                s = s.substring(0, s.length() - 1);
            }
            s += "i";
        }
        
        if (s.isEmpty()) {
            return "0";
        }
        
        return s;
    }
}
