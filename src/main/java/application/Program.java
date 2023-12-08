package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int number = scanner.nextInt();

        System.out.println("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());

        System.out.println("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva:");

            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Erro na reserva: As datas de reserva para atualização devem ser datas futuras");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");

            } else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);

            }
        }

        scanner.close();
    }
}
