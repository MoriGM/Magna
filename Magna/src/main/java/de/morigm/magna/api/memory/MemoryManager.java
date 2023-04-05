package de.morigm.magna.api.memory;

public class MemoryManager {

	public enum MemoryType {
		BYTE(1), GIGABYTE(1024 * 1024 * 1024), MEGABYTE(1024 * 1024), KILOBYTE(1024);

		private final int size;

		MemoryType(int i) {
			this.size = i;
		}

		public int getSize() {
			return size;
		}
	}

	public int getFreeMemory(MemoryType type) {
		return (int) (Runtime.getRuntime().freeMemory() / type.getSize());
	}

	public int getTotalMemory(MemoryType type) {
		return (int) (Runtime.getRuntime().totalMemory() / type.getSize());
	}

	public int getUsedMemory(MemoryType type) {
		return (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / type.getSize());
	}

	public int getMaxMemory(MemoryType type) {
		return (int) (Runtime.getRuntime().maxMemory() / type.getSize());
	}

}
