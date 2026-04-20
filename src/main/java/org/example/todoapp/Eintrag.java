package org.example.todoapp;

import java.util.*;

public class Eintrag {
    public static void main(String[] args) {

        //Objekte
        Scanner scanner = new Scanner(System.in);

        ArrayList<Werte> Einkaufsliste = new ArrayList<Werte>();


        //Listenfunktion

        boolean liste = true;

        int eintragsNummer = 1;

        while (liste) {
            System.out.println("Bitte wähle aus, was du machen möchtest: 1= Neuer Eintrag, 2= Alten Eintrag löschen, 3 = Liste anzeigen, 4= Beenden");
            int auswahl = scanner.nextInt();
            switch (auswahl) {
                case 1:
                    System.out.println("Bitte gibt zuerst einen Titel ein");
                    scanner.nextLine();
                    String titel = scanner.nextLine();

                    System.out.println();
                    System.out.println("Jetzt die Beschreibung");
                    String beschreibung = scanner.nextLine();

                    Werte neuerEintrag = new Werte(eintragsNummer, titel, beschreibung);

                    Einkaufsliste.add(neuerEintrag);

                    eintragsNummer++;

                    System.out.println("Eintrag erstellt!");
                    break;

                case 2:

                    if (Einkaufsliste.size() > 0) {

                        for (Werte eintraege : Einkaufsliste) {
                            System.out.println(eintraege.getEintragNummer() + " " + eintraege.getEintragTitel() + ", " + eintraege.getEintrag());
                            System.out.println();
                        }

                        System.out.println("Bitte wähle aus, welcher Eintrag gelöscht werden soll");
                        System.out.println();
                        int auswahlLoeschen = scanner.nextInt();

                        Werte loeschEintrag = null;

                            for (Werte eintrag : Einkaufsliste) {

                                if (auswahlLoeschen == eintrag.getEintragNummer()) {
                                    loeschEintrag = eintrag;
                                    break;
                                }
                            }

                            if (loeschEintrag != null){
                                Einkaufsliste.remove(loeschEintrag);
                                for (int i = 0; i < Einkaufsliste.size() ; i++){
                                    Einkaufsliste.get(i).setEintragNummer(i + 1);
                                }

                                System.out.println("Erfolgreich den Eintrag " + loeschEintrag.getEintragNummer() + " geloescht.");
                                System.out.println();
                                eintragsNummer--;
                            }

                            else System.out.println("Keine Einträge gefunden");
                            System.out.println();
                            break;
                        }

                case 3:
                    System.out.println("Hier sind deine Einträge");

                    if (Einkaufsliste.size() > 0){
                        for (Werte Einkaufliste : Einkaufsliste) {
                            System.out.println(Einkaufliste.getEintragNummer() + " " + Einkaufliste.getEintragTitel() + ", " + Einkaufliste.getEintrag());
                        }
                    }

                    else System.out.println("Keine Einträge gefunden");
                    break;

                case 4:
                    System.out.println("Programm beendet");
                    liste = false;
                    break;

                default:
                    System.out.println("Ungültiger Input");
            }
        }

    }
}

