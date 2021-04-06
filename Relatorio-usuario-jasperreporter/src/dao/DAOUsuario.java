/**
 * IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modelo.Usuario;

public class DAOUsuario extends DAO<Usuario> {

	public  void create(Usuario u) {
		try{
			PreparedStatement st=con.prepareStatement("insert into Usuario (nome, email, senha) values (?, ?, ?)");
			st.setString(1,u.getNome() );
			st.setString(2, u.getEmail() );
			st.setString(3, u.getSenha() );
			st.executeUpdate();

			//obter o id do objeto gravado
			st=con.prepareStatement("select id from Usuario where nome=?");
			st.setString(1,u.getNome());
			ResultSet rs = st.executeQuery();
			int id;
			if(rs.next()) {
				id = rs.getInt("id");
				u.setId(id);
			}
			st.close();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}

	public Usuario read(Object chave) 	{
		Usuario user=null;
		int id;
		String email;
		String senha;
		try{
			String nome = (String) chave ;
			PreparedStatement st = con.prepareStatement("select * from Usuario where nome =  ?");
			st.setString(1,nome);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				id = rs.getInt("id");
				nome = rs.getString("nome");
				email = rs.getString("email");
				senha = rs.getString("senha");
			 
				user = new Usuario(id,nome,email,senha);
				st.close();
			}
			else
				user = null;
		}catch(Exception e){ 
			throw new RuntimeException(e.getMessage());
		}
		return user;

	}
	
	public Usuario update(Usuario u) 	{
		try{
			PreparedStatement st =con.prepareStatement("update Usuario set nome = '"+ u.getNome() + "'  where id = "+u.getId());
			int i = st.executeUpdate();
			st.close();
		}catch(Exception e){ }
		return u;
	}
	
	public Usuario updateEmail(Usuario u) 	{
		try{
			PreparedStatement st =con.prepareStatement("update Usuario set email = '"+ u.getEmail() + "'  where id = "+u.getId());
			int i = st.executeUpdate();
			st.close();
		}catch(Exception e){ }
		return u;
	}
	
	public Usuario updateSenha(Usuario u) 	{
		try{
			PreparedStatement st =con.prepareStatement("update Usuario set senha = '"+ u.getSenha() + "'  where id = "+u.getId());
			int i = st.executeUpdate();
			st.close();
		}catch(Exception e){ }
		return u;
	}

	public  void delete(Usuario u) {
		try{
			PreparedStatement st =	con.prepareStatement("delete from Usuario where id = ?");
			st.setInt(1, u.getId());
			int i = st.executeUpdate();
			
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}

	}

	public  ArrayList<Usuario> readAll() {	
		int id;
		String nome;
		String email;
		String senha;
		ArrayList<Usuario> resultados = new ArrayList<Usuario>();
		try{
			//ler todas os usuarios
			PreparedStatement st =	con.prepareStatement("select id, nome, email, senha from usuario order by id");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
				nome = rs.getString("nome");
				email= rs.getString("email");
				senha= rs.getString("senha");
				Usuario u = new Usuario(id,nome,email,senha);
				resultados.add(u);
			}
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return resultados;
	}
}

	
