import cruds.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = ConexaoBanco.conectar()) {
            System.out.println(" Conectado ao banco!");

            // Instancia
            InstituicaoDAO instituicaoDAO = new InstituicaoDAO(conn);
            CursoDAO cursoDAO = new CursoDAO(conn);
            AlunoDAO alunoDAO = new AlunoDAO(conn);
            ProfessorDAO professorDAO = new ProfessorDAO(conn);
            QuadroHorarioDAO quadroHorarioDAO = new QuadroHorarioDAO(conn);
            DesempenhoDAO desempenhoDAO = new DesempenhoDAO(conn);
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO(conn);

            //  INSTITUIÇÃO
            //instituicaoDAO.inserir("Professora", "Av. Principal, 100", "12345-678", "12345678900001");
            //instituicaoDAO.listar();
            instituicaoDAO.atualizar(6, "ESCOLA", "Imbui", "41630-20", "11122233300001");
            //instituicaoDAO.deletar(7);

            //  CURSO
            //cursoDAO.inserir("Engenharia de Software", "Presencial", 2023, 1, 5);
            //cursoDAO.listar();
            //cursoDAO.atualizar(2, "Engenharia de Software", "Presencial", 2029, 2, 5);
            //cursoDAO.deletar(2);

            //  ALUNO
            //alunoDAO.inserir("João Silva", "12345678900", 1, "Rua A, 123", "joao@email.com", "999999999", "er12345000", "joao.institucional@uni.com", 2);
            //System.out.println("Aluno inserido.");
            //alunoDAO.listar();
            //alunoDAO.atualizar(4, "Matheus Souza Dantas", "12345678944", 1, "Rua B, 456", "Matheus@email.com", "988888888", "12345000", "Matheus.institucional@uni.com", 2);
            //alunoDAO.deletar(1);

            //  DISCIPLINA
            //disciplinaDAO.inserir("Matemática", "Sala 101", 2, 60, 1, 30, "Ementa", 1, 1);
            //disciplinaDAO.listar();
            //disciplinaDAO.atualizar(1, "Matemática Avançada", "Sala 102", 2, 60, 2, 25, "Nova ementa", 5, 3);
            
            //disciplinaDAO.deletar(2);
            
            
            //disciplinaDAO.listarViewDisciplinasInfo();
            
            
            //int totalDisciplinas = disciplinaDAO.contarDisciplinasPorProfessor(1);  //fuction// 
            //System.out.println("Total de disciplinas do professor : " + totalDisciplinas);


           //disciplinaDAO.atualizarNomeDisciplinaViaProcedure(3, "Matematica");
            //System.out.println("Nome da disciplina atualizado via procedure com sucesso!");



            //  DESEMPENHO
            //desempenhoDAO.inserir(4, 2, 85, 90, 3); // aluno_id, disciplina_id, notas, notas_geral, faltas
            //System.out.println("Inserção de desempenho realizada.");
            //desempenhoDAO.listar();
            //desempenhoDAO.atualizar(1, 1, 2, 88, 92, 2);
            //desempenhoDAO.deletar(2);


            //  PROFESSOR
            //professorDAO.inserir("João Pereira", "joao.pereira@uni.edu");
            //professorDAO.listar();

            //professorDAO.atualizar(id, nome, emailInstitucional);
            
           // professorDAO.deletar(id);

            //  QUADRO DE HORÁRIO
            //quadroHorarioDAO.inserir("08:00-10:00", "Segunda, Quarta");
            //quadroHorarioDAO.inserir("10:00-12:00", "Terça, Quinta");
            //System.out.println(" Inserções de horários realizadas!");

            //quadroHorarioDAO.listar();
            //System.out.println(" Listagem dos quadros de horários:");

            //quadroHorarioDAO.atualizar(1, "18:00-22:00", "Terça");
            //System.out.println(" Quadro de horário com ID 1 atualizado.");

            //quadroHorarioDAO.deletar(2);
            //System.out.println(" Quadro de horário com ID 2 deletado.");

        } catch (SQLException e) {
            System.err.println(" Erro ao conectar ou operar no banco: " + e.getMessage());
        }
    }
}
