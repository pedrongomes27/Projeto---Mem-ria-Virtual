package MANAGER_MEMORY;

import SISTEMA.HD_Mem;
import SISTEMA.Pagenation;
import SISTEMA.Ram_Mem;
import SISTEMA.Virtual_Mem;

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

    public Integer NotUsedRecently(){
            
        for(int i = 0; i <= tamanho; i++){
            
            Referenced_Position = Virtual.getMemory_Virtual(i).getReferenced();
            Modified_Position = Virtual.getMemory_Virtual(i).getModified();
            
            if((Referenced_Position == false) && (Modified_Position == false)){   // Classe 0: não referenciada (0), não modificada (0)
                return i;     
            }
            if((Referenced_Position == false) && (Modified_Position == true)){    // Classe 1: não referenciada (0), modificada (1)
                return i;
            }
            if((Referenced_Position == true) && (Modified_Position == false)){    // Classe 2: referenciada (1), não modificada (0)
                return i;
            }
            if((Referenced_Position == true) && (Modified_Position == true)){     // Classe 3: referenciada (1), modificada (1)
                return i;
            }
        
        }
        return null;
    }
}




