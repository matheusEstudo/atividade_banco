package br.com.senac.entidade;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class PessoaFisica extends Cliente {

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    public PessoaFisica() {
    }

    public PessoaFisica(String nome, String email, String cpf, String rg) {
        super(nome, email);
        this.cpf = cpf;
        this.rg = rg;
    }

}
