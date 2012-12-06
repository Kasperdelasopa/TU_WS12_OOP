import static org.junit.Assert.*;

import java.util.Iterator;
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
		
		Iterator<Traktor> iterator = list.iterator();
		
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
		
		Iterator<Traktor> iterator = list.iterator();
		iterator.remove();
		
		assertEquals(traktor2, iterator.next());
		assertEquals(traktor3, iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void addElementsAndRemoveEndElement() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		
		Iterator<Traktor> iterator1 = list.iterator();
		iterator1.next();
		iterator1.next();
		iterator1.remove();
		
		Iterator<Traktor> iterator2 = list.iterator();
		assertEquals(traktor1, iterator2.next());
		assertEquals(traktor2, iterator2.next());
		assertFalse(iterator2.hasNext());
	}
	
	@Test
	public void addElementsAndRemoveMiddleElement() {
		Traktor traktor1 = new DieselTraktor();
		Traktor traktor2 = new DieselTraktor();
		Traktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		
		Iterator<Traktor> iterator1 = list.iterator();
		iterator1.next();
		iterator1.remove();
		
		Iterator<Traktor> iterator2 = list.iterator();
		assertEquals(traktor1, iterator2.next());
		assertEquals(traktor3, iterator2.next());
		assertFalse(iterator2.hasNext());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void retrieveFromEmptyList() {
		list.iterator().next();
	}
	
	@Test
	public void addTraktorenAndGetDieselOnly() {
		DieselTraktor traktor1 = new DieselTraktor();
		DieselTraktor traktor2 = new DieselTraktor();
		GasTraktor traktor3 = new GasTraktor();
		
		list.add(traktor1);
		list.add(traktor2);
		list.add(traktor3);
		
		DieselTraktorList dieselList = list.getDieselTraktoren();
		Iterator<DieselTraktor> iterator = dieselList.iterator();
		
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
		
		GasTraktorList gasList = list.getGasTraktoren();
		Iterator<GasTraktor> iterator = gasList.iterator();
		
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
		
		Iterator<Traktor> iterator = list.getDrillmaschinen().iterator();
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
		
		Iterator<Traktor> iterator = list.getDuengerstreuer().iterator();
		assertEquals(traktor2, iterator.next());
		assertEquals(traktor4, iterator.next());
		assertFalse(iterator.hasNext());
	}
}
