package hu.petrik.Exercises;

import hu.petrik.Multihalmaz.Multihalmaz;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feladat3 {
    public static void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nyelvek száma: ");
        int nyelvekSzama = scanner.nextInt();

        System.out.print("Versenyzők száma: ");
        int versenyzokSzama = scanner.nextInt();
        scanner.nextLine();

        List<String> nyelvek = new ArrayList<>();
        System.out.println("Választható nyelvek:");
        for(int i = 0; i < nyelvekSzama; i++){
            String nyelv = scanner.nextLine();
            nyelvek.add(nyelv);
        }

        Multihalmaz<String> valasztottak = new Multihalmaz<>();
        List<Integer> illegalis = new ArrayList<>();
        System.out.println("Választott nyelvek:");
        for(int i = 0; i < versenyzokSzama; i++){
            String nyelv = scanner.nextLine();
            if(nyelvek.contains(nyelv)){
                valasztottak.add(nyelv);
            }
            else {
                illegalis.add(i + 1);
            }
        }
        scanner.close();

        System.out.println("\nIllegális nyelv(ek):");
        for (int i : illegalis){
            System.out.println(i + ". versenyző");
        }

        System.out.println("Nem választott nyelv(ek):");
        for (String s : nyelvek){
            if(!valasztottak.isElement(s)){
                System.out.println(s);
            }
        }

        System.out.println("Választott nyelv(ek):");
        System.out.println(valasztottak);
    }
}
