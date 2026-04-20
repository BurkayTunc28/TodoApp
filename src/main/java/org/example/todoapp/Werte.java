package org.example.todoapp;

public class Werte {
    //Attribute
    private int EintragNummer;
    private String EintragTitel;
    private String Eintrag;


    //Konstruktor
    public Werte(int EintragNummer, String EintragTitel, String Eintrag){
        this.EintragNummer = EintragNummer;
        this.EintragTitel = EintragTitel;
        this.Eintrag = Eintrag;
    }

    //Methoden

    //Getter
    public int getEintragNummer(){
        return EintragNummer;
    }

    public String getEintragTitel(){
        return EintragTitel;
    }

    public String getEintrag(){
        return Eintrag;
    }

    //Setter
    public void setEintragNummer(int Eintragnummer ){
        this.EintragNummer = Eintragnummer;
    }

    public void setEintragTitel(String EintragTitel){
        this.EintragTitel = EintragTitel;
    }

    public void setEintrag(String Eintrag){
        this.Eintrag = Eintrag;
    }
}
