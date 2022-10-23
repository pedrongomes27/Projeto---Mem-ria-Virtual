package MANAGER_MEMORY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Processo extends Thread{
    Buffer buffer;
    HashMap memoria;
    public Processo(Buffer b, HashMap memoria) {
        this.buffer = b;
        this.memoria = memoria;
    }


    public void run(){

        try{
            synchronized(this) {
                HashMap virtual = buffer.iniciarMemoriaVirtual();
                System.out.println(memoria);

                buffer.teste(virtual);
                System.out.println("Process");
            }
        }catch(Exception e){
        }
    }

//    public void leitura(ArrayList strList){
//        int tamanhoDaMinhaMemoriaVirtual = 10;
//        String SUA_ENTRADA = new Process(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
//        String[] strSplit = SUA_ENTRADA.split("[-,]");
//        System.out.println(SUA_ENTRADA);
//        ArrayList<String> strList = new ArrayList<String>(
//                Arrays.asList(strSplit));
//        System.out.println(strList);
//        String endereco = "";
//        String escrita = "";
//        for (int i = 0; i<strList.size(); i++) {
//            if (strList.get(i).contains("R")) {
//                endereco = strList.get(i - 1);
//                System.out.println("LENDO O ENDERECO " + endereco);
//                System.out.println(memoriaVirtual.get(Integer.parseInt(endereco)));
//            }
//            if (strList.get(i).contains("W")) {
//                endereco = strList.get(i - 1);
//                escrita = strList.get(i + 1);
//                System.out.println("ESCREVENDO " + escrita + " NO ENDERECO " + endereco);
//                memoriaVirtual.put(Integer.parseInt(endereco), escrita);
//            }
//
//        }
//        System.out.println(memoriaVirtual);
//    }



}
