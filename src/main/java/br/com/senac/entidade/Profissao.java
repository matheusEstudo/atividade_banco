package br.com.senac.entidade;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    public Profissao() {
    }

    public Profissao(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

}
