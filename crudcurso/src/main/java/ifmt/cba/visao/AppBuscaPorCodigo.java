package ifmt.cba.visao;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ifmt.cba.negocio.CursoNegocio;

public class AppBuscaPorCodigo {
    public static void main(String[] args){
        try{
            CursoNegocio cursoNegocio = new CursoNegocio();
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser localizado"));
            ResultSet resultado = cursoNegocio.buscaPorCodigo(codigo);
            if(resultado.next()){
                System.out.println("Codigo: " + resultado.getInt("codigo"));
                System.out.println("Nome: " + resultado.getString("nome")); 
                System.out.println("Carga Horaria: " + resultado.getInt("cargahoraria"));
                System.out.println("Numero Semestre: " + resultado.getInt("numsemestre"));
                System.out.println("-------------------------------------------------------------------");
            }else{
                System.out.println("Nao localizado");
            }
            cursoNegocio.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
        
