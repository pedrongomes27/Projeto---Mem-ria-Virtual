package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.io.IOException;
import java.util.ArrayList;

public class NRU {

    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void executarNRU(ArrayList<Pagenation> memoriaVirtual, int endereco) throws IOException {
        

        if (memoriaVirtual.get(endereco).getPresent()){
            for (Pagenation pagenation : memoriaVirtual) {
                // LISTA DE PRIORIDADE
                // PRIORIDADE MAIS ALTA
                if (!pagenation.getReferenced() && !pagenation.getModified()) { // CLASSE 0 0|0
                    //METODO DE SUBTITUICAO DE PAGINA
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                // SEGUNDA MAIS ALTA
                else if (!pagenation.getReferenced() && pagenation.getModified()) { //  CLASSE 1 0|1
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                //TERCEIRA MAIS IMPORTANTE
                else if (pagenation.getReferenced() && !pagenation.getModified()) { //  CLASSE 2 1|0
                    memoriaVirtual.set(endereco, new Pagenation());
                }
                // QUARTA MAIS IMPORTANTE
                else if (pagenation.getReferenced() && pagenation.getModified()) { //   CLASSE 3 1|1
                    memoriaVirtual.set(endereco, new Pagenation());
                }
            }
        }else{
            memoriaVirtual.set(endereco, new Pagenation());
        }
    }
}




