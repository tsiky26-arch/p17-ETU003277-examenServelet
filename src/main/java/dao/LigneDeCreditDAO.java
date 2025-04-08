package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import connexion.*;
import modele.*;

public class LigneDeCreditDAO {
    public void ajouterligneDeCredit(LigneDeCredit ligneDeCredit) {
        try(Connection conn = Connexion.getConnection()) {
            String sql = "insert into ligneDeCredit (libelle, montant) values (?,?)";
            try(PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, ligneDeCredit.getNom());
                stmt.setDouble(2, ligneDeCredit.getMontant());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public Vector<LigneDeCredit> getAll() throws Exception{
        Vector<LigneDeCredit> result = new Vector<>();
        try(Connection connexion = Connexion.getConnection()){
            String sql = "SELECT * from ligneDeCredit";
            try(Statement stmt = connexion.createStatement()){
                try(ResultSet rs = stmt.executeQuery(sql)){
                    while (rs.next()) {
                        result.add(new LigneDeCredit(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
                    }
                }
            }
        }
        return result;
    }

    public LigneDeCredit getById(int id) throws Exception {
        LigneDeCredit result = null;
        String sql = "SELECT * from ligneDeCredit where id = ?";
        try (Connection conn = Connexion.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {   
                        result = new LigneDeCredit(id, rs.getString("libelle"), rs.getDouble("montant"));
                    }
                }
            }
        }
        return result;
    }
}

