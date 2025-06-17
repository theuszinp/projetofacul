package cruds;

import java.sql.*;

public class QuadroHorarioDAO {

    private Connection conn;

    // Construtor que recebe a conexão
    public QuadroHorarioDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir novo quadro de horários
    public void inserir(String horarios, String dias) throws SQLException {
        String sql = "INSERT INTO Quadro_Horarios (horarios, dias) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horarios);
            stmt.setString(2, dias);
            stmt.executeUpdate();
        }
    }

    // Listar todos os quadros de horários
    public void listar() throws SQLException {
        String sql = "SELECT * FROM Quadro_Horarios";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Horários: %s, Dias: %s%n",
                        rs.getInt("id"),
                        rs.getString("horarios"),
                        rs.getString("dias"));
            }
        }
    }

    // Atualizar quadro de horários pelo ID
    public void atualizar(int id, String horarios, String dias) throws SQLException {
        String sql = "UPDATE Quadro_Horarios SET horarios = ?, dias = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, horarios);
            stmt.setString(2, dias);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    // Deletar quadro de horários pelo ID
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Quadro_Horarios WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
