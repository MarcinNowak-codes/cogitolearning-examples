package co.uk.cogitolearning.cli;

import co.uk.cogitolearning.calculator.Calculator;
import co.uk.cogitolearning.calculator.EvaluationException;
import co.uk.cogitolearning.calculator.ParserException;
import lombok.experimental.UtilityClass;

/**
 * Command line interface for calculator.
 */
@UtilityClass
public class CalculatorCli {
    /**
     * The main method to test the functionality of the parser.
     */
    public static void main(final String[] args) {

        String expresion = "2*(1+sin(0.5 * pi))^2"; //=8  with pi/2 is problem because DivExpressionNode was introduced. Parser has to be fixed.
        if (args.length > 0) {
            expresion = args[0];
        }

        try {
            Calculator calculator = new Calculator()
                    .withVariable("pi", Math.PI);
            System.out.println("The value of the expression is " + calculator.calculate(expresion));
        } catch (ParserException | EvaluationException e) {
            System.err.println(e.getMessage());
        }
    }

}
