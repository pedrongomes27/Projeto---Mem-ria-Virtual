package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Processo extends Thread{
    private final CyclicBarrier barrier;
    private ArrayList<String> comandos;
    private MMU MMU;
    private ArrayList<Pagenation> memoria;

    //Construtor
    public Processo(MMU m, ArrayList<Pagenation> memoria, ArrayList<String> comandos, CyclicBarrier barrier) {
        this.MMU = m;
        this.memoria = memoria;
        this.comandos = comandos;
        this.barrier = barrier;
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
                //Chamada do gerenciador de memória
//                MMU.Manager_Memory(memoria);
                for (int i = 1; i< comandos.size()-1; i++) {
                    int endereco = i - 1;
                    int valor = i + 1;
                    //rodar contador na página virtual para identificar por quanto tempo ela ficou ativa
//                        MMU.Manager_Memory(memoria.get(Integer.parseInt(comandos.get(i - 1))), i, comandos.get(i), comandos.get(i - 1), comandos.get(i + 1));
//
//                        memoria.get(i-1).setTimer(memoria.get(i-1).getTimer() + 1);

                    //Se a operação for de leitura, rodar o método para escrever na página virtual
                    if (comandos.get(i).equals("R")) {
                        if (memoria.get(Integer.parseInt(comandos.get(endereco))).getReferenced()) {
                            memoria.get(Integer.parseInt(comandos.get(endereco))).setTimer(memoria.get(Integer.parseInt(comandos.get(i - 1))).getTimer() + 1);
                            if (memoria.get(Integer.parseInt(comandos.get(endereco))).getTimer() >= 20) {
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setBlocked(false);
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setReferenced(false);
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setTimer(0);
                            }
                        }
                        MMU.leitura(memoria.get(Integer.parseInt(comandos.get(endereco))), i, comandos.get(i), comandos.get(endereco)); // 5 - R

                    }
                    //Se a operação for de escrita, rodar o método para escrever na página virtual
                    else if (comandos.get(i).equals("W")) {
                        if (memoria.get(Integer.parseInt(comandos.get(endereco))).getReferenced()) {
                            if (memoria.get(Integer.parseInt(comandos.get(endereco))).getTimer() >= 20) {
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setBlocked(false);
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setReferenced(false);
                                memoria.get(Integer.parseInt(comandos.get(endereco))).setTimer(0);
                            }
                        }
                        MMU.escrita(memoria.get(Integer.parseInt(comandos.get(endereco))), i, comandos.get(i), comandos.get(endereco), comandos.get(valor)); // 3 - W - 56
                    }
                }
                System.out.println("Fim da " + Thread.currentThread().getName() + ": ");
                System.out.println(memoria);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
