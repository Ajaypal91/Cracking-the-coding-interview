package ood.hashMap;

import java.util.LinkedList;

public class Hash<K,V> {

	final int MAX_ITEMS = 20;
	LinkedList<Cell<K,V>>[] items;
	
	@SuppressWarnings("unchecked")
	public Hash() {
		items = (LinkedList<Cell<K,V>>[]) new LinkedList[MAX_ITEMS];
	}
	
	public int getHashCode(K key) {
		return key.hashCode()%MAX_ITEMS;
	}
	
	public void put(K k, V v) {
		int loc = getHashCode(k);
		if (items[loc] == null) {
			items[loc] = new LinkedList<>();
		}
		
		LinkedList<Cell<K,V>> item = items[loc];
		
		for(Cell<K,V> c : item) {
			if (c.isEquivalent(k)) {
				item.remove(c);
				break;
			}
		}
		
		item.push(new Cell<K,V>(k, v));
	}
	
	public V get(K k) {
		int loc = getHashCode(k);
		if (items[loc] == null)
			return null;
		
		for(Cell<K,V> c : items[loc]) {
			if(c.isEquivalent(k))
				return c.val;
		}
		return null;
	}
}
