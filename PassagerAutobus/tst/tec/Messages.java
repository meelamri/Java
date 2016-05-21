package tec;

class Messages {
	final private String[] data = new String[20];
	private int nbElement;

	void clear() {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null)
				break;
			data[i] = null;
		}
		nbElement = 0;
	}

	int size() {
		return nbElement;
	}

	String get(int num) {
		assert num > 0 : "pas de message";
		return data[num - 1];
	}

	String getLast() {
		return get(size());
	}

	void add(String s) {
		data[nbElement++] = s;
	}
}
