package br.com.senac.dao;

import br.com.senac.entidade.PessoaJuridica;
import com.mysql.cj.log.Log;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PessoaJuridicaDaoImpl extends BaseDaoImpl<PessoaJuridica, Long> implements PessoaJuridicaDao, Serializable {

    @Override
    public PessoaJuridica pesquisarPorId(Long id, Session session) throws HibernateException {
        return session.find(PessoaJuridica.class, id);
    }

}
