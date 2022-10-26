package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.io.IOException;
import java.util.ArrayList;

public class NRU {

    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void executarNRU(ArrayList<Pagenation> memoriaVirtual, int endereco) throws IOException {
        memoriaVirtual.set(endereco, new Pagenation());

        if (memoriaVirtual.get(endereco).getPresent()){
            for (Pagenation pagenation : memoriaVirtual) {
                // LISTA DE PRIORIDADE
                // PRIORIDADE MAIS ALTA
                if (!pagenation.getReferenced() && !pagenation.getModified()) { // CLASSE 0
                    //METODO DE SUBTITUICAO DE PAGINA
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                // SEGUNDA MAIS ALTA
                else if (!pagenation.getReferenced() && pagenation.getModified()) { //  CLASSE 1
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                //TERCEIRA MAIS IMPORTANTE
                else if (pagenation.getReferenced() && !pagenation.getModified()) { //  CLASSE 2
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                // QUARTA MAIS IMPORTANTE
                else if (pagenation.getReferenced() && pagenation.getModified()) { //   CLASSE 3
                    memoriaVirtual.set(endereco, new Pagenation());
                }
            }
        }
    }
}




