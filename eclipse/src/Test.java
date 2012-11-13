
public class Test {

	public static void main(String[] args) {

		// NOTE Tests for Box start here
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
		
		// NOTE tests for ClearBox start here
		System.out.println("*********************************************************");
		System.out.println("ClearBox: hoehe = 4; breite = 4; rand = '*'; inhalt = ' '");
		ClearBox cb = new ClearBox(4.0, 4.0);	
		System.out.println(cb.toString());
		System.out.println("Seitenverhätnis: "+cb.getSeitenverhaeltniss().toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("ClearBox: hoehe = 3.2; breite = 4.8; rand = '*'; inhalt = ' '");
		cb = new ClearBox(3.2, 4.8);	
		System.out.println(cb.toString());
		System.out.println("Seitenverhätnis: "+cb.getSeitenverhaeltniss().toString());
		System.out.println("*********************************************************");
		
		// NOTE: Tests for FreeBox start here
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox: Text:'abcabc\\nabcabc\\nabcabc' ");
		FreeBox fb = new FreeBox("abcabc\nabcabc\nabcabc");	
		System.out.println(fb.toString());
		System.out.println("*********************************************************");
		
		// NOTE: Tests for DarkBox start here
		
		System.out.println("*********************************************************");
		System.out.println("DarkBox: hoehe = 5.1; breite = 3.9; zeichen='#' ");
		DarkBox db = new DarkBox('#' , 5.1, 3.9);	
		System.out.println(db.toString());
		System.out.println("*********************************************************");
		
		// NOTE: Tests for Scaled start here
		Box scaledBox1 = new Box(2.0, 2.0, 'o', '.' );
		Box scaledBox2 = new Box(2.0, 2.0, 'o', '.' );
		Box[][] scaledArray1 = { {scaledBox1}, {scaledBox2} };
		Scaled<Box> scaled1 = new Scaled<Box>(scaledArray1);
		
		ClearBox scClearBox = new ClearBox(3.0, 2.0);
		ClearBox[][] scClearBoxArray = { {scClearBox} };
		Scaled<ClearBox> scaled2 = new Scaled<ClearBox> (scClearBoxArray);
		
		System.out.println("*********************************************************");
		System.out.println("Scaled: [Box  hoehe = 2; breite = 2; rand = 'o'; inhalt = '.'], [Box hoehe = 2; breite = 2; rand = 'o'; inhalt = '.']");
		System.out.println(scaled1.toString());
		System.out.println("*********************************************************");

		System.out.println("*********************************************************");
		System.out.println("Scaled: [Box  hoehe = 2; breite = 2; rand = 'o'; inhalt = '.'], [Box hoehe = 2; breite = 2; rand = 'o'; inhalt = '.']");
		System.out.println("scale(2.3)");
		scaled1.scale(2.3);
		System.out.println(scaled1.toString());
		System.out.println("*********************************************************");

		System.out.println("*********************************************************");
		System.out.println("Scaled: [ClearBox  hoehe = 3; breite = 2]");
		System.out.println("scale(3.0)");
		scaled2.scale(3.0);
		System.out.println(scaled2.toString());
		System.out.println("*********************************************************");
		
		// NOTE Test for type Repeated start here
		
	}
}
