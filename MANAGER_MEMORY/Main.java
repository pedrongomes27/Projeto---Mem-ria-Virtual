package MANAGER_MEMORY;

import java.util.ArrayList;
import java.util.Arrays;

import SISTEMA.*;

public class Main {
    
    public static void main(String[] args) {
        //int storage_Virtual = 10;
        //int threads = 3;  
        
        //Ram_Mem Ram = new Ram_Mem(storage_Virtual/2);
        //Virtual_Mem Virtual = new Virtual_Mem();
        //HD_Mem HD=new HD_Mem();
        //Virtual.getMemory_Virtual(storage_Virtual);

            


        //EXEMPLO QUE COMO USAR A FABRICA DE ENTRADAS
        //Memoria Virtual Minima = 10
        //Memoria Virtual Maxima = 40
        int tamanhoDaMinhaMemoriaVirtual = 10;
        String SUA_ENTRADA = new Process(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
        String[] strSplit = SUA_ENTRADA.split("[,]");
        System.out.println(SUA_ENTRADA);
        ArrayList<String> strList = new ArrayList<String>( 
            Arrays.asList(strSplit)); 
        //for (int i = 0; i<strList.size(); i++){
        //    System.out.println(Arrays.asList(strSplit)[i]);
        //}
        System.out.println(strList);
        for (String s : strList) 
            
            System.out.println(s); 
            
        
        
        
    }

    
}