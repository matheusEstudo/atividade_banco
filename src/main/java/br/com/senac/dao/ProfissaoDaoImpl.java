package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProfissaoDaoImpl extends BaseDaoImpl<Profissao, Long> implements ProfissaoDao, Serializable {

    @Override
    public Profissao pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Profissao.class, id);
    }

    @Override
    public List<Profissao> askPerName(String nome, Session session) throws HibernateException {
        Query<Profissao> consulta = session.createQuery("from Profissao pf where pf.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

}
