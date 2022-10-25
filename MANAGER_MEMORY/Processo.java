package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    MMU MMU;
    ArrayList<Pagenation> memoria;
    CyclicBarrier barrier;

    Integer storage_Virtual = 10;

    public Processo(MMU m, ArrayList<Pagenation> memoria) {
        this.MMU = m;
        this.memoria = memoria;
    }

    public void await(CyclicBarrier Barrier) {
        try {
            Barrier.await();
        } catch (Exception e) {
        }
    }


    public void run(){

        try{
            synchronized(this) {
                //Inicialização das memórias virtual e física
                ArrayList<Pagenation> virtual = MMU.iniciarMemoriaVirtual(storage_Virtual);
                ArrayList<Pagenation> Fisica = MMU.iniciarMemoriaFisica(storage_Virtual);
                System.out.println(virtual);
                //Chamada do genrenciador de memória
                MMU.Manager_Memory(memoria);
                System.out.println("Fim da thread" + Thread.currentThread().getName() + ": ");

            }
        }catch(Exception e){
        }
    }
}