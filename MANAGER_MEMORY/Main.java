package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {

        //definição do espaço na memória
        int storage_Virtual = 10;
        //Chamada do método para criar as entradas
        String SUA_ENTRADA = new EntryFactory(storage_Virtual).getNewEntrada();
        //Dando split para retirar o hífen e a vírgula
        String[] strSplit = SUA_ENTRADA.split("[-,]");
        //Transformando a lista String[] srtSplit em arraylist para facilitar o manuseio dos indices
        ArrayList<String> comandos = new ArrayList<String>(Arrays.asList(strSplit));


        //Definição de quantidade de threads
        int threads = 3;
        //Instancia do MMU
        MMU mmu = new MMU();
        //Inicialização da memória virtual
        ArrayList<Pagenation> memoriav = mmu.iniciarMemoriaVirtual(storage_Virtual);
        CyclicBarrier barrier = new CyclicBarrier(threads);
        System.out.println(SUA_ENTRADA);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(mmu, memoriav, comandos, barrier).start();
        }
    }
}