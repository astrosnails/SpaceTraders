import java.util.ArrayList;

public class Cargo {

	ArrayList<Resources> a;
	int maxSize;

	public Cargo(int maxSize) {
		this.maxSize = maxSize;
		a = new ArrayList();
	}

	private boolean validateCargoSpace(ArrayList<Resources> a) {
		if (a.size() < maxSize) {
			return true;
		} 
		return false;
	}
}