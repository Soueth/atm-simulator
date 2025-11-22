package interfaces;

import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLessZeroException;

public interface INote {
    public void deposit(int qtd) throws DepositLessZeroException;
    public void remove(int qtd) throws RemoveMoreHaveException, RemoveLessZeroException;
    int getValue();
    int getQtd();
}