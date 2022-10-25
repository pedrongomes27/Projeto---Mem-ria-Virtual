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

    public void systemOn() {
        iniciarMemoriaVirtual(storageVirtual);
        iniciarMemoriaFisica(storageVirtual);
    }

    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void NRU(ArrayList<Pagenation> memoriaVirtual) {
        for (Pagenation pagenation : memoriaVirtual) {
            if (!pagenation.getReferenced() && !pagenation.getModified()) { // CLASSE 0

                pagenation = new Pagenation();
//                pagenation.setReference(0);
//                pagenation.setModified(false);
//                pagenation.setPresent(false);
//                pagenation.setVirtual_Page(null);
//                pagenation.setValue(null);
//                pagenation.setBlocked(false);
            }
            else if (!pagenation.getReferenced() && pagenation.getModified()) { //  CLASSE 1
                pagenation = new Pagenation();
//                pagenation.setReferenced(false);
//                pagenation.setReference(0);
//                pagenation.setModified(false);
//                pagenation.setPresent(false);
//                pagenation.setVirtual_Page(null);
//                pagenation.setValue(null);
//                pagenation.setBlocked(false);
            }
            else if (pagenation.getReferenced() && !pagenation.getModified()) { //  CLASSE 2
                pagenation = new Pagenation();

//                pagenation.setReferenced(false);
//                pagenation.setReference(0);
//                pagenation.setModified(false);
//                pagenation.setPresent(false);
//                pagenation.setVirtual_Page(null);
//                pagenation.setValue(null);
//                pagenation.setBlocked(false);
            }
            else if (pagenation.getReferenced() && pagenation.getModified()) { //   CLASSE 3
                pagenation = new Pagenation();

//                pagenation.setReferenced(false);
//                pagenation.setReference(0);
//                pagenation.setModified(false);
//                pagenation.setPresent(false);
//                pagenation.setVirtual_Page(null);
//                pagenation.setValue(null);
//                pagenation.setBlocked(false);
            }
        }
    }

    public void setBloqueado(Pagenation memoriaVirtual) throws InterruptedException {
        if (memoriaVirtual.getBlocked()) {
            memoriaVirtual.setBlocked(true);
            System.out.println("bloqueado");
            sleep(1000);
            memoriaVirtual.setBlocked(false);
        }
    }

    public void setDesbloqueado(Pagenation memoriaVirtual) throws InterruptedException {
        if (memoriaVirtual.getBlocked()) {
            memoriaVirtual.setBlocked(false);
            System.out.println("desbloqueado");
        }
    }



    public synchronized void leitura(ArrayList<Pagenation> memoriaVirtual, int i) throws InterruptedException {

        endereco = strList.get(i - 1);

        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (memoriaVirtual.get(Integer.valueOf(endereco)).getBlocked()) {

        //Se a página não existir, dizer que não existe e pular
            if (!memoriaVirtual.get(Integer.valueOf(endereco)).getModified()) {
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
            sleep(200);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println("Página vazia");
            //Se existir e não estiver bloqueada, ler normalmente
        } else {
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println(memoriaVirtual.get(Integer.valueOf(endereco)));
            sleep((long)(Math.random() * 100));
        }}
        else{
            memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
            System.out.println(Thread.currentThread().getName()+" pulou " + "O ENDERECO " + endereco);
            return;
        }
        sleep(20);
    }

    public synchronized void escrita(ArrayList<Pagenation> memoriaVirtual, int i) throws InterruptedException {
        endereco = strList.get(i - 1);
        escrita = strList.get(i + 1);
        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (!memoriaVirtual.get(Integer.valueOf(endereco)).getBlocked()) {


            //Se a página não existir, criar uma
            if (!memoriaVirtual.get(Integer.valueOf(endereco)).getModified()) {
                memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
                System.out.println(Thread.currentThread().getName() + " CRIANDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.get(Integer.valueOf(endereco)).setValue(Integer.valueOf(escrita));
                memoriaVirtual.get(Integer.valueOf(endereco)).setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setModified(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setPresent(true);
                System.out.println(memoriaVirtual.get(Integer.valueOf(endereco)));
                System.out.println("Página criada");
                sleep((long) (Math.random() * 500));
            }

        //Se existir e não estiver bloqueada, escrever normalmente
            else {
                memoriaVirtual.get(Integer.valueOf(endereco)).setBlocked(true);
                System.out.println(Thread.currentThread().getName() + " ESCREVENDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.get(Integer.valueOf(endereco)).setValue(Integer.valueOf(escrita));
                memoriaVirtual.get(Integer.valueOf(endereco)).setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.get(Integer.valueOf(endereco)).setReferenced(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setModified(true);
                memoriaVirtual.get(Integer.valueOf(endereco)).setPresent(true);
                System.out.println(memoriaVirtual.get(Integer.valueOf(endereco)));
                System.out.println("Página atualizada");
            }}
        else{
            System.out.println(Thread.currentThread().getName() + " pulou " + "O ENDERECO " + endereco);
            return;
        }
        sleep(100);
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas páginas
    public void Manager_Memory(ArrayList<Pagenation> memoriaVirtual) throws InterruptedException {
        System.out.println(SUA_ENTRADA);
        for (int i = 0; i<strList.size(); i++) {
            //rodar contador na página virtual para identificar por quanto tempo ela ficou ativa
            for(Pagenation pag : memoriaVirtual) {
                pag.setTimer(pag.getTimer() + 1);
                if(pag.getReferenced()){
                    if(pag.getTimer() >= 20){
                        pag.setBlocked(false);
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