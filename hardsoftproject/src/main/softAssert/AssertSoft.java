package softAssert;

public class AssertSoft {
	
	@Test
	public void softAssertTest {
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(2,2, "Error on 1st validation");
		soft.assertEquals(1,1, "Error on 2nd validation");
		soft.assertEquals(1,2, "Error on 3rd validation");
		soft.assertEquals(2,1, "Error on 4th validation");
		soft.assertAll();
	}
}