package interfaces;

import exceptions.DepositLessZeroException;
import exceptions.RemoveMoreHaveException;
import exceptions.RemoveLeseZeroException;

public interface INote {
    public void deposit(int qtd) throws DepositLessZeroException;
    public void remove(int qtd) throws RemoveMoreHaveException, RemoveLeseZeroException;
    int getValue();
    int getQtd();
}