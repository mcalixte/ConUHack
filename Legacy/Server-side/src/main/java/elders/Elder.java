package elders;

import java.util.ArrayList;
import java.util.List;

public class Elder
{
	private int roomNumber;
	private String name;
	private ArrayList<String> requests = new ArrayList<String>();
	public Elder(int roomNumber, String name) {
		super();
		this.roomNumber = roomNumber;
		this.name = name;
	}
	
	public List<String> getRequests()
	{
		return requests;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
