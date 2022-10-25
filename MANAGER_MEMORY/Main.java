package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.concurrent.CyclicBarrier;


public class Main {

    public static void main(String[] args) {
        int storage_Virtual = 10;
        int threads = 3;
        //Instancia do buffer
        MMU b = new MMU();
        //Inicialização da memória virtual
        Pagenation[] memoria = b.iniciarMemoriaVirtual(storage_Virtual);
        CyclicBarrier barrier = new CyclicBarrier(3);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(b, memoria, barrier).start();
        }
    }
}



//        Ram_Mem Ram = new Ram_Mem(storage_Virtual/2);
//        Virtual_Mem Virtual = new Virtual_Mem();
//        HD_Mem HD=new HD_Mem();
//        Virtual.getMemory_Virtual(storage_Virtual);
//        try {
//            for(int i=1; i <= threads; i++){
//
//            ArrayList<String> IN = new ArrayList<String>();
//
//        }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//int threads = 3;
//        HashMap<Integer, String> memoriaVirtual = new HashMap<>();
//
//        for(int i = 0; i < storage_Virtual; i++) {
//            memoriaVirtual.put(i, null);
//        }
//        System.out.println(memoriaVirtual);
//
//        HashMap<Integer, String> memoriaFisica = new HashMap<>();
//
//        for(int i = 0; i < storage_Virtual/2; i++) {
//            memoriaFisica.put(i, null);
//        }
//        System.out.println(memoriaFisica);
//

//Ram_Mem Ram = new Ram_Mem(storage_Virtual/2);
//        Virtual_Mem Virtual = new Virtual_Mem();
//        //HD_Mem HD=new HD_Mem();
//        Virtual.Virtual_Mem(storage_Virtual);
//        Array HD_Dados_Programa = {0-5, 1-5, 2-4, 3-0, 4-10, 5-2, 6-8, 7-3};
//        Array MemVirtual = {null,null,null,null, null,null,null,null};
//        Array MemFisica = {null,null,null,null};


//EXEMPLO QUE COMO USAR A FABRICA DE ENTRADAS
//Memoria Virtual Minima = 10
//Memoria Virtual Maxima = 40



//        int tamanhoDaMinhaMemoriaVirtual = 10;
//        String SUA_ENTRADA = new EntryFactory(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
//        System.out.println(SUA_ENTRADA);
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
//
//        System.out.println(memoriaVirtual);