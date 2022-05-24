package br.com.senac.dao;

import br.com.senac.entidade.PessoaFisica;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PessoaFiscaDaoImpl extends BaseDaoImpl<PessoaFisica, Long> implements PessoaFisicaDao, Serializable {

    @Override
    public PessoaFisica pesquisarPorId(Long id, Session session) throws HibernateException {
        return session.find(PessoaFisica.class, id);
    }

    @Override
    public List<PessoaFisica> askPerName(String nome, Session session) throws HibernateException {
        Query<PessoaFisica> consulta = session.createQuery("from PessoaFisica pf where pf.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

}
