package MMU;

import java.util.ArrayList;

import SISTEMA.*;

public class Main {
    
    public static void main(String[] args) {
        int storage_Virtual = 8;
        int threads = 3;  
        
        ram_Mem Ram =new ram_Mem(storage_Virtual/2);
        virtual_Mem mVirtual=new virtual_Mem(storage_Virtual);
        hd_Mem HD=new hd_Mem();
        
        try {
            
            for(int i=1; i <= threads; i++){
             
            ArrayList<String> IN = new ArrayList<String>();

                     
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        
    }

    
}