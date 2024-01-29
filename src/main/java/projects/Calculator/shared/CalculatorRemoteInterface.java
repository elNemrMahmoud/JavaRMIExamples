package projects.Calculator.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorRemoteInterface extends Remote {
    public double performOperation(Double op1, Double op2, char operation) throws RemoteException;

}
