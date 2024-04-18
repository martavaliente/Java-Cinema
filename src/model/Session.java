package model;

import java.util.ArrayList;
import java.util.Date;

public class Session implements ISession{
	private int id;
	private static int nextId=0;
	private Date date;
	private ArrayList<Seat> seats ;
	private ITheater theater;
	private IMovie movie;
	public Session (int capacity, Date date,ITheater theater,IMovie movie ) {
		this.date = date;
		id=nextId++;
		this.movie=movie;
		this.theater=theater;
		this.seats = new ArrayList<>();
		for (int i = 1; i <= theater.getCapacity(); i++) {
			seats.add(new Seat());
		}
	}
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id= id;
		
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date newDate) {
		this.date = newDate;
		
	}

	@Override
	public void book(int seatNumber) throws SeatAlreadyBookedException {
		
	}
	
}
