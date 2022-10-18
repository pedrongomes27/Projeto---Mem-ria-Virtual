package SISTEMA;

import SISTEMA.hd_Mem;
import SISTEMA.ram_Mem;
import SISTEMA.virtual_Mem;

public class mem_Page{

    private Boolean referenced; //REFERENCIADO
    private Integer reference;
    private Boolean modified;   //MODIFiuCADO
    private Boolean present;    //PRESENTE/AUSENTE
    private Integer Virtual_Page;   //MOLDURA DA PAGINA VIRTUAL

    public mem_Page(){
        this.referenced=false;
        this.reference=0;
        this.modified=false;
        this.present=false;
        this.Virtual_Page=null;

    }


    public Boolean getReferenced() {
        return referenced;
    }
    public void setReferenced(Boolean referenced) {
        if(referenced==true){
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


    public Boolean exist(){
        
        if(Virtual_Page==null){
            return false;
        }
        return true;
    }
    
    public void print(){
        
        System.out.println("Referenciada: "+ referenced + "Vezes: " + reference + "\n"  //OPERADOR TERNARIO(TENTAR)
                         + "Modificada: "+ modified + "\n"
                         + "Presente: "+ present + "\n"
                         + "Página Virtual: "+ Virtual_Page);
    }
}
