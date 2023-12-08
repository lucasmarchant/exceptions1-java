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
            System.out.print("Room Number: ");
            int number = scanner.nextInt();

            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(scanner.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");

            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e) {
            System.out.println("Formato da data inválido");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado");
        }

        scanner.close();
    }
}
