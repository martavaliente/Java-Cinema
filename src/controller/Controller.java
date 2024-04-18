package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Cinema;
import model.ICinema;
import model.ITheater;
import model.SeatAlreadyBookedException;
import model.IMovie;
import model.ISession;
import view.CLIView;
import view.IView;

public class Controller {

	private ICinema cinema;
	private IView view;
	private Scanner scanner;

	public static void main(String[] args) {
		ICinema cinema = new Cinema();
		IView view = new CLIView();
		Controller controller = new Controller(view, cinema);
		controller.handleCinema();
	}

	public Controller(IView view, ICinema cinema) {
		this.view = view;
		this.cinema = cinema;
		this.scanner = new Scanner(System.in);
	}

	public void handleCinema() {
		boolean exit = false;
		while (!exit) {
			view.displayCinemaMenu();
			int choice = getUserInput(0, 4);
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				handleTheaters();
				break;
			case 2:
				handleMovies();
				break;
			case 3:
				handleSessions();
				break;
			case 4:
				handleBookings();
				break;
			}
		}
	}

	private void handleTheaters() {
		boolean exit = false;
		while (!exit) {
			view.displayTheaterMenu();
			int choice = getUserInput(0, 4);
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				showTheaters();
				break;
			case 2:
				view.queryTheaterCapacity();
				int capacity = getUserInput();
				cinema.addTheater(capacity);
				showTheaters();
				break;
			case 3:
				view.queryTheaterId();
				int id = getUserInput();
				try {
					cinema.deleteTheater(id);
					showTheaters();
				} catch (NoSuchElementException e) {
					view.displayErrorMessage(e.getMessage());
				}
				break;
			case 4:
				view.queryTheaterId();
				int oldId = getUserInput();
				view.queryTheaterCapacity();
				int newCapacity = getUserInput();
				cinema.updateTheater(oldId, newCapacity);
				showTheaters();
				break;
			}
		}
	}

	private void handleMovies() {
		boolean exit = false;
		while (!exit) {
			view.displayMovieMenu();
			int choice = getUserInput(0, 4);
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				showMovies();
				break;
			case 2:
				view.queryMovieName();
				String name = getUserInputString();
				view.queryMovieAuthor();
				String author = getUserInputString();
				view.queryMovieDuration();
				int duration = getUserInput();
				cinema.addMovie(name, author, duration);
				showMovies();
				break;
			case 3:
				view.queryMovieId();
				int id = getUserInput();
				try {
					cinema.deleteMovie(id);
					showMovies();
				} catch (NoSuchElementException e) {
					view.displayErrorMessage(e.getMessage());
				}
				break;
			case 4:
				view.queryMovieId();
				int oldId = getUserInput();
				view.queryMovieName();
				String newName = getUserInputString();
				view.queryMovieAuthor();
				String newAuthor = getUserInputString();
				view.queryMovieDuration();
				int newDuration = getUserInput();
				cinema.updateMovie(oldId, newName, newAuthor, newDuration);
				showMovies();
				break;
			}
		}
	}

	private void handleSessions() {
		boolean exit = false;
		while (!exit) {
			view.displaySessionMenu();
			int choice = getUserInput(0, 4);
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				showSessions();
				break;
			case 2:
				view.queryTheaterId();
				int theaterId = getUserInput();
				view.queryMovieId();
				int movieId = getUserInput();
				view.querySessionDate();
				Date date = getUserInputDate();
				try {
					cinema.addSession(theaterId, movieId, date);
				} catch (NoSuchElementException e) {
					view.displayErrorMessage(e.getMessage());
				}
				showSessions();
				break;
			case 3:
				view.querySessionId();
				int id = getUserInput();
				try {
					cinema.deleteSession(id);
					showSessions();
				} catch (NoSuchElementException e) {
					view.displayErrorMessage(e.getMessage());
				}
				break;
			case 4:
				view.querySessionId();
				int oldId = getUserInput();
				view.querySessionDate();
				Date newDate = getUserInputDate();
				cinema.updateSession(oldId, newDate);
				showSessions();
				break;
			}
		}
	}

	private void handleBookings() {
		boolean exit = false;
		while (!exit) {
			view.displayBookingMenu();
			int choice = getUserInput(0, 1);
			switch (choice) {
			case 0:
				exit = true;
				break;
			case 1:
				view.querySessionId();
				int sessionId = getUserInput();
				view.querySeatNumber();
				int seatNumber = getUserInput();
				try {
					cinema.bookSeat(sessionId, seatNumber);
				} catch (SeatAlreadyBookedException e) {
					view.displayErrorMessage(e.getMessage());
				}
				showSessions();
				break;
			}
		}
	}

	private int getUserInput() {
		int choice;
		while (true) {
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				scanner.nextLine();
				break;
			} else {
				scanner.next();
			}
			view.displayErrorMessage("Invalid input. Please enter a valid number");
		}
		return choice;
	}
	
	public Date getUserInputDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter date (YYYY-MM-DD): ");
                String input = scanner.nextLine();
                date = dateFormat.parse(input);
                isValid = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            }
        }

        return date;
    }
	
	private String getUserInputString() {
		String input = scanner.nextLine();
		return input;
	}

	private int getUserInput(int min, int max) {
		int choice;
		while (true) {
			if (scanner.hasNextInt()) {
				choice = scanner.nextInt();
				if (choice >= min && choice <= max) {
					scanner.nextLine();
					break;
				}
			} else {
				scanner.next();
			}
			view.displayErrorMessage("Invalid choice. Please enter a number between " + min + " and " + max);
		}
		return choice;
	}

	private void showTheaters() {
		ITheater[] theaters = cinema.getTheaters();
		view.displayTheaters(theaters);
	}
	
	private void showMovies() {
		IMovie[] movies = cinema.getMovies();
		view.displayMovies(movies);
	}
	
	private void showSessions() {
		ISession[] sessions = cinema.getSessions();
		view.displaySessions(sessions);
	}

}
