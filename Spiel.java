import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * Klasse Spiel started das Spiel und beinhaltet den Ablauf des Spiels
 * @author Malou Eichhorn on 20.05.22
 */

public class Spiel {
    private Spielfeld Feld;
    private double anfangsbelegung;
    private Scanner UserInput;

    /**
     * neues Objekt der Klasse Spiel, erstellt einen Scanner
      * @param anfangsbelegung übergebene Anfangsbelegung
     * @param Feld neues Objekt der Klasse Spielfeld
     */
    public Spiel(double anfangsbelegung, Spielfeld Feld) {
        this.anfangsbelegung = anfangsbelegung;
        this.Feld = Feld;
        UserInput = new Scanner(System.in);
    }

    /**
     * ein random Spielfeld wird erstellt mithilfe von einer List, welche die Orte aller Zellen speichert
     * die Felder die zu Beginn belegt sind werden zufällig ausgerechnet
     */
    public void generateSpielfeld() {

        int numberOfSpaces = Feld.getSize() * Feld.getSize();
        List<Integer> locations = new ArrayList<>();
        for (int i = 0; i < numberOfSpaces; i++) {
            locations.add(i);
        }
        Collections.shuffle(locations);
        for (int i = 0; i < (int) (numberOfSpaces * anfangsbelegung); i++) {
            int positioneins = locations.get(i) % Feld.getSize();
            int positionzwei = locations.get(i) / Feld.getSize();
            Feld.getZellen()[positioneins][positionzwei].addBelegung();
        }
    }

    /**
     * Methode regeln erstellt die Vorgegeben regeln nach welchen das Spiel abläuft
     */
    public void regeln() {

        for (Zelle a[] : Feld.getZellen()) {
            for (Zelle b : a) {
                //rule1
                if (b.isBelegung() && b.getBelegungnachbarn() == 1 || b.getBelegungnachbarn() == 0) {
                    b.removeBelegung();
                }
                //rule2
                else if (b.isBelegung() && b.getBelegungnachbarn() == 3 || b.getBelegungnachbarn() == 2) {

                }
                //rule3
                else if (b.isBelegung() && b.getBelegungnachbarn() <= 8) {
                    b.removeBelegung();
                }
                //rule4
                else if (!b.isBelegung() && b.getBelegungnachbarn() >= 3) {
                    b.addBelegung();
                }
            }
        }
    }

    /**
     * Methode start, lässt das Spiel beginnen und ruft alle nötigen Methoden auf, sowie überprüft
     * ob das Spiel fortgesetzt werden soll und kann
     */
    public void start() {
        boolean quit;

        generateSpielfeld();
        System.out.println("Random generated board with " + (int) (anfangsbelegung * 100) + "% filled spaces.");
        System.out.println(Feld.toString());
        quit = stop();

        while (!quit) {


            for (Zelle a[] : Feld.getZellen()) {
                for (Zelle b : a) {
                    b.updateFilledNachbarn();
                }
            }
            regeln();

            System.out.println("Gameboard after this round:");
            System.out.println(Feld.toString());
            if (checkgameover()) {
                quit = true;
                System.out.println("Game over! No filled spaces left.");
                continue;
            }
           // muster();
            quit = stop();
        }
    }

    /**
     * Lässt Spieler*innen entscheiden ob sie das Spiel fortsetzten möchten
     * @return true wenn das spiel abgebrochen wird
     */
    public boolean stop() {
        System.out.println("To CONTINUE press any key (or 'q' to quit)");
        if (UserInput.nextLine().equals("q"))
            return true;
        else
            return false;
    }

    /**
     * Fragt Spieler*innen ob sich das Feld verändert hat
     * @return true wenn es als dynamisch charakterisiert
     */
   /* public boolean muster() {
        System.out.println(("Did the Board change?"));
        if (UserInput.nextLine().equals("yes")) {
            System.out.println("Board is dynamic");
            return true; }
        else {
            System.out.println("Board is static");
            return false;
        }
    }*/

    /**
     * überprüfut ob das Spielfeld leer ist
     * @return true, wenn das Spiel abgebrochen wird
     */
    public boolean checkgameover() {
        int filledSpaces = 0;
        for (Zelle a[] : Feld.getZellen()) {
            for (Zelle b : a) {
                if (b.isBelegung()) {
                    filledSpaces++;
                }
            }
        }
        if (filledSpaces == 0) {
            return true;
        }
        return false;
    }
}

