package com.niyue.coding.misc.skiplist;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/*
 * http://courses.csail.mit.edu/6.046/spring04/handouts/skiplists.pdf
 * http://www.csee.umbc.edu/courses/undergraduate/341/fall01/Lectures/SkipLists/skip_lists/skip_lists.html
 * http://en.wikipedia.org/wiki/Skip_list
 */
public class SkipList<E extends Comparable<E>> implements Set<E> {
	private static final double P = 0.5;
	private Random rand = new Random();
	
	private int size = 0;
	private ListNode<E> head;
	
	public SkipList() {
		head = new ListNode<E>();
	}
	
	private boolean higherLevel() {
		return rand.nextDouble() > P;
	}
	
	private static class ListNode<E> {
		public E value;
		public ListNode<E> prev;
		public ListNode<E> next;
		public ListNode<E> up;
		public ListNode<E> down;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		@SuppressWarnings("unchecked")
		E v = (E) o;
		ListNode<E> targetNode = search(v);
		return targetNode != null && targetNode.value.compareTo(v) == 0;
	}
	
	private ListNode<E> search(E v) {
		ListNode<E> current = head;
		ListNode<E> targetNode = null;
		while(current != null) {
			current = searchAtSameLevel(current, v);
			if(current.value.compareTo(v) == 0) {
				targetNode = current;
				break;
			}
			current = current.down;
		}
		return targetNode;
	}
	
	private ListNode<E> searchAtSameLevel(ListNode<E> node, E v) {
		while(node.next != null && 
			  (node.value == null || node.value.compareTo(v) < 0) && 
			  node.next.value.compareTo(v) < 0) {
			node = node.next;
		}
		return node;
	}

	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(E e) {
		// ListNode<E> targetNode = search(e);
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E v : c) {
			add(v);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object v : c) {
			remove(v);
		}
		return true;
	}

	@Override
	public void clear() {
		head = new ListNode<E>();
		size = 0;
	}

}
