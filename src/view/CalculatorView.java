package view;

import controller.Action;
import controller.Controller;
import dto.AnyNumber;
import dto.ComplexNumber;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculatorView implements View {
    public static final String NUM_REQUEST = "Введите комплексное число в формате a+bi или a-bi, где а - действительная часть, b - мнимая: ";
    private final Controller controller;
    private final Logger logger;

    public CalculatorView(Logger logger, Controller controller) {
        this.controller = controller;
        this.logger = logger;
    }

    @Override
    public void run() throws RuntimeException {
        Action action;

        while (true) {
            String fnStr = prompt(NUM_REQUEST);
            logger.log(Level.INFO, String.format("User input: first number: %s", fnStr));
            AnyNumber fn = new ComplexNumber(fnStr);

            String command = prompt("Введите действие (+,*,/): ");
            logger.log(Level.INFO, String.format("User input: command: %s", command));
            action = switch (command) {
                case "+" -> controller::add;
                case "*" -> controller::multiply;
                case "/" -> controller::divide;
                default -> throw new RuntimeException("Команда (" + command + ") не допустима");
            };

            String snStr = prompt(NUM_REQUEST);
            logger.log(Level.INFO, String.format("User input: second number: %s", snStr));
            AnyNumber sn = new ComplexNumber(snStr);

            AnyNumber result = action.Do(fn, sn);
            String logStr = String.format("%s %s %s = %s", fnStr, command, snStr, result);

            logger.log(Level.INFO, String.format("Result: %s", result));
            System.out.println(logStr);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
