import java.lang.reflect.Method;
import java.lang.reflect.Type;

@Guarantor(person="Alle Gruppenmitglieder")
public class Test {

	public static void main(String[] args) {
		/**
		 * Testfälle
		 */
		
		Traktor t1 = new DieselTraktor();
		t1.addBetriebsstunden(5);
		Bauernhof bauernhof1 = new Bauernhof("Landgut - Bauernhof");
		bauernhof1.addTraktor(t1);
		
		System.out.println("Durchschnitt Betriebsstunden: " + bauernhof1.getAverageBetriebsstunden());
		System.out.println("################");
		/**
		 * Ausgabe der Anotations
		 */
		printInfoForClass(Bauernhof.class);
		printInfoForClass(DieselTraktor.class);
		printInfoForClass(Drillmaschine.class);
		printInfoForClass(Duengestreuer.class);
		printInfoForClass(GasTraktor.class);
		printInfoForClass(Guarantor.class);
		printInfoForClass(IFunktion.class);
		printInfoForClass(Test.class);
		printInfoForClass(Traktor.class);
		
		printInfoForClass(TraktorList.class);
		printInfoForClass(DieselTraktorList.class);
		printInfoForClass(GasTraktorList.class);
		printInfoForClass(BauernhofList.class);
	}
	
	@Guarantor(person="Alle Gruppenmitglieder")
	public static void printInfoForClass(Class c){
		
		Guarantor g1 = ((Guarantor)c.getAnnotation(Guarantor.class));
		if(g1 != null)
			System.out.println("The Class <<"+c.getName()+">> was written by "+g1.person());
		
		for(Method m : c.getMethods()){
			Guarantor g2 = ((Guarantor)m.getAnnotation(Guarantor.class));
			if(g2 != null)
				System.out.println("  The Method <"+m.getName()+"> in Class <<"+c.getName()+">> was written by "+g2.person());
		}
	}
	//prints out the Annotations for classes and methods
	//@param c must not be null
}