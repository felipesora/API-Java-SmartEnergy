package br.com.fiap.dao;


import br.com.fiap.to.SugestoesTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SugestoesDAO extends Repository{
    public ArrayList<SugestoesTO> listarTodas() {
        ArrayList<SugestoesTO> listarSugestoes = new ArrayList<SugestoesTO>();
        String sql = "select * from t_sugestoes order by id_sugestao";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()){
                    SugestoesTO sugestoesTO = new SugestoesTO();
                    sugestoesTO.setIdSugestao(rs.getInt("id_sugestao"));
                    sugestoesTO.setTemaSugestao(rs.getString("tema_sugestao"));
                    sugestoesTO.setDsSugestao(rs.getString("ds_sugestao"));
                    listarSugestoes.add(sugestoesTO);
                }
                return listarSugestoes;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }

    public SugestoesTO getById(int idSugestao){
        SugestoesTO sugestoesTO = new SugestoesTO();
        String sql = "select * from t_sugestoes where id_sugestao=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)){
            ps.setInt(1, idSugestao);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sugestoesTO.setIdSugestao(rs.getInt("id_sugestao"));
                sugestoesTO.setTemaSugestao(rs.getString("tema_sugestao"));
                sugestoesTO.setDsSugestao(rs.getString("ds_sugestao"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        } finally {
            closeConnection();
        }
        return sugestoesTO;
    }
}
