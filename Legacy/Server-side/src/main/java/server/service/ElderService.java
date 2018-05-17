package server.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import elders.Elder;

@Service
public class ElderService
{
	List<Elder> elders = Arrays.asList(new Elder(1, "mike") , new Elder(2, "Mina") , new Elder(3, "Tony") , 
									   new Elder(4, "Charles") , new Elder(5 , "Sajib") , new Elder(6, "Yasser") );
	public List<Elder> getElders()
	{
		return elders;
	}
	
	public Elder getElderByRoomNumber(int n)
	{
		for(Elder x : elders)
		{
			if(x.getRoomNumber() == n)
				return x;
		}
		return null;
	}
	
}
