package utils;

import java.util.Arrays;

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
	
	public int[] toArray() { // TODO indexoutofbounds ex
		int[] result = new int[this.size()];
		int[] leftArray = this.left != null ? this.left.toArray() : new int[]{};		
		int[] rightArray = this.right != null ? this.right.toArray() : new int[]{};
		System.out.println("LOLOLOLOPL " + leftArray.length + " regerg " + rightArray.length);
		for(int i = 0; i < result.length; i++) {
			result[i] = (i <= leftArray.length) ? leftArray[i] : rightArray[i - leftArray.length - 1];
		}
		return result;
	}
	
	public int size() {
		return 1 + (this.left != null ? this.left.size() : 0) + (this.right != null ? this.right.size() : 0);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		if(obj.getClass() != this.getClass()) {
			return false;
		}
		
		IntTree it = (IntTree) obj;
		
		return Arrays.equals(it.toArray(), this.toArray());
	}
}