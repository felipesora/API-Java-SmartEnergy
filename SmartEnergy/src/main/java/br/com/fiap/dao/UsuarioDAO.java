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

    public UsuarioTO inserir(UsuarioTO usuarioTO){
        String sql = "INSERT INTO t_usuario (nm_usuario, email_usuario, senha_usuario) VALUES (?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuarioTO.getNomeUsuario());
            ps.setString(2, usuarioTO.getEmailUsuario());
            ps.setString(3, usuarioTO.getSenhaUsuario());
            if (ps.executeUpdate() > 0) {
                return usuarioTO;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public UsuarioTO alterar(UsuarioTO usuarioTO){
        String sql = "update t_usuario set nm_usuario=?, email_usuario=?, senha_usuario=? where id_usuario=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setString(1, usuarioTO.getNomeUsuario());
            ps.setString(2, usuarioTO.getEmailUsuario());
            ps.setString(3, usuarioTO.getSenhaUsuario());
            ps.setInt(4, usuarioTO.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                return usuarioTO;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean excluir(int idUsuario) {
        String deleteConsumoSQL = "DELETE FROM t_dados_consumo WHERE id_usuario = ?";
        String deleteUsuarioSQL = "DELETE FROM t_usuario WHERE id_usuario = ?";

        try (PreparedStatement psConsumo = getConnection().prepareStatement(deleteConsumoSQL);
             PreparedStatement psUsuario = getConnection().prepareStatement(deleteUsuarioSQL)) {

            // Exclua os dados de consumo primeiro
            psConsumo.setInt(1, idUsuario);
            psConsumo.executeUpdate();

            // Em seguida, exclua o usuário
            psUsuario.setInt(1, idUsuario);
            return psUsuario.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro de SQL ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean emailExistente(String email) {
        String sql = "SELECT 1 FROM t_usuario WHERE email_usuario = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();  // Retorna true se encontrar o email
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar email: " + e.getMessage());
        }
        return false;
    }


}
