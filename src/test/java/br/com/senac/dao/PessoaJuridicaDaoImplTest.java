package br.com.senac.dao;

import br.com.senac.entidade.PessoaJuridica;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaJuridicaDaoImplTest {

    private PessoaJuridica pessoaJuridica;
    private PessoaJuridicaDao pessoaJuridicaDao;
    private Session session;

    public PessoaJuridicaDaoImplTest() {
        pessoaJuridicaDao = new PessoaJuridicaDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("Save");
        pessoaJuridica = new PessoaJuridica("Vítor", "vitor@gmail.com", "123155315135", "Isso ai");
        session = HibernateUtil.abrirConexao();
        pessoaJuridicaDao.salvarOuAlterar(pessoaJuridica, session);
        session.close();
        assertNotNull(pessoaJuridica.getId());
    }

//    @Test
    public void testExcluir() {
        System.out.println("Excluir");

    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }

}
