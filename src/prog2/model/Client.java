package prog2.model;

import prog2.vista.ExcepcioReserva;

public class Client {
    private String nom;
    private String DNI;

    public Client(String nom, String DNI) throws ExcepcioReserva {
        this.nom = nom;
        setDni(DNI);
    }
    public void setDni(String DNI) throws ExcepcioReserva {
        //comprova el DNI (8 números seguits d'1 lletra
        String regex = "^[0-9]{8}[A-Za-z]$";
        if(DNI.matches(regex)){
            this.DNI = DNI;
        }else{
            throw new ExcepcioReserva("DNI introduït incorrecte");
        }
    }
    public String getDni() {
        return DNI;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

}
