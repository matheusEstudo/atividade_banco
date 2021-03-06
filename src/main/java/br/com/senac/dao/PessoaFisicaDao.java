package br.com.senac.dao;

import br.com.senac.entidade.PessoaFisica;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface PessoaFisicaDao extends BaseDao<PessoaFisica, Long> {

    List<PessoaFisica> askPerName(String nome, Session session) throws HibernateException;
}
