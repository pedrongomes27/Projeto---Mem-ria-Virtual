package MANAGER_MEMORY;

import java.util.ArrayList;

import SISTEMA.*;

public class Main {
    
    public static void main(String[] args) {
        int storage_Virtual = 10;
        int threads = 3;  
        
        Ram_Mem Ram = new Ram_Mem(storage_Virtual/2);
        Virtual_Mem Virtual = new Virtual_Mem();
        HD_Mem HD=new HD_Mem();
        Virtual.getMemory_Virtual(storage_Virtual);
        try {
            for(int i=1; i <= threads; i++){
             
            ArrayList<String> IN = new ArrayList<String>();
                     
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        //EXEMPLO QUE COMO USAR A FABRICA DE ENTRADAS
        //Memoria Virtual Minima = 10
        //Memoria Virtual Maxima = 40
        int tamanhoDaMinhaMemoriaVirtual = 10;
        String SUA_ENTRADA = new Process(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
        System.out.println(SUA_ENTRADA);
    }

    
}