package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import connexion.Connexion;
import modele.*;

public class DepenseDAO {
    public void ajouterDepense(Depense depense) {
        try(Connection conn = Connexion.getConnection()) {
            String sql = "insert into ligneDeDepense (idCredit, depense) values (?,?)";
            try(PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, depense.getIdCredit());
                stmt.setDouble(2, depense.getDepense());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Vector<Depense> getAll() throws Exception{
        Vector<Depense> result = new Vector<>();
        try(Connection connexion = Connexion.getConnection()){
            String sql = "SELECT * from ligneDeDepense";
            LigneDeCreditDAO creditDAO = new LigneDeCreditDAO();
            try(Statement stmt = connexion.createStatement()){
                try(ResultSet rs = stmt.executeQuery(sql)){
                    while (rs.next()) {
                        LigneDeCredit credit = creditDAO.getById(rs.getInt(2));
                        result.add(new Depense(rs.getInt(1), rs.getInt(2), rs.getDouble(3), credit));
                    }
                }
            }
        }
        return result;
    }


    public Depense getById(int id) throws Exception {
        Depense result = null;
        String sql = "SELECT * from ligneDeDepense where id = ?";
        try (Connection conn = Connexion.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {   
                        result = new Depense(id, rs.getInt("idCredit"), rs.getDouble("depense"));
                    }
                }
            }
        }
        return result;
    }
}
