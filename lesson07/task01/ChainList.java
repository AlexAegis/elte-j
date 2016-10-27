public class ChainList {

	private ListEntry entries;

	public ChainList() {
		this(null);
	}

	public ChainList(ListEntry entries) {
		this.entries = entries;
	}

	public void add(Object o) {
		if(entries == null) {
			entries = new ListEntry(o);
		} else {
			ListEntry e = entries;
			while(e.next != null) {
				e = e.next;
			}
			e.next = new ListEntry(o);
		}
	}

	public void concat() { //TODO

	}

	public Object getFirst() {
		return entries != null ? entries.data : null;
	}

	public ListEntry getRest() { //FIXME
		return entries != null ? entries.next : null;
	}

	public int length() {
		ListEntry e = entries;
		int size = 1;
		while(e.next != null) {
			e = e.next;
			size++;
		}
		return size;
	}

	public void remove() {//TODO

	}

	public Object[] toArray() {
		Object[] result = new Object[this.length()];
		ListEntry e = this.entries;
		int i = 0;
		if(e != null) {
			while(e.next != null) {
				result[i] = e.data;
				e = e.next;
				i++;
			}
			result[i] = e.data;
			return result;
		} else {
			return null;
		}

	}

	@Override
	public String toString() { //TODO
		return "";
	}
}