package cruds;

import java.sql.*;

public class CursoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public CursoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(String nomeCurso, String modalidades, int matrizCurricular, int turno, int instituicaoId) throws SQLException {
        String sql = "INSERT INTO Cursos (nome_curso, modalidades, matriz_curricular, turno, instituicao_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCurso);
            stmt.setString(2, modalidades);
            stmt.setInt(3, matrizCurricular);
            stmt.setInt(4, turno);
            stmt.setInt(5, instituicaoId);
            stmt.executeUpdate();
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM Cursos";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Curso: %s, Modalidade: %s, Matriz: %d, Turno: %d, Instituição ID: %d%n",
                        rs.getInt("id"),
                        rs.getString("nome_curso"),
                        rs.getString("modalidades"),
                        rs.getInt("matriz_curricular"),
                        rs.getInt("turno"),
                        rs.getInt("instituicao_id"));
            }
        }
    }

    public void atualizar(int id, String nomeCurso, String modalidades, int matrizCurricular, int turno, int instituicaoId) throws SQLException {
        String sql = "UPDATE Cursos SET nome_curso = ?, modalidades = ?, matriz_curricular = ?, turno = ?, instituicao_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeCurso);
            stmt.setString(2, modalidades);
            stmt.setInt(3, matrizCurricular);
            stmt.setInt(4, turno);
            stmt.setInt(5, instituicaoId);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Cursos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
