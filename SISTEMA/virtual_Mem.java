package SISTEMA;

public class Virtual_Mem {
    private Pagenation[] memory_Virtual;
    private HD_Mem HD;
    private Ram_Mem Ram;
    private int storage = -1;

    public Virtual_Mem(int storage) {

        this.storage = storage;

        for(int i=0; i<=storage; i++){
               
            memory_Virtual = new Pagenation[storage];
      
       }
    }

    public Pagenation getMemory_Virtual(int index) {
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