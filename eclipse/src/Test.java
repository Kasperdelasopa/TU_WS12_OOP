

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
		
		System.out.println("=================after adding more instances================");
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
		
		Double [] x1 = {5.0, 1.7, 4.3 , 3.3, 10.3, 2.2};
		
		MeanElapsedTime mean1 =  new MeanElapsedTime(2.0);
		mean1.add(4.3);mean1.add(23.2);mean1.add(3.3);
		MeanElapsedTime mean2 =  new MeanElapsedTime(5.2);
		mean2.add(0.5);mean2.add(1.2);mean2.add(100.3);
		MeanElapsedTime mean3 =  new MeanElapsedTime(4.3);
		mean3.add(0.4);mean3.add(9.2);mean3.add(3.3);
		MeanElapsedTime mean4 =  new MeanElapsedTime(1.0);
		mean4.add(1.4);mean4.add(7.2);mean4.add(3.3);
		
		map.insert(mean1);
		map.insert(mean2);
		map.insert(mean3);
		map.insert(mean4);
		
		
		MapIterator<MeanElapsedTime, CompositeTime> i1 = map.iterator();
		SetIterator<CompositeTime> compIterator;
		while(i1.hasNext()){		
			compIterator = i1.iterator();
			if(compIterator != null) {		
				compIterator.add(new CompositeTime(x1));		
			}
			i1.next();
		}
		
		MapIterator<MeanElapsedTime, CompositeTime> i2 = map.iterator();	
		while(i2.hasNext()){
			SetIterator<CompositeTime> compIterator2 = i2.iterator();
			System.out.println("Highest: " + i2.next().getHighestMeasurement());		
			if(compIterator2 != null) {
				
				System.out.println("ShortestTime: " + compIterator2.next().getMinimumTime());
			}
			System.out.println("--");				
		}
		
		System.out.println("=================after adding more instances================");
		MeanElapsedTime mean5 =  new MeanElapsedTime(0.0);
		mean5.add(0.3);mean5.add(0.2);
		MeanElapsedTime mean6 =  new MeanElapsedTime(50.0);
		mean6.add(50.3);mean6.add(50.0);mean6.add(50.1);mean6.add(5.1);mean6.add(30.1);
		
		map.insert(mean5);
		map.insert(mean6);
		
		MapIterator<MeanElapsedTime, CompositeTime> i3 = map.iterator();
		SetIterator<CompositeTime> compIterator3;
		while(i3.hasNext()){	
			compIterator3 = i3.iterator();
			if(compIterator3 != null) {	
				compIterator3.add(new CompositeTime(x1));				
			}
			i3.next();
		}
		
		MapIterator<MeanElapsedTime, CompositeTime> i4 = map.iterator();	
		while(i4.hasNext()){
			SetIterator<CompositeTime> compIterator4 = i4.iterator();
			System.out.println("Highest: " + i4.next().getHighestMeasurement());			
			if(compIterator4 != null) {		
				System.out.println("ShortestTime: " + compIterator4.next().getMinimumTime());
			}
			System.out.println("--");			
		}
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 3-################################################");
		
		for(MeanElapsedTime e: map)
		{
			System.out.println(  e.getHighestMeasurement());
			
		}
		System.out.println("=================after adding more instances================");
		
		MeanElapsedTime meanx =  new MeanElapsedTime(0.0);
		meanx.add(0.0);meanx.add(0.1);meanx.add(0.0);
		MeanElapsedTime meany =  new MeanElapsedTime(8.8);
		meany.add(45.21);meany.add(10.4);meany.add(1.4);
		
		map.insert(meanx);
		map.insert(meany);
		
		for(MeanElapsedTime e: map)
		{
			System.out.println(  e.getHighestMeasurement());
			
		}
		
		System.out.println("###############################################################");
		System.out.println("#######-FALL 4-################################################");
		OrderedSet<ElapsedTime> ordset = new OrderedSet<ElapsedTime>();
		
		MapIterator<MeanElapsedTime, CompositeTime> ix = map.iterator();	
		while(ix.hasNext()){
			SetIterator<CompositeTime> compIteratorx = ix.iterator();
			if(compIteratorx != null) {  
				if(compIteratorx.hasNext()) ordset.insert(compIteratorx.next());
			}
			ordset.insert(ix.next());
		}
		
		for(ElapsedTime e: ordset){
			System.out.println(e.count());
		}
		
	}

}
