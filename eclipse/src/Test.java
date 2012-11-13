
// Auf Grund der Transitivitaet sind die Klassen
// * AbstractCompositePict
// * Box
// * ClearBox
// * DarkBox
// * FreeBox
// * Repeated
// * Scaled
// Untertypen von Pict.
//
// Die Klassen
// * Scaled
// * Repeated
// sind Untertypen von AbstractCompositePict.
// 
// Die Klassen
// * ClearBox
// * DarkBox
// sind Untertypen von Box.
//
// Sonst kommen keine Untertypenbeziehungen vor, da folgende Bedingung 
// verletzt waere:
// > Fuer jede Variable in T gibt es eine entsprechende Variable in U, 
// > wobei U die deklarierten Typen der Variablen aequivalent sind.
// (siehe UML-Klassendiagramm 
// > https://github.com/Kasperdelasopa/TU_WS12_OOP/raw/master/doc/UE4/uml_diagram.pdf
// )
//
// Es kommen keine Aequivalenzen vor, d.h. fuer alle Typen T
// und deren jeweilige Untertypen U gilt: T ist kein Untertyp von U.
//

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
		System.out.println("FreeBox fb: Text:'123456\\n123456\\n123456' ");
		System.out.println("hoehe = 3; breite = 6;");
		FreeBox fb = new FreeBox("123456\n123456\n123456");	
		System.out.println(fb.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fb: scale(0.2)  -> hoehe=1; breite=2;");
		fb.scale(0.2);
		System.out.println(fb.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fb: scale(6.8)  -> hoehe=5; breite=9;");
		fb.scale(6.8);
		System.out.println(fb.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fx: Text:'1234\\n5678' ");
		System.out.println("hoehe = 2; breite = 4;");
		FreeBox fx = new FreeBox("1234\n5678");	
		System.out.println(fx.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fx: scale(1.5)  -> hoehe=3; breite=6;");
		fx.scale(1.5);
		System.out.println(fx.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fx: scale(3.5)  -> hoehe=7; breite=14;");
		fx.scale(2.3);
		System.out.println(fx.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("FreeBox fx: scale(0.15)  -> hoehe=2; breite=3;");
		fx.scale(0.15);
		System.out.println(fx.toString());
		System.out.println("*********************************************************");
		
		
		
		// NOTE: Tests for DarkBox start here
		
		System.out.println("*********************************************************");
		System.out.println("DarkBox: hoehe = 5.1; breite = 3.9; zeichen='#' ");
		DarkBox db = new DarkBox('#' , 5.1, 3.9);	
		System.out.println(db.toString());
		System.out.println("*********************************************************");
		
		// NOTE: Tests for Scaled start here
		Box scBox1 = new Box(2.0, 2.0, 'o', '.' );
		FreeBox scBox2 = new FreeBox("Hallo\nWelt!");
		ClearBox scBox3 = new ClearBox(3.0, 3.0);
		DarkBox scBox4 = new DarkBox('T', 4.0, 5.0);
		Pict[][] scArray1 = { {scBox1, scBox2}, {scBox1, scBox2}, {scBox3, scBox4} };
		Scaled<Pict> scaled = new Scaled<Pict>(scArray1);

		System.out.println("*********************************************************");
		System.out.println("Scaled with multiple sub-types of Pict");
		System.out.println(scaled.toString());
		System.out.println("*********************************************************");

		System.out.println("*********************************************************");
		System.out.println("Scaled with multiple sub-types of Pict");
		System.out.println("scale(2.3)");
		scaled.scale(2.3);
		System.out.println(scaled.toString());
		System.out.println("*********************************************************");

		System.out.println("*********************************************************");
		System.out.println("Scaled with multiple sub-types of Pict");
		System.out.println("scale(0.3)");
		scaled.scale(0.3);
		System.out.println(scaled.toString());
		System.out.println("*********************************************************");
		
		// NOTE Test for type Repeated start here
		Box repBox1 = new Box(2.0, 2.0, 'o', '.' );
		FreeBox repBox2 = new FreeBox("Hallo\nWelt!");
		ClearBox repBox3 = new ClearBox(3.0, 3.0);
		DarkBox repBox4 = new DarkBox('T', 4.0, 5.0);
		Pict[][] repArray1 = { {repBox1, repBox2}, {repBox1, repBox2}, {repBox3, repBox4} };
		Repeated<Pict> repeated1 = new Repeated<Pict>(repArray1);
		
		System.out.println("*********************************************************");
		System.out.println("Repeated with multiple sub-types of Pict");
		System.out.println(repeated1.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Repeated");
		System.out.println("scale(0.5)");
		repeated1.scale(0.5);
		System.out.println(repeated1.toString());
		System.out.println("*********************************************************");
		
		System.out.println("*********************************************************");
		System.out.println("Repeated");
		System.out.println("scale(5.4)");
		repeated1.scale(5.4);
		System.out.println(repeated1.toString());
		System.out.println("*********************************************************");
		
		Integer[][] intArray = { {2,3,5},{4,9,1},{6,0,1} };
		Repeated<Integer> repeated2 = new Repeated<Integer> (intArray);
		
		System.out.println("*********************************************************");
		System.out.println("Repeated: Integer array { {2,3,5},{4,9,1},{6,0,1} }");
		System.out.println("scale(5.4)");
		repeated2.scale(5.4);
		System.out.println(repeated2.toString());
		System.out.println("*********************************************************");
		
		Character[][] charArray = { {'a','b'},{'b','c'},{'c','d'} };
		Repeated<Character> repeated3 = new Repeated<Character> (charArray);
		
		System.out.println("*********************************************************");
		System.out.println("Repeated: Character array { {'a','b'},{'b','c'},{'c','d'} }");
		System.out.println(repeated3.toString());
		System.out.println("*********************************************************");
	
	}
}
