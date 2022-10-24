package SISTEMA;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Virtual_Mem implements virtual_Interface{
    private Pagenation[] memory_Virtual;
    private HD_Mem HD;
    private Ram_Mem Ram;
    private int storage = -1;




    public void Virtual_Mem(int storage) {
        for(int i=0; i<=storage; i++){

            memory_Virtual = new Pagenation[i];

            HashMap<Integer, Pagenation> memoria = new HashMap<>();

            memoria.put(i, new Pagenation( i));

            System.out.println(memoria);
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}