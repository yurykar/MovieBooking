import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//creating an instance of the class MovieShow, BookingTickets 

public class Factory {

	static int idMovieShow = 1;
	static int idBookingTickets = 1;

	public static MovieShow createObjectMovieShow(String movieShowString) {
		String[] temp = movieShowString.split(" ");
		Movie movie = new Movie(temp[0]);
		String dateString = temp[1] + " " + temp[2];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
		LocalDateTime date = LocalDateTime.parse(dateString, formatter);
		MovieShow movieShow = new MovieShow(idMovieShow++, movie, date, Integer.parseInt(temp[3]));
		return movieShow;

	}

	public static BookingTickets createObjectBookingTickets(MovieShow movieShow, int numberBookingSeats) {
		BookingTickets bookingTickets = new BookingTickets(movieShow.getidMovieShow(), idBookingTickets++, movieShow.getMovie(),
				movieShow.getDate(), numberBookingSeats);
		return bookingTickets;

	}

}
