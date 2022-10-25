package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
//TODO: Consertar algoritmo do NRU
//TODO: FAZER INTERAÇÃO COM O HD
//TODO: Utilizar Memória física

public class Main {

    public static void main(String[] args) {
        //definição do espaço na memória
        int storage_Virtual = 10;
        //Definição de quantidade de threads
        int threads = 3;
        //Instancia do buffer
        MMU mmu = new MMU();
        //Inicialização da memória virtual
        ArrayList<Pagenation> memoria = mmu.iniciarMemoriaVirtual(storage_Virtual);
//        CyclicBarrier barrier = new CyclicBarrier(3);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(mmu, memoria).start();
        }
    }
}
