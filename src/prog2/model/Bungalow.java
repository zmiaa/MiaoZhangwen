package prog2.model;

public class Bungalow extends Casa {
    private int placesParquing;
    boolean TV;
    private boolean terrassa;
    private boolean aireFred;
    private long estadaMinimaAlta;
    private long estadaMinimaBaixa;

    //constructor sense paràmetres, cridem al de casa
    Bungalow(){
        super();
    }

    //informació extreta de la pràctica en el requadre d'exemple de la pàg. 2
    //constructor
    public Bungalow(String nom, String ID, String mida, int numHabitacions,
                    int capacitatPersones, int placesParquing, boolean terrassa, boolean TV, boolean aireFred) {
        //nom no està dintre dels atributs de Bungalow
        super(nom, ID, 0, 0, numHabitacions, mida, capacitatPersones);
        this.placesParquing = placesParquing;
        this.terrassa = terrassa;
        this.TV = TV;
        this.aireFred = aireFred;
        this.estadaMinimaAlta = 7;
        this.estadaMinimaBaixa = 4;
    }
    public String toString() {
        String s = "Nom: " + getNom() + ", ID: " + ID + ", mida: " + mida + ", places persones: " + capacitatPersones + ", places parquing: " +
                placesParquing + ", terrassa: " + terrassa + ", TV: " + TV + ", aire fred: " + aireFred;
        return s;
    }
    @Override
    public void setNom(String nom) {
        this.setNom(nom);
    }

    public String getMida() {
        return mida;
    }

    public void setMida(String v) {
        mida = v;
    }
    @Override
    public String getId() {
        return ID;
    }

    @Override
    public void setId(String id) {
        this.ID = ID;
    }

    public int getHabitacions() {
        return numHabitacions;
    }

    public void setHabitacions(int x){
        this.numHabitacions = x;
    }

    public int getCapacitat(){
        return capacitatPersones;
    }

    public void setCapacitat(int x){
        this.capacitatPersones = x;
    }

    public int getPlacesParquing(){
        return placesParquing;
    }

    public void setPlacesParquing(int x){
        this.placesParquing = x;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public boolean isTv() {
        return TV;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setTerrassa (boolean x){
        this.terrassa = x;
    }

    public void setTv(boolean x){
        this.TV = x;
    }

    public void setAireFred(boolean x){
        this.aireFred = x;
    }
    @Override
    public boolean correcteFuncionament() {
        if (aireFred){
            return true;
        }
        return false;
    }

    public void setEstadaMinima(int x, int y) {
        estadaMinimaAlta = x;
        estadaMinimaBaixa = y;
    }
    @Override
    public long getEstadaMinima (InAllotjament.Temp x){
        if (x == InAllotjament.Temp.ALTA){
            return estadaMinimaAlta;
        }
        return estadaMinimaBaixa;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        estadaMinimaAlta = estadaMinimaALTA_;
        estadaMinimaBaixa = estadaMinimaBAIXA_;
    }

    public int getPlacesPersones() {
        return capacitatPersones;
    }
}

