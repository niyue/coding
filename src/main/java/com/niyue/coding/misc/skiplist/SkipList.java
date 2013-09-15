package com.niyue.coding.misc.skiplist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * http://en.literateprograms.org/Skip_list_(Java)
 * http://courses.csail.mit.edu/6.046/spring04/handouts/skiplists.pdf
 * http://www.csee.umbc.edu/courses/undergraduate/341/fall01/Lectures/SkipLists/skip_lists/skip_lists.html
 * http://en.wikipedia.org/wiki/Skip_list
 * 
 * There is still some implementation issue making some tests failed randomly.
 */
public class SkipList<E extends Comparable<E>> implements Set<E> {
	private static final double P = 0.5;
	private Random rand = new Random();
	
	private int size = 0;
	private ListNode<E> head;
	private int level = 0;
	private final static int MAX_LEVEL = 32;
	
	public SkipList() {
		head = new ListNode<E>(null, MAX_LEVEL);
	}
	
	private boolean higherLevel(double p) {
		return rand.nextDouble() <= p;
	}
	
	private int randomLevel() {
		int level = 0;
		for(double p = P; higherLevel(p); p *= P) {
			level++;
		}
		return Math.min(MAX_LEVEL, level);
	}
	
	private static class ListNode<E> {
		public E value;
		public List<ListNode<E>> next;
		public ListNode(E value, int level) {
			this.value = value;
			next = new ArrayList<ListNode<E>>(Collections.<ListNode<E>>nCopies(level + 1, null));
		}
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
		for(int l = level; l >= 0; l--) {
			while(current.next.get(level) != null && current.next.get(level).value.compareTo(v) < 0) {
				current = current.next.get(level);
			}
		}
		current = current.next.get(0);
		
		return current;
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
		assert e != null;
		ListNode<E> current = head;
		List<ListNode<E>> updatedNodes = new ArrayList<ListNode<E>>(Collections.<ListNode<E>>nCopies(MAX_LEVEL + 1, null));
		
		for(int l = level; l >= 0; l--) {
			while(current.next.get(level) != null && current.next.get(level).value.compareTo(e) < 0) {
				current = current.next.get(level);
			}
			updatedNodes.set(l, current);
		}
		current = current.next.get(0);
		
		boolean added = false;
		if(current == null || current.value.compareTo(e) != 0) {
			int newLevel = randomLevel();
			if(newLevel > level) {
				for(int l = level + 1; l <= newLevel; l++) {
					updatedNodes.set(l, head);
				}
				level = newLevel;
			}
			
			ListNode<E> newNode = new ListNode<E>(e, newLevel);
			for(int l = 0; l <= newLevel; l++) {
				newNode.next.set(l, updatedNodes.get(l).next.get(l));
				updatedNodes.get(l).next.set(l, newNode);
			}
			size++;
		}
		
		return added;
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
		head = new ListNode<E>(null, MAX_LEVEL);
		size = 0;
		level = 0;
	}

}
