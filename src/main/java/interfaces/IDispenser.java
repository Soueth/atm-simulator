package interfaces;

import exceptions.CantDispense;

public interface IDispenser {
    void setNext(IDispenser next);
    void dispense(int amount) throws CantDispense;
}
