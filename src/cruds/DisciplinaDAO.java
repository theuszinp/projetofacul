package cruds;

import java.sql.*;

/**
 * Classe responsável por operações CRUD e consultas relacionadas à tabela Disciplinas.
 */
public class DisciplinaDAO {
    private Connection conn;

    /**
     * Construtor que recebe a conexão com o banco de dados.
     * @param conn conexão ativa com o banco.
     */
    public DisciplinaDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Insere uma nova disciplina no banco de dados.
     */
    public void inserir(String nomeDisciplina, String sala, int cursoId, int cargaHoraria, int turno, int vagas, String ementa, int professorId, int horarioId) throws SQLException {
        String sql = "INSERT INTO Disciplinas (nome_disciplina, sala, curso_id, carga_horaria, turno, vagas, ementa, professor_id, horario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeDisciplina);
            stmt.setString(2, sala);
            stmt.setInt(3, cursoId);
            stmt.setInt(4, cargaHoraria);
            stmt.setInt(5, turno);
            stmt.setInt(6, vagas);
            stmt.setString(7, ementa);
            stmt.setInt(8, professorId);
            stmt.setInt(9, horarioId);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todas as disciplinas da tabela Disciplinas.
     */
    public void listar() throws SQLException {
        String sql = "SELECT * FROM Disciplinas";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, Sala: %s, Curso ID: %d, Carga: %d, Turno: %d, Vagas: %d, Ementa: %s, Professor ID: %d, Horario ID: %d%n",
                        rs.getInt("id"),
                        rs.getString("nome_disciplina"),
                        rs.getString("sala"),
                        rs.getInt("curso_id"),
                        rs.getInt("carga_horaria"),
                        rs.getInt("turno"),
                        rs.getInt("vagas"),
                        rs.getString("ementa"),
                        rs.getInt("professor_id"),
                        rs.getInt("horario_id"));
            }
        }
    }

    /**
     * Atualiza os dados de uma disciplina pelo ID.
     */
    public void atualizar(int id, String nomeDisciplina, String sala, int cursoId, int cargaHoraria, int turno, int vagas, String ementa, int professorId, int horarioId) throws SQLException {
        String sql = "UPDATE Disciplinas SET nome_disciplina = ?, sala = ?, curso_id = ?, carga_horaria = ?, turno = ?, vagas = ?, ementa = ?, professor_id = ?, horario_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeDisciplina);
            stmt.setString(2, sala);
            stmt.setInt(3, cursoId);
            stmt.setInt(4, cargaHoraria);
            stmt.setInt(5, turno);
            stmt.setInt(6, vagas);
            stmt.setString(7, ementa);
            stmt.setInt(8, professorId);
            stmt.setInt(9, horarioId);
            stmt.setInt(10, id);
            stmt.executeUpdate();
        }
    }

    /**
     * Exclui uma disciplina do banco pelo ID.
     */
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Disciplinas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    /**
     * view
     */
    public void listarViewDisciplinasInfo() throws SQLException {
        String sql = "SELECT * FROM vw_disciplinas_info";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf(
                    "ID: %d, Nome: %s, Sala: %s, Curso: %s, Professor: %s, Horários: %s, Dias: %s, Carga Horária: %d, Turno: %d, Vagas: %d, Ementa: %s%n",
                    rs.getInt("disciplina_id"),
                    rs.getString("nome_disciplina"),
                    rs.getString("sala"),
                    rs.getString("nome_curso"),
                    rs.getString("nome_professor"),
                    rs.getString("horarios"),
                    rs.getString("dias"),
                    rs.getInt("carga_horaria"),
                    rs.getInt("turno"),
                    rs.getInt("vagas"),
                    rs.getString("ementa")
                );
            }
        }
    }

    /**
     * fuction.
     */
    public int contarDisciplinasPorProfessor(int professorId) throws SQLException {
        String sql = "SELECT contar_disciplinas_por_professor(?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, professorId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }

    /* procedure */
    public void atualizarNomeDisciplinaViaProcedure(int id, String novoNome) throws SQLException {
        String sql = "{CALL atualizar_nome_disciplina(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, novoNome);
            stmt.execute();
        }
    }
    
}
