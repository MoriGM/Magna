package de.morigm.magna.api.manager;

import java.util.ArrayList;
import java.util.List;

import de.morigm.magna.api.sign.SignListener;
import lombok.Getter;

public class SignManager 
{
	
	@Getter private List<SignListener> signs = new ArrayList<>();
	
	public void registerSign(SignListener listener)
	{
		if(!signs.contains(listener) && !containsSignListener(listener.getName()))
			signs.add(listener);
	}
	
	public boolean containsSignListener(String name)
	{
		return getSignListener(name) != null;
	}
	
	public SignListener getSignListener(String name)
	{
		for(SignListener sign : signs)
			if(sign.getName().equals(name))
				return sign;
		return null;
	}
	
}
