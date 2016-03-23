package fr.uga.erods.datastruct;

import java.util.Collection;

public class MyUnsortedList<K> implements UnsortedList<K>{
	
	private UnsortedItem<K> head;
	private int itemCount;
	
	
	public MyUnsortedList(){
		head=new UnsortedItem<K>(null);
		itemCount=0;
	}
	
	public MyUnsortedList(Collection<K> c){
		head=new UnsortedItem<K>(null);
		itemCount=0;
		
		for(K item: c){
			append(item);
		}
		
	}
	
	private UnsortedItem<K> get(int index){
		
		if(index <0 || index >= this.getSize()){
			return null;
		}
		
		UnsortedItem<K> item=head.getNext();
		
		for(int i=0; i<index; i++){
			item=item.getNext();
		}
		
		return item;
		
	}
	
	
	public boolean equals(Object o){
		if(o instanceof MyUnsortedList<?>){
			MyUnsortedList<?> list=(MyUnsortedList<?>) o;
			
			if(list.getSize() == this.getSize()){
								
				for(int i=0; i<list.getSize(); i++){
					if(!list.get(i).getItem().equals(this.get(i).getItem())){
						return false;
					}
				}
				
				return true;
			}
		}
		return false;
	}

	public void append(K item){
		UnsortedItem<K> last=head;
		
		while(last.getNext() !=null){
			last=last.getNext();
		}
		last.setNext(new UnsortedItem<K>(item));
		itemCount++;
	}
	
	public int getSize(){
		return itemCount;
	}
	
	public K pop() throws EmptyListException{
		if(itemCount == 0){
			throw new EmptyListException();
		}
		else{
			
			UnsortedItem<K> item=head.getNext();
			head.setNext(item.getNext());
			itemCount--;
			return item.getItem();
		}
	}
	
	public void insert(K val, int pos) throws IndexOutOfBoundsException{
		if(pos>itemCount || pos <0){
			throw new IndexOutOfBoundsException();
		}
		else{
			UnsortedItem<K> previous=head;
			for(int i=0; i<pos;i++){
				previous=previous.getNext();
			}
			UnsortedItem<K> item=new UnsortedItem<K>(val);
			item.setNext(previous.getNext());
			previous.setNext(item);
			itemCount++;
		}
	}
	
	public K remove(int pos) throws IndexOutOfBoundsException{
		if(pos>itemCount || pos <0){
			throw new IndexOutOfBoundsException();
		}
		else{
			UnsortedItem<K> previous=head;
			for(int i=0; i<pos;i++){
				previous=previous.getNext();
			}
			UnsortedItem<K> item=previous.getNext();
			previous.setNext(item.getNext());
			itemCount--;
			return item.getItem();
		}
	}

	@Override
	public boolean isEmpty() {
		return getSize()==0;
	}

	@Override
	public int size() {
		return getSize();
	}
	
}
