/**
 * Klasse Spielfeld, erstellt Spielfelder und legt die Bedingungen fest
 * @author Malou Eichhorn on 20.05.22
 */

public class Spielfeld {
    private Zelle [][] Spielzellen;
    private int size;
    private boolean zyklisch;

    /**
     * Ein Objekt der Klasse wird erstellt
     * @param size die Größe des Feldes
     * @param zyklisch ist das Spielfeld zyklisch oder nicht
     */
    public Spielfeld (int size, boolean zyklisch){
        this.size = size;
        this.zyklisch = zyklisch;
        Spielzellen = new Zelle[size][size];

        for (int positioneins = 0; positioneins<size; positioneins++) {
            for (int positionzwei=0; positionzwei<size; positionzwei++) {
                Spielzellen [positioneins][positionzwei] = new Zelle (positioneins, positionzwei);
            }
        }
        for (Zelle a[] : Spielzellen)
            for (Zelle b : a) {
                setgrenzen(b);
                setnachbarn(b);
            }
    }

    /**
     * Methode setzt die Grenzen fest
     * @param Zellen werden als Grenzen festgelegt
     */
    private void setgrenzen(Zelle Zellen) {
        if (!zyklisch) {
            if (Zellen.getPositioneins() == 0)
                Zellen.setGrenzenord(true);
            if (Zellen.getPositioneins() == size)
                Zellen.setGrenzesued(true);
            if (Zellen.getPositionzwei() == 0)
                Zellen.setGrenzewest(true);
            if (Zellen.getPositionzwei() == size)
                Zellen.setGrenzeost(true);
        }
    }

    /**
     * setzt Nachbarn fest und überprüft ob die Zellen Grenzen sind
     * @param Zellen
     */
    private void setnachbarn(Zelle Zellen) {
        if (!Zellen.isGrenzenord())
            setAngrenzendeZellen(Zellen,"north","");
        if (!Zellen.isGrenzenord() && !Zellen.isGrenzeost() )
            setAngrenzendeZellen(Zellen,"north","east");
        if (!Zellen.isGrenzeost())
            setAngrenzendeZellen(Zellen,"","east");
        if (!Zellen.isGrenzeost() && !Zellen.isGrenzesued())
            setAngrenzendeZellen(Zellen,"south","east");
        if (!Zellen.isGrenzesued())
            setAngrenzendeZellen(Zellen,"south","");
        if (!Zellen.isGrenzesued() && !Zellen.isGrenzewest())
            setAngrenzendeZellen(Zellen,"south","west");
        if (!Zellen.isGrenzewest())
            setAngrenzendeZellen(Zellen,"","west");
        if (!Zellen.isGrenzewest() && !Zellen.isGrenzenord())
            setAngrenzendeZellen(Zellen,"north","west");

        System.out.println(Zellen.getBoardPosition().toString() + " has following neighbors: " + Zellen.printNachbarn());
    }

    /**
     * Setzt Angrenzende Zellen und berechnet ihre Position
     * @param Zellen
     * @param vertical ist die Position auf der Y-Achse
     * @param horizontal ist die Position auf der X-Achse
     */
    private void setAngrenzendeZellen(Zelle Zellen, String vertical, String horizontal) {
        int positioneins = Zellen.getPositioneins();
        int positionzwei = Zellen.getPositionzwei();
        int modulus = size;

        switch(vertical) {
            case "south":
                positioneins = Math.floorMod(positioneins+1, modulus);
                break;
            case "north":
                positioneins = Math.floorMod(positioneins-1, modulus);
                break;
        }
        switch(horizontal) {
            case "east":
                positionzwei = Math.floorMod(positionzwei+1,modulus);
                break;
            case "west":
                positionzwei = Math.floorMod(positionzwei-1, modulus);
                break;
        }

        Zellen.addNachbarn(Spielzellen [positioneins] [positionzwei]);

    }

    /**
     * Erzeugt das Spielfeld, welches zu sehen ist
     * @return die zu sehenden Zellen mit . und 1, je nach Belegung
     */
    public String toString() {
        StringBuffer toPrint = new StringBuffer();
        for (Zelle a[] : Spielzellen) {
            for (Zelle b : a) {
                toPrint.append(" ");
                if (!b.isBelegung())
                    toPrint.append(".");
                else
                    toPrint.append("1");
                toPrint.append(" ");
            }
            toPrint.append("\n");
        }
        return toPrint.toString();
    }

    /**
     * Gibt die Spielfeldgröße (Länge bzw Breite) zurück
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gibt die Zellen zurück
     * @return Spielzellen
     */
    public Zelle[][] getZellen(){
        return Spielzellen ;
    }
}
