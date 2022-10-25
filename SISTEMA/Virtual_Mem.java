package SISTEMA;

import java.util.ArrayList;

public class Virtual_Mem {
    private ArrayList<Pagenation> memory_Virtual;
    private HD_Mem HD;
    private Ram_Mem Ram;
    private int storage = -1;

    private int Class;


    public void Virtual_Mem(int storage) {
        for(int i=0; i<=storage; i++){

       }
    }

    public Pagenation getMemory_Virtual(int index) {
        return memory_Virtual.get(index);
    }

    public void setClass(int Class) {
        this.Class = Class;
    }

}