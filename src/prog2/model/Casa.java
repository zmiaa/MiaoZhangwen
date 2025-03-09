package prog2.model;

import java.time.LocalDate;

public class Casa extends Allotjament {
    private String nom;
    String ID;
    private int diaEntrada;
    private int diaSortida;
    int numHabitacions;
    String mida;
    int capacitatPersones;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;

    //cridem el constructor de Allotjament
    Casa(){
        super("nom casa", "ID casa", 0, 0);
    }
    //Constructor
    Casa(String nom, String ID, int diaEntrada, int diaSortida, int numHabitacions, String mida, int capacitatPersones) {
        super( nom, ID, diaEntrada, diaSortida);
        this.numHabitacions = numHabitacions;
        this.mida = mida;
        this.capacitatPersones = capacitatPersones;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

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
        if(temp == Temp.ALTA){
            return estadaMinimaALTA;
        }else if(temp == Temp.BAIXA){
            return estadaMinimaBAIXA;
        }else{
            return 0; //valor per defecte si no està definit.
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    @Override
    public boolean correcteFuncionament() {
        return true;
    }
    public String toStringTestCasa() {
        return "nom: " + nom + ", ID: " + ID + ", numHabitacions=" + numHabitacions +
                ", mida: " + mida +
                ", capacitatPersones: " + capacitatPersones +
                ", dataEntrada: " + dataEntrada +
                ", dataSortida: " + dataSortida +
                ", estadaMinimaALTA: " + estadaMinimaALTA +
                ", estadaMinimaBAIXA: " + estadaMinimaBAIXA + ".";
    }

}
