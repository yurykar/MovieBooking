import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Describe class booking tickets with fields idMovieShow, idBookingTickets, Movie, date of movie, number of booking seats

public class BookingTickets {

	private int idMovieShow;
	private int idBookingTickets;
	private Movie movie;
	private LocalDateTime date;
	private int numberBookingSeats;

	public BookingTickets() {

	}

	public BookingTickets(int idMovieShow, int idBookingTickets, Movie movie, LocalDateTime date,
			int numberBookingSeats) {
		super();
		this.idMovieShow = idMovieShow;
		this.idBookingTickets = idBookingTickets;
		this.movie = movie;
		this.date = date;
		this.numberBookingSeats = numberBookingSeats;
	}

	public int getidMovieShow() {
		return idMovieShow;
	}

	public void setidMovieShow(int idMovieShow) {
		this.idMovieShow = idMovieShow;
	}

	public int getidBookingTickets() {
		return idBookingTickets;
	}

	public void setidBookingTickets(int idBookingTickets) {
		this.idBookingTickets = idBookingTickets;
	}

	public String getMovie() {
		return movie.getTitle();
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getnumberBookingSeats() {
		return numberBookingSeats;
	}

	public void setnumberBookingSeats(int numberBookingSeats) {
		this.numberBookingSeats = numberBookingSeats;
	}

	@Override
	public String toString() {
		return "idBooking = " + idBookingTickets + " title = " + movie + "  date = " + DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(date)
				+ "  number of booking seats = " + numberBookingSeats;
	}

}
