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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length = 40, nullable = false)
    private String nome;
    //para definir a quantidade de numeros
    @Column(precision = 6)
    private float precoVenda;

    @ManyToOne(fetch = FetchType.EAGER)
    private GrupoProduto grupoProduto;

    @ManyToMany(fetch = FetchType.EAGER)
    private List <Fornecedor> listaFornecedor;

    public Produto(){

    }

    public Produto(String nome, float precoVenda){
        this.nome = nome;
        this.precoVenda = precoVenda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public List <Fornecedor> getlListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List <Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

}
