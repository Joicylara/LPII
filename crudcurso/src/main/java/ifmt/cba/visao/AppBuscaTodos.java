package ifmt.cba.visao;

import java.sql.ResultSet;

import ifmt.cba.negocio.CursoNegocio;

public class AppBuscaTodos {
    public static void main(String[] args){
        try{
            CursoNegocio cursoNegocio = new CursoNegocio();
            ResultSet resultado = cursoNegocio.buscaTodos();
            while(resultado.next()){
                System.out.println("Codigo: " + resultado.getInt("codigo"));
                System.out.println("Nome: " + resultado.getString("nome")); 
                System.out.println("Carga Horaria: " + resultado.getInt("cargahoraria"));
                System.out.println("Numero Semestre: " + resultado.getInt("numsemestre"));
                System.out.println("-------------------------------------------------------------------");
            }
            cursoNegocio.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
