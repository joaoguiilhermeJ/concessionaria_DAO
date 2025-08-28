import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoDao {
    private String url = "jdbc:postgresql://localhost:5432/loja_de_motos";  
    private String usuario = "seu_usuario";  
    private String senha = "sua_senha";  

    public MotoDao() {
        try {
            Class.forName("org.postgresql.Driver");  
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public void inserirMoto(Moto moto) {
        String sql = "INSERT INTO motos (nome, ano, preco) VALUES (?, ?, ?)";
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, moto.getNome());
            stmt.setInt(2, moto.getAno());
            stmt.setDouble(3, moto.getPreco());

            stmt.executeUpdate();
            System.out.println("Moto inserida");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir moto: " + e.getMessage());
        }
    }

    public List<Moto> buscarMotos() {
        List<Moto> motos = new ArrayList<>();
        String sql = "SELECT * FROM motos";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Moto moto = new Moto(rs.getString("nome"), rs.getInt("ano"), rs.getDouble("preco"));
                moto.setId(rs.getInt("id"));
                motos.add(moto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar motos: " + e.getMessage());
        }

        return motos;
    }

    public void atualizarPrecoMoto(int id, double novoPreco) {
        String sql = "UPDATE motos SET preco = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, novoPreco);
            stmt.setInt(2, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Preço da moto atualizado");
            } else {
                System.out.println("Moto não encontrada");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar preço: " + e.getMessage());
        }
    }

    public void deletarMoto(int id) {
        String sql = "DELETE FROM motos WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Moto deletada ");
            } else {
                System.out.println("Moto não encontrada");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar moto: " + e.getMessage());
        }
    }

    public double calcularPrecoMedio() {
        String sql = "SELECT AVG(preco) AS media_preco FROM motos";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getDouble("media_preco");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao calcular preço médio: " + e.getMessage());
        }

        return 0.0;
    }

    public int contarMotos() {
        String sql = "SELECT COUNT(*) AS total_motos FROM motos";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total_motos");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao contar motos: " + e.getMessage());
        }

        return 0;
    }
}
