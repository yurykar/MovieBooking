
//organize read from file and write in file

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InputOutput {

	public static List<MovieShow> readFromFile(String fileName) {
		Scanner scanner = null;
		List<MovieShow> schedule = new ArrayList<MovieShow>();
		try {
			FileReader fr = new FileReader(fileName);
			scanner = new Scanner(fr);
			while (scanner.hasNextLine()) {
				schedule.add(Factory.createObjectMovieShow(scanner.nextLine()));
			}

		} catch (FileNotFoundException e) {
			System.err.println(e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return schedule;
	}

	public static void writeInFile(Map<Integer, BookingTickets> booking) {
		try (FileWriter writer = new FileWriter(new File("BOOKING.TXT"), false)) {
			for (Map.Entry<Integer, BookingTickets> e : booking.entrySet()) {
				writer.write(String.valueOf(e.getValue()));
				writer.write(System.getProperty("line.separator"));
			}
			writer.flush();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

}
