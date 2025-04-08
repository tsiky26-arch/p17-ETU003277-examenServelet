package modele;

public class Depense {
    private int id;
    private int idCredit;
    private double depense;
    private LigneDeCredit credit;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



    public void setIdCredit(int idCredit) {
        this.idCredit = idCredit;
    }

    public int getIdCredit() {
        return idCredit;
    }



    public void setDepense(double depense) {
        this.depense = depense;
    }

    public double getDepense() {
        return depense;
    }


    public void setCredit(LigneDeCredit credit) {
        this.credit = credit;
    }

    public LigneDeCredit getCredit() {
        return credit;
    }



    public Depense(int id, int idCredit, double depense, LigneDeCredit credit) {
        this.id = id;
        this.idCredit = idCredit;
        this.depense = depense;
        this.credit = credit;
    }


    public Depense(int id, int idCredit, double depense) {
        this.id = id;
        this.idCredit = idCredit;
        this.depense = depense;
    }

    public Depense(int idCredit, double depense) {
        this.idCredit = idCredit;
        this.depense = depense;
    }
}
