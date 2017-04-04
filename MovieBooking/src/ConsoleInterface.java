import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ConsoleInterface {
	public static void startBooking(String fileName) {
		int counter = 0;
		List<MovieShow> schedule = InputOutput.readFromFile(fileName);
		Map<Integer, BookingTickets> booking = new TreeMap<Integer, BookingTickets>();

		while (counter != 5) {
			System.out.println("Select the action and enter a number");
			System.out.println("1 - show shedule");
			System.out.println("2 - book tickets");
			System.out.println("3 - cancel booking");
			System.out.println("4 - show information about booking");
			System.out.println("5 - end booking");
			Scanner in = new Scanner(System.in);
			String input = in.next();
			switch (input) {
			case "1":
				showSchedule(schedule);
				break;
			case "2":
				bookTickets(schedule, booking);
				break;
			case "3":
				cancelBooking(schedule, booking);
				break;
			case "4":
				showBooking(booking);
				break;
			case "5":
				counter = closeBooking(booking);
				System.out.println("Booking completed");
				in.close();
				break;
			default:
				System.out.println("Enter the correct data (any number from 1 to 5).");
			}
		}

	}

	// implements end of program and write information about booking in
	// BOOKING.txt
	private static int closeBooking(Map<Integer, BookingTickets> booking) {
		InputOutput.writeInFile(booking);
		return 5;
	}

	// implements showing information about booking using id of booking
	private static void showBooking(Map<Integer, BookingTickets> booking) {
		System.out.println("Enter the id of booking");
		Scanner in = new Scanner(System.in);
		String inputId = in.next();
		int idBooking = Integer.parseInt(inputId);
		if (booking.containsKey(idBooking)) {
			showMap(booking, idBooking);
		} else {
			System.out.println("It's incorrect id");
			waiting();
		}

	}

	// implements cancellation of booking using id of booking
	private static void cancelBooking(List<MovieShow> schedule, Map<Integer, BookingTickets> booking) {
		System.out.println("Enter the id of booking to cancel");
		Scanner in = new Scanner(System.in);
		String inputId = in.next();
		int idBooking = Integer.parseInt(inputId);
		if (booking.containsKey(idBooking)) {
			schedule.get(booking.get(idBooking).getidMovieShow() - 1)
					.setNumberFreeSeats(schedule.get(booking.get(idBooking).getidMovieShow() - 1).getNumberFreeSeats()
							+ booking.get(idBooking).getnumberBookingSeats());
			booking.remove(idBooking);
			System.out.println("Booking with id " + idBooking + " was canceled");
			waiting();
		} else {
			System.out.println("It's incorrect id");
			waiting();
		}

	}

	// implements ticket booking
	private static void bookTickets(List<MovieShow> schedule, Map<Integer, BookingTickets> booking) {
		showSh(schedule);
		System.out.println("Enter the id of movie show");
		Scanner in = new Scanner(System.in);
		String inputId = in.next();
		int idMovieShow = Integer.parseInt(inputId);
		if (idMovieShow > 0 && idMovieShow <= schedule.size()) {
			System.out.println("Enter number of tickets you want to booking (any number from 1 to "
					+ schedule.get(idMovieShow - 1).getNumberFreeSeats() + " ).");
			String inputNumberSeats = in.next();
			int numberBookingSeats = Integer.parseInt(inputNumberSeats);
			if (numberBookingSeats > 0 && numberBookingSeats <= schedule.get(idMovieShow - 1).getNumberFreeSeats()) {
				booking.put(Factory.idBookingTickets,
						Factory.createObjectBookingTickets(schedule.get(idMovieShow - 1), numberBookingSeats));
				schedule.get(idMovieShow - 1)
						.setNumberFreeSeats(schedule.get(idMovieShow - 1).getNumberFreeSeats() - numberBookingSeats);
				System.out.println("The booking was successful");
				System.out.println(booking.get(Factory.idBookingTickets - 1).toString());
				waiting();

			} else {
				System.out.println("Enter the correct number of booking seats (any number from 1 to "
						+ schedule.get(idMovieShow - 1).getNumberFreeSeats() + " ).");
			}

		} else {
			System.out.println("Enter the correct id of movie show (any number from 1 to " + schedule.size() + " ).");
		}

	}

	// implements showing of Schedule
	private static void showSchedule(List<MovieShow> schedule) {
		showSh(schedule);
		waiting();

	}

	//show Schedule
	private static void showSh(List<MovieShow> schedule) {
		for (MovieShow temp : schedule) {
			if (temp.getNumberFreeSeats() > 0) {
				System.out.println(temp.toString());
			}
		}
	}

	// implements waiting of press Enter
	private static void waiting() {
		System.out.println("Press Enter to continue");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();

	}

	// show information about booking using id of booking
	private static void showMap(Map<Integer, BookingTickets> booking, int idBooking) {
		System.out.println("id = " + idBooking + " " + booking.get(idBooking));
		waiting();
	}

}
