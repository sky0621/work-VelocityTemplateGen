package beforeaftercheck;

import java.util.HashMap;
import java.util.Map;

public class FixChecker {

	protected String beforeCassette;
	protected String afterCassette;

	public FixChecker(String afterCassette) {
		this.afterCassette = afterCassette;
		if (beforeCassetteMap.containsKey(afterCassette)) {
			this.beforeCassette = beforeCassetteMap.get(afterCassette);
		}
		System.out
				.println("●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●\t\t●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●");
		System.out.println("◆　【既存テンプレート】" + beforeCassette + "　◆\t\t◆　【新規テンプレート】" + afterCassette
				+ "　◆");
		System.out
				.println("●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●\t\t●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●　●");
	}

	protected void test(String caseName, Object bean, Map<String, Object> dataMap) {
		Tester.test(caseName, Before.exec(beforeCassette, dataMap), After.exec(afterCassette, bean));
	}

	private static Map<String, String> beforeCassetteMap = new HashMap<String, String>();
	static {
		beforeCassetteMap.put("/abc.vm", "/abc/oldA.vm");
		beforeCassetteMap.put("/def.vm", "/def/oldB.vm");
	}
}
