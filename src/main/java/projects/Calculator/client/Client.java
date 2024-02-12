package projects.Calculator.client;

import projects.Calculator.shared.CalculatorRemoteInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {
    private static Double op1;
    private static Double op2;
    private static Character operation;

    public Client() {
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough arguments inserted");
        } else {
            CalculatorRemoteInterface calculator = getConnectionInterface();
            if (isCorrectFormat(args));
            {
                try {
                    System.out.println("The result is : "+calculator.performOperation(op1,op2,operation));
                } catch (RemoteException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }

    public static CalculatorRemoteInterface getConnectionInterface() {
        CalculatorRemoteInterface calculator = null;
        try {
            Registry reg = LocateRegistry.getRegistry(1199);
            calculator =
                    (CalculatorRemoteInterface) reg.lookup("CalculatorService");
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (NotBoundException e) {
            System.out.println(e.getMessage());
        }
        return calculator;
    }

    public static boolean isCorrectFormat(String[] args) {
        try {
            op1=Double.parseDouble(args[0]);
            op2=Double.parseDouble(args[2]);

        } catch (NumberFormatException e) {
            System.out.println("Operand incorrect Format");
            return false;
        }
        if (args[1].length() == 1) {
            char op = args[1].charAt(0);
            switch (op) {
                case '+':
                    operation = '+';
                    break;
                case '-':
                    operation = '-';
                    break;
                case '*':
                    operation = '*';
                    break;
                case '/':
                    operation = '/';
                    break;
            }
        } else {
            System.out.println("Incorrect Operation");
            return false;
        }
        return true;

    }



}
