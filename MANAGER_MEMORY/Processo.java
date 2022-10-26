package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    MMU MMU;
    ArrayList<Pagenation> memoria;

    Integer storage_Virtual = 10;

    //Construtor
    public Processo(MMU m, ArrayList<Pagenation> memoria) {
        this.MMU = m;
        this.memoria = memoria;
    }

//    public void await(CyclicBarrier Barrier) {
//        try {
//            Barrier.await();
//        } catch (Exception e) {
//        }
//    }


    public void run(){

        try{
            //Para realizar um multi processamento
            synchronized(this) {
                System.out.println(memoria);
                //Chamada do gerenciador de memória
                MMU.Manager_Memory(memoria);
                System.out.println("Fim da thread" + Thread.currentThread().getName() + ": ");

            }
        }catch(Exception e){
        }
    }
}