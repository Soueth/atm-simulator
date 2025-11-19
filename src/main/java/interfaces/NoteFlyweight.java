package interfaces;

import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLeseZeroException;

public interface NoteFlyweight {
    public void deposit(int amount) throws DepositLessZeroException;
    public void remove(int amount) throws RemoveMoreHaveException, RemoveLeseZeroException;
    int getValue();
    int getAmount();
}