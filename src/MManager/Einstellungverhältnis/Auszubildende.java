package MManager.Einstellungverhältnis;

import MManager.Mitarbeiter;

public class Auszubildende extends Mitarbeiter {
    private int ausbildungsjahr;

    public Auszubildende(String nachname, String vorname, String personalnummer, String abteilung,
            int ausbildungsjahr) {
        super(nachname, vorname, personalnummer, abteilung);
        this.ausbildungsjahr = ausbildungsjahr;
    }

    public int getAusbildungsjahr() {
        return ausbildungsjahr;
    }

    public void setAusbildungsjahr(int ausbildungsjahr) {
        this.ausbildungsjahr = ausbildungsjahr;
    }

    @Override
    public String toString() {
        return getVorname() + " " + getNachname() + " (Auszubildende)";
    }
}
