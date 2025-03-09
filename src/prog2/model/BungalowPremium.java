package prog2.model;

public class BungalowPremium extends Bungalow {
    private boolean serveisExtra;
    private String codiWifi;
    private long estadaAlta;
    private long estadaBaixa;

    //cridem el constructor Bungalow
    BungalowPremium() {
        super();
    }

    public BungalowPremium(String nom, String ID, String mida, int numHabitacions, int capacitatPersones, int placesParquing,
                           boolean terrassa, boolean TV, boolean aireFred, boolean serveisExtra, String codiWifi)
    {
        super(nom, ID, mida, numHabitacions, capacitatPersones, placesParquing, terrassa, TV, aireFred);
        this.estadaAlta = 7;
        this.estadaBaixa = 4;
        this.serveisExtra = serveisExtra;
        this.codiWifi = codiWifi;

    }
    @Override
    public String toString(){
        String s = "Nom: " + getNom() + ", ID: " + ID + ", mida: " + mida + ", numero habitacions: " + numHabitacions + ", places persones: " + capacitatPersones + ", places parquing: " +
                getPlacesParquing() + ", terrassa: " + isTerrassa() + ", TV: " + TV + ", aire fred: " + isAireFred() + ", serveis extra: " + serveisExtra + ", codi de la wifi: " + codiWifi;
        return s;
    }
    @Override
    public void setNom(String nom) {
        this.setNom(nom);
    }

    public String getId() {
        return ID;
    }

    @Override
    public void setId(String ID) {
        this.ID = ID;
    }

    public String getMida() {
        return mida;
    }

    public void setMida(String mida) {
        this.mida = mida;
    }

    public int getHabitacions() {
        return numHabitacions;
    }

    public void setHabitacions(int numHabitacions){
        this.numHabitacions = numHabitacions;
    }

    public int getCapacitat(){
        return capacitatPersones;
    }

    public void setCapacitat(int capacitatPersones){
        this.capacitatPersones = capacitatPersones;
    }
    @Override
    public int getPlacesParquing(){
        return getPlacesParquing();
    }
    @Override
    public void setPlacesParquing(int x){
        setPlacesParquing(x);
    }

    public boolean getTerrassa (){
        return isTerrassa();
    }

    public void setTerrassa (boolean x){
        setTerrassa(x);
    }

    public boolean getTv (){
        return TV;
    }

    public void setTv(boolean x){
        this.TV = x;
    }

    public boolean getAireFred (){
        return isAireFred();
    }

    public void setAireFred(boolean x){
        setAireFred(x);
    }

    public boolean getServeiExtra (){
        return serveisExtra;
    }

    public void setServeisExtra(boolean x){
        this.serveisExtra = x;
    }

    public String getCodiWiFi(){
        return codiWifi;
    }

    public void setCodiWifi (String x){
        this.codiWifi= x;
    }

    @Override
    public boolean correcteFuncionament() {
        //funciona tot correctament si té aire fred(retorna true) i que el length del codi de la wifi és entre els
        //intervals [8, 16]
        if (isAireFred() && codiWifi.length() >= 8 && codiWifi.length()<=16){
            return true;
        }
        return false;
    }
    @Override
    public void setEstadaMinima(int x, int y) {
        this.estadaAlta = x;
        this.estadaBaixa = y;
    }
    @Override
    public long getEstadaMinima (Temp x){
        if (x == InAllotjament.Temp.ALTA){
            return estadaAlta;
        }
        return estadaBaixa;
    }
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaAlta = estadaMinimaALTA_;
        this.estadaBaixa = estadaMinimaBAIXA_;
    }
    public int getPlacesPersones() {
        return capacitatPersones;
    }

    public boolean isServeisExtra() {
        return serveisExtra;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

}
