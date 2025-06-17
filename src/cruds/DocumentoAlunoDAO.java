package cruds;

import java.sql.*;

public class DocumentoAlunoDAO {
    private Connection conn;

    // Construtor
    public DocumentoAlunoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(int alunoId, String comprovanteMatricula, int modalidadeIngresso, String comprovanteResidencia, String assinaturaContratoEstagio, String atestados, String requerimentos) throws SQLException {
        String sql = "INSERT INTO Documentos_Aluno (aluno_id, comprovante_matricula, modalidade_ingresso, comprovante_residencia, assinatura_contrato_estagio, atestados, requerimentos) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            stmt.setString(2, comprovanteMatricula);
            stmt.setInt(3, modalidadeIngresso);
            stmt.setString(4, comprovanteResidencia);
            stmt.setString(5, assinaturaContratoEstagio);
            stmt.setString(6, atestados);
            stmt.setString(7, requerimentos);
            stmt.executeUpdate();
        }
    }

    public void listar() throws SQLException {
        String sql = "SELECT * FROM Documentos_Aluno";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.printf("ID: %d, Aluno ID: %d, Comprovante Matricula: %s, Modalidade Ingresso: %d, Comprovante Residencia: %s, Assinatura Contrato: %s, Atestados: %s, Requerimentos: %s%n",
                        rs.getInt("id"),
                        rs.getInt("aluno_id"),
                        rs.getString("comprovante_matricula"),
                        rs.getInt("modalidade_ingresso"),
                        rs.getString("comprovante_residencia"),
                        rs.getString("assinatura_contrato_estagio"),
                        rs.getString("atestados"),
                        rs.getString("requerimentos"));
            }
        }
    }

    public void atualizar(int id, int alunoId, String comprovanteMatricula, int modalidadeIngresso, String comprovanteResidencia, String assinaturaContratoEstagio, String atestados, String requerimentos) throws SQLException {
        String sql = "UPDATE Documentos_Aluno SET aluno_id = ?, comprovante_matricula = ?, modalidade_ingresso = ?, comprovante_residencia = ?, assinatura_contrato_estagio = ?, atestados = ?, requerimentos = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, alunoId);
            stmt.setString(2, comprovanteMatricula);
            stmt.setInt(3, modalidadeIngresso);
            stmt.setString(4, comprovanteResidencia);
            stmt.setString(5, assinaturaContratoEstagio);
            stmt.setString(6, atestados);
            stmt.setString(7, requerimentos);
            stmt.setInt(8, id);
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM Documentos_Aluno WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
