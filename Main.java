/**
 * Main Klasse übergibt anfangsbelegung und Spielgröße und ob das Spielfeld zyklisch ist
 * @author Malou Eichhorn on 20.05.22
 */
public class Main {

    public static void main(String[] args) {
        Spielfeld conwayBoard = new Spielfeld(10, true);
            Spiel conwayGame = new Spiel(0.75, conwayBoard);
            conwayGame.start();
        }
    }
