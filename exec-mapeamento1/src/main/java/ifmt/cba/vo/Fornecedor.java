package ifmt.cba.vo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length = 40, nullable = false)
    private String razaoSocial;

    @ManyToMany(fetch = FetchType.EAGER)
    private List <Produto> listaProduto;

    public Fornecedor(){

    }

    public Fornecedor(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public List <Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List <Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public String toString(){
        return razaoSocial;
    }
}
