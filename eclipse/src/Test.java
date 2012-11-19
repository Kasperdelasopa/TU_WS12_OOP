

public class Test {

	public static void main(String[] args) {
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 1-################################################");
		
		OrderedSet<Description> ordered = new OrderedSet<Description>();
		
		ordered.insert(new Description("zeile1\nzeile2\nzeile3\nzeile4\nzeile4"));
		ordered.insert(new Description("1234"));		
		ordered.insert(new Description("xyz\nxyz"));
		ordered.insert(new Description("first\nsecond\nthird"));
		ordered.insert(new Description("abcd"));
		
		for(Description e: ordered)
		{
			System.out.println(e.getLineCount());
		}
		ordered.insert(new Description("abcd"));
		ordered.insert(new Description("abcd"));
		System.out.println("---------------");
		for(Description e: ordered)
		{
			System.out.println(e.getLineCount());
		}
		System.out.println("###############################################################");
		System.out.println("#######-FALL 2-################################################");
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 3-################################################");
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 4-################################################");
	/*	Description desc1 = new Description("abcdefgh");
		Description desc2 = new Description("abcd");
		System.out.println("Desc1:"+desc1.toString());
		System.out.println("Desc2:"+desc2.toString());
		if(desc1.shorter(desc2)) System.out.println("Desc1 is shorter"); else System.out.println("Desc2 is shorter");
		System.out.println("##########################################");
		MeanElapsedTime mean1 = new MeanElapsedTime(2.0);
		mean1.add(6.0);
		mean1.add(2.0);
		mean1.add(2.0);
		MeanElapsedTime mean2 = new MeanElapsedTime(5.0);
		System.out.println("Mean1 highest:"+mean1.getHighestMeasurement() + ", Anzahl: " + mean1.count());
		System.out.println("Mean2 highest:"+mean2.getHighestMeasurement() + ", Anzahl: " + mean2.count());
		if(mean1.shorter(mean2)) System.out.println("Mean1 is lower"); else System.out.println("Mean2 is shorter"); 
		System.out.println("##########################################"); 
		Double [] x1 = {1.0, 2.0, 4.3};
		CompositeTime comp1 = new CompositeTime(x1);
		Double [] x2 = {1.0, 2.0, 4.4};
		CompositeTime comp2 = new CompositeTime(x2);
		System.out.println("Comp1 lowest:"+comp1.getMinimumTime() + ", Anzahl: " + comp1.count());
		System.out.println("Comp2 lowest:"+comp2.getMinimumTime() + ", Anzahl: " + comp2.count());
		if(comp1.shorter(comp2)) System.out.println("Comp1 is lower");else System.out.println("Comp2 is shorter");
		*/
		
	
		 
		
	}

}
