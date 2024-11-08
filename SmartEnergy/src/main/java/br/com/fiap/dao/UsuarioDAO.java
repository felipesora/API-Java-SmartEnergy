package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository {
    public ArrayList<UsuarioTO> listarTodos() {
        ArrayList<UsuarioTO> listarUsuarios = new ArrayList<UsuarioTO>();
        String sql = "select * from t_usuario order by id_usuario";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    UsuarioTO usuarioTO = new UsuarioTO();
                    usuarioTO.setIdUsuario(rs.getInt("id_usuario"));
                    usuarioTO.setNomeUsuario(rs.getString("nm_usuario"));
                    usuarioTO.setEmailUsuario(rs.getString("email_usuario"));
                    usuarioTO.setSenhaUsuario(rs.getString("senha_usuario"));
                    listarUsuarios.add(usuarioTO);
                }
                return listarUsuarios;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }

    public UsuarioTO getById(int idUsuario){
        UsuarioTO usuarioTO = new UsuarioTO();
        String sql = "select * from t_usuario where id_usuario=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuarioTO.setIdUsuario(rs.getInt("id_usuario"));
                usuarioTO.setNomeUsuario(rs.getString("nm_usuario"));
                usuarioTO.setEmailUsuario(rs.getString("email_usuario"));
                usuarioTO.setSenhaUsuario(rs.getString("senha_usuario"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
        return usuarioTO;
    }

}
