package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //definição do espaço na memória
        int storage_Virtual = 10;
        //Definição de quantidade de threads
        int threads = 3;
        //Instancia do MMU
        MMU mmu = new MMU();
        //Iniciando HD
        ArrayList<HD_Mem> HD = mmu.iniciarHD(storage_Virtual);

        ArrayList<String> HDsaida = new ArrayList<>();
        //Inicialização da memória virtual
        ArrayList<Pagenation> memoriaVirtual = mmu.iniciarMemoriaVirtual(storage_Virtual);
        //Inicialização da memória Física
        ArrayList<String> memoriaFisica = mmu.iniciarMemoriaFisica(storage_Virtual);
        //Criação das Threads
        for(int i = 0; i < threads; i++){
            new Processo(mmu, memoriaVirtual, memoriaFisica, HDsaida, HD).start();
        }
    }
}