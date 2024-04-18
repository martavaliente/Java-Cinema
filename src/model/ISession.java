package model;

import java.util.Date;

public interface ISession {

	int getId();
	void setId(int id);
	Date getDate();
	void setDate(Date newDate);
	void book(int seatNumber) throws SeatAlreadyBookedException;

}
