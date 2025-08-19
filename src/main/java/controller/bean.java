package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.ActionEvent;
import java.io.Serializable;


@Named("ctl")
@SessionScoped
public class bean implements Serializable {
    
    public bean() {
    } //construtor
    
    
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
