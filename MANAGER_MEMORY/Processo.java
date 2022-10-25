package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    MMU MMU;
    ArrayList<Pagenation> memoria;
    CyclicBarrier barrier;

    Integer storage_Virtual = 10;

    public Processo(MMU m, ArrayList<Pagenation> memoria, CyclicBarrier barrier) {
        this.MMU = m;
        this.memoria = memoria;
        this.barrier = barrier;
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
                ArrayList<Pagenation> virtual = MMU.iniciarMemoriaVirtual(storage_Virtual);
                ArrayList<Pagenation> Fisica = MMU.iniciarMemoriaFisica(storage_Virtual);
                System.out.println(virtual);
                MMU.Manager_Memory(memoria);
                System.out.println("Fim da thread" + Thread.currentThread().getName() + ": ");
                for(int i = 0; i < memoria.size(); i++){
                    System.out.println(memoria.get(i));
                    await(barrier);
                }
            }
        }catch(Exception e){
        }
    }
}