package br.com.senac.dao;

import br.com.senac.entidade.Endereco;
import br.com.senac.entidade.PessoaFisica;
import static br.com.senac.util.GeradorUtil.*;
import com.github.javafaker.Faker;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaFiscaDaoImplTest {

    private PessoaFisica pessoaFisica;
    private PessoaFisicaDao pessoaFisicaDao;
    private Session session;
    private ProfissaoDaoImplTest consultaProfissao;
    Faker faker;

    public PessoaFiscaDaoImplTest() {
        pessoaFisicaDao = new PessoaFiscaDaoImpl();
        consultaProfissao = new ProfissaoDaoImplTest();
        faker = new Faker();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        pessoaFisica = new PessoaFisica(faker.name().firstName(),
                faker.name().firstName() + "@gmail.com",
                gerarCpf(),
                "1456967");
        Endereco endereco = gerarEndereco();
        pessoaFisica.setEndereco(endereco);
        endereco.setCliente(pessoaFisica);
        pessoaFisica.setProfissao(consultaProfissao.buscarProfissaoBd());
        session = HibernateUtil.abrirConexao();
        pessoaFisicaDao.salvarOuAlterar(pessoaFisica, session);
        session.close();
        assertNotNull(pessoaFisica.getId());
    }

//    @Test
    public void testalterar() {
        System.out.println("alterar");
        buscarPessoaFisicaBd();
        pessoaFisica.setNome("Pedrão");
        pessoaFisica.getEndereco().setCidade("palhoca");
        pessoaFisica.setProfissao(consultaProfissao.buscarProfissaoBd());
        pessoaFisica.getProfissao().setNome("dev");
        session = HibernateUtil.abrirConexao();
        pessoaFisicaDao.salvarOuAlterar(pessoaFisica, session);
        session.close();

        session = HibernateUtil.abrirConexao();
        PessoaFisica pesFisicaAlt = pessoaFisicaDao.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();

        assertEquals(pessoaFisica.getNome(), pesFisicaAlt.getNome());
    }

//    @Test
    public void testExcluir() {
        System.out.println("Excluir");
        buscarPessoaFisicaBd();
        session = HibernateUtil.abrirConexao();
        pessoaFisicaDao.excluir(pessoaFisica, session);

        PessoaFisica pesFisicaExc = pessoaFisicaDao.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();

        assertNotNull(pesFisicaExc);

    }

//     @Test
    public void testePesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarPessoaFisicaBd();
        session = HibernateUtil.abrirConexao();
        List<PessoaFisica> pessoasF = pessoaFisicaDao.askPerName(pessoaFisica.getNome(), session);
        session.close();
        assertFalse(pessoasF.isEmpty());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPessoaFisicaBd();
        session = HibernateUtil.abrirConexao();
        PessoaFisica pesFisica = pessoaFisicaDao.pesquisarPorId(pessoaFisica.getId(), session);
        session.close();
        assertNotNull(pesFisica);
    }

    public PessoaFisica buscarPessoaFisicaBd() {
        String hql = "from PessoaFisica pf";
        session = HibernateUtil.abrirConexao();
        Query<PessoaFisica> consulta = session.createQuery(hql);
        List<PessoaFisica> pessoaFisicas = consulta.getResultList();
        session.close();
        if (pessoaFisicas.isEmpty()) {
            testSalvar();
        } else {
            pessoaFisica = pessoaFisicas.get(0);
        }
        return pessoaFisica;
    }

}
