package hardAssert;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedHardAssertTest {

  @Test
  public void hardAssertTestTest() {
	Assert.assertEquals(2,2, "Error on 1st validation");
	Assert.assertEquals(1,1, "Error on 2nd validation");
	Assert.assertEquals(1,2, "Error on 3rd validation");
	Assert.assertEquals(1,1, "Error on 4th validation");
  }
}
