// package com.exemplo;

import classes.atm.ATM;
import classes.notes.NoteFactory;
import enums.NoteValue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ATM atm = new ATM();

        try {
            // Inserir notas de exemplo
            NoteFactory.get(NoteValue.TWO_HUNDRED).deposit(3);
            NoteFactory.get(NoteValue.ONE_HUNDRED).deposit(5);
            NoteFactory.get(NoteValue.FIFTY).deposit(8);
            NoteFactory.get(NoteValue.TWENTY).deposit(12);
            NoteFactory.get(NoteValue.TEN).deposit(15);
            NoteFactory.get(NoteValue.FIVE).deposit(4);
            NoteFactory.get(NoteValue.TWO).deposit(30);
            NoteFactory.get(NoteValue.ONE).deposit(2);

            atm.setEstadoAtual(atm.getStateNoCard());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("======================================= ATM =======================================\n");

        atm.insertCard();
        System.out.println("\n•••\n");
        atm.insertPIN("1234");
        System.out.println("\n•••\n");
        atm.requestWithdraw(347);
        System.out.println("Ejete o cartão.");
        atm.ejectCard();

        System.out.println("============================ OBRIGADO PELA PREFERÊNCIA ============================");
    }
}
