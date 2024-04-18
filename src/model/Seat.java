package model;

public class Seat implements ISeat{
	private boolean booked =false;
	private int id;
	
	public Seat(int id) {
		this.id=id;
	}
	@Override
	public void book() throws SeatAlreadyBookedException {
		if(booked) {
			throw new SeatAlreadyBookedException("Seient reservat");
		} else {
			booked=true;
		}
	}
	@Override
	public String toString() {
		if(booked) {
			return "X" + id+ " ";
		}return "O" + id + " ";
	}

}
