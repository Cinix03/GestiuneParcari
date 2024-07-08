package Controllers;

import Domain.Parcare;
import Repositories.RepoParcare;
import Validators.ValidationException;
import Validators.ValidatorParcare;

import java.util.ArrayList;

public class ServiceParcare {
    private RepoParcare r;
    private ValidatorParcare v = new ValidatorParcare();
    public ServiceParcare(RepoParcare r) {
        this.r = r;
    }
    public ArrayList<Parcare> get_all(){
        return r.getParcari();
    }
    public void adaugaParcare(Parcare p) throws ValidationException {
        v.validate(p);
        r.adaugaParcare(p);
    }
    public void stergeParcare(String adresa) throws ValidationException {
        r.stergeParcare(adresa);
    }
}
