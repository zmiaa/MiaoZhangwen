package prog2.model;
//ja que InAllotjament és una interfície que utilitza els mètodes d'Allotjament
public class Allotjament implements InAllotjament{
    private String nom;
    String ID;

    private long estadaMinimaBaixa;
    private long estadaMinimaAlta;

    public Allotjament (String nom, String ID, int estadaMinimaAlta, int estadaMinimaBaixa)
    {
        this.nom = nom;
        this.ID = ID;
        this.estadaMinimaAlta = estadaMinimaAlta;
        this.estadaMinimaBaixa = estadaMinimaBaixa;
    };

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    //setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    //getter
    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setId(String ID) {
        this.ID = ID;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        //si la temperatura és alta, llavors retorna el valor de l'estada mínima ALTA
        if(temp == InAllotjament.Temp.ALTA){
            return estadaMinimaAlta;
        }
        //si és baixa la temperatura retorna això
        return estadaMinimaBaixa;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        estadaMinimaAlta = estadaMinimaALTA_;
        estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    @Override
    public boolean correcteFuncionament() {
        return true;
        //si és correcte retorna true, en cas contrari false
    }

    public String toStringTestAllotjament(){
        return "Nom: " + nom + ", ID: " + ID + ", estada mínima en temp. ALTA: " + estadaMinimaAlta +
                ", estada mínima en temp. BAIXA: " + estadaMinimaBaixa + ".";
    }
}
