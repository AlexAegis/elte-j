package utils;

public class IntTree {
	
	public final int value;
	
	private IntTree left;
	private IntTree right;
	
	public IntTree(int x) {
		this.value = x;
		this.left = null;
		this.right = null;
	}
	
	public IntTree insert(int x) {
		if(x < value) {
			if(left != null) {
				this.left.insert(x);
			} else {
				this.left = new IntTree(x);
			}
			
		} else {			
			if(right != null) {
				this.right.insert(x);
			} else {
				this.right = new IntTree(x);
			}
		}
		return this;
	}
	
	public boolean contains(int x) {
		if(this.value == x) {
			return true;
		} else if(x < this.value) {
			return this.left != null && this.left.contains(x);
		} else {
			return this.left != null && this.right.contains(x);
		}
	}
	
	public int[] toArray() {
		return new int[]{};
	}
	
	public int size() {
		return 1 + (this.left != null ? this.left.size() : 0) + (this.right != null ? this.right.size() : 0);
	}
}