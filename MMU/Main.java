package MMU;

import java.util.ArrayList;

import SISTEMA.HD_Mem;
import SISTEMA.Ram_Mem;
import SISTEMA.Virtual_Mem;

public class Main {
    
    public static void main(String[] args) {
        int storage_Virtual = 8;
        int threads = 3;  
        
        Ram_Mem Ram = new Ram_Mem(storage_Virtual/2);
        Virtual_Mem Virtual = new Virtual_Mem(storage_Virtual);
        HD_Mem HD=new HD_Mem();
        
        try {
            for(int i=1; i <= threads; i++){
             
            ArrayList<String> IN = new ArrayList<String>();
                     
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
    }

    
}