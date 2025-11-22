package interfaces;
public interface IHandler {
    void setNext(IHandler next);
    int dispense(int amount);
}
