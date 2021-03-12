package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double media;
	private LocalDateTime datahora = LocalDateTime.now();
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video(String link, String nome, Assunto assunto) {
		this.link = link;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	
	public void remover(Visualizacao vis) {
		visualizacoes.remove(vis);
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public LocalDateTime getDatahora() {
		return datahora;
	}


	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}

	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}

	public void setVisualizacoes(List<Visualizacao> visualizacoes) {
		this.visualizacoes = visualizacoes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAssunto() {
		String assunto = "";
		for (Assunto a: assuntos) {
			assunto += a != null ? a.getPalavra() + ", " : "";
			
		}
		return assunto;
	}
	
	public String getIdVisualizacao() {
		String id = "";
		for (Visualizacao visu: visualizacoes) {
			id += visu != null ? visu.getId() + "," : "";
		}
		return id;
	}
	
	
	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "datahora=" + this.datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + ", " + "media=" + media ;
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra();
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		texto+="\n";
		return texto;
	}
		
}
