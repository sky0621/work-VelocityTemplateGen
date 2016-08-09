package beforeaftercheck;

import static common.Const.BEFORE_VM_PATH;
import static common.Const.ENC;

import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Before {

	public static String exec(String beforeCassette, Map<String, Object> dataMap) {
		StringWriter sw = new StringWriter();
		Template template = Velocity.getTemplate(BEFORE_VM_PATH + beforeCassette, ENC);
		VelocityContext context = new VelocityContext();
		Set<Map.Entry<String, Object>> entrySet = dataMap.entrySet();
		for (Map.Entry<String, Object> entry : entrySet) {
			context.put(entry.getKey(), entry.getValue());
		}
		template.merge(context, sw);
		String res = sw.toString();
		sw.flush();
		return res;
	}

}
