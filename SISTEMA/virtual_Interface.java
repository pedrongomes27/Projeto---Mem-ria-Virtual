package SISTEMA;

import java.util.Map;

public interface virtual_Interface extends Map {

    void Virtual_Mem(int storage);

    int getIndexValue();

    void updateValue(int index, int a, int b);

    void PrintVirtual();

    Pagenation getMemory_Virtual(int index);


}
