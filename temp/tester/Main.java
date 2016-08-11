package beforeaftercheck;

import org.apache.velocity.app.Velocity;

public class Main {

	public static void main(String[] args) {
		try {
			Velocity.init();

			new XxxxDiffChecker().process();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
