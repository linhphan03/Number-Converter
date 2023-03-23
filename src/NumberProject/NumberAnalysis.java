package NumberProject;

public class NumberAnalysis {
	private String number;
	private Converter convert;
	
	public NumberAnalysis(int number) {
		this.number = ""+number;
		this.convert = new Converter(""+number);
	}
	
	public int getLength() {
		return this.number.length();
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String convertNumber() {
		return this.convert.convertNumber();
	}
}
