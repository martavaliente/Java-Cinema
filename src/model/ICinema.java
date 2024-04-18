package model;

import java.util.Date;
import java.util.NoSuchElementException;

public interface ICinema {

	ITheater[] getTheaters();

	void addTheater(int capacity);

	void deleteTheater(int id) throws NoSuchElementException;

	void updateTheater(int id, int newCapacity) throws NoSuchElementException;
	
	IMovie[] getMovies();
	
	void addMovie(String name, String author, int duration);
	
	void deleteMovie(int id) throws NoSuchElementException;
	
	void updateMovie(int id, String newName, String newAuthor, int newDuration) throws NoSuchElementException;
	
	ISession[] getSessions();
	
	void addSession(int idTheater, int idMovie, Date date) throws NoSuchElementException;
	
	void deleteSession(int id) throws NoSuchElementException;
	
	void updateSession(int id, Date newDate) throws NoSuchElementException;

	void bookSeat(int idSession, int seatNumber) throws SeatAlreadyBookedException;
}
