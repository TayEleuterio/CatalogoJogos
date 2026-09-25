package br.uel.CatalogoJogos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_jogos")
public class Jogo {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String titulo;


    @Column(nullable = false)
    private String genero;


    @Column(nullable = false)
    private Double preco;


    private  LocalDate dataLancamento;

    private  String urlCapa;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public  Jogo() {}

    public Jogo(String titulo, String genero, Double preco, LocalDate dataLancamento, String urlCapa, String descricao) {
        this.titulo = titulo;
        this.genero = genero;
        this.preco = preco;
        this.dataLancamento = dataLancamento;
        this.urlCapa = urlCapa;
        this.descricao = descricao;
    }

    //Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
    public LocalDate getDataLancamento() { return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) { this.dataLancamento = dataLancamento; }
    public String getUrlCapa() { return urlCapa; }
    public void setUrlCapa(String urlCapa) { this.urlCapa = urlCapa; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
