package ps2.teoriab2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Serie {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private int temporadas;
    private int episodios;

    public Serie() {
    }
    public Serie(Long id, String titulo, int temporadas, int episodios) {
        this.id = id;
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public int getEpisodios() {
        return episodios;
    }
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    
}
