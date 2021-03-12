package modelo;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Visualizacao {
    private int id;
    private int nota;
    private Usuario usuario;
    private Video video;
    private LocalDate data = LocalDate.now();
    private LocalTime hora = LocalTime.now(); 
    DateTimeFormatter parserHora= DateTimeFormatter.ofPattern("HH:mm:ss");
    private String horaFormatada = parserHora.format(hora);
    private String datahora="";
    
    public Visualizacao(int id, int nota, Usuario usuario, Video video) {
        this.id = id;
        this.nota = nota;
        this.usuario = usuario;
        this.video = video;
        this.datahora+=data+" ";
        this.datahora+=horaFormatada;
    }
    
    public int getNota() {
        return nota;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Video getVideo() {
        return video;
    }
    public void setVideo(Video video) {
        this.video = video;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDatahora() {
		return datahora;
	}

	public void setDatahora(String datahora) {
		this.datahora = datahora;
	}

	@Override
    public String toString() {
        return "Visualizacao [id=" + id + 
                ", nota=" + nota +
                "\n usuario=" + usuario.getEmail() + ", datahora= "+datahora+", video=" + video.getNome() + "]";
    }
}
