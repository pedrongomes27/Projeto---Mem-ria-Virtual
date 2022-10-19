package SISTEMA;

public class Virtual_Mem implements virtual_Interface{
    private Pagenation[] memory_Virtual;
    private HD_Mem HD;
    private Ram_Mem Ram;
    private int storage = -1;




    public void Virtual_Mem(int storage) {
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

    @Override
    public int getIndexValue() {
        return 0;
    }

    @Override
    public void updateValue(int index, int a, int b) {
        memory_Virtual[index].setValue(a+b);
    }
}