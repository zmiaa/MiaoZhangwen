package prog2.model;

public class Glamping extends Casa{
    private String material;
    private boolean casaMascota;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    //crida al constructor de casa
    Glamping(){
        super();
    }
    Glamping(String nom, String ID, String mida, int numHabitacions,
             int capacitatPersones, String material, boolean casaMascota){
        super.setNom(nom);
        super.ID = ID;
        super.mida = mida;
        super.numHabitacions = numHabitacions;
        super.capacitatPersones = capacitatPersones;
        this.material = material;
        this.casaMascota = casaMascota;
        estadaMinimaAlta = 5;
        estadaMinimaBaixa = 3;
    }
    public String toString() {
        String s = "Nom: " + getNom() + ", ID: " + ID + ", mida: " + mida +
                ", numero habitacions: " + numHabitacions +
                ", capacitat persones: " + capacitatPersones + ", material: " + material + ", casa mascota: " + casaMascota;
        return s;
    }
    @Override
    public String getNom(){
        return super.getNom();
    }
    @Override
    public void setNom(String nom){
        super.setNom(nom);
    }
    @Override
    public String getId(){
        return super.getId();
    }
    @Override
    public void setId(String id){
        super.setId(id);
    }

    public String getMida() {
        return super.mida;
    }
    public void setMida(String mida){
        super.mida = mida;
    }

    public int getNumHabitacions(){
        return numHabitacions;
    }

    public void setNumHabitacions(int numHabitacions){
        this.numHabitacions = numHabitacions;
    }

    public int getCapacitatPersones(){
        return capacitatPersones;
    }

    public void setCapacitatPersones(int capacitatPersones){
        this.capacitatPersones = capacitatPersones;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public boolean getCasaMascota(){
        return casaMascota;
    }
    public void setCasaMascota(boolean casaMascota){
        this.casaMascota = casaMascota;
    }
    public void setEstadaMinima(int x, int y) {
        estadaMinimaAlta = x;
        estadaMinimaBaixa = y;
    }
    public long getEstadaMinima (Temp i){
        if (i == InAllotjament.Temp.ALTA){
            // T. Alta -- 5 dies
            return estadaMinimaAlta;
        } // T. Baixa -- 3 dies
        return estadaMinimaBaixa;
    }
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        estadaMinimaAlta = estadaMinimaALTA_;
        estadaMinimaBaixa = estadaMinimaBAIXA_;
    }
}
