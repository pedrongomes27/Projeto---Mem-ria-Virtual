package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MMU {


    public ArrayList<HD_Mem> iniciarHD(Integer storageVirtual) {

        ArrayList<HD_Mem> HD = new ArrayList<HD_Mem>(storageVirtual);
        return HD;
    }

    // Método para iniciar a memória virtual
    public ArrayList<Pagenation> iniciarMemoriaVirtual(Integer storageVirtual) {
        // CRIAÇÃO DE UM ARRAYLIST DE PAGINAS VIRTUAIS
        ArrayList<Pagenation> memoriaVirtual = new ArrayList<Pagenation>(storageVirtual);
        return memoriaVirtual;
    }

    public ArrayList<String> iniciarMemoriaFisica(Integer storageVirtual) {
        ArrayList<String> memoriaFisica = new ArrayList<String>(storageVirtual/2);
        for (int i = 0; i < storageVirtual / 2; i++) {
            memoriaFisica.add(i, ""); // ADICIONA UMA NOVA PAGINA EM UM ENDEREÇO ATÉ ATINGIR O VALOR DEFINIDO PELA metade do storageVirtual
        }
        System.out.println(memoriaFisica);
        return memoriaFisica;
    }

    public void inserirHD(String endereco, String valor, ArrayList<String> HD){
        HD.add(Integer.valueOf(endereco), valor);
    }

    //Método para inserir valor na memória física
    public void inserirFisica(String valor, ArrayList<String> memoriaFisica){
        System.out.println("Inserir na memoria física");
        for(int i = 0; i < memoriaFisica.size();i++) {
            if(memoriaFisica.get(i).equals("")){ 
                memoriaFisica.set(i, valor);
            }
        }
    }
    // método para limpar bit de referenciado da página virtual//
    public void tirarRerenciado(ArrayList<Pagenation> memoriaVirtual){
        for(Pagenation pagina : memoriaVirtual){
            pagina.setReferenced(false);
        }
    }

    public synchronized void leitura(Pagenation memoriaVirtual, String endereco) throws InterruptedException, IOException {
        sleep(100);
        Pagenation pagina = memoriaVirtual;
        //Se o atributo "Blocked" for falso, preosseguir com o método
        if (!memoriaVirtual.getBlocked()) {
            //Se a página não estiver preenchida, dizer que ela está vazia e pular
                if ((!pagina.getPresent())) {
                    memoriaVirtual.setBlocked(true);
                    memoriaVirtual.setReferenced(true);
                    System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO: " + endereco);
                    System.out.println("Página vazia");
                //Se estiver preenchida e não estiver bloqueada, ler normalmente
            } else {
                    memoriaVirtual.setBlocked(true);
                    memoriaVirtual.setReferenced(true);
                    System.out.println(Thread.currentThread().getName()+" LENDO O ENDERECO: " + endereco);
            }
        }
    }

    public synchronized void escrita(Pagenation memoriaVirtual, String endereco, String escrita) throws InterruptedException, IOException {
        sleep(20);
        //Se o atributo "Blocked" for falso, prosseguir com o método
        if (!memoriaVirtual.getBlocked()) {
            //Se a página estiver vazia, preencher ela com novos dados
            if (!memoriaVirtual.getPresent()) {
                memoriaVirtual.setBlocked(true);
                System.out.println(Thread.currentThread().getName() + " ESCREVENDO: " + escrita + " NO ENDERECO: " + endereco);
                memoriaVirtual.setEndereco(Integer.valueOf(endereco));
                memoriaVirtual.setReferenced(true);
                memoriaVirtual.setModified(true);
                memoriaVirtual.setPresent(true);
                System.out.println("Página escrita");
            }
        }
    }
}
