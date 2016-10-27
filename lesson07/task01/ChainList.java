public class ChainList {

	private ListEntry entries;

	public ChainList() {
		entries = null;
	}

	public void add(Object o) {
		if(entries == null) {
			entries = new ListEntry o;
		} else {
			ListEntry e = entries;
			while(e.next != null) {
				e = e.next;
			}
			e.next = new ListEntry(o);
		}
	}

	public void concat() {

	}

	public Object getFirst() {
		return entries != null ? entries.data : null;
	}

	public ChainList getRest() {

	}

	public int length() {

	}

	public void remove() {

	}

	public Object[] toArray() {

	}

	@Override
	public String toString() {

	}
}