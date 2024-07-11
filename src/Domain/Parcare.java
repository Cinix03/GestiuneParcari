package Domain;

import java.util.ArrayList;

public class Parcare {
    private String adresa;
    private String nume;
    private ArrayList<LocDeParcare> locuriDeParcare = new ArrayList<>();
    private double dimensiune;
    private int locuri_totale;
    private int locuri_ocupate;
    private int locuri_libere;
    private int linii;
    private int coloane;

    /*
    Constructor pentru Domain.Parcare;
     */
    public Parcare(String adresa, String nume, double capacitate, int locuri_totale, int locuri_ocupate, int locuri_libere, int linii, int coloane, String distributieParcare) {
        this.adresa = adresa;
        this.nume = nume;
        this.dimensiune = capacitate;
        this.locuri_totale = locuri_totale;
        this.locuri_ocupate = locuri_ocupate;
        this.locuri_libere = locuri_libere;
        this.linii = linii;
        this.coloane = coloane;
        for(int i=0;i<linii*coloane;i++)
            if(distributieParcare.charAt(i)=='-')
                locuriDeParcare.add(new LocDeParcare(i, true));
            else
                locuriDeParcare.add(new LocDeParcare(i, false));
    };

    @Override
    public String toString() {
        String distributieParcare = "";
        for(LocDeParcare loc : locuriDeParcare)
            if(loc.isFree())
                distributieParcare += "-";
            else
                distributieParcare += "X";
        return adresa+","+nume+","+dimensiune+","+locuri_totale+","+locuri_ocupate+","+locuri_libere+","+linii+","+coloane+","+distributieParcare;
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
    public int getLinii() {return linii;}
    public int getColoane() {return coloane;}
    public ArrayList<LocDeParcare> getLocuriDeParcare() {
        return locuriDeParcare;
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
    public void setLocuriLibere(int locuri_libere) {
        this.locuri_libere=locuri_libere;
    }
    public void setLocuriOcupate(int locuri_ocupate) {
        this.locuri_ocupate = locuri_ocupate;
    }
    public void setLocuriTotale(int locuri_totale) {
        this.locuri_totale=locuri_totale;
    }
    public void setLinii(int linii) {this.linii = linii;}
    public void setColoane(int coloane) {this.coloane = coloane;}
    public void setLocuriDeParcare(String distributieParcare){
        for(int i=0;i<linii*coloane;i++)
            if(distributieParcare.charAt(i)=='-')
                locuriDeParcare.add(new LocDeParcare(i, true));
            else
                locuriDeParcare.add(new LocDeParcare(i, false));
    }

    public void refreshLocuri(){
        int locuri_libere = 0;
        int locuri_ocupate = 0;
        for(LocDeParcare loc : locuriDeParcare)
            if(loc.isFree())
                locuri_libere++;
            else
                locuri_ocupate++;
        this.locuri_libere = locuri_libere;
        this.locuri_ocupate = locuri_ocupate;
    }
}
