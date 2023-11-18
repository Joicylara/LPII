package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class ListaCliente {
    public static void main(String ard[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createQuery("SELECT cliente FROM Cliente cliente ORDER BY cliente.nome");
            List <Cliente> listaCliente = query.getResultList();
            for(Cliente cliente : listaCliente){
                System.out.println("---------------------------------------------------------");
                System.out.println("Lista de cliente");
                System.out.println("Codigo: " +cliente.getCodigo());
                System.out.println("Nome: " +cliente.getNome());
                System.out.println("Quantidade: " +cliente.getListaVenda().size());
                System.out.println("---------------------------------------------------------");
            }
       
            em.getTransaction().commit();
        }catch(Exception ex){
        System.out.println(ex.toString());
        }
    }    
}
