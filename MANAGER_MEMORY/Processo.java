// PROCESSO SÃO AS THREADS
package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Processo extends Thread{
    private ArrayList<String> HDsaida;
    private ArrayList<HD_Mem> HD;
    private ArrayList<String> memoriaFisica;
    private MMU MMU;
    private ArrayList<Pagenation> memoria;
    private NRU NRU;

    private int storage_Virtual = 10;

    private String SUA_ENTRADA = new EntryFactory(storage_Virtual).getNewEntrada();
    //Dando split para retirar o hífen e a vírgula
    private String[] strSplit = SUA_ENTRADA.split("[-,]");
    //Transformando a lista String[] srtSplit em arraylist para facilitar o manuseio dos indices
    private ArrayList<String> comandos = new ArrayList<String>(Arrays.asList(strSplit));


    //Construtor
    public Processo(MMU m, ArrayList<Pagenation> memoriaVirtual, ArrayList<String> memoriaFisica, ArrayList<String> HDsaida, ArrayList<HD_Mem> HD) {
        this.MMU = m;
        this.memoria = memoriaVirtual;
        this.NRU = new NRU();
        this.memoriaFisica = memoriaFisica;
        this.HDsaida = HDsaida;
        this.HD = HD;
    }

    public void run(){
        try{
            //Para realizar um multi processamento
            synchronized(this) {
                for (int i = 1; i< comandos.size()-1; i++) {
                    Instant start = Instant.now(); // inicio do timer
                    int endereco = i - 1;
                    int valor = i + 1;

                    //Se a operação for de leitura, rodar o método para escrever na página virtual
                    if (comandos.get(i).equals("R")) {
                        MMU.leitura(memoria.get(Integer.parseInt(comandos.get(endereco))), comandos.get(endereco)); // 5 - R
                    }
                    //Se a operação for de escrita, rodar o método para ler na página virtual
                    if (comandos.get(i).equals("W")) {
                        MMU.escrita(memoria.get(Integer.parseInt(comandos.get(endereco))), comandos.get(endereco), comandos.get(valor)); // 3 - W - 56
                        MMU.inserirFisica(String.valueOf(valor), memoriaFisica);
                        //Caso a memória virtual esteja sem página
                        if (!memoria.get(Integer.parseInt(comandos.get(endereco))).verificarFaltaPag(memoria) ){
                            MMU.inserirHD(String.valueOf(endereco), String.valueOf(valor), HDsaida);//vai inserir o valor dentro do hd 
                            NRU.executarNRU(memoria, endereco);
                        }
                    }
                    Instant end = Instant.now();
                    // fim do timer para zerar as páginas virtuais
                    if(Duration.between(start, end).getSeconds() >= 1){
                        MMU.tirarRerenciado(memoria);
                    }
                }
                System.out.println("Fim da " + Thread.currentThread().getName() + ": ");
                System.out.println(memoria);
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
