package SISTEMA;
import java.io.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class HD_Mem {
    
    private Integer[] memory_HD; // Definição do array da memória do HD
    private static int storage = 2352626;

    public HD_Mem() {   // Construtor para memória do HD
        this.memory_HD = new Integer[storage];
    }

    public Integer getMemory_HD(int index) {    // Retornar o valor do index especificado
        return this.memory_HD[index];
    }
    public void setMemory_HD(int index, int value) {    // Setar um valor para um index especifico
        memory_HD[index] = value;
    }


    
    public Integer getIndexFree(){  //Retornar se há algum espaço de memória do HD vazio
        
        for(int i=0; i<=storage; i++){
            
           if(memory_HD[i] == null){
               System.out.println("Tem espaço no Index [" + i + "] do HD");
               return i;
           }
           
        }
        System.out.println("Não tem espaço no HD");
        return null;
    }

    public void PrintHD(){  //Printar toda a memória do HD
                
        for(int i=0; i<=memory_HD.length; i++){
            
            if(memory_HD[i] != null){    //Todos os index e valores não nulos
                
                System.out.println("Index [" + i + "] de valor =" + memory_HD[i]);

            }else{  //Todos os index nulos

                System.out.println("Index [" + i + "] está vazio");
            }
            
        }
    }


    public static void Escrever_HD() throws IOException {

        FileWriter arq = new FileWriter("c://HD_Mem.txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("asdasd");

        arq.close();
    }
}
