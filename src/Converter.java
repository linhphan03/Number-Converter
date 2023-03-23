import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Converter {
	private HashMap<Integer, String> digitMap = new HashMap<Integer, String>();
	private HashMap<Integer, String> indexMap = new HashMap<Integer, String>();
	private HashMap<Integer, String> packIndex = new HashMap<Integer, String>();

	private String number;
	

	public Converter(String number) {
		this.number = number;
		mapDigit();
		mapReversedIndexOfDigit();
		mapPackIndex();
	}

	public void mapDigit() {
		this.digitMap.put(0, "không");
		this.digitMap.put(1, "một");
		this.digitMap.put(2, "hai");
		this.digitMap.put(3, "ba");
		this.digitMap.put(4, "bốn");
		this.digitMap.put(5, "năm");
		this.digitMap.put(6, "sáu");
		this.digitMap.put(7, "bảy");
		this.digitMap.put(8, "tám");
		this.digitMap.put(9, "chín");
	}
		
	public void mapReversedIndexOfDigit() {
		this.indexMap.put(0,"");
		this.indexMap.put(1,"mươi");
		this.indexMap.put(2,"trăm");
	}
	
	public void mapPackIndex() {
		this.packIndex.put(0,"");
		this.packIndex.put(1,"nghìn");
		this.packIndex.put(2,"triệu");
		this.packIndex.put(3,"tỷ");	
	}
	
	public int getLength() {
		return this.number.length();
	}
	
	//Convert group of <= 3 digits
	public String getGroup3Converted(String group3Digits) {
		Converter num3Digits = new Converter(group3Digits);
		ArrayList<String> parts = new ArrayList<String>();
		int length = num3Digits.getLength();
		
		int firstDigit = length > 2 ? Integer.parseInt(num3Digits.number.charAt(length-3)+"") : 0;
		int secondDigit = length > 1 ? Integer.parseInt(num3Digits.number.charAt(length-2)+"") : 0;
		int lastDigit = length > 0 ? Integer.parseInt(num3Digits.number.charAt(length-1)+"") : 0;
		
		if (length == 3) {
			if (firstDigit == 0 && secondDigit == 0 && lastDigit == 0) {
				//do nothing
			}
			else {
				parts.add(num3Digits.digitMap.get(firstDigit));
				parts.add(num3Digits.indexMap.get(2));
			}
		}
		
		if (length >= 2) {
			if (secondDigit == 0) {
			//x00
				if (lastDigit == 0) {
					//do nothing
				}
				else {
					parts.add("lẻ");
				}
			}
			else if (secondDigit == 1) {
				parts.add("mười");
			}
			else {
				parts.add(num3Digits.digitMap.get(secondDigit));
				parts.add(num3Digits.indexMap.get(1));
			}
		}
		
		if (length >= 1) {
			if (length > 1 && lastDigit == 0) {
				//do nothing
			}
			else if (lastDigit == 1 && length > 1 && secondDigit != 1) {
				parts.add("mốt");
			}
			else if (lastDigit == 5 && length > 1 && secondDigit != 0) {
				parts.add("lăm");
			}
			else {
				parts.add(num3Digits.digitMap.get(lastDigit));
			}
		}
		return String.join(" ", parts);
	}

	public ArrayList<String> split(String string) {
		ArrayList<String> list = new ArrayList<String>();
		int index = string.length();
		while (index > 0) {
			int start = Math.max(0, index - 3);
			list.add(string.substring(start, string.length()));
			string = string.substring(0, start);
			index -= 3;
		}
		Collections.reverse(list);
		return list;
	}
	
	public String convertNumber() {
		ArrayList<String> packs = split(this.number);
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < packs.size(); i++) {
			String group3Converted = this.getGroup3Converted(packs.get(i));
			result.add(group3Converted);
			if (i != packs.size()-1) {
				result.add(this.packIndex.get(packs.size() - i - 1));
			}
		}
		return String.join(" ", result);
	}
}
