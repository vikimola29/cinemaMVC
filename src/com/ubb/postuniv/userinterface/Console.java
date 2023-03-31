package com.ubb.postuniv.userinterface;

import com.ubb.postuniv.service.ClientCardService;
import com.ubb.postuniv.service.FilmService;
import com.ubb.postuniv.service.ReservationService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    private FilmService filmService;
    private ClientCardService clientCardService;
    private ReservationService reservationService;
    private Scanner scan;

    public Console(FilmService filmService, ClientCardService clientCardService, ReservationService reservationService) {
        this.filmService = filmService;
        this.clientCardService = clientCardService;
        this.reservationService = reservationService;
        this.scan = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. CRUD Film");
        System.out.println("2. CRUD Client Card");
        System.out.println("3. CRUD Reservations");
        System.out.println("0. Exit");
    }

    private void showAll(ArrayList objects) {
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    public void runConsole() {
        while (true) {
            showMenu();
            int option = scan.nextInt();
            switch (option) {
                case 0 -> {
                    return;
                }
                case 1 -> runSubmenuCRUDFilm();
                case 2 -> runSubmenuCRUDClientCard();
                case 3 -> runSubmenuCRUDReservation();
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void runSubmenuCRUDFilm() {
        while (true) {
            System.out.println("1. Add film");
            System.out.println("2. Update film");
            System.out.println("3. Delete film");
            System.out.println("4. Show all film");
            System.out.println("0. Back");

            int option = scan.nextInt();
            switch (option) {
                case 0 -> runConsole();
                case 1 -> handleAddFilm();
                case 2 -> handleUpdateFilm();
                case 3 -> handleDeleteFilm();
                case 4 -> showAll((ArrayList) this.filmService.getAll());
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void handleAddFilm() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();

            System.out.println("Title: ");
            String title = this.scan.next();

            System.out.println("Release Year: ");
            int releaseYear = this.scan.nextInt();

            System.out.println("Price: ");
            double price = this.scan.nextDouble();

            System.out.println("In Program: ");
            String inProgram = this.scan.next();

            this.filmService.add(id, title, releaseYear, price, inProgram);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdateFilm() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();

            System.out.println("Title: ");
            String title = this.scan.next();

            System.out.println("Release Year: ");
            int releaseYear = this.scan.nextInt();

            System.out.println("Price: ");
            double price = this.scan.nextDouble();

            System.out.println("In Program: ");
            String inProgram = this.scan.next();

            this.filmService.refresh(id, title, releaseYear, price, inProgram);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void handleDeleteFilm() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();
            this.filmService.rid(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    private void runSubmenuCRUDClientCard() {
        while (true) {
            System.out.println("1. Add client card");
            System.out.println("2. Update client card");
            System.out.println("3. Delete client card");
            System.out.println("4. Show all client card");
            System.out.println("0. Back");

            int option = scan.nextInt();
            switch (option) {
                case 0 -> runConsole();
                case 1 -> handleAddClientCard();
                case 2 -> handleUpdateClientCard();
                case 3 -> handleDeleteClientCard();
                case 4 -> showAll((ArrayList) this.clientCardService.getAll());
                default -> System.out.println("Invalid option.");
            }
        }}

    private void handleAddClientCard() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();

            System.out.println("firstName: ");
            String firstName = this.scan.next();

            System.out.println("lastName: ");
            String lastName = this.scan.next();

            System.out.println("CNP: ");
            int CNP = this.scan.nextInt();

            System.out.println("dateBorn: ");
            String dateBorn = this.scan.next();

            System.out.println("dateJoined: ");
            String dateJoined = this.scan.next();

            System.out.println("points: ");
            int points = this.scan.nextInt();

            this.clientCardService.add(id, firstName, lastName, CNP,  dateBorn, dateJoined, points);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdateClientCard() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();

            System.out.println("firstName: ");
            String firstName = this.scan.next();

            System.out.println("lastName: ");
            String lastName = this.scan.next();

            System.out.println("CNP: ");
            int CNP = this.scan.nextInt();

            System.out.println("dateBorn: ");
            String dateBorn = this.scan.next();

            System.out.println("dateJoined: ");
            String dateJoined = this.scan.next();

            System.out.println("points: ");
            int points = this.scan.nextInt();

            this.clientCardService.refresh(id, firstName, lastName, CNP,  dateBorn, dateJoined, points);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleDeleteClientCard() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();
            this.clientCardService.rid(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void runSubmenuCRUDReservation() {
        while (true) {
            System.out.println("1. Add reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Show all reservation");
            System.out.println("0. Back");

            int option = scan.nextInt();
            switch (option) {
                case 0 -> runConsole();
                case 1 -> handleAddReservation();
                case 2 -> handleUpdateReservation();
                case 3 -> handleDeleteReservation();
                case 4 -> showAll((ArrayList) this.reservationService.getAll());
                default -> System.out.println("Invalid option.");
            }
        }}

    private void handleAddReservation() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();

            System.out.println("idFilm: ");
            int idFilm = this.scan.nextInt();

            System.out.println("idClientCard: ");
            int idClientCard = this.scan.nextInt();

            System.out.println("dateTime: ");
            String dateTime = this.scan.next();

            this.reservationService.add(id, idFilm, idClientCard ,dateTime);

            int points = clientCardService.getOne(idClientCard).getPoints();
            System.out.print("New total points: " + points +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleUpdateReservation() {

            try {
                System.out.println("ID: ");
                int id = this.scan.nextInt();

                System.out.println("idFilm: ");
                int idFilm = this.scan.nextInt();

                System.out.println("idClientCard: ");
                int idClientCard = this.scan.nextInt();

                System.out.println("dateTime: ");
                String dateTime = this.scan.next();

                this.reservationService.refresh(id, idFilm, idClientCard ,dateTime);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }



    private void handleDeleteReservation() {
        try {
            System.out.println("ID: ");
            int id = this.scan.nextInt();
            this.reservationService.rid(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



}
