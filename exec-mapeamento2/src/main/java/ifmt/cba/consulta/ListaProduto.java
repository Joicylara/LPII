package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
/*Listar todos os produtos cadastrados, ordenados por nome (código, nome, preço de venda, 
nome do grupo de produto e seus fornecedores (código e razão social)); */
public class ListaProduto {
    public static void main(String ard[]){
        try{
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createQuery("SELECT produto FROM Produto produto ORDER BY produto.nome");
            List<Produto> listaProduto= query.getResultList();
            
            for(Produto produto : listaProduto){
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("\t\tDados de produto");
                System.out.println("Codigo: " +produto.getCodigo());
                System.out.println("Nome: " +produto.getNome());
                System.out.println("Preco de venda: " +produto.getPrecoVenda());
                for(Fornecedor fornecedor : produto.getlListaFornecedor()){
                    System.out.println("\t\tDados do fornecedor");
                    System.out.println("Codigo: " +fornecedor.getCodigo());
                    System.out.println("Nome: " +fornecedor.getRazaoSocial());
                }
                
                if(produto.getGrupoProduto() != null){
                    System.out.println("\t\tDados do grupo de produto");
                    System.out.println("Codigo: " +produto.getGrupoProduto().getCodigo());
                    System.out.println("Nome: " +produto.getGrupoProduto().getNome());
                }
                System.out.println("--------------------------------------------------------------------------");
            }

            em.getTransaction().commit();
        
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
