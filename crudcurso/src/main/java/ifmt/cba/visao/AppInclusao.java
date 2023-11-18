package ifmt.cba.visao;
import javax.swing.JOptionPane;
import ifmt.cba.negocio.CursoNegocio;

public class AppInclusao {
    public static void main(String[] args){
        try{
            CursoNegocio cursoNegocio =  new CursoNegocio();
            String nome = JOptionPane.showInputDialog(null, "Forneca o nome do curso");
            int cargahoraria = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneca a carga horaria do curso"));
            int numsemestre = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneca o novo numero do semestres do curso"));
            cursoNegocio.incluir(nome, cargahoraria, numsemestre);
            JOptionPane.showMessageDialog(null,"Curso incluido com sucesso");
            cursoNegocio.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
