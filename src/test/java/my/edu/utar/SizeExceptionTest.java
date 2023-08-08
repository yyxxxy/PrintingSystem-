package my.edu.utar;

import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class SizeExceptionTest {

	//Check if invalid document size will throw exception
	@Test(expected = IllegalArgumentException.class)
	@Parameters({"-1","0","51"})
	public void testDocSizeException(int size) {
		Document d = new Document(1, 1);
		if(size <=0 || size > 50) {
		d.docSizeException();
		}
	}

	//Check if invalid photo size will throw exception
	@Test(expected = IllegalArgumentException.class)
	@Parameters({"-1","0","51"})
	public void testPhotoSizeException(int size) {
		Photo p = new Photo(1, 1);
		if(size <=0 || size > 50) {
			p.photoSizeException();
			}

	}
}
