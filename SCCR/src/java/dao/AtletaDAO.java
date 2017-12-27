package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;
import modelo.Atleta;

public class AtletaDAO {

    public static List<Atleta> obterAtletas() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Atleta> atletas = new ArrayList<Atleta>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atleta");
            while (rs.next()) {

                Atleta atleta = new Atleta(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("dtNascimento"), 
                        rs.getString("apelido"), 
                        rs.getString("cpf"),
                        rs.getString("tamCamisa"), 
                        rs.getString("sexo"), 
                        rs.getString("telefoneFixo"),
                        rs.getString("telefoneCelular"), 
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"), 
                        rs.getString("estado"), 
                        rs.getString("pais"), 
                        rs.getString("login"), 
                        rs.getString("senha"), 
                        rs.getString("email"));

                atletas.add(atleta);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);

        }
        return atletas;
    }

    private static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {

        }

    }

    public static void gravar(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // caso de herança tem qeu fazer para as duas classes .
            String sql = "insert into atleta(id,nome,dtNascimento,apelido,cpf,tamCamisa,sexo,telefoneFixo,telefoneCelular,rua,bairro,cidade,estado,pais,login,senha,email) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, atleta.getId());
            comando.setString(2, atleta.getNome());
            comando.setString(3, atleta.getDataNascimento());
            comando.setString(4, atleta.getApelido());

            comando.setString(5, atleta.getCpf());
            comando.setString(6, atleta.getTamCamisa());
            comando.setString(7, atleta.getSexo());
            comando.setString(8, atleta.getTelefoneFixo());
            comando.setString(9, atleta.getTelefoneCel());

            comando.setString(10, atleta.getRua());
            comando.setString(11, atleta.getBairro());
            comando.setString(12, atleta.getCidade());
            comando.setString(13, atleta.getEstado());
            comando.setString(14, atleta.getPais());

            comando.setString(15, atleta.getLogin());
            comando.setString(16, atleta.getSenha());
            comando.setString(17, atleta.getEmail());

            
            comando.execute();
            comando.close();
            conexao.close();

        } catch (SQLException e) {

            throw e;
        }

    }

    public static void alterar(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            // String sql= "update atleta set nome= ?,nomeEquipe =?,dtNascimento=?,apelido=?,cpf=?,TamCamisa=?where id = ?";
            String sql = "update atleta set nome=?,dtNascimento=?,apelido=?,cpf=?,TamCamisa=?,sexo=?,telefoneFixo=?,telefoneCelular=?,rua=?,bairro=?,cidade=?,estado=?,pais=?,login=?,senha=?,email=? where id =?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, atleta.getNome());
            comando.setString(2, atleta.getDataNascimento());
            comando.setString(3, atleta.getApelido());

            comando.setString(4, atleta.getCpf());
            comando.setString(5, atleta.getTamCamisa());
            comando.setString(6, atleta.getSexo());
            comando.setString(7, atleta.getTelefoneFixo());
            comando.setString(8, atleta.getTelefoneCel());

            comando.setString(9, atleta.getRua());
            comando.setString(10, atleta.getBairro());
            comando.setString(11, atleta.getCidade());
            comando.setString(12, atleta.getEstado());
            comando.setString(13, atleta.getPais());

            comando.setString(14, atleta.getLogin());
            comando.setString(15, atleta.getSenha());
            comando.setString(16, atleta.getEmail());
            comando.setInt(17, atleta.getId());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Atleta atleta) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from atleta where id ="
                    + atleta.getId();
            comando.execute(stringSQL);
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }

    }

    public static Atleta obterAtleta(int id) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Atleta atleta = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from atleta where id = " + id);
            rs.first();
            atleta = new Atleta(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("dtNascimento"), 
                    rs.getString("apelido"), 
                    rs.getString("cpf"),
                    rs.getString("tamCamisa"), 
                    rs.getString("sexo"), 
                    rs.getString("telefoneFixo"),
                    rs.getString("telefoneCelular"), 
                    rs.getString("rua"), 
                    rs.getString("bairro"),
                    rs.getString("cidade"), 
                    rs.getString("estado"), 
                    rs.getString("pais"), 
                    rs.getString("login"), 
                    rs.getString("senha"), 
                    rs.getString("email"));


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }

        return atleta;
    }

    public static Atleta logar(String login, String senha) throws ClassNotFoundException {
        Connection conexao = null;
        Atleta atleta = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            String sql = "SELECT * FROM atleta WHERE login = ? AND senha = ?";
            comando = conexao.prepareStatement(sql);
            comando.setString(1, login);
            comando.setString(2, senha);
            ResultSet rs = comando.executeQuery();
            if (rs.first()) {
                 atleta = new Atleta(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("dtNascimento"), 
                        rs.getString("apelido"), 
                        rs.getString("cpf"),
                        rs.getString("tamCamisa"), 
                        rs.getString("sexo"), 
                        rs.getString("telefoneFixo"),
                        rs.getString("telefoneCelular"), 
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"), 
                        rs.getString("estado"), 
                        rs.getString("pais"), 
                        rs.getString("login"), 
                        rs.getString("senha"), 
                        rs.getString("email"));
            }

            comando.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return atleta;
       }

}
