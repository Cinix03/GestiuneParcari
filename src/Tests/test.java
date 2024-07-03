package Tests;

import Domain.Parcare;
import Repositories.RepoParcare;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.util.ArrayList;


public class test {
    @BeforeAll
    public static void initAll() {
        System.out.println("Before all tests");
        Path sourcePath = Paths.get("/Users/vasilegeorge/IdeaProjects/JavaFirst/src/Tests/CopyFrom.txt");
        Path targetPath = Paths.get("/Users/vasilegeorge/IdeaProjects/JavaFirst/src/Tests/DataTest.txt");
        try{
            Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @Test
    public void testDomain() {
        Parcare p = new Parcare("aici", "Nume1", 200.5, 40, 35, 5);
        Assertions.assertTrue(p.getNume().equals("Nume1"));
        Assertions.assertTrue(p.getAdresa().equals("aici"));
        Assertions.assertEquals(200.5, p.getDimensiune(), 0.0001);
        Assertions.assertEquals(p.getLocuriTotale(), 40);
        Assertions.assertEquals(p.getLocuriOcupate(), 35);
        Assertions.assertEquals(p.getLocuriLibere(), 5);
        p.setAdresa("aici1");
        Assertions.assertTrue(p.getAdresa().equals("aici1"));
        p.setNume("Nume2");
        Assertions.assertTrue(p.getNume().equals("Nume2"));
        p.setCapacitate(210.5);
        Assertions.assertEquals(p.getDimensiune(), 210.5, 0.0001);
        p.setLocuriLibere(20);
        Assertions.assertEquals(p.getLocuriLibere(), 20);
        p.setLocuriOcupate(20);
        Assertions.assertEquals(p.getLocuriOcupate(), 20);
        p.setLocuriTotale(0);
        Assertions.assertEquals(p.getLocuriTotale(), 0);
    }

    @Test
    public void testRepo() throws IOException {
        initAll();
        RepoParcare repo = new RepoParcare("/Users/vasilegeorge/IdeaProjects/JavaFirst/src/Tests/DataTest.txt");
        ArrayList<Parcare> l = repo.getParcari();
        System.out.println(l.size());
        Assertions.assertTrue(l.size() == 15);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Tests have executed perfectly");
    }

}
