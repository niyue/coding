package com.niyue.coding.misc.recentuniquechar;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 *  Basically, it is a knock off of LinkedHashSet in JDK with iteration order changed from insertion order to reversed insertion order so that the last inserted element will be iterated first
 */
public class ReversedIteratingLinkedHashSet<E> implements Set<E>, Iterable<E> {
	private Map<E, LinkedNode<E>> map = new HashMap<E, LinkedNode<E>>();
	private LinkedNode<E> head;
	private LinkedNode<E> tail;
	
	private static class LinkedNode<E> {
		private E value;
		private LinkedNode<E> prev;
		private LinkedNode<E> next;
	}
	
	private static class ReverseLinkedNodeIterator<E> implements Iterator<E> {
		private LinkedNode<E> cursor;
		
		public ReverseLinkedNodeIterator(LinkedNode<E> tail) {
			this.cursor = tail;
		}
		
		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public E next() {
			if(hasNext()) {
				E next = cursor.value;
				cursor = cursor.prev;
				return next;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new ReverseLinkedNodeIterator<E>(tail);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
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
		boolean added = false;
		if(!contains(e)) {
			LinkedNode<E> newNode = new LinkedNode<E>();
			newNode.value = e;
			if(tail != null) {
				tail.next = newNode;
			}
			newNode.prev = tail;
			tail = newNode;
			if(map.isEmpty()) {
				head = newNode;
			}
			map.put(e, newNode);
			added = true;
		}
		return added;
	}

	@Override
	public boolean remove(Object o) {
		boolean removed = false;
		if(contains(o)) {
			LinkedNode<E> node = map.get(o);
			if(node == tail) {
				tail = node.prev;
			}
			if(node == head) {
				head = node.next;
			} else {
				node.prev.next = node.next;
			}
			if(node.next != null) {
				node.next.prev = node.prev;
			}
			map.remove(o);
			removed = true;
		}
		return removed;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}
}
