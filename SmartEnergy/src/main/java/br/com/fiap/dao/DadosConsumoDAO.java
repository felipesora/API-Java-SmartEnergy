package br.com.fiap.dao;

import br.com.fiap.to.DadosConsumoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DadosConsumoDAO extends Repository{
    public ArrayList<DadosConsumoTO> listarTodos() {
        ArrayList<DadosConsumoTO> listarDadosConsumo = new ArrayList<DadosConsumoTO>();
        String sql = "select * from t_dados_consumo order by id_usuario";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    DadosConsumoTO dadosConsumoTO = new DadosConsumoTO();
                    dadosConsumoTO.setIdUsuario(rs.getInt("id_usuario"));
                    dadosConsumoTO.setIdConsumo(rs.getInt("id_consumo"));
                    dadosConsumoTO.setAnoConsumo(rs.getInt("ano_consumo"));
                    dadosConsumoTO.setMesConsumo(rs.getString("mes_consumo"));
                    dadosConsumoTO.setKwhConsumo(rs.getDouble("kwh_consumo"));
                    listarDadosConsumo.add(dadosConsumoTO);
                }
                return listarDadosConsumo;
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }

    public ArrayList<DadosConsumoTO> getById(int idUsuario) {
        ArrayList<DadosConsumoTO> listaDadosConsumo = new ArrayList<>();
        String sql = "SELECT * FROM t_dados_consumo WHERE id_usuario=? ORDER BY ano_consumo ASC, " +
                "CASE mes_consumo " +
                "WHEN 'Janeiro' THEN 1 " +
                "WHEN 'Fevereiro' THEN 2 " +
                "WHEN 'Março' THEN 3 " +
                "WHEN 'Abril' THEN 4 " +
                "WHEN 'Maio' THEN 5 " +
                "WHEN 'Junho' THEN 6 " +
                "WHEN 'Julho' THEN 7 " +
                "WHEN 'Agosto' THEN 8 " +
                "WHEN 'Setembro' THEN 9 " +
                "WHEN 'Outubro' THEN 10 " +
                "WHEN 'Novembro' THEN 11 " +
                "WHEN 'Dezembro' THEN 12 " +
                "END ASC"; // Ordenando primeiro por ano e depois por mês

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DadosConsumoTO dadosConsumoTO = new DadosConsumoTO();
                dadosConsumoTO.setIdUsuario(rs.getInt("id_usuario"));
                dadosConsumoTO.setIdConsumo(rs.getInt("id_consumo"));
                dadosConsumoTO.setAnoConsumo(rs.getInt("ano_consumo"));
                dadosConsumoTO.setMesConsumo(rs.getString("mes_consumo"));
                dadosConsumoTO.setKwhConsumo(rs.getDouble("kwh_consumo"));
                listaDadosConsumo.add(dadosConsumoTO);
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
        return listaDadosConsumo;
    }


    public DadosConsumoTO inserir(DadosConsumoTO dadosConsumoTO){
        String sql = "INSERT INTO t_dados_consumo (id_usuario, ano_consumo, mes_consumo, kwh_consumo) VALUES (?,?,?,?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, dadosConsumoTO.getIdUsuario());
            ps.setInt(2, dadosConsumoTO.getAnoConsumo());
            ps.setString(3, dadosConsumoTO.getMesConsumo());
            ps.setDouble(4, dadosConsumoTO.getKwhConsumo());
            if (ps.executeUpdate() > 0) {
                return dadosConsumoTO;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean excluir(int idCosumo){
        String sql = "delete from t_dados_consumo where id_consumo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, idCosumo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro de SQL ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

}
