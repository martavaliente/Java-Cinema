package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public class Cinema implements ICinema {
	private List<IMovie> movies;
	private List<ITheater> theater;
	private List<ISession> session;
	public Cinema() {
		movies = new ArrayList<IMovie>();
		theater =new ArrayList<ITheater>();
		session = new ArrayList<ISession>();
	}
	public void addMovie(String name, String author, int duration) {
		Movie movie = new Movie(name, author, duration);
		movies.add(movie);	
	}
	@Override
	public ITheater[] getTheaters() {
		return theater.toArray(new ITheater[theater.size()]);
	}
	@Override
	public void addTheater(int capacity) {
		theater
	}
	@Override
	public void deleteTheater(int id) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateTheater(int id, int newCapacity) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public IMovie[] getMovies() {
		return movies.toArray(new IMovie[movies.size()]);
	}
	@Override
	public void deleteMovie(int id) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateMovie(int id, String newName, String newAuthor, int newDuration) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ISession[] getSessions() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addSession(int idTheater, int idMovie, Date date) throws NoSuchElementException {
		ITheater theater = null;
		IMovie movie = null;
		for(ITheater thea : theater) {
			if(thea.getId()== idTheater) {
				theater= thea;
				break;
			}
		}
		for(IMovie mov : movie) {
			if(mov.getId()== idMovie) {
				movie = mov;
				break;
			}
		}
	}
	@Override
	public void deleteSession(int id) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateSession(int id, Date newDate) throws NoSuchElementException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void bookSeat(int idSession, int seatNumber) throws SeatAlreadyBookedException {
		// TODO Auto-generated method stub
		
	}

}
