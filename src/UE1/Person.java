package UE1;

public class Person {
	
	private String name;
	private String tele;
	private int nummer;
	
	public Person(Integer num, String name, String tele){
		setName(name);
		setTele(tele);
		setNummer(num);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
	
	public int getNummer() {
		return nummer;
	}


	public void setNummer(int nummer) {

		this.nummer = nummer;
	}
}
