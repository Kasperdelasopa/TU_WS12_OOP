import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Guarantor(person="Alle Gruppenmitglieder")
public class Test {

	static List<Traktor> traktoren = null;
	
	public static void main(String[] args) {
		
		traktoren = new ArrayList<Traktor>();
		
		Dieseltrakor dt = new Dieseltrakor();
		dt.setFunktion(new Drillmaschine());
		traktoren.add(dt);
		GasTraktor gt = new GasTraktor();
		gt.setFunktion(new Duengestreuer());
		traktoren.add(gt);
		
		dt = new Dieseltrakor();
		dt.setFunktion(new Duengestreuer());
		traktoren.add(dt);
		gt = new GasTraktor();
		gt.setFunktion(new Drillmaschine());
		traktoren.add(gt);

		for(Traktor t : getSubset(GasTraktor.class, Drillmaschine.class) ){
			System.out.println(t.toString()+";"+t.getFunktion().toString());
		}
		
		
		/**
		 * Ausgabe der Anotations
		 */
		printInfoForClass(Bauernhof.class);
		printInfoForClass(Dieseltrakor.class);
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
	}
	
	private static List<Traktor> getSubset(Class traktor, Class funktion){
		
		List<Traktor> t = new ArrayList<Traktor>();
		
		for(Traktor tr : traktoren){
			if(traktor.isInstance(tr) && funktion.isInstance(tr.getFunktion()))
				t.add(tr);	
		}
		
		
		
		return t;
		
	}
	
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
}