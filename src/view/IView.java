package view;

import model.ITheater;
import model.IMovie;
import model.ISession;

public interface IView {

	void displayErrorMessage(String message);
	void displayCinemaMenu();
	void displayTheaterMenu();
	void displaySessionMenu();
	void displayMovieMenu();
	void displayBookingMenu();
	void displayTheaters(ITheater[] theaters);
	void displayMovies(IMovie[] movies);
	void displaySessions(ISession[] sessions);
	void queryTheaterId();
	void queryTheaterCapacity();
	void queryMovieName();
	void queryMovieAuthor();
	void queryMovieDuration();
	void queryMovieId();
	void querySessionDate();
	void querySessionId();
	void querySeatNumber();

}
