package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class MMU {

    //Definindo tamanho da memória virtual(A física é definida matematicamente pela divisão da virtual por 2)
    Integer storageVirtual = 10;

    //Chamada da fábrica de entradas
    private String SUA_ENTRADA = new EntryFactory(storageVirtual).getNewEntrada(), endereco = "", escrita = "";
    //Dando split para tirar o hífen e a vírgula
    private String[] strSplit = SUA_ENTRADA.split("[-,]");
    //Transformando em arraylist
    private ArrayList<String> strList = new ArrayList<String>(Arrays.asList(strSplit));

    //  NRU algoritmo = new NRU();

    //Método para iniciar a memória virtual
    public Pagenation[] iniciarMemoriaVirtual(Integer storageVirtual) {
        storageVirtual = this.storageVirtual;
        Pagenation[] memoriaVirtual = new Pagenation[storageVirtual];
        for (int i = 0; i < storageVirtual; i++) {
            memoriaVirtual[i] = new Pagenation(i);
        }
        System.out.println(Arrays.toString(memoriaVirtual));
        return memoriaVirtual;
    }

    //Método para iniciar a memória física
    public Pagenation[] iniciarMemoriaFisica(Integer espacoMemoriaVirtual) {
        Integer storage_Fisica = espacoMemoriaVirtual/2;
        Pagenation[] memoriaFisica = new Pagenation[storage_Fisica];
        for (int i = 0; i < storage_Fisica; i++) {
            memoriaFisica[i] = new Pagenation(i);
        }
        System.out.println(Arrays.toString(memoriaFisica));
        return memoriaFisica;
    }

    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void PorLista(Pagenation[] memoriaVirtual){
        for(Pagenation pag : memoriaVirtual){
            if(!pag.getReferenced() && !pag.getModified()) { // CLASSE 0
                pag.setReferenced(false);pag.setReference(0); pag.setModified(false);pag.setPresent(false);pag.setVirtual_Page(null);pag.setValue(null);pag.setBlocked(false);
            }
            if(!pag.getReferenced() && pag.getModified()) { //  CLASSE 1
                pag.setReferenced(false); pag.setReference(0); pag.setModified(false); pag.setPresent(false); pag.setVirtual_Page(null); pag.setValue(null); pag.setBlocked(false);
            }
            if(pag.getReferenced() && !pag.getModified()) { //  CLASSE 2
                pag.setReferenced(false); pag.setReference(0); pag.setModified(false); pag.setPresent(false); pag.setVirtual_Page(null); pag.setValue(null); pag.setBlocked(false);
            }
            if(pag.getReferenced() && pag.getModified()) { //   CLASSE 3
                pag.setReferenced(false); pag.setReference(0); pag.setModified(false); pag.setPresent(false); pag.setVirtual_Page(null); pag.setValue(null); pag.setBlocked(false);
            }
        }
    }

    public void bloqueado(Pagenation memoriaVirtual) throws InterruptedException {
        if(memoriaVirtual.getBlocked()) {
            memoriaVirtual.setBlocked(true);
            System.out.println("bloqueado");
            sleep(1000);
            memoriaVirtual.setBlocked(false);
        }
    }

    public void desbloqueado(Pagenation memoriaVirtual) throws InterruptedException {
        if(memoriaVirtual.getBlocked()) {
            memoriaVirtual.setBlocked(false);
            System.out.println("desbloqueado");
        }
    }

    public void verificar(Pagenation[] memoriaVirtual)  throws InterruptedException {
        for(Pagenation pag : memoriaVirtual) {
            if(pag.getTimer() == 20){
                pag.setReferenced(false);
            }
        }
    }


    public synchronized void leitura(Pagenation[] memoriaVirtual, int i) throws InterruptedException {
        sleep((long)(Math.random() * 900));
        endereco = strList.get(i - 1);
        Pagenation p = memoriaVirtual[Integer.valueOf(endereco)];

        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (memoriaVirtual[Integer.valueOf(endereco)].getBlocked()) {
            bloqueado(memoriaVirtual[Integer.valueOf(endereco)]);
            System.out.println("bloqueado");
            return;
        }
        //Se a página não existir, dizer que não existe e pular
        else if (!memoriaVirtual[Integer.valueOf(endereco)].getModified()) {
            bloqueado(memoriaVirtual[Integer.valueOf(endereco)]);
            memoriaVirtual[Integer.valueOf(endereco)].setReferenced(true);
            sleep(200);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println("Página vazia");
          memoriaVirtual[Integer.valueOf(endereco)].setBlocked(false);
        //Se existir e não estiver bloqueada, ler normalmente
        } else {
            bloqueado(memoriaVirtual[Integer.valueOf(endereco)]);
            memoriaVirtual[Integer.valueOf(endereco)].setReferenced(true);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            sleep((long)(Math.random() * 100));
        }
        sleep((long)(Math.random() * 100));
        memoriaVirtual[Integer.valueOf(endereco)].setBlocked(false);
    }

    public synchronized void escrita(Pagenation[] memoriaVirtual, int i) throws InterruptedException {
        sleep((long)(Math.random() * 500));
        endereco = strList.get(i - 1);
        escrita = strList.get(i + 1);
        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (memoriaVirtual[Integer.valueOf(endereco)].getBlocked()) {
            return;
        }
        //Se a página não existir, criar uma
        if (!memoriaVirtual[Integer.valueOf(endereco)].getModified()) {
            System.out.println(Thread.currentThread().getName()+" Criando " + escrita + " NO ENDERECO " + endereco);
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(true);
            memoriaVirtual[Integer.valueOf(endereco)].setValue(Integer.valueOf(escrita));
            memoriaVirtual[Integer.valueOf(endereco)].setVirtual_Page(Integer.valueOf(endereco));
            memoriaVirtual[Integer.valueOf(endereco)].setReferenced(true);
            memoriaVirtual[Integer.valueOf(endereco)].setModified(true);
            memoriaVirtual[Integer.valueOf(endereco)].setPresent(true);
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(false);
            System.out.println(memoriaVirtual[Integer.valueOf(endereco)]);
            System.out.println("Página criada");
            sleep((long)(Math.random() * 500));
        }

        //Se existir e não estiver bloqueada, escrever normalmente
        else {
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(true);
            System.out.println(Thread.currentThread().getName()+" ESCREVENDO " + escrita + " NO ENDERECO " + endereco);
            memoriaVirtual[Integer.valueOf(endereco)].setValue(Integer.valueOf(escrita));
            memoriaVirtual[Integer.valueOf(endereco)].setVirtual_Page(Integer.valueOf(endereco));
            memoriaVirtual[Integer.valueOf(endereco)].setReferenced(true);
            memoriaVirtual[Integer.valueOf(endereco)].setModified(true);
            memoriaVirtual[Integer.valueOf(endereco)].setPresent(true);
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(false);
            System.out.println(memoriaVirtual[Integer.valueOf(endereco)]);
            System.out.println("Página atualizada");
            sleep((long)(Math.random() * 500));
        }
        sleep(20);
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas páginas
    public void teste(Pagenation[] memoriaVirtual) throws InterruptedException {
        System.out.println(SUA_ENTRADA);
        for (int i = 0; i<strList.size(); i++) {
            //rodarmetodo
            for(Pagenation pag : memoriaVirtual) {
                desbloqueado(pag);
                pag.setTimer(pag.getTimer() + 1);
                if(pag.getReferenced()){
                    if(pag.getTimer() >= 20){
                        pag.setReferenced(false);
                        pag.setTimer(0);
                    }
                }
            }


            //Se a operação for de leitura, rodar o método para escrever na página virtual
            if (strList.get(i).contains("R")) {
                leitura(memoriaVirtual, i);
            }
            //Se a operação for de escrita, rodar o método para escrever na página virtual
            else if (strList.get(i).contains("W")) {
                escrita(memoriaVirtual, i);
            }
        }
        System.out.println(memoriaVirtual);
    }
}

