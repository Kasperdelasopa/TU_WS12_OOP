
public class Test {

	public static void main(String[] args) {

		System.out.println("*********************************************************");
		System.out.println("Box: hoehe = 2.1; breite = 3.4; rand = 'o'; inhalt = '.' -> muss aufgerundet werden:");
		Box b = new Box(2.1, 3.4, 'o', '.' );	
		System.out.println(b.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Box: hoehe = 2; breite = 2; rand = 'o'; inhalt = '.' -> nur rand ausgeben:");
		b = new Box(2.0, 2.0, 'o', '.' );	
		System.out.println(b.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Box: hoehe = 3; breite = 2; rand = 'o'; inhalt = '.' -> nur rand ausgeben:");
		b = new Box(3.0, 2.0, 'o', '.' );	
		System.out.println(b.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Box: hoehe = 2; breite = 2; rand = 'o'; inhalt = '.'");
		System.out.println("scale(1.5) -> hoehe = 3; breite = 3;");
		b = new Box(2.0, 2.0, 'o', '.' );	
		b.scale(1.5);
		System.out.println(b.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Box: hoehe = 2.5; breite = 2.8; rand = 'o'; inhalt = '.'");
		System.out.println("scale(1.5) -> hoehe = 4; breite = 5;");
		b = new Box(2.5, 2.8, 'o', '.' );	
		b.scale(1.5);
		System.out.println(b.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("ClearBox: hoehe = 4; breite = 4; rand = '*'; inhalt = ' '");
		ClearBox cb = new ClearBox(4.0, 4.0);	
		System.out.println(cb.toString());
		System.out.println("Seitenverhätnis: "+cb.getSeitenverhältniss().toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("ClearBox: hoehe = 3.2; breite = 4.8; rand = '*'; inhalt = ' '");
		cb = new ClearBox(3.2, 4.8);	
		System.out.println(cb.toString());
		System.out.println("Seitenverhätnis: "+cb.getSeitenverhältniss().toString());
		System.out.println("*********************************************************");
		
	}
}
