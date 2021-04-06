package fachada;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import dao.DAO;
import dao.DAOUsuario;
import modelo.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Fachada {
	private static DAOUsuario daousuario = new DAOUsuario();
	

	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	public static Usuario cadastrarUsuario(String nome, String email, String senha) throws Exception{
		DAO.begin();
		Usuario u = daousuario.read(nome);
		if(u != null) {
			DAO.rollback();
			throw new Exception("cadastrar usuario - usuario ja cadastrado:" + nome);
		}
		u = new Usuario(nome,email,senha);
		daousuario.create(u);
		DAO.commit();
		return u;
	}
	
	public static Usuario alterarNomeUsuario(String nome, String novonome) throws Exception{
		DAO.begin();		
		Usuario u = daousuario.read(nome);	//usando  chave primaria
		if (u==null) {
			DAO.rollback();
			throw new Exception("usuario nao encontrado");
		}
		u.setNome(novonome); 			
		u=daousuario.update(u);     	
		DAO.commit();
		return u;
	}
	
	public static Usuario alterarEmailUsuario(String nome, String novoemail) throws Exception{
		DAO.begin();		
		Usuario u = daousuario.read(nome);	//usando  chave primaria
		if (u==null) {
			DAO.rollback();
			throw new Exception("usuario nao encontrado");
		}
		u.setEmail(novoemail); 			
		u=daousuario.updateEmail(u);     	
		DAO.commit();
		return u;
	}
	
	public static Usuario alterarSenhaUsuario(String nome, String novasenha) throws Exception{
		DAO.begin();		
		Usuario u = daousuario.read(nome);	//usando  chave primaria
		if (u==null) {
			DAO.rollback();
			throw new Exception("usuario nao encontrado");
		}
		u.setSenha(novasenha); 			
		u=daousuario.updateSenha(u);     	
		DAO.commit();
		return u;
	}
	
	public static void excluirUsuario(String usuario) throws Exception {
		DAO.begin();
		Usuario u = daousuario.read(usuario);
		if (u==null) {
			DAO.rollback();	
			throw new Exception("usuario nao encontrado");
		}
		daousuario.delete(u);  
		DAO.commit();
	}

	/**********************************************************
	 * 
	 * RELATORIO JASPER REPORT 
	 * 
	 * compila relatório e abre a janela de visualização
	 * 
	 * **********************************************************/
	public static void gerarRelatorioJasper(String arqjrxml) throws Exception {
		try {
			Connection con = DAO.getConnection();  //conexao JDBC
			if (con==null) 
				throw new Exception("conexão inexistente");
			
			InputStream istream = Fachada.class.getClassLoader().getResourceAsStream(arqjrxml);
			JasperReport report = JasperCompileManager.compileReport(istream);
			
			HashMap<String,Object>  parametros = new HashMap<>();   //obrigatorio mesmo vazio
			JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
			JasperViewer.viewReport(print, false);  //false não fecha a janela principal da aplicação
		}
		catch(JRException e) {
			throw new Exception ("erro de relatório:"+e.getMessage());
		}
	
	}


}
