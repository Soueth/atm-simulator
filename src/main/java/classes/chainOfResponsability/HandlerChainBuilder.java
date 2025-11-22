package classes.chainOfResponsability;

import classes.chainOfResponsability.handlers.Handler1;
import classes.chainOfResponsability.handlers.Handler10;
import classes.chainOfResponsability.handlers.Handler100;
import classes.chainOfResponsability.handlers.Handler2;
import classes.chainOfResponsability.handlers.Handler20;
import classes.chainOfResponsability.handlers.Handler200;
import classes.chainOfResponsability.handlers.Handler5;
import classes.chainOfResponsability.handlers.Handler50;
import interfaces.IHandler;

public class HandlerChainBuilder {
    public static IHandler build() {
        IHandler d200 = new Handler200();
        IHandler d100 = new Handler100();
        IHandler d50 = new Handler50();
        IHandler d20 = new Handler20();
        IHandler d10 = new Handler10();
        IHandler d5 = new Handler5();
        IHandler d2 = new Handler2();
        IHandler d1 = new Handler1();

        d200.setNext(d100);
        d100.setNext(d50);
        d50.setNext(d20);
        d20.setNext(d10);
        d10.setNext(d5);
        d5.setNext(d2);
        d2.setNext(d1);

        return d200;
    }
}
