package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    private ArrayList<String> comandos = new ArrayList<String>(Arrays.asList(strSplit));

    //  NRU algoritmo = new NRU();

    //Método para iniciar a memória virtual
    public ArrayList<Pagenation> iniciarMemoriaVirtual(Integer storageVirtual) {

        ArrayList<Pagenation> memoriaVirtual = new ArrayList<Pagenation>(storageVirtual);
        for (int i = 0; i < storageVirtual; i++) {
            memoriaVirtual.add(i, new Pagenation());
        }
        System.out.println(memoriaVirtual);
        return memoriaVirtual;
    }

    //Método para iniciar a memória física
    public ArrayList<Pagenation> iniciarMemoriaFisica(Integer espacoMemoriaVirtual) {
        Integer storage_Fisica = espacoMemoriaVirtual / 2;
        ArrayList<Pagenation> memoriaFisica = new ArrayList<Pagenation>(storageVirtual);
        for (int i = 0; i < storage_Fisica; i++) {
            memoriaFisica.add(i, new Pagenation());
        }
        System.out.println(memoriaFisica);
        return memoriaFisica;
    }

    //Método para escrever no HD
    public static void Escrever_HD(Pagenation pagenation) throws IOException {

        FileWriter arq = new FileWriter("c://HD_Mem.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf(String.valueOf(pagenation));

        arq.close();
    }


    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void NRU(ArrayList<Pagenation> memoriaVirtual) throws IOException {
        for (Pagenation pagenation : memoriaVirtual) {

            if (!pagenation.getReferenced() && !pagenation.getModified()) { // CLASSE 0
                Escrever_HD(pagenation);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            else if (!pagenation.getReferenced() && pagenation.getModified()) { //  CLASSE 1
                Escrever_HD(pagenation);
                pagenation.setReferenced(false);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            else if (pagenation.getReferenced() && !pagenation.getModified()) { //  CLASSE 2
                Escrever_HD(pagenation);
                pagenation.setReferenced(false);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            else if (pagenation.getReferenced() && pagenation.getModified()) { //   CLASSE 3
                Escrever_HD(pagenation);
                pagenation.setReferenced(false);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
        }
    }



    public synchronized void leitura(ArrayList<Pagenation> memoriaVirtual, int i) throws InterruptedException {

        endereco = comandos.get(i - 1);
        Pagenation p = memoriaVirtual.get(Integer.valueOf(endereco));
        //Se o atributo "Blocked" for falso, preosseguir com o método
        if (memoriaVirtual.get(Integer.valueOf(endereco)).getBlocked()) {

        //Se a página não estiver preenchida, dizer que ela está vazia e pular
            if ((p.getModified())) {
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println("Página vazia");
            //Se estiver preenchida e não estiver bloqueada, ler normalmente
        } else {
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println(memoriaVirtual.get(Integer.valueOf(endereco)));
        }}
        //Se estiver bloqueada, alertar e prosseguir para o próximo
        else{
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            System.out.println(Thread.currentThread().getName()+" pulou " + "O ENDERECO " + endereco);
            return;
        }
        sleep(20);
    }

    public synchronized void escrita(ArrayList<Pagenation> memoriaVirtual, int i) throws InterruptedException, IOException {
        endereco = comandos.get(i - 1);
        escrita = comandos.get(i + 1);
        //Se o atributo "Blocked" for falso, preosseguir com o método
        if (!memoriaVirtual.get(Integer.valueOf(endereco)).getBlocked()) {
            //Se a página estiver vazia, preencher ela com novos dados
            if (!memoriaVirtual.get(Integer.valueOf(endereco)).getModified()) {
                memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
                System.out.println(Thread.currentThread().getName() + " ESCREVENDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.get(Integer.valueOf(endereco)).setValue(Integer.valueOf(escrita));
                memoriaVirtual.get(Integer.valueOf(endereco)).setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setModified(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setPresent(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setPresent(true);
                System.out.println("Página escrita");
            }

        //Se existir e não estiver bloqueada, escrever normalmente
            else {
                //Se a página existir, sobrescrever o que há nela
// O método está quebrado               NRU(memoriaVirtual);
                memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
                System.out.println(Thread.currentThread().getName()+" SOBRESCREVENDO " + escrita + " NO ENDERECO " + endereco);
                memoriaVirtual.get(Integer.valueOf(endereco)).setValue(Integer.valueOf(escrita));
                memoriaVirtual.get(Integer.valueOf(endereco)).setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setModified(true);
                System.out.println("Página atualizada");
                sleep((long)(Math.random() * 500));
            }
        }
        //Se estiver bloqueada, alertar e prosseguir para o próximo
        else{
            System.out.println(Thread.currentThread().getName() + " pulou " + "O ENDERECO " + endereco);
            return;
        }
        sleep(100);
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas páginas
    public void Manager_Memory(ArrayList<Pagenation> memoriaVirtual) throws InterruptedException, IOException {
        System.out.println(SUA_ENTRADA);
        for (int i = 0; i< comandos.size(); i++) {
            //rodar contador na página virtual para identificar por quanto tempo ela ficou ativa
            for (Pagenation pag : memoriaVirtual) {
                pag.setTimer(pag.getTimer() + 1);
                if (pag.getReferenced()) {
                    if (pag.getTimer() >= 20) {
                        pag.setBlocked(false);
                        pag.setReferenced(false);
                        pag.setTimer(0);
                    }
                }
            }



            //Se a operação for de leitura, rodar o método para escrever na página virtual
            if (comandos.get(i).contains("R")) {
                leitura(memoriaVirtual, i);
            }
            //Se a operação for de escrita, rodar o método para escrever na página virtual
            else if (comandos.get(i).contains("W")) {
                escrita(memoriaVirtual, i);
            }
        }
        System.out.println(memoriaVirtual);
    }
}