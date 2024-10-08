package Repositories;

import Domain.Parcare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class RepoParcare {
    private String nume_fisier;
    private ArrayList<Parcare> parcari = new ArrayList<>();

    public RepoParcare(String nume_fisier) throws IOException {
        this.nume_fisier = nume_fisier;
        load_from_file();
    };

    public Parcare getParcare(String adr){
        for(Parcare p : parcari){
            if(p.getAdresa() == adr){
                return p;
            }
        }
        return null;
    }

    public void adaugaParcare(Parcare parcare) {
        parcari.add(parcare);
        load_to_file();
    }

    public void stergeParcare(String adr) {
        for(Parcare p : parcari) {
            if(p.getAdresa() == adr){
                parcari.remove(p);
                break;
            }
        }
        load_to_file();
    }

    private void load_from_file() throws IOException {
        try{
            List<String> lines = Files.readAllLines(Paths.get(nume_fisier));
            for(String line : lines){
                String[] parts = line.split(",");
                Parcare p = new Parcare(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), parts[8]);
                parcari.add(p);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void load_to_file(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nume_fisier))) {
            int maxx = parcari.size();
            int cnt=1;
            for (Parcare p : parcari) {
                writer.write(p.toString());
                if(cnt<maxx)
                    writer.write("\n");
                cnt++;
            }
            writer.newLine(); // Adds a new line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Parcare> getParcari() {
        return parcari;
    }

}
