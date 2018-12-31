package somoonShop.function.util;

import java.io.IOException;

public class urlSite {
	Runtime runtime = Runtime.getRuntime();
	String path = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	String cmd = "https://media.gucci.com/style/DarkGray_Center_0_0_2400x2400/";
	String[] urlLink = { "1522088105/469250_X3P70_4649_001_100_0000_Light-GucciHallucination-print-sweatshirt.jpg",
			"1522082708/492347_X3P69_4725_001_100_0000_Light-GucciHallucination-print-T-shirt.jpg",
			"1522087209/492347_X3P63_4205_001_100_0000_Light-GucciHallucination-print-T-shirt.jpg",
			"1519964109/440103_X3F05_9045_001_100_0000_Light-Washed-T-shirt-with-Gucci-Logo.jpg",
			"1522086306/492347_X3P66_7548_001_100_0000_Light-GucciHallucination-print-T-shirt.jpg" };

	public void bodySize(int size) {

		int i = 0;
		if (size == 90) {
			i = 0;
		} else if (size == 95) {
			i = 1;
		} else if (size == 100) {
			i = 2;
		} else if (size == 105) {
			i = 3;
		} else if (size == 110) {
			i = 4;
		}

		String[] cmds = { path, cmd + urlLink[i] };

		try {
			runtime.exec(cmds);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}