package model;

import java.sql.Timestamp;


 /**
 * @since JdbcDemo
 * @author Ö£Ë®ºé  
 */
public class Demo {
	private String name;
	private Timestamp timeOne;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getTimeOne() {
		return timeOne;
	}
	public void setTimeOne(Timestamp timeOne) {
		this.timeOne = timeOne;
	}
}
