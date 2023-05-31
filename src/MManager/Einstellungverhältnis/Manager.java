package MManager.Einstellungverhältnis;

import MManager.Mitarbeiter;

class Manager extends Mitarbeiter {
    private String projekt;


    public Manager(String nachname, String vorname, String personalnummer, String abteilung, String projekt) {
        super(nachname, vorname, personalnummer, abteilung);
        this.projekt = projekt;
    }

    public String mitarbeiterInfoAnzeigen() {
        StringBuilder output = new StringBuilder();
        output.append("Manager:\n");
        output.append("Vorname: ").append(getVorname()).append("\n");
        output.append("Nachname: ").append(getNachname()).append("\n");
        output.append("Personalnummer: ").append(getPersonalnummer()).append("\n");
        output.append("Abteilung: ").append(getAbteilung()).append("\n");
        output.append("Projekt: ").append(getProjekt()).append("\n\n");
        return output.toString();
    }

    public String getProjekt() {
        return projekt;
    }

    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }
}