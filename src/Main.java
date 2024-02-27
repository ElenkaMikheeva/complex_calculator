import controller.CalculatorController;
import controller.Controller;
import model.Calculator;
import model.ComplexCalculator;
import utils.Log;
import view.CalculatorView;
import view.View;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Log.log(Main.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "===============================================================\nMethod main in model package started");

        Calculator calc = new ComplexCalculator();
        Controller ctrl = new CalculatorController(calc);
        View view = new CalculatorView(logger, ctrl);

        try {
            view.run();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}