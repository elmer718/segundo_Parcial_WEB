package co.edu.ufps.crud.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Bill {
	private int id;
	private Date date_bill;
	private int type;
	private int value;
	private String observation;
	
	private int user_id;
	
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(int id, Date date_bill, int type, int value, String observation, int user_id) {
		super();
		this.id = id;
		this.date_bill = date_bill;
		this.type = type;
		this.value = value;
		this.observation = observation;
		this.user_id = user_id;
	}

	
	
}
