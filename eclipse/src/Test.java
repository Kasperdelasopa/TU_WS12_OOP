
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Description x = new Description("111\n111");
		 Description xx = new Description("2222");
		 System.out.println(x.toString());
		 System.out.println(xx.toString());	  
		 if(x.shorter(xx)) System.out.println("Shorter");
		
		 ElapsedTime el1 = new ElapsedTime(1.0);
		 ElapsedTime el2 = new ElapsedTime(3.2);
		 if(el1.shorter(el2)) System.out.println("EL1 kleiner");
		 System.out.println(el1.count());
		  */
		 ElapsedTime el1 = new ElapsedTime(1.0);
		 MeanElapsedTime mean1 = new MeanElapsedTime(2.0);
		 mean1.add(9.0);
		 MeanElapsedTime mean2 = new MeanElapsedTime(9.0);
		 if(el1.shorter(mean2)) System.out.println("el1 kleiner");
		 Double [] x = {4.32, 6.0, 10.0};
		 CompositeTime comp1 = new CompositeTime(x);
		 
		 System.out.println("Anzahl: " + comp1.count());
		 System.out.println("Minimum: " + comp1.getMinimumTime());
		 comp1.add(3.2);
		 System.out.println("Anzahl: " + comp1.count());
		 System.out.println("Minimum: " + comp1.getMinimumTime());
		 /*
		 
		 System.out.println("Anzahl: " + mean1.count());
		 System.out.println("Highest: " + mean1.getHighestMeasurement());
		 System.out.println("Mean: " + mean1.getmean());
		 System.out.println("#######################");
		 System.out.println("Anzahl: " + mean2.count());
		 System.out.println("Highest: " + mean2.getHighestMeasurement());
		 System.out.println("Mean: " + mean2.getmean());
		 */
		 
		 
		
	}

}
