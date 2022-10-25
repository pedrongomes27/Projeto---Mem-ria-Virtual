package SISTEMA;

import java.util.ArrayList;

public class Ram_Mem {

    private ArrayList<Pagenation> memory_RAM;
    private int storage = -1;

    public Ram_Mem(int storage){
        this.storage = storage;
        this.memory_RAM = new ArrayList<Pagenation>(5);
    }

    public Pagenation getMemory_RAM(Integer index) {
        return memory_RAM.get(index);
    }
    public void setMemory_RAM(Integer index, Pagenation pagina) {
        this.memory_RAM.add(index, pagina);
    }

    public Integer getIndexFree(){  //Retornar se há algum espaço de memoria RAM vazio

        for(int i=0; i<=memory_RAM.size(); i++){

           if(memory_RAM.get(i)== null){
               System.out.println("Tem espaço no Index [" + i + "]");
               return i;
           }

        }
        System.out.println("Não tem espaço na RAM");
        return null;
    }

}