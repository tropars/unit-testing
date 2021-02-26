package fr.uga.erods.datastruct;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnsortedListTest<K> {
	UnsortedList<Integer> list;
	
	
	@Before
	public void setUp() throws Exception {
		list= new MyUnsortedList<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void construcFromCollection() throws Exception{
		UnsortedList<Integer> myList=new MyUnsortedList<Integer>(Arrays.asList(6,5,4,3));

                // this is a simple test with integers
		list.append(6);
		list.append(5);
		list.append(4);
		list.append(3);
		
		assertEquals("list created based on collection", list, myList);
	}
	
	@Test
	public void testCountEmpty() throws Exception{
		assertEquals("Empty after new List",0,list.size());
		list.append(2);
		assertEquals("Not Empty after add",1,list.size());
		list.pop();
		assertEquals("Empty after Add+Remove",0,list.size());		
		
	}
	
	@Test(expected=EmptyListException.class)
	public void popOnEmpty() throws Exception{
		list.pop();
	}

	@Test
	public void getSize() throws Exception{
		list.append(2);
		list.append(3);
		list.append(4);
		assertEquals("count after append",3,list.size());
		
		list.pop();
		assertEquals("count after pop",2,list.size());
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void insertIndexTooBig() throws Exception{
		list.insert(2, 1);
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void insertIndexTooSmall() throws Exception{
		list.insert(2, -1);
	}


	@Test
	public void insert() throws Exception{
		list.append(1);
		list.append(2);
		
		list.insert(3,1);
		
		assertEquals("insert in the middle", new MyUnsortedList<Integer>(Arrays.asList(1,3,2)),list);
	}

	@Test
	public void insertFirst() throws Exception{
		list.append(1);
		list.append(2);
		
		list.insert(3,0);
		
		assertEquals("insert fist pos", new MyUnsortedList<Integer>(Arrays.asList(3,1,2)),list);
	}
	
	@Test
	public void insertLast() throws Exception{
		list.append(1);
		list.append(2);
		
		list.insert(3,2);
		
		assertEquals("insert last pos", new MyUnsortedList<Integer>(Arrays.asList(1,2,3)),list);
	}


	@Test
	public void removeFirst() throws Exception{
		list.append(1);
		list.append(2);
		list.append(3);
		
		assertEquals("remove first", new Integer(1), list.remove(0));
	}
	
	@Test
	public void removeLast() throws Exception{
		list.append(1);
		list.append(2);
		list.append(3);
		
		assertEquals("remove first", new Integer(3), list.remove(2));
	}

    @Test(expected=EmptyListException.class)
    public void popOnNonEmpty() throws Exception{
        //        list.append(1);
        list.pop();
    }

    
}
