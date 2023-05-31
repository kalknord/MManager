package MManager.Einstellungverhältnis;

import MManager.Mitarbeiter;

class Manager extends Mitarbeiter {
    private String projekt;


    public Manager(String nachname, String vorname, String personalnummer, String abteilung, String projekt) {
        super(nachname, vorname, personalnummer, abteilung);
        this.projekt = projekt;
    }

    public String getProjekt() {
        return projekt;
    }

    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }
}