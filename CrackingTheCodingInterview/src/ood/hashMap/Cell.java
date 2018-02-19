package ood.hashMap;

public class Cell<K,V> {

	K key;
	V val;
	
	Cell (K k,V v){
		key = k;
		val = v;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getVal() {
		return val;
	}
	
	public boolean isEquivalent(K k) {
		return k.equals(key);
	}
}
