package Repositories;

import Domain.Parcare;

import java.util.ArrayList;


public class RepoParcare {
    private String nume_fisier;
    private ArrayList<Parcare> parcari;

    public RepoParcare(String nume_fisier){
        this.nume_fisier = nume_fisier;
    };

    private void load_from_file() {

    }

    private void load_to_file(){

    }

    ArrayList<Parcare> getParcari() {
        return parcari;
    }
}
