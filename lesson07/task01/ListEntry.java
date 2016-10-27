class ListEntry {
	Object data;
	ListEntry next;

	ListEntry(Object data) {
		this(data, null);
	}

	ListEntry(Object data, ListEntry next) {
		this.data = data;
		this.next = null;
	}
}