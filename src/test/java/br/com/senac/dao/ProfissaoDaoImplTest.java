package br.com.senac.dao;

import br.com.senac.entidade.Profissao;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProfissaoDaoImplTest {

    private Profissao profissao;
    private ProfissaoDao profissaoDao;
    private Session session;
    Faker faker = new Faker();

    public ProfissaoDaoImplTest() {
        profissaoDao = new ProfissaoDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");

        profissao = new Profissao(faker.job().title(), faker.lorem().sentence());
        session = HibernateUtil.abrirConexao();
        profissaoDao.salvarOuAlterar(profissao, session);
        session.close();
        assertNotNull(profissao.getId());
    }
//    @Test

    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

//    @Test
    public void testAskPerName() {
        System.out.println("askPerName");

    }

    public Profissao buscarProfissaoBd() {
        session = HibernateUtil.abrirConexao();
        Query<Profissao> consulta = session.createQuery("from Profissao p");
        List<Profissao> profissaos = consulta.getResultList();
        session.close();
        if (profissaos.isEmpty()) {
            testSalvar();
        } else {
            profissao = profissaos.get(0);
        }
        return profissao;
    }

}
