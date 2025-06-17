package cruds;

import java.sql.*;

public class ProfessorDAO {

    private Connection conn;

    // Construtor que recebe a conexão
    public ProfessorDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir professor
    public void inserir(String nome, String emailInstitucional) throws SQLException {
        String sql = "INSERT INTO Professores (nome, email_institucional) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, emailInstitucional);
            stmt.executeUpdate();
        }
    }

    // Listar todos os professores
    public void listar() throws SQLException {
        String sql = "SELECT * FROM Professores";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, Email Institucional: %s%n",
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email_institucional"));
            }
        }
    }

    // Atualizar professor pelo id
    public void atualizar(int id, String nome, String emailInstitucional) throws SQLException {
        String sql = "UPDATE Professores SET nome = ?, email_institucional = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, emailInstitucional);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    // Deletar professor pelo id
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Professores WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
