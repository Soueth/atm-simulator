import java.util.Scanner;

import classes.atm.ATM;
import classes.notes.NoteFactory;
import exceptions.CantDispense;
import exceptions.InsuficientBalanceException;
import exceptions.InvalidValueException;
import exceptions.WrongPINEjectCardException;
import exceptions.DepositLessZeroException;
import exceptions.RemoveLessZeroException;
import exceptions.RemoveMoreHaveException;

/** Menu interativo para o ATM (console) */
public class App {

    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================= ATM =======================================\n");

        try {
            NoteFactory.resetSimulation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        outlast:
        while (true) {
            System.out.println("Menu:");
            System.out.println("1 » Resetar simulação (popular notas)");
            System.out.println("2 » Mostrar estado do ATM (saldo, estado, notas)");
            System.out.println("3 » Inserir cartão");
            System.out.println("4 » Inserir PIN");
            System.out.println("5 » Fazer saque");
            System.out.println("6 » Ejetar cartão");
            System.out.println("0 » Finalizar a simulação");
            System.out.print("\nEscolha uma opção ('0' para sair): ");

            String choice = sc.nextLine().trim();
            System.out.println();

            try {
                switch (choice) {
                    case "1":
                        NoteFactory.resetSimulation();
                        System.out.println("Simulação resetada. Notas atuais:");
                        System.out.println(NoteFactory.notesStatus());
                        break;
                    case "2":
                        System.out.println("Estado atual do ATM: " + atm.getStateName());
                        System.out.println("Saldo da conta: " + atm.getAccountBalance());
                        System.out.println("Notas no ATM:\n" + NoteFactory.notesStatus());
                        break;
                    case "3":
                        atm.insertCard();
                        // System.out.println("Cartão inserido.");
                        break;
                    case "4":
                        System.out.print("Digite PIN: ");
                        String pin = sc.nextLine().trim();
                        atm.insertPIN(pin);
                        // System.out.println("PIN processado.");
                        break;
                    case "5":
                        System.out.print("Valor para saque: ");
                        String sVal = sc.nextLine().trim();
                        int valor = Integer.parseInt(sVal);
                        atm.requestWithdraw(valor);
                        // System.out.println("Saque solicitado: " + valor);
                        break;
                    case "6":
                        atm.ejectCard();
                        // System.out.println("Cartão ejetado.");
                        break;
                    case "0":
                        break outlast;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (WrongPINEjectCardException | InvalidValueException | InsuficientBalanceException
                    | DepositLessZeroException | RemoveLessZeroException | RemoveMoreHaveException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido para número.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }

            System.out.println();
        }

        sc.close();
        System.out.println("============================ OBRIGADO PELA PREFERÊNCIA ============================");
    }
}
