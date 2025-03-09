package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class Camping implements InCamping{
    String nom;
    ArrayList<Allotjament>  llistaAllotjaments = new ArrayList<Allotjament>();
    ArrayList<Client> llistaClients = new ArrayList<Client>();
    ArrayList<Reserva> llistaReserves = new ArrayList<Reserva>();

    Iterator<Allotjament> iAllotjaments = llistaAllotjaments.iterator();
    Iterator<Client> iClients = llistaClients.iterator();
    Iterator<Reserva> iReserves = llistaReserves.iterator();

    //per fer l'ho de Camping mar de gestorCamping
    public Camping(String nom) {
        this.nom = nom;
    }
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public ArrayList<Reserva> getLlistaReserves(){
        return llistaReserves;
    }
    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments(){
        return llistaAllotjaments;
    }
    @Override
    public ArrayList<Client> getLlistaClients(){
        return llistaClients;
    }
    @Override
    public int getNumReserves(){
        return llistaReserves.size();
    }
    @Override
    public int getNumAllotjaments(){
        return llistaAllotjaments.size();
    }
    @Override
    public int getNumClients(){
        return llistaClients.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) throws ExcepcioReserva {
        Client nou_client = new Client(nom_, dni_);
        llistaClients.add(nou_client);
    }

    @Override
    public void afegirParcela(String nom, String ID, float metres, boolean connexioElectrica) {
        Parcela novaParcela = new Parcela(nom, ID, metres, connexioElectrica);
        llistaAllotjaments.add(novaParcela);
    }

    @Override
    public void afegirBungalow(String nom, String ID, String mida, int habitacions, int placesPersones,
                               int placesParquing, boolean terrassa, boolean tv, boolean aireFred)
    {
        Bungalow nouBungalow = new Bungalow(nom, ID, mida, habitacions, placesPersones, placesParquing, terrassa,
                tv, aireFred);
        llistaAllotjaments.add(nouBungalow);
    }

    //fet
    @Override
    public void afegirBungalowPremium(String nom, String ID, String mida, int habitacions,
                                      int placesPersones, int placesParquing, boolean terrassa, boolean tv,
                                      boolean aireFred, boolean serveisExtra, String codiWifi)
    {
        BungalowPremium nouBungalowPremium = new BungalowPremium(nom, ID, mida, habitacions,
                placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.add(nouBungalowPremium);
    }

    //fet
    @Override
    public void afegirGlamping(String nom, String ID, String mida, int habitacions, int placesPersones, String material, boolean casaMascota)
    {
        Glamping nouGlamping = new Glamping(nom, ID, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.add(nouGlamping);
    }

    //fet
    @Override
    public void afegirMobilHome(String nom, String ID, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa)
    {
        MobilHome nouMobilHome = new MobilHome(nom, ID, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.add(nouMobilHome);
    }



    @Override
    public void ferReserva(String ID, String DNI, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        try {
            afegirReserva(ID, DNI, dataEntrada, dataSortida);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void afegirReserva(String ID, String DNI, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva
    {
        Allotjament allotjamentR = null;
        Client clientR = null;
        for (Allotjament a : llistaAllotjaments)
        {
            if (a.ID.equals(ID))
            {
                allotjamentR = a;
                break;
            }
        }
        for (Client c : llistaClients)
        {
            if (c.getDni().equals(DNI))
            {
                clientR = c;
                break;
            }
        }

        InAllotjament.Temp temporada = getTemporada(dataEntrada);
        long diesDesitjatsR = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        for (Reserva r : llistaReserves)
        {
            if (allotjamentR == r.getAllotjament_())
            {
                throw new ExcepcioReserva("Allotjament ja ocupat.");
            }
            else if ((dataEntrada.isEqual(r.getDataEntrada()) || dataEntrada.isAfter(r.getDataEntrada())) &&
                    dataSortida.isEqual(r.getDataSortida()) || dataSortida.isBefore(r.getDataSortida()))
            {
                throw new ExcepcioReserva("Dies ja ocupats per una altra reserva.");
            }

        }
        Reserva novaReserva = new Reserva(allotjamentR, clientR, dataEntrada, dataSortida);
        llistaReserves.add(novaReserva);

    }

    @Override
    public float calculMidaTotalParceles()
    {
        ArrayList<Allotjament> allotjaments = getLlistaAllotjaments();
        float metresQuadrats = 0f;
        for (Allotjament a : allotjaments) {
            if (a instanceof Parcela) {
                metresQuadrats += ((Parcela) a).getMida();
            }
        }
        return metresQuadrats;
    }

    //Falta fer!!!
    @Override
    public int calculAllotjamentsOperatius()
    {
        return 0;
    }

    //Falta fer!!!
    @Override
    public Allotjament getAllotjamentEstadaMesCurta()
    {
        return null;
    }

    public static InAllotjament.Temp getTemporada(LocalDate data){
        MonthDay iniciAlta = MonthDay.of (Month.MARCH,21);
        MonthDay finalAlta = MonthDay.of (Month.SEPTEMBER,20);
        /*MonthDay iniciBaixa = MonthDay.of (Month.SEPTEMBER,21);
        MonthDay finalBaixa = MonthDay.of (Month.MARCH,20); -- es comenta per si de cas*/
        MonthDay data1  = MonthDay.of(data.getMonth(), data.getDayOfMonth());
        //S'ha de tenir en compte la data d'entrada per tal de determinar la temporada
        if (!data1.isBefore(iniciAlta) && !data1.isAfter(finalAlta)) {
            //Alta
            return InAllotjament.Temp.ALTA;
        }
        return InAllotjament.Temp.BAIXA; //Baixa
    }
}