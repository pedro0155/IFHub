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
    
    public void init(){
        projetos = new ArrayList<>();
        projetos.add(new Projeto(1,
                "Identidade Visual de Marca: Adoção Pet Local",
                " Este trabalho de design gráfico tem como objetivo a criação de uma identidade visual completa e profissional para uma ONG de resgate e adoção de animais. O projeto inclui a idealização e o desenvolvimento de um logotipo atraente e memorável, que transmita confiança e carinho. Além disso, a proposta abrange a definição de uma paleta de cores, tipografia e elementos gráficos que serão aplicados em todos os materiais da marca: cartões de visita, posts para redes sociais, camisetas, e banners. O foco é criar uma imagem de marca coerente e empática, que inspire doações e adoções.",
                4.9,"Informática"));
        projetos.add(new Projeto(2,
                "Estratégia de Conteúdo para Pequenos Negócios: Crescendo no Instagram",
" O projeto de marketing digital desenvolve uma estratégia de conteúdo e crescimento para o Instagram de um pequeno negócio de artesanato. A proposta se inicia com uma análise do público-alvo e dos concorrentes, seguida pela definição de pilares de conteúdo (educacional, inspiracional e de venda) e um calendário editorial. O plano detalha a criação de conteúdo visual (fotos e Reels), a redação de legendas com foco em SEO, a gestão de hashtags e o agendamento de publicações. Por fim, o projeto inclui a definição de métricas de desempenho (alcance, engajamento e conversão) para monitorar e ajustar a estratégia.",
                4.7,"Ciências"));
        projetos.add(new Projeto(3,
                "Fazenda Inteligente: Otimizando a Produção com Sensores IoT",
"Este projeto integrador foca no desenvolvimento de um sistema de monitoramento agrícola utilizando a Internet das Coisas (IoT). O sistema consiste em uma rede de sensores sem fio, instalados em pontos estratégicos de uma lavoura, para coletar dados em tempo real sobre umidade do solo, temperatura ambiente, luminosidade e pH. As informações são transmitidas para uma plataforma central, onde são analisadas para gerar recomendações personalizadas para o agricultor, como o momento ideal para irrigação e a quantidade necessária de água e fertilizantes. O objetivo é aumentar a eficiência hídrica, reduzir custos operacionais e maximizar a produtividade da colheita de forma sustentável, utilizando a tecnologia para uma agricultura mais precisa.",
                3.2,"Biologia"));
        projetos.add(new Projeto(4,
                "Análise Estrutural de Pontes: Otimização de Custo e Segurança",
" O projeto consiste na análise e modelagem estrutural de uma ponte rodoviária de pequeno a médio porte. Utilizando softwares de engenharia avançados (como SAP2000 ou Cype), o objetivo é simular diferentes cargas (tráfego, vento, sismo) e condições ambientais para garantir a segurança e a estabilidade da estrutura. A análise busca a otimização do projeto, propondo a utilização de materiais e perfis estruturais que reduzam o peso e o custo total da construção sem comprometer a integridade e a durabilidade da ponte. O resultado é um memorial de cálculo detalhado e um modelo 3D da estrutura.",
                3.2,"Biologia"));
        projetos.add(new Projeto(5,
                "Plataforma de E-learning Interativa para Ensino Fundamental",
" O projeto consiste no desenvolvimento de uma plataforma de e-learning gamificada para alunos do Ensino Fundamental. O foco é transformar o aprendizado de disciplinas como matemática e português em uma experiência divertida e interativa. A plataforma conta com módulos de ensino temáticos, que incluem jogos, quizzes, vídeos animados e atividades práticas. Os alunos são incentivados a avançar através de sistemas de pontos, medalhas e ranking, o que aumenta o engajamento e a motivação. O projeto também inclui um dashboard para pais e professores, que permite monitorar o progresso do aluno e identificar áreas de dificuldade.",
                3.2,"Biologia"));
        projetos.add(new Projeto(6,
                "App de Gestão Financeira Pessoal: Finanças Fácil",
" O Finanças Fácil é um aplicativo móvel intuitivo projetado para ajudar o usuário a ter controle total sobre suas finanças pessoais. A aplicação permite registrar despesas e receitas de forma rápida, categorizar gastos, e visualizar o fluxo de caixa através de gráficos e dashboards interativos. O diferencial é a funcionalidade de orçamentos personalizáveis, onde o usuário pode definir limites de gastos por categoria e receber alertas em tempo real ao se aproximar desses limites. O aplicativo também oferece relatórios mensais e análises preditivas, auxiliando na criação de metas financeiras de longo prazo.",
                3.2,"Biologia"));
        projetos.add(new Projeto(7,
                "Inovação na Cozinha: Gastronomia Molecular e Texturas",
" Este projeto explora as técnicas da gastronomia molecular para desconstruir e reinventar pratos clássicos. O objetivo é utilizar ferramentas e ingredientes da ciência dos alimentos, como alginato de sódio, agar-agar e lecitina de soja, para criar novas texturas e experiências sensoriais. O projeto prático inclui a experimentação com esferificação, gelificação, e emulsificação para transformar sucos em \"caviar\", espumas em mousses e óleos em pós. O resultado é um menu degustação inovador, que apresenta a fusão entre a culinária tradicional e a ciência moderna.",
                3.2,"Biologia"));
        projetos.add(new Projeto(8,
                "Construções Sustentáveis: Design e Materiais Ecológicos",
" Este projeto é um estudo detalhado e proposição de design para uma residência unifamiliar ecologicamente correta. O foco está na aplicação de princípios de arquitetura bioclimática, como a orientação solar adequada para iluminação natural e o uso de ventilação cruzada para reduzir a necessidade de ar-condicionado. A construção prioriza o uso de materiais sustentáveis, como bambu, madeira de reflorestamento e tijolos de solo-cimento. O projeto inclui sistemas de captação e reuso de água da chuva, telhado verde para isolamento térmico e painéis solares para geração de energia limpa, buscando uma edificação com mínima pegada ambiental.",
                3.2,"Biologia"));
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    
    
private Projeto mostrarProjeto; //Controlador para mostrar projeto sem banco apagar depois
private int mostrarid;
private String mostrartitulo;
private String mostrardesc;


    public Projeto getMostrarProjeto() {
        return mostrarProjeto;
    }

    public void setMostrarProjeto(Projeto mostrarProjeto) {
        this.mostrarProjeto = mostrarProjeto;
    }

    public void setMostrarid(int mostrarid) {
        this.mostrarid = mostrarid;
    }

    public void setMostrartitulo(String mostrartitulo) {
        this.mostrartitulo = mostrartitulo;
    }

    public void setMostrardesc(String mostrardesc) {
        this.mostrardesc = mostrardesc;
    }

    public int getMostrarid() {
        return mostrarid;
    }

    public String getMostrartitulo() {
        return mostrartitulo;
    }

    public String getMostrardesc() {
        return mostrardesc;
    }

    
    public String btVisualizarProjeto(){
        
        if(mostrarProjeto != null){
            setMostrarid(mostrarProjeto.getId());
            setMostrartitulo(mostrarProjeto.getNomeProjeto());
            setMostrardesc(mostrarProjeto.getDescricaoProjeto());
        }

        return "/descricaoProjeto.xhtml";
    } //apagar até aqui


    
    
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
