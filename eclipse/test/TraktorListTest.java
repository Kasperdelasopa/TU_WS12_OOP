import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

// DIESE KLASS IST NICHT TEIL DER ABGABE!

public class TraktorListTest {

	TraktorList list;
	
	@Before
	public void prepareList() {
		list = new TraktorList();
	}
	
	@Test
	public void addElementAndGetSize() {
		Traktor traktor = new DieselTraktor();
		
		list.add(traktor);
		assertTrue(list.size() == 1);
	}

	@Test
	public void addElementsAndUseIterator() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		ITraktorIterator iterator = list.iterator();
		assertEquals(traktor1, iterator.next());
		assertEquals(traktor2, iterator.next());
		assertEquals(traktor3, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addElementsAndRemoveStartElement() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		ITraktorIterator iterator = list.iterator();
		iterator.next();
		iterator.remove();
		
		assertEquals(list.size(), 2);
		assertEquals(traktor2, iterator.next());
		assertEquals(traktor3, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addElementsAndRemoveMiddleElement() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		ITraktorIterator iterator1 = list.iterator();
		iterator1.next();
		iterator1.next();
		iterator1.remove();
		assertEquals(list.size(), 2);
		
		ITraktorIterator iterator2 = list.iterator();
		assertEquals(traktor1, iterator2.next());
		assertEquals(traktor3, iterator2.next());
		assertFalse(iterator2.hasNext());
	}
	
	@Test
	public void addElementsAndRemoveEndElement() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		ITraktorIterator iterator1 = list.iterator();
		iterator1.next();
		iterator1.next();
		iterator1.next();
		iterator1.remove();
		assertEquals(list.size(), 2);
		
		ITraktorIterator iterator2 = list.iterator();
		assertEquals(traktor1, iterator2.next());
		assertEquals(traktor2, iterator2.next());
		assertFalse(iterator2.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void retrieveFromEmptyList() {
		list.iterator().next();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void deleteFromEmptyList() {
		list.iterator().remove();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void deleteFromListWithoutCallingNext() {
		list.add(new DieselTraktor());
		list.iterator().remove();
	}
		
	@Test
	public void addTraktorenAndGetDieselOnly() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		DieselTraktorList dieselList = list.getDieselTraktoren();
		IDieselTraktorIterator iterator = dieselList.iterator();
		
		assertEquals(dieselList.size(), 2);
		assertEquals(traktor1, iterator.next());
		assertEquals(traktor2, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addTraktorenAndGetGasOnly() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		assertEquals(list.size(), 3);
		
		GasTraktorList gasList = list.getGasTraktoren();
		IGasTraktorIterator iterator = gasList.iterator();
		
		assertEquals(gasList.size(), 1);
		assertEquals(traktor3, iterator.next());
		assertFalse(iterator.hasNext());
	}

	@Test
	public void addTraktorenAndGetDrillmaschinenOnly() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		GasTraktor traktor4 = new GasTraktor();
		
		traktor1.setFunktion(new Drillmaschine(5));
		traktor2.setFunktion(new Duengestreuer(2.8));
		traktor3.setFunktion(new Drillmaschine(6));
		traktor4.setFunktion(new Duengestreuer(10.8));
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		list.add(traktor4);
		assertEquals(list.size(), 4);
		
		TraktorList drillmaschinen = list.getDrillmaschinen();
		ITraktorIterator iterator = drillmaschinen.iterator();
		assertEquals(drillmaschinen.size(), 2);
		assertEquals(traktor1, iterator.next());
		assertEquals(traktor3, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addTraktorenAndGetDuengerstreuerOnly() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		GasTraktor traktor4 = new GasTraktor();
		
		traktor1.setFunktion(new Drillmaschine(7));
		traktor2.setFunktion(new Duengestreuer(3.8));
		traktor3.setFunktion(new Drillmaschine(7));
		traktor4.setFunktion(new Duengestreuer(6.9));
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		list.add(traktor4);
		assertEquals(list.size(), 4);
		
		TraktorList duengerstreuer = list.getDuengerstreuer();
		ITraktorIterator iterator = duengerstreuer.iterator();
		assertEquals(duengerstreuer.size(), 2);
		assertEquals(traktor2, iterator.next());
		assertEquals(traktor4, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addTraktorenAndRemoveAll() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		
		ITraktorIterator iterator = list.iterator();
		
		assertEquals(traktor1, iterator.next());
		iterator.remove();
		assertTrue(list.size() == 2);
		
		assertEquals(traktor2, iterator.next());
		iterator.remove();
		assertTrue(list.size() == 1);
		
		assertEquals(traktor3, iterator.next());
		iterator.remove();
		assertTrue(list.size() == 0);
		
		assertFalse(iterator.hasNext());
		
		// request new iterator and test again
		iterator = list.iterator();
		assertFalse(iterator.hasNext());
	}
}