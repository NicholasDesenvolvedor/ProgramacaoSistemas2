package ps2.teoriab2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Filme {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private int ano;
    private String pais;

    public Filme() {
    }
    public Filme(Long id, String titulo, int ano, String pais) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.pais = pais;
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
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
