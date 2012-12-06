import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TraktorTest {

	Traktor traktor;
	DieselTraktor dtraktor;
	GasTraktor gtraktor;
	IFunktion funktion;
	Drillmaschine drillmaschiene;
	Duengestreuer duengestreuer;
	
	@Before
	public void init(){
		
		dtraktor = new DieselTraktor();		
		gtraktor = new GasTraktor();
		
		drillmaschiene = new Drillmaschine(5);
		duengestreuer = new Duengestreuer(2.2);
		
		dtraktor.setFunktion(drillmaschiene);
		gtraktor.setFunktion(duengestreuer);
	}

	@Test
	public void testInterchangeabilityOfTraktor(){
		
		traktor = dtraktor;	
		assertEquals(traktor.toString(), "DieselTraktor");
		
		traktor = gtraktor;
		assertEquals(traktor.toString(), "GasTraktor");			
	}
	
	@Test
	public void testInterchangeabilityOfIFunktion(){
		
		traktor = dtraktor;		
		assertEquals(traktor.getFunktion().toString(), "Drillmaschine");
		traktor.setFunktion(duengestreuer);
		assertEquals(traktor.getFunktion().toString(), "Duengestreuer");
		
		gtraktor.setFunktion(drillmaschiene);
		traktor = gtraktor;
		assertEquals(traktor.getFunktion().toString(), "Drillmaschine");
		traktor.setFunktion(duengestreuer);
		assertEquals(traktor.getFunktion().toString(), "Duengestreuer");		
	}
	
	@Test
	public void testIDisUnique(){
		Traktor gt1 = new GasTraktor();
		Traktor gt2 = new GasTraktor();
		Traktor dt1 = new DieselTraktor();
		Traktor dt2 = new DieselTraktor();
		Traktor gt3 = new GasTraktor();
		Traktor dt3 = new DieselTraktor();
		
		assertEquals(gt2.getID(), gt1.getID()+1);
		assertEquals(dt1.getID(), gt2.getID()+1);
		assertEquals(dt2.getID(), dt1.getID()+1);
		assertEquals(gt3.getID(), dt2.getID()+1);
		assertEquals(dt3.getID(), gt3.getID()+1);	
	}
}
