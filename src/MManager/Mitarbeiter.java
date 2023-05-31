package MManager;
public class Mitarbeiter {
    private String nachname;
    private String vorname;
    private String personalnummer;
    private String abteilung;

    public Mitarbeiter(String nachname, String vorname, String personalnummer, String abteilung) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.personalnummer = personalnummer;
        this.abteilung = abteilung;
    }

    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getPersonalnummer() {
        return personalnummer;
    }
    public void setPersonalnummer(String personalnummer) {
        this.personalnummer = personalnummer;
    }
    public String getAbteilung() {
        return abteilung;
    }
    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }


}