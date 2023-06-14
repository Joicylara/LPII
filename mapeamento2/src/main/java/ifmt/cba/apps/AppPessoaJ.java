package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;

public class AppPessoaJ {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            PessoaJuridica pj = new PessoaJuridica("Maria", "sadia");
            em.persist(pj);

            pj = new PessoaJuridica("Ana Maria", "Perdigao");
            em.persist(pj);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
