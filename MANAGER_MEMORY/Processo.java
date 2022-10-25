package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    MMU buffer;
    Pagenation[] memoria;
    CyclicBarrier barrier;

    Integer storage_Virtual = 10;



    public Processo(MMU b, Pagenation[] memoria, CyclicBarrier barrier) {
        this.buffer = b;
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
                Pagenation[] virtual = buffer.iniciarMemoriaVirtual(storage_Virtual);
                System.out.println(virtual);
                buffer.teste(memoria);
                System.out.println("Fim da thread" + Thread.currentThread().getName() + ": ");
                for(int i = 0; i < memoria.length; i++){
                    System.out.println(memoria[i]);
                    await(barrier);
                }
            }
        }catch(Exception e){
        }
    }
}
