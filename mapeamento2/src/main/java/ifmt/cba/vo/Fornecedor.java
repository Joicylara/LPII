package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;


@Entity

@DiscriminatorValue("fornecedor")
public class Fornecedor extends PessoaJuridica{
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List <Produto> listaProduto;

    public Fornecedor(){

    }

    public Fornecedor(String nome, String razaoSocial){
        super(nome, razaoSocial);
    }

    public List <Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List <Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

}
