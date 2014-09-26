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

	public boolean add(Resources addMe) {
		if (a == null) {
			return false;
		} 
		if (validateCargoSpace()) {
			a.add(addMe);
			return true;
		}
		return false;
	}

	public boolean contains(Resources seeMe) {
		if (seeMe == null) {
			return false;
		} 
		if (a.size() != 0) {
			for (Resources x: a) {
				if (x != null && x.equals(seeMe)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean remove(Resources removeMe) {
		if (removeMe == null) {
			return false;
		} 
		if (contains()) {
			for (Resources x: a) {
				if (x != null && x.equals(removeMe)) {
					a.remove(x);
					return true;
				}
			}		
		}
		return false;
	}
}