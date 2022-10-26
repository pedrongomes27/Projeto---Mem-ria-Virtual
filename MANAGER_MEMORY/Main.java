package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
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
        //Instancia do MMU
        MMU mmu = new MMU();
        //Inicialização do HD
        HD_Mem HD = new HD_Mem();
        //Inicialização da memória virtual
        ArrayList<Pagenation> memoriav = mmu.iniciarMemoriaVirtual(storage_Virtual);
        //Inicialização da memória física
        ArrayList<String> memoriaF = mmu.iniciarMemoriaFisica(storage_Virtual);
//        CyclicBarrier barrier = new CyclicBarrier(3);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(mmu, memoriav).start();
        }
    }
}
