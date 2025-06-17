package cruds;

import java.sql.*;

public class InstituicaoDAO {
    private Connection conn;

    public InstituicaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(String faculdade, String endereco, String cep, String cnpj) throws SQLException {
        String sql = "INSERT INTO Instituicao (faculdade, endereco, cep, cnpj) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, faculdade);
            stmt.setString(2, endereco);
            stmt.setString(3, cep);
            stmt.setString(4, cnpj);
            stmt.executeUpdate();
        }
    }
 
    public void listar() throws SQLException {
        String sql = "SELECT * FROM Instituicao;";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Faculdade: %s, Endereço: %s, CEP: %s, CNPJ: %s%n",
                        rs.getInt("id"),
                        rs.getString("faculdade"),
                        rs.getString("endereco"),
                        rs.getString("cep"),
                        rs.getString("cnpj"));
            }
        }
    }

    public void atualizar(int id, String faculdade, String endereco, String cep, String cnpj) throws SQLException {
        String sql = "UPDATE Instituicao SET faculdade = ?, endereco = ?, cep = ?, cnpj = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, faculdade);
            stmt.setString(2, endereco);
            stmt.setString(3, cep);
            stmt.setString(4, cnpj);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Instituicao WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // CONSULTA COM JOIN
    public void listarComCursos() throws SQLException {
        String sql = "SELECT i.faculdade, c.nome AS curso FROM Instituicao i JOIN Cursos c ON i.id = c.instituicao_id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Faculdade: %s | Curso: %s%n",
                        rs.getString("faculdade"),
                        rs.getString("curso"));
            }
        }
    }

    public void listarViewSimples() throws SQLException {
        String sql = "SELECT * FROM vw_faculdades_cursos";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("Faculdade: %s | Curso: %s%n",
                        rs.getString("faculdade"),
                        rs.getString("nome_curso"));
            }
        }
    }
    




    }
 