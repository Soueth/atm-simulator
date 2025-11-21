package classes.chainOfResponsability;

import classes.chainOfResponsability.dispensers.Dispenser1;
import classes.chainOfResponsability.dispensers.Dispenser10;
import classes.chainOfResponsability.dispensers.Dispenser100;
import classes.chainOfResponsability.dispensers.Dispenser2;
import classes.chainOfResponsability.dispensers.Dispenser20;
import classes.chainOfResponsability.dispensers.Dispenser200;
import classes.chainOfResponsability.dispensers.Dispenser5;
import classes.chainOfResponsability.dispensers.Dispenser50;
import interfaces.IDispenser;

public class DispenserChainBuilder {
    public static IDispenser build() {
        IDispenser d200 = new Dispenser200();
        IDispenser d100 = new Dispenser100();
        IDispenser d50 = new Dispenser50();
        IDispenser d20 = new Dispenser20();
        IDispenser d10 = new Dispenser10();
        IDispenser d5 = new Dispenser5();
        IDispenser d2 = new Dispenser2();
        IDispenser d1 = new Dispenser1();

        d200.setNext(d100);
        d100.setNext(d50);
        d50.setNext(d20);
        d20.setNext(d10);
        d10.setNext(d5);
        d5.setNext(d2);
        d2.setNext(d1);

        return d100; // devolve o primeiro da cadeia
    }
}
