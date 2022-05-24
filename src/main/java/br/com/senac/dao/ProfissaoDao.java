package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface ProfissaoDao extends BaseDao<Profissao, Long> {

    List<Profissao> askPerName(String nome, Session session) throws HibernateException;

}
