package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Buffer {
    //Instanciando a classe de página virtual para uso futuro no hashmap
    Pagenation pagenation;
    int inicio = 0;
    //Definindo tamanho da memória virtual(A física é definida matematicamente pela divisão da virtual por 2)
    int tamanhoDaMinhaMemoriaVirtual = 10;
    //Chamada da fabrica de entradas
    String SUA_ENTRADA = new EntryFactory(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
    //Dando split para tirar o hífen e a vírgula
    String[] strSplit = SUA_ENTRADA.split("[-,]");
    //Transformando em arraylist
    ArrayList<String> strList = new ArrayList<String>(
            Arrays.asList(strSplit));
    String endereco = "";
    String escrita = "";

    Pagenation novo = new Pagenation(1);

    ReentrantLock lock = new ReentrantLock();
    int counter = 0;




    //Método para iniciar a memória virtual
    public Pagenation[] iniciarMemoriaVirtual() {
        int storage_Virtual = 10;
        Pagenation[] memoriaVirtual = new Pagenation[storage_Virtual];
        for (int i = 0; i < storage_Virtual; i++) {
            memoriaVirtual[i] = new Pagenation(i);
        }
        System.out.println(Arrays.toString(memoriaVirtual));
        return memoriaVirtual;
    }


    //Método para iniciar a memória física
    public Map iniciarMemoriaFisica() {
        Map<Integer, Pagenation> memoriaFisica = new HashMap<>();
        while (inicio == 0) {
            int storage_Virtual = 10;
            for (int i = 0; i < storage_Virtual / 2; i++) {
                memoriaFisica.put(i, new Pagenation(i));
            }
            System.out.println(memoriaFisica);
            inicio = 1;
        }
        return memoriaFisica;
    }

    public void ignorar(HashMap memoria, int i){
//        if((HashMap.get(i).getReferenced() == true){
//
//        }
    }

    public void perform() {
        lock.lock();
        try {
            // Critical section here
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public void performTryLock(int i) throws InterruptedException {
        //...
        boolean isLockAcquired = lock.tryLock(1, TimeUnit.SECONDS);

        if(isLockAcquired) {
            try {
                //Critical section here
            } finally {
                lock.unlock();
            }
        }
        //...
    }




    public synchronized void leitura(Pagenation[] memoriaVirtual, int i) throws InterruptedException {
        sleep((long)(Math.random() * 100));
        endereco = strList.get(i - 1);
        Pagenation p = memoriaVirtual[Integer.valueOf(endereco)];
        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (memoriaVirtual[Integer.valueOf(endereco)].getBlocked()) {
            return;
        }
        //Se a página não existir, dizer que não existe e pular
        else if (!memoriaVirtual[Integer.valueOf(endereco)].getPresent()) {
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(true);
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            System.out.println("Página vazia");
            sleep((long)(Math.random() * 100));
        //Se existir e não estiver bloqueada, ler normalmente
        } else {
            System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO " + endereco);
            sleep((long)(Math.random() * 100));
        }
        sleep(100);
    }

    public synchronized void escrita(Pagenation[] memoriaVirtual, int i) throws InterruptedException {
        sleep((long)(Math.random() * 100));
        endereco = strList.get(i - 1);
        escrita = strList.get(i + 1);

        System.out.println(Thread.currentThread().getName()+" ESCREVENDO " + escrita + " NO ENDERECO " + endereco);
        Pagenation p = memoriaVirtual[Integer.valueOf(endereco)];
        //Se o atributo "Blocked" for verdadeiro, pular para a próxima leitura
        if (memoriaVirtual[Integer.valueOf(endereco)].getBlocked()) {
            return;
        }
        //Se a página não existir, criar uma
        else if (!memoriaVirtual[Integer.valueOf(endereco)].getPresent()) {
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(true);
            p.setValue(Integer.valueOf(escrita));
            p.setVirtual_Page(Integer.valueOf(endereco));
            p.setReferenced(true);
            p.setModified(true);
            p.setPresent(true);
            memoriaVirtual[Integer.valueOf(endereco)] = p;
            System.out.println("Página criada");
            sleep((long)(Math.random() * 100));

        }
        //Se existir e não estiver bloqueada, escrever normalmente
        else {
            memoriaVirtual[Integer.valueOf(endereco)].setBlocked(true);
            p.setValue(Integer.valueOf(escrita));
            p.setVirtual_Page(Integer.valueOf(endereco));
            p.setReferenced(true);
            p.setModified(true);
            p.setPresent(true);
            memoriaVirtual[Integer.valueOf(endereco)] = p;
            System.out.println("Página atualizada");
            sleep((long)(Math.random() * 100));
        }
        sleep(10);
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas páginas
    public void teste(Pagenation[] memoriaVirtual) throws InterruptedException {
        System.out.println(SUA_ENTRADA);
        for (int i = 0; i<strList.size(); i++) {
            if (strList.get(i).contains("R")) {
                leitura(memoriaVirtual, i);


            }
            else if (strList.get(i).contains("W")) {
                escrita(memoriaVirtual, i);
            }
        }
        System.out.println(memoriaVirtual);
    }
}
