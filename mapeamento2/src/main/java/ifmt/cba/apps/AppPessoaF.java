package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaFisica;
import jakarta.persistence.EntityManager;

public class AppPessoaF {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //PessoaFisica pf = new PessoaFisica("Heloise","87530-9" , "873542-09");
            //em.persist(pf);

            //pf = new PessoaFisica("Ana Maria", "45367-0", "8754253-08");
            //em.persist(pf);

            PessoaFisica pf = new PessoaFisica("Ana Claudia", "11167-0", "0954253-11");
            em.persist(pf);

            pf = new PessoaFisica("Benjamin", "77867-0", "0984253-08");
            em.persist(pf);

            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
