package ifmt.cba.vo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")
public class PessoaJuridica extends Pessoa {
    private String razaoSocial;

    public PessoaJuridica(){

    }

    public PessoaJuridica(String nome, String razaoSocial){
        super(nome);
        this.razaoSocial = razaoSocial; 
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    public String getNomeFantasia(){
        return nome;
    }

    public void setNomeFantasia(String nome){
        this.nome = nome;
    }

}
