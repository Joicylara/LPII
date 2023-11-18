package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
/*Listar todas as pessoas jurídicas cadastradas (código, nome fantasia e cnpj), ordenados pelo
nome fantasia. */
public class ListaPessoaJuridica {
    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT pessoa FROM PessoaJuridica pessoa ORDER BY pessoa.nome");
            List<PessoaJuridica> listaPessoaFisica = query.getResultList();
            for(PessoaJuridica pessoa : listaPessoaFisica){
                System.out.println("Dados de pessoa juridica");
                System.out.println("Codigo: " +pessoa.getCodigo());
                System.out.println("Nome fantasia: "+pessoa.getNomeFantasia());
                System.out.println("CNPJ: "+pessoa.getCnpj());
                System.out.println("-----------------------------------------");
            }
           
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
