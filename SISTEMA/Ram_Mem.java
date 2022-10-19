package SISTEMA;

public class Ram_Mem {

    private Integer[] memory_RAM;
    private int storage = -1;

    public Ram_Mem(int storage){
        this.storage = storage;
        this.memory_RAM = new Integer[storage];
    }

    public Integer getMemory_RAM(int index) {
        return memory_RAM[index];
    }
    public void setMemory_RAM(int index, Integer value) {
        this.memory_RAM[index] = value;
    }

    public Integer getIndexFree(){  //Retornar se há algum espaço de memoria RAM vazio
        
        for(int i=0; i<=memory_RAM.length; i++){
            
           if(memory_RAM[i]== null){
               System.out.println("Tem espaço no Index [" + i + "]");
               return i;
           }
           
        }
        System.out.println("Não tem espaço na RAM");
        return null;
    }

}