package de.morigm.magna.api.censor;

public enum CensorType 
{
	
	BAN,
	KICK,
	WARN,
	MUTE,
	DEOP,
	SPAWN,
	GROUPKICK,
	GROUPBAN,
	KILL,
	CLEAR,
	BLIND,
	NORMAL;
	
	public static boolean isType(String s)
	{
		for(CensorType t : values())
			if(t.name().equals(s.toUpperCase()))
				return true;
		return false;
	}
	
	public static CensorType getType(String s)
	{
		for(CensorType t : values())
			if(t.name().equals(s.toUpperCase()))
				return t;
		return CensorType.NORMAL;
	}

}
