package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MMU {

    //Definindo tamanho da memória virtual(A física é definida matematicamente pela divisão da virtual por 2)
    Integer storageVirtual = 10;

    //Chamada da fábrica de entradas
    private String SUA_ENTRADA = new EntryFactory(storageVirtual).getNewEntrada(),  endereco = "", escrita = "";
    //Dando split para retirar o hífen e a vírgula
    private String[] strSplit = SUA_ENTRADA.split("[-,]");
    //Transformando a lista String[] srtSplit em arraylist para facilitar o manuseio dos indices
//    private ArrayList<String> comandos = new ArrayList<String>(Arrays.asList(strSplit));

    // NRU algoritmo = new NRU();

    // Método para iniciar a memória virtual
    public ArrayList<Pagenation> iniciarMemoriaVirtual(Integer storageVirtual) {
        // CRIAÇÃO DE UM ARRAYLIST DE PAGINAS VIRTUAIS
        ArrayList<Pagenation> memoriaVirtual = new ArrayList<Pagenation>(storageVirtual);
        for (int i = 0; i < storageVirtual; i++) {
            memoriaVirtual.add(i, new Pagenation()); // ADICIONA UMA NOVA PAGINA EM UM ENDEREÇO ATÉ ATINGIR O VALOR DEFINIDO PELA storageVirtual
        }
        System.out.println(memoriaVirtual);
        return memoriaVirtual;
    }

        public void NRU(Pagenation memoriaVirtual) throws IOException {
            // LISTA DE PRIORIDADE
            // PRIORIDADE MAIS ALTA
            if (!memoriaVirtual.getReferenced() && !memoriaVirtual.getModified()) { // CLASSE 0
//                Escrever_HD(memoriaVirtual);
                memoriaVirtual.setReference(0);
                memoriaVirtual.setModified(false);
                memoriaVirtual.setPresent(false);
                memoriaVirtual.setVirtual_Page(null);
                memoriaVirtual.setValue(null);
                memoriaVirtual.setBlocked(false);
            }
            // SEGUNDA MAIS ALTA
            else if (!memoriaVirtual.getReferenced() && memoriaVirtual.getModified()) { //  CLASSE 1
//                Escrever_HD(memoriaVirtual);
                memoriaVirtual.setReferenced(false);
                memoriaVirtual.setReference(0);
                memoriaVirtual.setModified(false);
                memoriaVirtual.setPresent(false);
                memoriaVirtual.setVirtual_Page(null);
                memoriaVirtual.setValue(null);
                memoriaVirtual.setBlocked(false);
            }
            //TERCEIRA MAIS IMPORTANTE
            else if (memoriaVirtual.getReferenced() && !memoriaVirtual.getModified()) { //  CLASSE 2
//                Escrever_HD(memoriaVirtual);
                memoriaVirtual.setReferenced(false);
                memoriaVirtual.setReference(0);
                memoriaVirtual.setModified(false);
                memoriaVirtual.setPresent(false);
                memoriaVirtual.setVirtual_Page(null);
                memoriaVirtual.setValue(null);
                memoriaVirtual.setBlocked(false);
            }
            // QUARTA MAIS IMPORTANTE
            else if (memoriaVirtual.getReferenced() && memoriaVirtual.getModified()) { //   CLASSE 3
//                Escrever_HD(memoriaVirtual);

                memoriaVirtual.setReferenced(false);
                memoriaVirtual.setReference(0);
                memoriaVirtual.setModified(false);
                memoriaVirtual.setPresent(false);
                memoriaVirtual.setVirtual_Page(null);
                memoriaVirtual.setValue(null);
                memoriaVirtual.setBlocked(false);
            }
        }


    //Método para iniciar a memória física
    public ArrayList<String> iniciarMemoriaFisica(Integer espacoMemoriaVirtual) {
        Integer storage_Fisica = espacoMemoriaVirtual / 2;
        ArrayList<String> memoriaFisica = new ArrayList<String>(storageVirtual);
        for (int i = 0; i < storage_Fisica; i++) {
            memoriaFisica.add(i, "");
        }
        System.out.println(memoriaFisica);
        return memoriaFisica;
    }


    public void inserirFisico(String valor, ArrayList<String> memoriaFisica){
        System.out.println("Inserir na memoria física");
        for(int i = 0; i < memoriaFisica.size();i++) {
            if(!memoriaFisica.get(i).equals("")){
                memoriaFisica.set(i, valor);
            }
        }
    }

    //Método para escrever no HD
    public static void Escrever_HD(Pagenation pagenation) throws IOException {

        FileWriter arq = new FileWriter("c://HD_Mem.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf(String.valueOf(pagenation));

        arq.close();
    }

    public synchronized void leitura(Pagenation memoriaVirtual, int i, String comandos, String endereco) throws InterruptedException {
        sleep(100);
        Pagenation p = memoriaVirtual;
        //Se o atributo "Blocked" for falso, preosseguir com o método
        if (!memoriaVirtual.getBlocked()) {
            //Se a página não estiver preenchida, dizer que ela está vazia e pular
                if ((!p.getModified())) {
                    memoriaVirtual.setBlocked(true);
                    memoriaVirtual.setReferenced(true);
                    System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO: " + endereco);
                    System.out.println("Página vazia");
                //Se estiver preenchida e não estiver bloqueada, ler normalmente
            } else {
                    memoriaVirtual.setBlocked(true);
                    memoriaVirtual.setReferenced(true);
                    System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO: " + endereco);
                    System.out.println(memoriaVirtual);
            }}
            //Se estiver bloqueada, alertar e prosseguir para o próximo
            else{
            try {
                NRU(memoriaVirtual);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //            System.out.println(Thread.currentThread().getName()+" pulou " + "O ENDERECO " + endereco);
                return;
        }
            sleep(100);
    }

    public synchronized void escrita(Pagenation memoriaVirtual, int i, String comandos, String endereco, String escrita) throws InterruptedException, IOException {
        sleep(20);
        //Se o atributo "Blocked" for falso, prosseguir com o método
        if (!memoriaVirtual.getBlocked()) {
            //Se a página estiver vazia, preencher ela com novos dados
            if (!memoriaVirtual.getModified()) {
                memoriaVirtual.setBlocked(true);
                System.out.println(Thread.currentThread().getName() + " ESCREVENDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.setValue(Integer.valueOf(escrita));
                memoriaVirtual.setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.setReferenced(true);
                memoriaVirtual.setModified(true);
                memoriaVirtual.setPresent(true);
                System.out.println("Página escrita");
            }

        //Se existir e não estiver bloqueada, escrever normalmente
            else {
                //Se a página existir, sobrescrever o que há nela
                // O método está quebrado

                memoriaVirtual.setBlocked(true);
                System.out.println(Thread.currentThread().getName()+" SOBRESCREVENDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.setValue(Integer.valueOf(escrita));
                memoriaVirtual.setVirtual_Page(Integer.valueOf(endereco));
                memoriaVirtual.setReferenced(true);
                memoriaVirtual.setModified(true);
                System.out.println("Página atualizada");
            }
        }
        //Se estiver bloqueada, alertar e prosseguir para o próximo
        else{
            NRU(memoriaVirtual);
//  System.out.println(Thread.currentThread().getName() + " pulou " + "O ENDERECO " + endereco);
            return;
        }
        sleep(20);
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas páginas
    public void Manager_Memory(Pagenation memoriaVirtual, int i, String valor, String endereco, String escrita) throws InterruptedException, IOException {
         // PRINTA AS ENTRADAS DA FABRICA DE ENTRADAS
            //rodar contador na página virtual para identificar por quanto tempo ela ficou ativa
//                memoriaVirtual.setTimer(memoriaVirtual.getTimer() + 1);

//        memoriaVirtual.get(i-1).setTimer(memoriaVirtual.get(i-1).getTimer() + 1);
//        if (memoriaVirtual.get(i-1).getReferenced()) {
//            if (memoriaVirtual.get(i-1).getTimer() >= 20) {
//                memoriaVirtual.get(i-1).setBlocked(false);
//                memoriaVirtual.get(i-1).setReferenced(false);
//                memoriaVirtual.get(i-1).setTimer(0);
//            }
//        }
                if (memoriaVirtual.getReferenced()) {
                    if (memoriaVirtual.getTimer() >= 20) {
                        memoriaVirtual.setBlocked(false);
                        memoriaVirtual.setReferenced(false);
                        memoriaVirtual.setTimer(0);
                    }
                }
            //Se a operação for de leitura, rodar o método para escrever na página virtual
            if (valor.contains("R")) {
                leitura(memoriaVirtual, i, valor, endereco);
            }
            //Se a operação for de escrita, rodar o método para escrever na página virtual
            else if (valor.contains ("W")) {
                escrita(memoriaVirtual, i, valor, endereco, escrita);
            }
    }
}
