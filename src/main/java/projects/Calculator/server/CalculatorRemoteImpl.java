package projects.Calculator.server;

import projects.Calculator.shared.CalculatorRemoteInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorRemoteImpl extends UnicastRemoteObject implements CalculatorRemoteInterface {

    protected CalculatorRemoteImpl() throws RemoteException {
    }

    @Override
    public double performOperation(Double op1, Double op2, char operation) throws RemoteException {
        double result = 0.0;
        switch (operation) {
            case '+':
                result = add(op1, op2);
                break;
            case '-':
                result = subtract(op1, op2);
                break;
            case '*':
                result = multiply(op1, op2);
                break;
            case '/':
                result = divide(op1, op2);
                break;

        }
        return result;

    }

    private double add(double op1, double op2) {
        return op1 + op2;

    }

    private double subtract(double op1, double op2) {
        return op1 - op2;

    }

    private double multiply(double op1, double op2) {
        return op1 * op2;

    }

    private double divide(double op1, double op2) {
        try {
            return op1 / op2;
        } catch (ArithmeticException e) {
            return -1.0;
        }

    }
}
