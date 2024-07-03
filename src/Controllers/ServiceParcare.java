package Controllers;

import Domain.Parcare;
import Repositories.RepoParcare;

import java.util.ArrayList;

public class ServiceParcare {
    private RepoParcare r;
    public ServiceParcare(RepoParcare r) {
        this.r = r;
    }
    public ArrayList<Parcare> get_all(){
        return r.getParcari();
    }
}
