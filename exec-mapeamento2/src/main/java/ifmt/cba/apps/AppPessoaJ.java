package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;

public class AppPessoaJ {
    public static void main(String arg[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //instancia e persistencia de pessoa juridica
            PessoaJuridica pj = new PessoaJuridica("Buzz Lightyear", "sadia", "34546728-98");
            em.persist(pj);

            pj = new PessoaJuridica("Woody Botas", "Perdigao", "8394758392-93");
            em.persist(pj);

            pj = new PessoaJuridica("Andy Brinquedos ", "Coca-Cola", "3637638492-01");
            em.persist(pj);

            pj = new PessoaJuridica("Cabeleleila Leila", "Amazon", "625364284-06");
            em.persist(pj);

            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
