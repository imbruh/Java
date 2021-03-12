package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOUsuario;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import modelo.Usuario;
import modelo.Assunto;
import modelo.Video;
import modelo.Visualizacao;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Fachada {
	private static DAOUsuario daousuario = new DAOUsuario();  
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();


	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}

	public static Usuario cadastrarUsuario(String email) throws  Exception{
		DAO.begin();	
		Usuario u = daousuario.read(email);
		if(u != null) {
			DAO.rollback();
			throw new Exception("Usuario ja cadastrado:" + email);
		}
		u = new Usuario(email);
		daousuario.create(u);	
		DAO.commit();
		return u;
	}

	public static Assunto cadastrarAssunto(String palavra) throws  Exception{
		DAO.begin();	
		Assunto a = daoassunto.read(palavra);
		if(a != null) {
			DAO.rollback();
			throw new Exception("Assunto ja cadastrado:" + palavra);	
		}
		a=new Assunto(palavra);
		daoassunto.create(a);
		DAO.commit();
		return a;
	}	

	public static Video cadastrarVideo(String link, String nome, String assunto) throws  Exception{
		DAO.begin();	
		Video vid = daovideo.read(nome);
		if(vid != null) {
			DAO.rollback();
			throw new Exception("Video ja cadastrado:" + nome);
		}
		
		Assunto a = daoassunto.read(assunto);
		if (a == null) {
			 a = new Assunto(assunto);
			 daoassunto.create(a);	
			 DAO.commit();
		}
		
		vid = new Video(link, nome, a);
		daovideo.create(vid);	
		vid.adicionar(a);
		a.adicionar(vid);
		daovideo.update(vid);
		daoassunto.update(a);	
		DAO.commit();
		return vid;
	}

	public static Visualizacao cadastrarVisualizacao(int nota, String email, String videoNome) throws  Exception{
        DAO.begin();
        Usuario u = daousuario.read(email);
        Video v = daovideo.read(videoNome);
        if (v==null) {
            DAO.rollback();
            throw new Exception("Video nao encontrado:" + videoNome);
        }
        if (u == null) {
            u=Fachada.cadastrarUsuario(email);
        }
        int id;
        List<Visualizacao> visall= daovisualizacao.readAll();
        if (visall.size()==0) {
            id=1;
        }
        else {
            int lastvis=visall.size()-1;
            Visualizacao vi =visall.get(lastvis);
            id =vi.getId()+1;
        }
        Visualizacao vis = new Visualizacao(id,nota,u,v);
        daovisualizacao.create(vis);
        v.adicionar(vis);
        u.adicionar(vis);
        daousuario.update(u);
        daovideo.update(v);

        DAO.commit();

        calcularMedia(videoNome);
        return vis;
    }

    public static void calcularMedia(String videoNome) {
        DAO.begin();
        Video v = daovideo.read(videoNome);
        List<Visualizacao> visAll = v.getVisualizacoes();
        double numeroVis = visAll.size();
        double somaNota=0;
        for (Visualizacao vis : visAll) {
            somaNota+=vis.getNota();
        }
        double media = somaNota/numeroVis;
        v.setMedia(media);
        daovideo.update(v);
        DAO.commit();

    }
	
	public static void removerVisualizacao(int id) throws Exception {  
		DAO.begin();
		Visualizacao visu = daovisualizacao.read(id);
		if(visu==null) {
			throw new Exception("Visualização " + id + " inexistente" );
		}
		Usuario u = visu.getUsuario();
		Video vid = visu.getVideo();
		u.remover(visu);
		vid.remover(visu);
		daovisualizacao.delete(visu);
		calcularMedia(vid.getNome());
		daousuario.update(u);
        daovideo.update(vid);
        
        DAO.commit();
	}
	
	public static List<Usuario> listarUsuario() {
		return daousuario.readAll();
		
	}
	
	public static List<Assunto> listarAssunto() {
		return daoassunto.readAll();
	}
	
	public static List<Video> listarVideo() {
		return daovideo.readAll();
	}
	
	public static List<Visualizacao> listarVisualizacao() {
		return daovisualizacao.readAll();
	}
	
	public static List<Video> consultarVideoAssunto(String assunto) throws  Exception{
		DAO.begin();
		List<Video> vid = daovideo.readAssunto(assunto);
		if (vid==null) {
			throw new Exception("Video nao encontrado com assunto: " + assunto);
		}
		else {
			return vid;
		}			
	}
	
	public static List<Video> consultarVideoUsuario(String email) throws  Exception{
		DAO.begin();
		List<Video> vid = daovideo.readUsuario(email);
		if (vid==null) {
			throw new Exception("Nenhum video foi visualizado pelo usuario: " + email);
		}
		else {
			return vid;
		}
	}
	
	public static List<Usuario> consultarUsuarioVideo(String nomeVideo) throws  Exception{
		DAO.begin();
		List<Usuario> usuario = daousuario.readVideo(nomeVideo);
		if (usuario==null) {
			throw new Exception("Nenhum usuario visualizou o video: " + nomeVideo);
		}
		else {
			return usuario;
		}
	}
	
	public static void abrirLink(String nomeVideo) throws Exception {
        Video v=daovideo.read(nomeVideo);
        if (v==null) {
        	throw new Exception("Nenhum video foi cadastrado com o nome: " + nomeVideo);
        }
        String link =""; 
        link=v.getLink();
        try {
            Desktop.getDesktop().browse(new URL(link).toURI());

        } catch (MalformedURLException e) {
            throw new Exception(e.getMessage());
        } catch (IOException e) {
            throw new Exception(e.getMessage());
        } catch (URISyntaxException e) {
            throw new Exception(e.getMessage());
        } 
    }
	

	public static String atualizarUsuario(String email, String novoEmail) throws Exception{
		DAO.begin();		
		Usuario u = daousuario.read(email);	
		if (u==null) {
			DAO.rollback();
			throw new Exception("usuario inexistente:" + email);
		}
		if (email.equals(novoEmail)) {
			throw new Exception("o email é o mesmo");
		}
 		u.setEmail(novoEmail); 			
		u=daousuario.update(u);     	
		DAO.commit();
		return email + " foi atualizado para " + novoEmail;
	}
	
	public static String atualizarAssunto(String palavra, String novaPalavra) throws Exception{
		DAO.begin();		
		Assunto a = daoassunto.read(palavra);	
		if (a==null) {
			DAO.rollback();
			throw new Exception("assunto inexistente:" + palavra);
		}
		if (palavra.equals(novaPalavra)) {
			throw new Exception("o assunto é o mesmo");
		}
		a.setPalavra(novaPalavra); 			
		a=daoassunto.update(a);     	
		DAO.commit();
		return palavra + " foi atualizado para " + novaPalavra;
	}
	
	public static String atualizarVideoNome(String nome, String novoNome) throws Exception{
		DAO.begin();		
		Video v = daovideo.read(nome);	
		if (v==null) {
			DAO.rollback();
			throw new Exception("video inexistente:" + nome);
		}
		if (nome.equals(novoNome)) {
			throw new Exception("o nome é o mesmo");
		}
		v.setNome(novoNome); 			
		v=daovideo.update(v);     	
		DAO.commit();
		return nome + " foi atualizado para " + novoNome;
	}
	
	public static String atualizarLink(String nomeVideo, String novoLink) throws Exception{
        DAO.begin();
        Video v = daovideo.read(nomeVideo);
        if (v==null) {
            DAO.rollback();
            throw new Exception("Video inexistente:" + nomeVideo);
        }
        if (v.getLink().equals(novoLink)) {
			throw new Exception("o link é o mesmo");
		}
        v.setLink(novoLink);
        v=daovideo.update(v);
        DAO.commit();
        return  "O link do video "+ nomeVideo+" foi atualizado";
    }
	
	public static String adicionarAssunto(String assunto,String nomeVideo) throws Exception {
        Assunto a = daoassunto.read(assunto);
        Video v = daovideo.read(nomeVideo);
        if (v==null) {
            throw new Exception("Video nao encontrado: "+nomeVideo);
        }
        if (a==null) {
            a =cadastrarAssunto(assunto);
        }
        v.adicionar(a);
        daovideo.update(v);
        DAO.commit();
        return "o assunto " + assunto + " foi inserido no video " + nomeVideo;
    }

}
