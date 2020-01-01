import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
 * See under doc/index.html for the API of methods.  
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence,
	 * with initial term 'start' and common difference 'diff'.  
	 * You can assume that n is non-negative (larger than or equal to 0).
	 * e.g., arithmeticArray(2, 3, 5) returns an array {2, 5, 8, 11, 14}.
	 * @param start the first term in an arithmetic sequence
	 * @param diff the common difference between terms in an arithmetic sequence
	 * @param n the first n numbers in an arithmetic sequence 
	 * @return an array representing the first n numbers in the specified arithmetic sequence
	 * 
	 * <b>You are forbidden to use the arithmeticList method below to solve this problem.</b> 
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		if (n == 0) {
			int[] seq = new int[0];
			return seq;
		}
		else if(n == 1) {
			int[] seq = { start };
			return seq;
		}
		else {
			int[] seq = new int[n];
			seq[0] = start;
			arithmeticArrayHelper(1, diff, seq);
			return seq;
		}
	}
	
	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence 
	 * @param seq a partially filled arithmetic sequence
	 *  
	 * Each recursive call to this helper method stores at index `i` of the resulting
	 * arithmetic sequence `seq`, which is assumed to have been partially filled at indices 0, 1, ..., i - 1. 
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		if(i < seq.length) {
			seq[i] = seq[i - 1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
		}
	}
	
	/**
	 * Return a list storing the first n numbers in an arithmetic sequence,
	 * with initial term 'start' and common difference 'diff'.  
	 * You can assume that n is non-negative (larger than or equal to 0).
	 * e.g., arithmeticList(2, 3, 5) returns a list {2, 5, 8, 11, 14}.
	 * @param start the first term in an arithmetic sequence
	 * @param diff the common difference between terms in an arithmetic sequence
	 * @param n the first n numbers in an arithmetic sequence 
	 * @return a list representing the first n numbers in the specified arithmetic sequence
	 * 
	 * <b>You are forbidden to use the arithmeticArray method above to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		else if(n == 1) {
			ArrayList<Integer> seq = new ArrayList<Integer>();
			seq.add(start);
			return seq;
		}
		else {
			ArrayList<Integer> seq = new ArrayList<>();
			seq.add(start);
			arithmeticListHelper(1, diff, seq, n);
			return seq;
		}
	}
	
	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence 
	 * @param seq a partially filled arithmetic sequence
	 * @param n size of the arithmetic sequence to be built eventually
	 *  
	 * Each recursive call to this helper method stores at index `i` of the resulting
	 * arithmetic sequence `seq`, which is assumed to have been partially filled at indices 0, 1, ..., i - 1. 
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		if(i < n) {
			seq.add(seq.get(i - 1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
		}
	}
	
	/**
	 * Return whether or not an array represents the first n numbers of an arithmetic sequence.
	 * An arithmetic sequence has a common difference between every two adjacent terms.   
	 * The array may or may not be empty.
	 * e.g., isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1, 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false otherwise.
	 * 
	 * <b>You are forbidden to use the isArithmeticList method below to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isArithmeticArray(int[] a) {
		if(a.length <= 2) {
			return true;
		}
		else {
			return 
				isArithmeticArrayHelper(2, a[1] - a[0], a);
		}
	}
	
	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i position in `seq`, starting from which the remaining sub-sequence is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1, ..., a.length - 1 is an arithmetic sequence
	 *  
	 * Each recursive call to this helper method considers if elements of `a` at indices `i - 1` and `i`
	 * make two valid adjacent elements in the arithmetic sequence, 
	 * i.e., their difference is equal to the common difference `diff`. 
	 * Also, it considers if the remaining sub-sequence (indices i + 1, i + 2, ..., a.length - 1) 
	 * is an arithmetic sequence with common difference `diff`. 
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		if(i < a.length) {
			return 
					a[i] - a[i - 1] == diff
					&&
					isArithmeticArrayHelper(i + 1, diff, a);
		}
		else {
			return true;
		}
	}
	
	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic sequence.
	 * An arithmetic sequence has a common difference between every two adjacent terms.   
	 * The list may or may not be empty.
	 * e.g., isArithmeticList({1, 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false otherwise.
	 * 
	 * <b>You are forbidden to use the isArithmeticArray method above to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		if(l.size() <= 2) {
			return true;
		}
		else {
			return 
				isArithmeticListHelper(2, l.get(1) - l.get(0), l);
		}
	}
	
	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i position in `seq`, starting from which the remaining sub-sequence is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence 
	 * @param l a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1, ..., l.size() - 1 is an arithmetic sequence
	 *  
	 * Each recursive call to this helper method considers if elements of `l` at indices `i - 1` and `i`
	 * make two valid adjacent elements in the arithmetic sequence, 
	 * i.e., their difference is equal to the common difference `diff`. 
	 * Also, it considers if the remaining sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) 
	 * is an arithmetic sequence with common difference `diff`. 
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		if(i < l.size()) {
			return 
					l.get(i) - l.get(i - 1) == diff
					&&
					isArithmeticListHelper(i + 1, diff, l);
		}
		else {
			return true;
		}
	}
	
	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of array a and integer i.
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * <b>You are forbidden to use the insertIntoSortedList method below to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] newSortedArray = new int[a.length + 1];
		if(a.length == 0) {
			newSortedArray[0] = i;
		}
		else {
			insertIntoSortedArrayHelper(a, i, newSortedArray, 0, false);
		}
		return newSortedArray;
	}
	
	
	private void insertIntoSortedArrayHelper(int[] a, int i, int[] na, int current, boolean inserted) {
		if(current == a.length - 1) {
			if(inserted) {
				na[current + 1] = a[current];
			}
			else {
				if(a[current] <= i) {
					na[current] = a[current];
					na[current + 1] = i;
				}
				else {
					na[current] = i;
					na[current + 1] = a[current];
				}
			}
		}
		else {
			if(inserted) {
				na[current + 1] = a[current];
				insertIntoSortedArrayHelper(a, i, na, current + 1, inserted);
			}
			else {
				if(a[current] <= i) {
					na[current] = a[current];
					insertIntoSortedArrayHelper(a, i, na, current + 1, inserted);
				}
				else {
					na[current] = i;
					insertIntoSortedArrayHelper(a, i, na, current, true);
				}
			}
		}
	}
	
	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * @param list a list that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of the input list and integer i.
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * <b>You are forbidden to use the insertIntoSortedArray method above to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		ArrayList<Integer> newSortedList= new ArrayList<>();
		if(list.size()== 0) {
			newSortedList.add(i);
		}
		else {
			insertIntoSortedListHelper(list, i, newSortedList, 0, false);
		}
		return newSortedList;
	}
	
	private void insertIntoSortedListHelper(List<Integer> list, int i, List<Integer> nl, int current, boolean inserted) {
		if(current == list.size() - 1) {
			if(inserted) {
				nl.add(list.get(current));
			}
			else {
				if(list.get(current) <= i) {
					nl.add(list.get(current));
					nl.add(i);
				}
				else {
					nl.add(i);
					nl.add(list.get(current));
				}
			}
		}
		else {
			if(inserted) {
				nl.add(list.get(current));
				insertIntoSortedListHelper(list, i, nl, current + 1, inserted);
			}
			else {
				if(list.get(current) <= i) {
					nl.add(list.get(current));
					insertIntoSortedListHelper(list, i, nl, current + 1, inserted);
				}
				else {
					nl.add(i);
					insertIntoSortedListHelper(list, i, nl, current, true);
				}
			}
		}
	}
	
	/**
	 * Given two sorted arrays left and right, 
	 * where left is sorted in a non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a non-descending order, 
	 * consisting of all elements of arrays left and right.
	 * @param left an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all elements of arrays left and right.
	 * e.g., mergeSortedArraysV2({1, 3, 5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * <b>You are forbidden to use the mergeSortedListsV2 method below to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		int[] merge = new int[left.length + right.length];
		mergeSortedArraysHelper(left, right, 0, right.length - 1, merge, 0);
		return merge;
	}
	
	private void mergeSortedArraysHelper(int[] left, int[] right, int L, int R, int[] merge, int current) {
		if(L < left.length || R >= 0) {
			if(L < left.length && R >= 0) {
				if(left[L] <= right[R]) {
					merge[current] = left[L];
					mergeSortedArraysHelper(left, right, L + 1, R, merge, current + 1);
				}
				else {
					merge[current] = right[R];
					mergeSortedArraysHelper(left, right, L, R - 1, merge, current + 1);
				}
			}
			else { /* L >= left.length || R < 0 */
				if(L >= left.length) {
					merge[current] = right[R];
					mergeSortedArraysHelper(left, right, L, R - 1, merge, current + 1);
				}
				else { /* R >= right.length */
					merge[current] = left[L];
					mergeSortedArraysHelper(left, right, L + 1, R, merge, current + 1);
				}
			}
		}
		else {
			/* L >= left.length && R >= right.length
			 * --> DONE!  
			 */
		}
	}
	
	/**
	 * Given two sorted lists left and right, 
	 * where left is sorted in a non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending order, 
	 * consisting of all elements of lists left and right.
	 * @param left a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all elements of lists left and right.
	 * e.g., mergeSortedListsV2({1, 3, 5, 7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * <b>You are forbidden to use the mergeSortedArraysV2 method above to solve this problem.</b>
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> merge = new ArrayList<>();
		mergeSortedListsHelper(left, right, 0, right.size() - 1, merge);
		return merge;
	}
	
	private void mergeSortedListsHelper(List<Integer> left, List<Integer> right, int L, int R, List<Integer> merge) {
		if(L < left.size() || R >= 0) {
			if(L < left.size() && R >= 0) {
				if(left.get(L) <= right.get(R)) {
					merge.add(left.get(L));
					mergeSortedListsHelper(left, right, L + 1, R, merge);
				}
				else {
					merge.add(right.get(R));
					mergeSortedListsHelper(left, right, L, R - 1, merge);
				}
			}
			else { /* L >= left.length || R < 0 */
				if(L >= left.size()) {
					merge.add(right.get(R));
					mergeSortedListsHelper(left, right, L, R - 1, merge);
				}
				else { /* R >= right.length */
					merge.add(left.get(L));
					mergeSortedListsHelper(left, right, L + 1, R, merge);
				}
			}
		}
		else {
			/* L >= left.length && R >= right.length
			 * --> DONE!  
			 */
		}
	}
}