package utils;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

public class IntList {

    private int[] array;

    public IntList() {
        this.array = new int[]{};
    }

    public IntList(int[] n) {
        this.array = Arrays.copyOf(n, n.length);
    }

    public IntList add(int n) {
        try {
            this.add(n, this.size() + 1);
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return this;
    }

    public IntList add(int n, int position) throws IndexOutOfBoundsException {
        if(position > this.size() + 1) {
            throw new IndexOutOfBoundsException();
        }
        int[] replacer = new int[this.size() + 1];
        position -= 1;
        for(int i = 0; i < replacer.length; i++) {
            if(i < position) {
                replacer[i] = this.array[i];
            } else if (i == position) {
                replacer[i] = n;
            } else {
                replacer[i] = this.array[i - 1];
            }
        }
        this.array = replacer;
        return this;
    }

    public int get() {
        return this.get(1);
    }

    public int get(int n) {
        return this.array[n - 1];
    }

    public IntList set(int n, int position) throws IndexOutOfBoundsException {
        if(position <= this.size()) {
            this.array[position] = n;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    public IntList remove() {
        try{
            this.remove(1);
        } catch(IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return this;
    }

    public IntList remove(int position) throws IndexOutOfBoundsException {
        int[] replacer = new int[this.size() - 1];
        position -= 1;
        for(int i = 0; i < replacer.length; i++) {
            if(i < position) {
                replacer[i] = this.array[i];
            } else {
                replacer[i] = this.array[i + 1];
            }
        }
        this.array = replacer;
        return this;
    }

    public int indexOf(int n) {
        int result = -1;
        for(int i = 0; i < this.size(); i++) {
            if(this.array[i] == n) {
                result = this.array[i];
                break;
            }
        }
        return result;
    }

    public IntList clear() {
        this.array = new int[]{};
        return this;
    }

    public int[] toArray() {
        return Arrays.copyOf(this.array, this.array.length);
    }

    public static IntList read() { //TODO stub
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        return new IntList();
    }
	
    public IntList concat(IntList l) { //TODO stub
        int[] replacer = new int[this.size() + l.size()];




        this.array = replacer;
        return this;
    }

    public int size() {
        return this.array.length;
    }

    public IntList show() { // TODO nem ezt kell csinálnia, ez nekem kell.
        for(int n : this.array) {
            System.out.println(n);
        }
        return this;
    }

}