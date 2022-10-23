package MANAGER_MEMORY;

import SISTEMA.Pagenation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Buffer {
    //Instanciando a classe de página virtual para uso futuro no hashmap
    Pagenation pagenation;
    int inicio = 0;
    //Definindo tamanho da memória virtual(A física é definida matematicamente pela divisão da virtual por 2)
    int tamanhoDaMinhaMemoriaVirtual = 10;
    //Chamada da fabrica de entradas
    String SUA_ENTRADA = new Process(tamanhoDaMinhaMemoriaVirtual).getNewEntrada();
    //Dando split para tirar o hífen e a vírgula
    String[] strSplit = SUA_ENTRADA.split("[-,]");
    //Transformando em arraylist
    ArrayList<String> strList = new ArrayList<String>(
            Arrays.asList(strSplit));
    String endereco = "";
    String escrita = "";


    //Método para iniciar a memória virtual
    public HashMap iniciarMemoriaVirtual() {
        HashMap<Integer, Pagenation> memoriaVirtual = new HashMap<>();
        int storage_Virtual = 10;
        for (int i = 0; i < storage_Virtual; i++) {
            memoriaVirtual.put(i, new Pagenation(i));
            }
        return memoriaVirtual;
    }
    //Método para iniciar a memória física
    public HashMap iniciarMemoriaFisica() {
        HashMap<Integer, Pagenation> memoriaFisica = new HashMap<>();
        while (inicio == 0) {
            int storage_Virtual = 10;
            for (int i = 0; i < storage_Virtual / 2; i++) {
                memoriaFisica.put(i, new Pagenation(i));
            }
            System.out.println(memoriaFisica);
            inicio = 1;
        }
        return memoriaFisica;
    }

    //Método para manipular a memória virtual escrevendo e lendo os valores em suas respectivas chaves
    public void teste(HashMap memoriaVirtual){
        for (int i = 0; i<strList.size(); i++) {
            if (strList.get(i).contains("R")) {
                endereco = strList.get(i - 1);
                System.out.println("LENDO O ENDERECO " + endereco);
                System.out.println(memoriaVirtual.get(Integer.parseInt(endereco)));
            }
            if (strList.get(i).contains("W")) {
                endereco = strList.get(i - 1);
                escrita = strList.get(i + 1);
                System.out.println("ESCREVENDO " + escrita + " NO ENDERECO " + endereco);
                memoriaVirtual.put(Integer.parseInt(endereco), escrita);
            }
        }
        System.out.println(memoriaVirtual);
    }
}
