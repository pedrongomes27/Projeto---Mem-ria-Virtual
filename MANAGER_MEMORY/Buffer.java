package MANAGER_MEMORY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Buffer {
    int inicio = 0;
    int tamanhoDaMinhaMemoriaVirtual = 10;
    String SUA_ENTRADA = new Process(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
    String[] strSplit = SUA_ENTRADA.split("[-,]");
    ArrayList<String> strList = new ArrayList<String>(
            Arrays.asList(strSplit));
    String endereco = "";
    String escrita = "";


    public HashMap iniciarMemoriaVirtual() {
        HashMap<Integer, String> memoriaVirtual = new HashMap<>();
        int storage_Virtual = 10;
        for (int i = 0; i < storage_Virtual; i++) {
            memoriaVirtual.put(i, null);
            }

        return memoriaVirtual;
    }

    public HashMap iniciarMemoriaFisica() {
        HashMap<Integer, String> memoriaFisica = new HashMap<>();
        while (inicio == 0) {
            int storage_Virtual = 10;


            for (int i = 0; i < storage_Virtual / 2; i++) {
                memoriaFisica.put(i, null);
            }
            System.out.println(memoriaFisica);
            inicio = 1;
        }
        return memoriaFisica;
    }
    public void teste(HashMap memoriaVirtual){
        for (int i = 0; i<strList.size(); i++) {
            if (strList.get(i).contains("R")) {
                endereco = strList.get(i - 1);
                System.out.println("LENDO O ENDERECO " + endereco);
                System.out.println(memoriaVirtual.get(Integer.parseInt(endereco)));
            }
            if (strList.get(i).contains("W")) {
                endereco = strList.get(i - 1);
                escrita = strList.get(i + 1);
                System.out.println("ESCREVENDO " + escrita + " NO ENDERECO " + endereco);
                memoriaVirtual.put(Integer.parseInt(endereco), escrita);
            }
        }
        System.out.println(memoriaVirtual);
    }


//    public String pegarEntrada(String tipo, String entrada){
//        if (tipo.contains("R")) {
//            endereco = strList.get(i - 1);
//            System.out.println("LENDO O ENDERECO " + endereco);
//            System.out.println(memoriaVirtual.get(Integer.parseInt(endereco)));
//        }
//
//
//        return entrada;
//    }



}
