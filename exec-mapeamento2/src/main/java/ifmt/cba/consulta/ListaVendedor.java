package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class ListaVendedor {

/*Listar todos os vendedores cadastrados, ordenados por nome (código, nome, valor de 
comissão de cada venda que ele realizou (código da venda, valor total da venda, valor 
comissão na venda)) */
    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT vendedor FROM Vendedor vendedor ORDER BY vendedor.nome");
            List<Vendedor> listaVenda = query.getResultList();

            for (Vendedor vendedor : listaVenda ){
                System.out.println("Dados do Vendedor");
                 System.out.println("Codigo: "+vendedor.getCodigo());
                 System.out.println("Nome: "+vendedor.getNome());
                 System.out.println("Percentual de comissao: "+vendedor.getPerComissao());
                 for(Venda venda : vendedor.getListaVenda()){
                    System.out.println("Codigo da venda: "+venda.getCodigo());
                    System.out.println("Valor total da venda: "+venda.totalVenda());
                    System.out.println("Valor comissao na venda: " +vendedor.totalVendedor());
                 }
                 System.out.println("---------------------------------");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
