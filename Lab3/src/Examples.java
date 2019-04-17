import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Examples {

	Planning test;
	LinkedList<Double> rain;
	
	@Before
	public void setup() {
		test = new Planning();
		rain = new LinkedList<Double>();
		rain.add(0.0);
	}
	
	@Test
	public void rainfall1() {
		assertEquals(test.rainfall(rain), 0, 0.1);
	}
	
	@Test
	public void rainfall2() {
		rain.add(2.0);
		assertEquals(test.rainfall(rain), 1, 0.1);
	}
	
	@Test
	public void rainfall3() {
		rain.add(2.0);
		rain.add(-12.0);
		assertEquals(test.rainfall(rain), 1, 0.1);
	}
	
	@Test
	public void rainfall4() {
		rain.add(2.0);
		rain.add(6.0);
		rain.add(-999.0);
		rain.add(20.0);
		assertEquals(test.rainfall(rain), 8.0/3, 0.1);
	}

}
