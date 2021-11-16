package hu.petrik;

import hu.petrik.Multihalmaz.Multihalmaz;

public class Main {

    public static void main(String[] args) {
        Multihalmaz<String> a = new Multihalmaz<>();
        Multihalmaz<String> b = new Multihalmaz<>();
        for(int i = 0; i < 10; i++){
            a.add("alma");
            a.add("alma");
            b.add("alma");
            a.add("körte");
            b.add("körte");
            b.add("körte");
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.different(b));
        System.out.println(b.different(a));
        System.out.println(a);
        System.out.println(b);
    }
}
