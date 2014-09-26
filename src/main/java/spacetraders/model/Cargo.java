public class Cargo {

	ArrayList<Cargo> a = new ArrayList();
	int maxSize;
	
	public Cargo(int maxSize) {
		this.maxSize = maxSize;
	}

	private boolean validateCargoSpace(ArrayList<Cargo> a) {
		if (a.size() < maxSize) {
			return true;
		} 
		return false;
	}
}