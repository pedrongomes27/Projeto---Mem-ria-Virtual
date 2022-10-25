package SISTEMA;

import java.lang.constant.Constable;

public class Pagenation {

    private Boolean referenced; //REFERENCIADO
    private Integer reference;
    private Boolean modified;   //MODIFICADO
    private Boolean present;    //PRESENTE/AUSENTE
    private Integer Virtual_Page;   //ENDEREÇO DA MEMORIA
    private Integer value;    //VALOR

    public Integer getTimer() {
        return timer;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }

    private Integer timer;

    private Boolean blocked;

    public Pagenation() { //    INICIA TODAS AS PÁGINAS VAZIAS
        this.referenced = false;
        this.reference = 0;
        this.modified = false;
        this.present = false;
        this.Virtual_Page = null;
        this.blocked = false;
        this.timer = 0;
    }

    public Pagenation(Integer Virtual_Page) {
        this.referenced = false;
        this.reference = 0;
        this.modified = false;
        this.present = false;
        this.Virtual_Page = null;
        this.blocked = false;
        this.timer = 0;
    }

    @Override
    public String toString() { //   PRINT DA PÁGINA VIRTUAL
        return "Página{" +
                "Referenced='" + referenced +
                ", reference='" + reference +
                ", modified='" + modified +
                ", present='" + present +
                ", virtual_page='" + Virtual_Page +
                ", value='" + value +
                ", blocked='" + blocked +
                ", timer='" + timer +
                '}';
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
        return Virtual_Page;
    }

    public void setVirtual_Page(Integer Virtual_Page) {
        this.Virtual_Page = Virtual_Page;
    }

    public Boolean existPage() {

        if (Virtual_Page == null) {
            return false;
        }
        return true;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getVirtual_Page() {
        return Virtual_Page;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }


}