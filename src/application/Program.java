package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = scanner.nextInt();
            System.out.print("Check-in date (DD/MM/AAAA): ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date (DD/MM/AAAA): ");
            Date checkOut = sdf.parse(scanner.next());

            //essa função da classe Date faz uma verificação
            //se a data de check-out não é antes da data de check-in
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (DD/MM/AAAA): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date (DD/MM/AAAA): ");
            checkOut = sdf.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e) {
            System.out.println("Invalid date format!");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
    }
}
