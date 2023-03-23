public class Main {
	public static void main(String[]args) {
		System.out.println(new NumberAnalysis(00).convertNumber());
		System.out.println(new NumberAnalysis(5).convertNumber().equals("năm"));
		System.out.println(new NumberAnalysis(20).convertNumber().equals("hai mươi"));
		System.out.println(new NumberAnalysis(25).convertNumber().equals("hai mươi lăm"));
		System.out.println(new NumberAnalysis(100).convertNumber().equals("một trăm"));
		System.out.println(new NumberAnalysis(105).convertNumber().equals("một trăm lẻ năm"));
		System.out.println(new NumberAnalysis(123456789).convertNumber().equals("một trăm hai mươi ba triệu bốn trăm năm mươi sáu nghìn bảy trăm tám mươi chín"));
		System.out.println(new NumberAnalysis(123055789).convertNumber().equals("một trăm hai mươi ba triệu không trăm năm mươi lăm nghìn bảy trăm tám mươi chín"));
		System.out.println(new NumberAnalysis(123051719).convertNumber().equals("một trăm hai mươi ba triệu không trăm năm mươi mốt nghìn bảy trăm mười chín"));
		System.out.println(new NumberAnalysis(123051710).convertNumber().equals("một trăm hai mươi ba triệu không trăm năm mươi mốt nghìn bảy trăm mười"));
		System.out.println(new NumberAnalysis(123051711).convertNumber().equals("một trăm hai mươi ba triệu không trăm năm mươi mốt nghìn bảy trăm mười một"));
		System.out.println(new NumberAnalysis(123051711).convertNumber().equals("một trăm hai mươi ba triệu không trăm năm mươi mốt nghìn bảy trăm mười một"));
		System.out.println(new NumberAnalysis(103055009).convertNumber().equals("một trăm lẻ ba triệu không trăm năm mươi lăm nghìn không trăm lẻ chín"));
		System.out.println(new NumberAnalysis(1123051711).convertNumber().equals("một tỷ một trăm hai mươi ba triệu không trăm năm mươi mốt nghìn bảy trăm mười một"));
	}
}
