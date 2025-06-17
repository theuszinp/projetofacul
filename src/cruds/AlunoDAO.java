package cruds;

import java.sql.*;

public class AlunoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public AlunoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(String nome, String cpf, int historicoEscolar, String endereco, String email, String telefone, String cep, String emailInstitucional, int cursoId) throws SQLException {
        String sql = "INSERT INTO Alunos (nome, cpf, historico_escolar, endereco, email, telefone, cep, email_institucional, curso_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setInt(3, historicoEscolar);
            stmt.setString(4, endereco);
            stmt.setString(5, email);
            stmt.setString(6, telefone);
            stmt.setString(7, cep);
            stmt.setString(8, emailInstitucional);
            stmt.setInt(9, cursoId);
            stmt.executeUpdate();
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM Alunos";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nome: %s, CPF: %s, Histórico: %d, Endereço: %s, Email: %s, Telefone: %s, CEP: %s, Email Inst.: %s, Curso ID: %d%n",
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getInt("historico_escolar"),
                        rs.getString("endereco"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("cep"),
                        rs.getString("email_institucional"),
                        rs.getInt("curso_id"));
            }
        }
    }

    public void atualizar(int id, String nome, String cpf, int historicoEscolar, String endereco, String email, String telefone, String cep, String emailInstitucional, int cursoId) throws SQLException {
        String sql = "UPDATE Alunos SET nome = ?, cpf = ?, historico_escolar = ?, endereco = ?, email = ?, telefone = ?, cep = ?, email_institucional = ?, curso_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setInt(3, historicoEscolar);
            stmt.setString(4, endereco);
            stmt.setString(5, email);
            stmt.setString(6, telefone);
            stmt.setString(7, cep);
            stmt.setString(8, emailInstitucional);
            stmt.setInt(9, cursoId);
            stmt.setInt(10, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Alunos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
