import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Describe movie show with fields id, Movie, date of film, number of free seats

public class MovieShow {
	private int idMovieShow;
	private Movie movie;
	private LocalDateTime date;
	private int numberFreeSeats;

	public MovieShow() {

	}

	public MovieShow(int idMovieShow, Movie movie, LocalDateTime date2, int numberFreeSeats) {
		super();
		this.idMovieShow = idMovieShow;
		this.movie = movie;
		this.date = date2;
		this.numberFreeSeats = numberFreeSeats;
	}

	public int getidMovieShow() {
		return idMovieShow;
	}

	public void setidMovieShow(int idMovieShow) {
		this.idMovieShow = idMovieShow;
	}
	
	
	public Movie getMovie() {
		return movie;
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

	public int getNumberFreeSeats() {
		return numberFreeSeats;
	}

	public void setNumberFreeSeats(int numberFreeSeats) {
		this.numberFreeSeats = numberFreeSeats;
	}

	@Override
	public String toString() {
		return "id = " + idMovieShow + " title = " + movie + "  date = " + DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(date) + "  number of free seats = " + numberFreeSeats;
	}

}
