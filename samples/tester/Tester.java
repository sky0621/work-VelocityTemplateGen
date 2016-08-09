package beforeaftercheck;

public class Tester {

	public static void test(String caseName, String before, String after) {

		System.out.println("■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■\t\t■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■");
		System.out.println("■■　" + caseName);
		System.out.println("■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■\t\t■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■　　■■");

		String[] beforeLines = before.split("\n");
		String[] afterLines = after.split("\n");
		int beforeLen = beforeLines.length;
		int afterLen = afterLines.length;
		int length = beforeLen > afterLen ? beforeLen : afterLen;
		for (int i = 0; i < length; i++) {
			String bef = i < beforeLen ? beforeLines[i] : "";
			String aft = i < afterLen ? afterLines[i] : "";
			if (bef == null && aft == null) {
				System.out.println(" ");
				continue;
			}
			if (bef == null)
				bef = "<null>";
			if (aft == null)
				aft = "<null>";

			bef = bef.replace("\n", "").replace("\t", "").replace("\r", "");
			aft = aft.replace("\n", "").replace("\t", "").replace("\r", "");

			System.out.println(bef + "\t\t" + aft);
		}

	}

}
