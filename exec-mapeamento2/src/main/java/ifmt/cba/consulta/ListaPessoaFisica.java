package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaFisica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
/*Listar todas as pessoas físicas cadastradas (código, nome, rg e cpf), ordenados pelo nome. */
public class ListaPessoaFisica {
    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT pessoa FROM PessoaFisica pessoa ORDER BY pessoa.nome");
            List<PessoaFisica> listaPessoaFisica = query.getResultList();
            for(PessoaFisica pessoa : listaPessoaFisica){
                System.out.println("Dados de pessoa fisicas");
                System.out.println("Codigo: " +pessoa.getCodigo());
                System.out.println("Nome: "+pessoa.getNome());
                System.out.println("RG: "+pessoa.getRg());
                System.out.println("CPF: "+pessoa.getCpf());
                System.out.println("-----------------------------------------");
            }
           
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
