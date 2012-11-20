

public class Test {

	public static void main(String[] args) {
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 1-################################################");
		OrderedSet<Description> ordered = new OrderedSet<Description>();
		ordered.insert(new Description("zeile1\nzeile2\nzeile3\nzeile4\nzeile5"));
		ordered.insert(new Description("1234"));		
		ordered.insert(new Description("xyz\nxyz"));
		ordered.insert(new Description("first\nsecond\nthird"));
		ordered.insert(new Description("abcd"));
		
		for(Description e: ordered)
		{
			System.out.println(  e.toString());
			System.out.println("Lines: " +e.getLineCount());
		}
		
		
		System.out.println("--------------after adding more instances");
		ordered.insert(new Description("lin1\nlin2\nlin3\nlin4\nlin5\nlin6\nlin7\nlin8"));
		ordered.insert(new Description("111\222\n333"));
		ordered.insert(new Description("oneline"));
		
		for(Description e: ordered)
		{
			System.out.println( e.toString());
			System.out.println("Zeilen: " +e.getLineCount());
		}
		System.out.println("###############################################################");
		System.out.println("#######-FALL 2-################################################");
		OrderedMap<MeanElapsedTime, CompositeTime> map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		
		Double [] x1 = {1.0, 2.0, 4.3};
		CompositeTime comp1 = new CompositeTime(x1);
		
		/*
		map.insert(new MeanElapsedTime(2.0));
		map.insert(new MeanElapsedTime(1.0));
		map.insert(new MeanElapsedTime(3.0));
		
		MapIterator<MeanElapsedTime, CompositeTime> i = map.iterator();
		i.add(new MeanElapsedTime(2.0));
		System.out.println("X:"+ i.next());
		while(i.hasNext())
		{
			System.out.println("1");
			//map.iterator().add(comp1);
			
		}
		*/
		System.out.println("###############################################################");
		System.out.println("#######-FALL 3-################################################");
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 4-################################################");
		OrderedSet<ElapsedTime> ordset = new OrderedSet<ElapsedTime>();
	
		 
		
	}

}
