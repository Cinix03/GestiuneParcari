package Repositories;

import Domain.Parcare;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class RepoParcare {
    private String nume_fisier;
    private ArrayList<Parcare> parcari;

    public RepoParcare(String nume_fisier) throws IOException {
        this.nume_fisier = nume_fisier;
        load_from_file();
    };

    private void load_from_file() throws IOException {
        try{
            List<String> lines = Files.readAllLines(Paths.get(nume_fisier));
            for(String line : lines){
                String[] parts = line.split(",");
                Parcare p = new Parcare(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                parcari.add(p);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void load_to_file(){

    }

    public ArrayList<Parcare> getParcari() {
        return parcari;
    }
}
