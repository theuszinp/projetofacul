package cruds;

import java.sql.*;

public class DesempenhoDAO {
    private Connection conn;

    public DesempenhoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(int alunoId, int disciplinaId, int notasGeral, int notas, int faltas) throws SQLException {
        String sql = "INSERT INTO Desempenho (aluno_id, disciplina_id, notas_geral, notas, faltas) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            stmt.setInt(2, disciplinaId);
            stmt.setInt(3, notasGeral);
            stmt.setInt(4, notas);
            stmt.setInt(5, faltas);
            stmt.executeUpdate();
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM Desempenho";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Aluno ID: %d, Disciplina ID: %d, Notas Geral: %d, Notas: %d, Faltas: %d%n",
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getInt("disciplina_id"),
                        rs.getInt("notas_geral"),
                        rs.getInt("notas"),
                        rs.getInt("faltas"));
            }
        }
    }

    public void atualizar(int id, int alunoId, int disciplinaId, int notasGeral, int notas, int faltas) throws SQLException {
        String sql = "UPDATE Desempenho SET aluno_id = ?, disciplina_id = ?, notas_geral = ?, notas = ?, faltas = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            stmt.setInt(2, disciplinaId);
            stmt.setInt(3, notasGeral);
            stmt.setInt(4, notas);
            stmt.setInt(5, faltas);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Desempenho WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
