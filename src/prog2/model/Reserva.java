package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;

public class Reserva {
    private Allotjament allotjamentR;
    private Client clientR;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjamentR, Client clientR, LocalDate dataEntrada, LocalDate dataSortida) {
        this.allotjamentR = allotjamentR;
        this.clientR = clientR;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;

        if(dataEntrada.isBefore(dataEntrada)) {
            try {
                throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
            } catch (ExcepcioReserva e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Allotjament getAllotjament_()
    {
        return allotjamentR;
    }

    public Client getClient()
    {
        return clientR;
    }

    public LocalDate getDataEntrada()
    {
        return dataEntrada;
    }

    public LocalDate getDataSortida()
    {
        return dataSortida;
    }

    public void setAllotjament_(Allotjament nouAllotjament) {
        this.allotjamentR = nouAllotjament;
    }

    public void setClient(Client nouClient) {
        this.clientR = nouClient;
    }

    public void setDataEntrada(LocalDate novaDataEntrada throws ExcepcioReserva {
        if(novaDataEntrada.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data d'entrada no pot ser després de la data de sortida")
        }
        this.dataEntrada = novaDataEntrada;
    }

    public void setDataSortida(LocalDate novaDataSortida) throws ExcepcioReserva {
        if (novaDataSortida.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }
        this.dataSortida = novaDataSortida;
    }

}
