package SISTEMA;

public class virtual_Mem {
    private mem_Page[] memory_Virtual;
    private hd_Mem HD;
    private ram_Mem Ram;
    private int storage = -1;

    public virtual_Mem(int storage) {

        this.storage = storage;

        for(int i=0; i<=storage; i++){
               
            memory_Virtual = new mem_Page[storage];
      
       }
    }

    public mem_Page getMemory_Virtual(int index) {
        return memory_Virtual[index];
    }

   
    public void PrintVirtual(){
        
        for(int i=0; i<=memory_Virtual.length; i++){
                        
            if(memory_Virtual[i] != null ){
                
                System.out.println("Index [" + i + "] de valor =" + memory_Virtual[i]);
                
            }else System.out.println("Index [" + i + "] está vazio");
            
        }
            
    }
}