package br.com.senac.entidade;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class PessoaJuridica extends Cliente {

    @Column(nullable = false, unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String escriçãoEstadual;

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String email, String cnpj, String escriçãoEstadual) {
        super(nome, email);
        this.cnpj = cnpj;
        this.escriçãoEstadual = escriçãoEstadual;
    }

}
