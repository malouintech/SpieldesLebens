import java.util.ArrayList;
import java.util.List;
/**
 * Erstelllt die einzelnen Zellen des Spielfeldes
 * @author Malou Eichhorn on 20.05.22
 */


public class Zelle {
    private List<Zelle> nachbarn;
    private boolean belegung;
    private boolean grenzenord;
    private boolean grenzesued;
    private boolean grenzeost;
    private boolean grenzewest;
    private int belegungnachbarn;
    private int positioneins;
    private int positionzwei;
    private StringBuffer boardPosition;

    /**
     * Erstellt eine Zelle mit den Positionen
     * @param positioneins ist die Position auf der X-Achse
     * @param positionzwei ist die Position auf der Y-Achse
     */
    public Zelle(int positioneins, int positionzwei) {
        this.belegung = false;
        this.belegungnachbarn = 0;
        this.positioneins = positioneins;
        this.positionzwei = positionzwei;
        nachbarn = new ArrayList<Zelle>();

        grenzenord = false;
        grenzeost = false;
        grenzesued = false;
        grenzewest = false;

         boardPosition = new StringBuffer();
         boardPosition.append(positioneins);
         boardPosition.append("-");
         boardPosition.append(positionzwei);
    }

    /**
     * Fügt neue Zellen zur List nachbarn hinzu
     * @param Zellen übergibt die entsprechended Zelle
     */
    public void addNachbarn(Zelle Zellen) {
        this.nachbarn.add(Zellen);
    }

    /**
     * Belegung wird hinzugefügt
     */
    public void addBelegung() {
            belegung = true;
    }

    /**
     * Belegung wird entfernt
     */
    public void removeBelegung() {
        belegung = false;
    }

    /**
     * Gibt zurück ob eine Zelle belegt ist
     * @return belegung true oder false
     */

    public boolean isBelegung() {
        return belegung;
    }

    /**
     * Gibt die Position zurück
     * @return positioneins ist die Position auf der X-Achse
     */
    public int getPositioneins() {
        return positioneins;
    }

    /**
     * Gibt die Position zurück
     * @return positionzwei ist die Position auf der Y-Achse
     */
    public int getPositionzwei() {
        return positionzwei;
    }

    /**
     * Gibt die Position (X und Y Wert) zurück
     * @return boardPosition als StringBuffer, X und Y Wert werden als veränderbarer String zurückgegeben
     */
    public StringBuffer getBoardPosition() {
        return boardPosition;
    }

    /**
     * gibt alle Nachbarn in einem String aus
     * @return StringBuffer aller Nachbarn
     */
    public String printNachbarn() {
        StringBuffer alleNachbarn = new StringBuffer();
        for (Zelle a : nachbarn) {
            alleNachbarn.append(a.boardPosition.toString());
            alleNachbarn.append(" | ");
        }
        return alleNachbarn.toString();
    }

    /**
     * wie viele der Nachbarn sind belegt
     * @return belegungnachbarn
     */
    public int getBelegungnachbarn() {
        return belegungnachbarn;
    }

    /**
     * Nachbarn werden überprüft und Anzahl wird verändert
     */
    public void updateFilledNachbarn() {
        setBelegungNachbarn(0);
        for(Zelle c : nachbarn) {
            if(c.isBelegung()) {
                setBelegungNachbarn(getBelegungnachbarn()+1);
            }
        }
    }

    /**
     * setzt Grenze nord
     * @param grenzenord
     */
    public void setGrenzenord(boolean grenzenord) {
        this.grenzenord = grenzenord;
    }

    /**
     * setzt Grenze süd
     * @param grenzesued
     */
    public void setGrenzesued(boolean grenzesued) {
        this.grenzesued = grenzesued;
    }

    /**
     * setzt Grenze Ost
     * @param grenzeost
     */
    public void setGrenzeost(boolean grenzeost) {
        this.grenzeost = grenzeost;
    }

    /**
     * setzt Grenze west
     * @param grenzewest
     */
    public void setGrenzewest(boolean grenzewest) {
        this.grenzewest = grenzewest;
    }

    /**
     * überprüft ob eine Zelle eine Grenze (Nord) ist
     * @return grenzenord
     */
    public boolean isGrenzenord() {
        return grenzenord;
    }
    /**
     * überprüft ob eine Zelle eine Grenze (Süd) ist
     * @return grenzesued
     */
    public boolean isGrenzesued() {
        return grenzesued;
    }
    /**
     * überprüft ob eine Zelle eine Grenze (Ost) ist
     * @return grenzeost
     */
    public boolean isGrenzeost() {
        return grenzeost;
    }
    /**
     * überprüft ob eine Zelle eine Grenze (West) ist
     * @return grenzewest
     */
    public boolean isGrenzewest() {
        return grenzewest;
    }
/**
 * setzt Belegung der Nachbarn fest
 * @param belegungnachbarn ist die Anzahl der belegten Nachbarn
 */
    public void setBelegungNachbarn(int belegungnachbarn) {
        this.belegungnachbarn = belegungnachbarn;
    }
}


