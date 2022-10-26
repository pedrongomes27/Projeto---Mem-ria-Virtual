package SISTEMA;

import java.util.ArrayList;

public class Pagenation {

    private Boolean referenced; //REFERENCIADO, IDENTIFICA SE A PAGINA VIRTUAL FOI REFERENCIADA
    private Integer reference;
    private Boolean modified;   //MODIFICADO, IDENTIFICA SE A PAGINA VIRTUAL FOI MODIFICADA
    private Boolean present;    //PRESENTE/AUSENTE
    private Integer endereco;   //ENDEREÇO DA MEMORIA
    

    private Boolean blocked;

    public Pagenation() { //    INICIA TODAS AS PÁGINAS VAZIAS
        this.referenced = false;
        this.reference = 0;
        this.modified = false;
        this.present = true;
        this.endereco = null;
        this.blocked = false;
    }

    public String toString() { //   PRINT DA PÁGINA VIRTUAL
        return "Página{" +
                "Referenced='" + referenced +
                ", reference='" + reference +
                ", modified='" + modified +
                ", present='" + present +
                ", virtual_page='" + endereco +
                '}';
    }

    public Boolean verificarFaltaPag(ArrayList<Pagenation> memoriaVirtual){
        int counter = 0;
        for(Pagenation pagina : memoriaVirtual){
            if(pagina.getModified()){
                counter += 1;
            }
        }
        if(counter == memoriaVirtual.size()){
            return true;
        }else{return false;}
    }

    public Boolean getReferenced() {
        return referenced;
    }

    public void setReferenced(Boolean referenced) {
        if (referenced == true) {
            reference++;
            this.referenced = referenced;
        }
    }

    public Boolean getModified() {
        return modified;
    }

    public void setModified(Boolean modified) {
        this.modified = modified;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public Integer getVirtualPage() {
        return endereco;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getEndereco() {
        return endereco;
    }

    public void setEndereco(Integer endereco) {
        this.endereco = endereco;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }


}