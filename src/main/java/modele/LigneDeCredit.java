package modele;

public class LigneDeCredit {
    private int id;
    private String nom;
    private double montant;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontant() {
        return montant;
    }


    public LigneDeCredit(String nom, double montant) {
        this.nom = nom;
        this.montant = montant;
    }

    public LigneDeCredit(int id, String nom, double montant) {
        this.nom = nom;
        this.id = id;
        this.montant = montant;
    }
}

