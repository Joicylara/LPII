package ifmt.cba;

import java.util.List;

import javax.swing.JOptionPane;

import ifmt.cba.negocio.CursoNegocio;
import ifmt.cba.negocio.NegocioException;

import ifmt.cba.vo.CursoVO;


public class App 
{
    private static CursoNegocio cursoNegocio;

    static{
        try{
            cursoNegocio = new CursoNegocio();
        }catch(NegocioException n){
            JOptionPane.showMessageDialog(null, n.getMessage());
        }
    }
    public static void main( String[] args ){
       int selecao;
       do{
            selecao = menu();
            switch(selecao){
                case 1:
                    processarInclusao();
                    break;
                case 2:
                    processarAlteracao();
                    break;
                case 3:
                    processarExclusao();
                    break;
                case 4:
                    SelecaoPorCodigo();
                    break;
                case 5:
                    SelecaoPorNome();
                    break;
                case 6:
                    ListarTodos();
                    break;                   
            }
       } 
       while(selecao != 7);
       try{
            cursoNegocio.desconectar();
       }catch(NegocioException n){
            JOptionPane.showMessageDialog(null,n.getMessage());
       }
       System.exit(0);
    }

    private static int menu(){
        int selecao = 0;
        String opcoes = "1-Incluir curso\n" + "2-Alterar curso\n" + "3-Excluir curso\n" + "4-Pesquisar curso por codigo\n" + "5-Pesquisar curso por nome\n" + "6-Listar todos os cursos\n" + "7-Sair";
        
        do{
            selecao = Integer.parseInt(JOptionPane.showInputDialog(opcoes));
            if(selecao < 1 || selecao > 7){
                JOptionPane.showMessageDialog(null, "Opcao invalida, repita a escolha");
            }
        }
        while(selecao < 1 || selecao > 7);
        return selecao;

    }

    private static void processarInclusao(){
        try{
            String nome = JOptionPane.showInputDialog("Forneca o nome do curso");
            int cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Forneca a carga horaria do curso"));
            int numSemestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o novo numero de semestres do curso"));
            CursoVO cursoVO = new CursoVO();
            cursoVO.setNome(nome);
            cursoVO.setCargaHoraria(cargaHoraria);
            cursoVO.setNumSemestre(numSemestre);
            cursoNegocio.incluir(cursoVO);
            JOptionPane.showMessageDialog(null, "Inclusao realizada com sucesso");
        }catch(NegocioException n){
            JOptionPane.showMessageDialog(null, n.getMessage());
        }
    }
    
    private static void processarAlteracao(){
        
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser alterado"));
            CursoVO cursoVO = cursoNegocio.buscaPorCodigo(codigo);
            if(cursoVO != null){
                String nome = cursoVO.getNome();
                nome = JOptionPane.showInputDialog("Forneca o novo nome do curso", nome);
                int cargaHoraria = cursoVO.getCargaHoraria();
                cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Forneca a nova carga horaria do curso", cargaHoraria));
                int numSemestre = cursoVO.getNumSemestre();
                numSemestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o novo numero do semestres do curso", numSemestre));
                cursoVO.setNome(nome);
                cursoVO.setCargaHoraria(cargaHoraria);
                cursoVO.setNumSemestre(numSemestre);
                cursoNegocio.alterar(cursoVO);
                JOptionPane.showMessageDialog(null," Alteracao do curso realizada com sucesso ");
            }else{
                JOptionPane.showMessageDialog(null," Curso nao localizado ");
            }
        }catch(NegocioException n){
            JOptionPane.showMessageDialog(null, n.getMessage());
        }
    }


    private static void processarExclusao(){
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser excluido"));
            CursoVO cursoVO = cursoNegocio.buscaPorCodigo(codigo);
            if(cursoVO != null){
                if(JOptionPane.showConfirmDialog(null,"Confirmar exclusao do curso " + cursoVO.getNome(), "Exclusao ", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
                    cursoNegocio.excluir(cursoVO.getCodigo());
                    JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
                }else{
                    JOptionPane.showMessageDialog(null, "Curso nao localizado");
                }
            }
        }catch(NegocioException n){
            JOptionPane.showMessageDialog(null, n.getMessage());
        }
    }

    private static void SelecaoPorCodigo(){
        try{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser localizado"));
            CursoVO cursoVO = cursoNegocio.buscaPorCodigo(codigo);
            if(cursoVO != null){
                System.out.println("Codigo: " +cursoVO.getCodigo());
                System.out.println("Nome: " +cursoVO.getNome());
                System.out.println("Carga Horaria: " +cursoVO.getCargaHoraria());
                System.out.println("Numero de semestres: " +cursoVO.getNumSemestre());
                System.out.println("---------------------------------------------------------");
            }else{
                System.out.println("Nao localizado");
            }
        }catch(NegocioException n){
            System.out.println(n.getMessage());
        }
    }

    private static void SelecaoPorNome(){
        try{
            String nome = JOptionPane.showInputDialog("Forneca o nome do curso a ser localizado");
            List<CursoVO> listaCurso = cursoNegocio.buscaPorNome(nome);
            if(listaCurso.size() > 0){
                for(CursoVO cursoVO : listaCurso){
                    System.out.println("Codigo: " +cursoVO.getCodigo());
                    System.out.println("Nome: " +cursoVO.getNome());
                    System.out.println("Carga Horaria: " +cursoVO.getCargaHoraria());
                    System.out.println("Numero de semestres: " +cursoVO.getNumSemestre());
                    System.out.println("---------------------------------------------------------");
                }
            }else{
                System.out.println("Curso nao localizado");
            }
        }catch(NegocioException n){
            System.out.println(n.getMessage());
            
        }
    }

    private static void ListarTodos(){
        try{
            List<CursoVO> listaCurso = cursoNegocio.buscaTodos();
            if(listaCurso.size() > 0){
                for(CursoVO cursoVO : listaCurso){
                    System.out.println("Codigo: " +cursoVO.getCodigo());
                    System.out.println("Nome: " +cursoVO.getNome());
                    System.out.println("Carga Horaria: " +cursoVO.getCargaHoraria());
                    System.out.println("Numero de semestres: " +cursoVO.getNumSemestre());
                    System.out.println("---------------------------------------------------------");
                }
            }else{
                System.out.println("Nao localizado");
            }
        }catch(NegocioException n){
            System.out.println(n.getMessage());
        }
    }
}
