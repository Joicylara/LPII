package ifmt.cba.consulta;

import java.text.SimpleDateFormat;
import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class ListaVenda {
 
/*Listar todas as vendas cadastradas, ordenadas por data da venda (código, data da venda, 
valor total da venda) e seus itens (código, quantidade, preço venda, percentual de desconto) */
    public static void main (String[]args){

        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Query query = em.createQuery("SELECT venda FROM Venda venda ORDER BY venda.dataVenda");
            List<Venda> listaVenda = query.getResultList();
            for (Venda venda : listaVenda ){
                System.out.println("\nCodigoVenda: "+venda.getCodigo());
                System.out.println("Data Venda: "+(formatter.format(venda.getDataVenda().getTime())));
                System.out.println("Total da venda: "+venda.totalVenda());
                
                for (ItemVenda itemVenda : venda.getListaItemVenda()){
                    System.out.println("\nItens da venda");
                    System.out.println("Codigo Venda: "+itemVenda.getCodigo());
                    System.out.println("Quantidade: "+itemVenda.getQuantidade());
                    System.out.println("Preço: "+itemVenda.getPrecoVenda());
                    System.out.println("Desconto: "+itemVenda.getPerDesconto());
                }
                System.out.println("---------------------------------");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
