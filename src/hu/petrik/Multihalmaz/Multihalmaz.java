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
            /*for (int i = 0; i < elemLista.size(); i++){

            }*/
        }
        else{
            equals = false;
        }
        return equals;
    }

    /*
    remove
    unio
    intersection
    isEqual
    different
     */
}
