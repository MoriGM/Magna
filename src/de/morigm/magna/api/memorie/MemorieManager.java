package de.morigm.magna.api.memorie;

public class MemorieManager 
{

	public static enum MemorieType
	{
		BYTE(1),GIGABYTE(1024 * 1024 * 1024),MEGABYTE(1024 * 1024),KILOBYTE(1024);
		
		private int size;

		private MemorieType(int i)
		{
			this.size = i;
		}
		
		public int getSize()
		{
			return size;
		}
	}
	
	public int getFreeMemorie(MemorieType type)
	{
		return (int) (Runtime.getRuntime().freeMemory() / type.getSize());
	}
	
	public int getTotalMemorie(MemorieType type)
	{
		return (int) (Runtime.getRuntime().totalMemory() / type.getSize());
	}
	
	
	public int getUsedMemorie(MemorieType type)
	{
		return (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / type.getSize());
	}
	
	public int getMaxMemorie(MemorieType type)
	{
		return (int) (Runtime.getRuntime().maxMemory() / type.getSize());
	}
	
}
