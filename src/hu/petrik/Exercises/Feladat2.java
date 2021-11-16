package hu.petrik.Exercises;

import hu.petrik.Multihalmaz.Multihalmaz;

public class Feladat2 {
    public static void run(){
        Multihalmaz<String> termelo = new Multihalmaz<>();
        Multihalmaz<String> kereskedo = new Multihalmaz<>();
        for(int i = 0; i < 500; i++){
            if(i < 30){
                termelo.add("golden");
            }
            if(i < 50){
                kereskedo.add("golden");
            }
            if(i < 100){
                termelo.add("jonagold");
                kereskedo.add("starking");
            }
            termelo.add("idared");
        }

        System.out.println("Termelő:");
        System.out.println(termelo);

        System.out.println("Kereskedő:");
        System.out.println(kereskedo);

        System.out.println("Termelőnél marad:");
        System.out.println(termelo.different(kereskedo));

        System.out.println("Kereskedő vesz:");
        System.out.println(termelo.intersection(kereskedo));
    }
}
