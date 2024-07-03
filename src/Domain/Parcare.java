package Domain;

public class Parcare {
    private String adresa;
    private String nume;
    private double dimensiune;
    private int locuri_totale;
    private int locuri_ocupate;
    private int locuri_libere;

    /*
    Constructor pentru Domain.Parcare;
     */
    public Parcare(String adresa, String nume, double capacitate, int locuri_totale, int locuri_ocupate, int locuri_libere) {
        this.adresa = adresa;
        this.nume = nume;
        this.dimensiune = capacitate;
        this.locuri_totale = locuri_totale;
        this.locuri_ocupate = locuri_ocupate;
        this.locuri_libere = locuri_libere;
    };

    @Override
    public String toString() {
        return adresa+","+nume+","+dimensiune+","+locuri_totale+","+locuri_ocupate+","+locuri_libere;
    }

    /*
        getter pentru adresa
         */
    public String getAdresa() {
        return adresa;
    }
    /*
    getter pentru nume
     */
    public String getNume() {
        return nume;
    }
    public double getDimensiune() {
        return dimensiune;
    }
    public int getLocuriTotale() {
        return locuri_totale;
    }
    public int getLocuriOcupate() {
        return locuri_ocupate;
    }
    public int getLocuriLibere() {
        return locuri_libere;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setCapacitate(double capacitate) {
        this.dimensiune = capacitate;
    }
    public void setLocuriLibere(int locuri_totale) {
        this.locuri_totale = locuri_totale;
    }
    public void setLocuriOcupate(int locuri_ocupate) {
        this.locuri_ocupate = locuri_ocupate;
    }
    public void setLocuriTotale(int locuri_libere) {
        this.locuri_libere = locuri_libere;
    }

}
