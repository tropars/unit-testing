package fr.uga.erods.datastruct;

public class UnsortedItem<K> {

	private K item;
	private UnsortedItem<K> next;
	
	
	public UnsortedItem(K item){
		this.setItem(item);
	}


	public K getItem() {
		return item;
	}


	public void setItem(K item) {
		this.item = item;
	}


	public UnsortedItem<K> getNext() {
		return next;
	}


	public void setNext(UnsortedItem<K> next) {
		this.next = next;
	}
	
	
}
