package ifmt.cba.vo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length = 40, nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.EAGER)
    private List <Venda> listaVenda;

    public Cliente(){

    }

    public Cliente(String nome){
        this.nome = nome;
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

    public List <Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(List <Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }
    
}
