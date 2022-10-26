package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;
import SISTEMA.Ram_Mem;
import SISTEMA.Virtual_Mem;

import java.io.IOException;
import java.util.ArrayList;

public class NRU {
    private Virtual_Mem Virtual;
    private Ram_Mem Ram;
    private HD_Mem HD;
    private Pagenation Page;
    private int tamanho = 8;
    private Boolean Referenced_Position;
    private Boolean Modified_Position;

    public NRU(Virtual_Mem Virtual, Ram_Mem Ram, HD_Mem HD, Pagenation Page) {
        this.Virtual = Virtual;
        this.Ram = Ram;
        this.HD = HD;
        this.Page = Page;
    }

//    public Integer AlgorithmNRU(){
//        for(int i = 0; i <= tamanho; i++){
//
//            Referenced_Position = Virtual.getMemory_Virtual(i).getReferenced();
//            Modified_Position = Virtual.getMemory_Virtual(i).getModified();
//
//            if((Referenced_Position == false) && (Modified_Position == false)){   // Classe 0: não referenciada (0), não modificada (0)
//                Virtual.setClass(0);
//            }
//            if((Referenced_Position == false) && (Modified_Position == true)){    // Classe 1: não referenciada (0), modificada (1)
//                Virtual.setClass(1);
//            }
//            if((Referenced_Position == true) && (Modified_Position == false)){    // Classe 2: referenciada (1), não modificada (0)
//                Virtual.setClass(2);
//            }
//            if((Referenced_Position == true) && (Modified_Position == true)){     // Classe 3: referenciada (1), modificada (1)
//                Virtual.setClass(3);
//            }
//        }
//        return null;
//    }

    //Método para rodar pela lista de arrays, identificar uma página que possui
    public void NRU(ArrayList<Pagenation> memoriaVirtual) throws IOException {
        for (Pagenation pagenation : memoriaVirtual) {
            // LISTA DE PRIORIDADE
            // PRIORIDADE MAIS ALTA
            if (!pagenation.getReferenced() && !pagenation.getModified()) { // CLASSE 0
                //Escrever_HD(pagenation);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            // SEGUNDA MAIS ALTA
            else if (!pagenation.getReferenced() && pagenation.getModified()) { //  CLASSE 1
                //Escrever_HD(pagenation);
                pagenation.setReferenced(false);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            //TERCEIRA MAIS IMPORTANTE
            else if (pagenation.getReferenced() && !pagenation.getModified()) { //  CLASSE 2
                //Escrever_HD(pagenation);
                pagenation.setReferenced(false);
                pagenation.setReference(0);
                pagenation.setModified(false);
                pagenation.setPresent(false);
                pagenation.setVirtual_Page(null);
                pagenation.setValue(null);
                pagenation.setBlocked(false);
            }
            // QUARTA MAIS IMPORTANTE
            else if (pagenation.getReferenced() && pagenation.getModified()) { //   CLASSE 3
                //Escrever_HD(pagenation);
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

}




