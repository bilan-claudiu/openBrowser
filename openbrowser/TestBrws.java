package openbrowser;

import org.testng.annotations.Test;

public class TestBrws {

	@Test
	public void TestingBrowser() {
	
			OpenBrws.startBrowser("ie", "http://www.google.com");
	}
}