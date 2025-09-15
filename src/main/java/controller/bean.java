package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import model.Projeto;
import java.util.ArrayList;


@Named("ctl")
@SessionScoped
public class bean implements Serializable {
    
        public bean() {
            
            init();
    } //construtor
    
    
    
    
    
    private List<Projeto> projetos;
    
    public void init(){
        projetos = new ArrayList<>();
        projetos.add(new Projeto(1,"projeto1","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",4.9,"Informática"));
        projetos.add(new Projeto(2,"projeto2","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",4.7,"Ciências"));
        projetos.add(new Projeto(3,"projeto3","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
        projetos.add(new Projeto(4,"projeto4","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
        projetos.add(new Projeto(5,"projeto5","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
        projetos.add(new Projeto(6,"projeto6","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
        projetos.add(new Projeto(7,"projeto7","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
        projetos.add(new Projeto(8,"projeto8","Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero",3.2,"Biologia"));
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    
    

    
    
    private String cpLogin;
    private String cpSenha;
    private String lbSenha = "";
    
    public String btEntrar (ActionEvent ae){
        setLbSenha("Login ou Senha Incorreta");
        return "index";
    }

    public String getCpLogin() {
        return cpLogin;
    }

    public void setCpLogin(String cpLogin) {
        this.cpLogin = cpLogin;
    }

    public String getCpSenha() {
        return cpSenha;
    }

    public void setCpSenha(String cpSenha) {
        this.cpSenha = cpSenha;
    }

    public String getLbSenha() {
        return lbSenha;
    }

    public void setLbSenha(String lbSenha) {
        this.lbSenha = lbSenha;
    }
    
    
    
    
}
