package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.Map;
import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    Buffer buffer;
    Pagenation[] memoria;
    CyclicBarrier barrier;
    private int threadsUpdatedSomething;



    public Processo(Buffer b, Pagenation[] memoria, CyclicBarrier barrier) {
        this.buffer = b;
        this.memoria = memoria;
        this.barrier = barrier;
    }


    public void run(){

        try{
            synchronized(this) {
                Pagenation[] virtual = buffer.iniciarMemoriaVirtual();
                System.out.println(virtual);
                barrier.await();
                buffer.teste(memoria);
                System.out.println("Fim da thread" + Thread.currentThread().getName() + ": ");
                for(int i = 0; i < memoria.length; i++){
                    System.out.println(memoria[i]);
                }
            }
        }catch(Exception e){
        }
    }

    public void await(CyclicBarrier Barrier) {
        try {
            System.out.println("A turma " + barrier + " está esperando");
            Barrier.await();
        } catch (Exception e) {
        }
    }

}
