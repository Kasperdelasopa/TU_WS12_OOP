import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


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

		
		/**
		 * Ausgabe der Anotations
		 */
		/*
		Class[] classes = new Class[]{Bauernhof.class};
		for(Class c : classes){
			System.out.println("The Class <<"+c.getName()+">> was written by "+c.get.class.getAnnotation(Guarantor.class).person());
			
			for(Method m : c.getMethods()){
				System.out.println("  The Method <"+m.getName()+"> in Class <<"+c.getName()+">> was written by "+m.getAnnotation(Guarantor.class).person());
			}
		}*/
		
		for(Traktor t : getSubset(GasTraktor.class, Drillmaschine.class) ){
			System.out.println(t.toString()+";"+t.getFunktion().toString());
		}
	}
	
	private static List<Traktor> getSubset(Class traktor, Class funktion){
		
		List<Traktor> t = new ArrayList<Traktor>();
		
		for(Traktor tr : traktoren){
			if(traktor.isInstance(tr) && funktion.isInstance(tr.getFunktion()))
				t.add(tr);	
		}
		
		return t;
		
	}
}