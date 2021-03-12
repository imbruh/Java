package modelo;
import java.util.ArrayList;
import java.util.List;

public class Assunto {
	private String palavra;
	private List<Video> videos = new ArrayList<>();
	
	public Assunto(String palavra) {
		this.palavra = palavra;
	}

	
	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}
	
	public String getNomeVideos() {
		String video = "";
		for (Video a: videos) {
			video += a != null ? a.getNome() + ", " : "";
			
		}
		return video;
	}
	
	@Override
	public String toString() {
		String texto = "Assunto [palavra=" + palavra;
		texto+=", videos=";
		for(Video v : videos) {
			texto += v.getNome() + ", ";
		}
		texto+="]\n";
		return texto;
	}
	
	
	
}
