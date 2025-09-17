package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.Projeto;
import java.util.ArrayList;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.util.IOUtils;

@Named("ctl")
@SessionScoped
public class bean implements Serializable {

    public bean() {

        init();
    } //construtor

    ////cadastroProjeto
    private UploadedFile arq;
    
    public void upload(FileUploadEvent event) throws IOException {
        this.arq = null;
        UploadedFile file = event.getFile();
        if (file != null && file.getContent() != null && file.getContent().length > 0 && file.getFileName() != null) {
            this.arq = file;
            String extensao = FilenameUtils.getExtension(arq.getFileName());
            //fiz para pegar da data e hora do servidor
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyy-HH_mm_ss_SSS");
            LocalDateTime now = LocalDateTime.now();
            // Gera o novo nome do arquivo no formato 'dia-mes-ano_hora-minuto-segundo.extensão' depois só vou colocar o ID do usuário logado no começo
            String newFileName = dtf.format(now) + "." + extensao;
            InputStream input = arq.getInputStream();
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
            String realPath = context.getRealPath("/");
            File pasta = new File(realPath + "/artefatos/");
            pasta.mkdirs();
            String caminho = realPath + "/artefatos/";
            System.out.println("### caminho: "+ caminho);//só para ver aonde está gerando o caminho dos artefatos no meu ficou esse C:\IFHUB\IFHub\target\ifHub-1.0-SNAPSHOT\artefatos

            
            OutputStream output = new FileOutputStream(new File(caminho, newFileName));
            try {
                IOUtils.copyLarge(input, output);
            } finally {
            }
            FacesMessage msg = new FacesMessage("Enviado com sucesso!", this.arq.getFileName() + " foi armazenado.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }//upload

    public UploadedFile getArq() {
        return arq;
    }

    public void setArq(UploadedFile arq) {
        this.arq = arq;
    }

    private List<Projeto> projetos;

    public void init() {
        projetos = new ArrayList<>();
        projetos.add(new Projeto(1, "projeto1", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 4.9, "Informática"));
        projetos.add(new Projeto(2, "projeto2", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 4.7, "Ciências"));
        projetos.add(new Projeto(3, "projeto3", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
        projetos.add(new Projeto(4, "projeto4", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
        projetos.add(new Projeto(5, "projeto5", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
        projetos.add(new Projeto(6, "projeto6", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
        projetos.add(new Projeto(7, "projeto7", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
        projetos.add(new Projeto(8, "projeto8", "Teste Funcional de projeto para alinhamento de camadas para adequar ao tamanho necessário para ficar bem bonito e para fazer um miojo basta acrescentar agua a uma panela e ao ferver adicionar o macarrão estantaneo e logo em seguida desligar o fogo e adicionar o tempero", 3.2, "Biologia"));
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

    public String btEntrar(ActionEvent ae) {
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
