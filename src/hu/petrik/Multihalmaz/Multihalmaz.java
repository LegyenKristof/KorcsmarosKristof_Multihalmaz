package hu.petrik.Multihalmaz;

import java.util.ArrayList;
import java.util.List;

public class Multihalmaz<T>{
    private List<T> elemLista;
    private List<Integer> mennyisegLista;

    public Multihalmaz(){
        elemLista = new ArrayList<>();
        mennyisegLista = new ArrayList<>();
    }

    public void add(T elem){
        if(elemLista.contains(elem)){
            int index = elemLista.indexOf(elem);
            mennyisegLista.set(index, mennyisegLista.get(index) + 1);
        }
        else{
            elemLista.add(elem);
            mennyisegLista.add(1);
        }
    }

    public void remove(T elem){
        if(elemLista.contains(elem)){
            int index = elemLista.indexOf(elem);
            if(mennyisegLista.get(index) == 1){
                elemLista.remove(index);
                mennyisegLista.remove(index);
            }
            else{
                mennyisegLista.set(index, mennyisegLista.get(index) - 1);
            }
        }
    }

    public int getSize(){
        return elemLista.size();
    }

    public void clear(){
        elemLista.clear();
        mennyisegLista.clear();
    }

    public boolean isElement(T elem){
        return elemLista.contains(elem);
    }

    public boolean isEmpty(){
        return elemLista.size() == 0;
    }

    public boolean isEqual(Multihalmaz<T> masikHalmaz){
        boolean equals = true;
        if(elemLista.size() == masikHalmaz.getSize()){
            for (int i = 0; i < elemLista.size(); i++){
                if(masikHalmaz.isElement(elemLista.get(i))){
                    int index = masikHalmaz.elemLista.indexOf(elemLista.get(i));
                    if(mennyisegLista.get(i) != masikHalmaz.mennyisegLista.get(index)){
                        equals = false;
                    }
                }
                else{
                    equals = false;
                }
            }
        }
        else{
            equals = false;
        }
        return equals;
    }

    public boolean isPartOf(Multihalmaz<T> masikHalmaz){
        boolean partOf = true;
        for(int i = 0; i < elemLista.size(); i++){
            if (!masikHalmaz.isElement(elemLista.get(i))){
                partOf = false;
            }
        }
        return partOf;
    }

    public Multihalmaz<T> unio(Multihalmaz<T> masikHalmaz){
        Multihalmaz<T> unio = masikHalmaz;
        for(int i = 0; i < elemLista.size(); i++){
            T elem = elemLista.get(i);
            if(unio.isElement(elem)){
                int index = unio.elemLista.indexOf(elem);
                unio.mennyisegLista.set(index, mennyisegLista.get(i));
            }
            else{
                unio.elemLista.add(elem);
                unio.mennyisegLista.add(mennyisegLista.get(i));
            }
        }
        return unio;
    }

    public Multihalmaz<T> intersection(Multihalmaz<T> masikHalmaz){
        Multihalmaz<T> intersection = new Multihalmaz<>();
        for (int i = 0; i < elemLista.size(); i++){
            T elem = elemLista.get(i);
            if(masikHalmaz.isElement(elem)){
                intersection.elemLista.add(elem);
                intersection.mennyisegLista.add(Math.min(mennyisegLista.get(i), masikHalmaz.mennyisegLista.get(masikHalmaz.elemLista.indexOf(elem))));
            }
        }
        return intersection;
    }

    public Multihalmaz<T> different(Multihalmaz<T> masikHalmaz){
        Multihalmaz<T> different = this;
        for (int i = 0; i < different.getSize(); i++){
            T elem = elemLista.get(i);
            if(masikHalmaz.isElement(elem)){
                int mennyiseg = mennyisegLista.get(i) - masikHalmaz.mennyisegLista.get(masikHalmaz.elemLista.indexOf(elem));
                if(mennyiseg <= 0){
                    different.elemLista.remove(i);
                    different.mennyisegLista.remove(i);
                    i--;
                }
                else{
                    different.mennyisegLista.set(i, mennyiseg);
                }
            }
        }
        return different;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < elemLista.size(); i++){
            s += elemLista.get(i) + " " + mennyisegLista.get(i) + "\n";
        }
        return s;
    }
}
