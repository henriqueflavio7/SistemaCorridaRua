package modelo;

import dao.AdministradorDAO;
import java.sql.SQLException;
import java.util.*;

public class Administrador extends Usuario {

    //Variaveis do banco de dados
    private int id;

    public Administrador(int id, String nome, String senha, String login, String email) {
        super(nome, senha, login, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static List<Administrador> obterAdministrador()
            throws ClassNotFoundException {
        return AdministradorDAO.obterAdministradores();
    }

    public void gravar() throws SQLException, ClassNotFoundException {

        AdministradorDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.alterar(this);

    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AdministradorDAO.excluir(this);
    }

    public static Administrador obterAdministrador(int id) throws ClassNotFoundException, SQLException {
        return AdministradorDAO.obterAdministrador(id);
    }
}
