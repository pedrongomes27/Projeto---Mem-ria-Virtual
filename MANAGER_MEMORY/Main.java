package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;


public class Main {

    public static void main(String[] args) {
        int storage_Virtual = 10;
        int threads = 3;
        //Instancia do buffer
        MMU mmu = new MMU();
        //Inicialização da memória virtual
        ArrayList<Pagenation> memoria = mmu.iniciarMemoriaVirtual(storage_Virtual);
        CyclicBarrier barrier = new CyclicBarrier(3);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(mmu, memoria, barrier).start();
        }
    }
}
