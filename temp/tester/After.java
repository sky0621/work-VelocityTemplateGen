package beforeaftercheck;

import static common.Const.ENC;
import static common.Const.VM_PATH;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class After {

	public static String exec(String afterCassette, Object bean) {
		StringWriter sw = new StringWriter();
		Template template = Velocity.getTemplate(VM_PATH + afterCassette, ENC);
		template.merge(createVelocityContext(bean), sw);
		String res = sw.toString();
		sw.flush();
		return res;
	}

	private static VelocityContext createVelocityContext(Object actualBean) {
		Map<String, Object> actualMap = new HashMap<String, Object>();
		actualMap.put("bean", actualBean);
		VelocityContext context = new VelocityContext();
		Set<Map.Entry<String, Object>> entrySet = actualMap.entrySet();
		for (Map.Entry<String, Object> entry : entrySet) {
			context.put(entry.getKey(), entry.getValue());
		}
		return context;
	}

}
