package agileJava.ch1;

/**
 * 卒
 * 
 * @author AAA
 * 
 */
public class Pawn {

	private String color;

	public Pawn(){
		this.color="white";
	}
	
	public Pawn(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	public String print(){
		if("white".equals(this.color)){
			return "p";
		}else{
			return "P";
		}
	}
	
}
