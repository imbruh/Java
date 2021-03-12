package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Video;

public class DAOVideo  extends DAO<Video>{

	public Video read (Object chave) {
		String nome = (String) chave;
		
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("nome").constrain(nome);
		List<Video> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	
	public List<Video> readAssunto (Object chave) {
		String assunto = (String) chave;
		
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("assuntos").descend("palavra").constrain(assunto);
		List<Video> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
	
	public List<Video> readUsuario (Object chave) {
		String email = (String) chave;
		
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("visualizacoes").descend("usuario").descend("email").constrain(email);
		List<Video> resultados = q.execute();
		if (resultados.size()>0)
			return resultados;
		else
			return null;
	}
}

