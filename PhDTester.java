import static org.junit.Assert.*;
import org.junit.Test;

public class PhDTester {
	@Test
	public void testConstructor1() {
		PhD p1 = new PhD("Eric Tse",2016,5,'m');
		assertEquals("Eric Tse",p1.getName());
		assertEquals(2016,p1.getYear());
		assertEquals(5,p1.getMonth());
		assertEquals(false,p1.isFemale());
		assertEquals(null,p1.advisor1());
		assertEquals(null,p1.advisor2());
		assertEquals(0,p1.numAdvisees());
	}
	@Test
	public void testaddAdvisor(){
		PhD p1 = new PhD("Eric Tse",2016,5,'m');
		PhD p2 = new PhD("Lala Tse",2011,6,'f');
		PhD p3 = new PhD("William Tse",2006,7,'m');
		p1.addAdvisor1(p2);
		p1.addAdvisor2(p3);
		p2.addAdvisor1(p3);
		assertEquals(p2,p1.advisor1());
		assertEquals(p3,p1.advisor2());
		assertEquals(p3,p2.advisor1());
		assertEquals(null,p2.advisor2());
		assertEquals(null,p3.advisor1());
		assertEquals(null,p3.advisor2());
		assertEquals(0,p1.numAdvisees());
		assertEquals(1,p2.numAdvisees());
		assertEquals(2,p3.numAdvisees());
	}
	@Test
	public void testConstructor2(){
		PhD p1 = new PhD("William Tse",2006,7,'m');
		PhD p2 = new PhD("Lala Tse",2011,6,'f');
		PhD p3 = new PhD("Eric Tse",2016,5,'m',p1);
		PhD p4 = new PhD("Andy Tse",2020,8,'m',p1,p2);
		assertEquals("Eric Tse",p3.getName());
		assertEquals(2016,p3.getYear());
		assertEquals(5,p3.getMonth());
		assertEquals(false,p3.isFemale());
		assertEquals(p1,p3.advisor1());
		assertEquals(null,p3.advisor2());
		assertEquals(0,p3.numAdvisees());
		assertEquals("Andy Tse",p4.getName());
		assertEquals(2020,p4.getYear());
		assertEquals(8,p4.getMonth());
		assertEquals(false,p4.isFemale());
		assertEquals(p1,p4.advisor1());
		assertEquals(p2,p4.advisor2());
		assertEquals(0,p4.numAdvisees());
		assertEquals(2,p1.numAdvisees());
		assertEquals(1,p2.numAdvisees());
	}
	@Test
	public void testGotBefore(){
		PhD p1 = new PhD("William Tse",2006,7,'m');
		PhD p2 = new PhD("Lala Tse",2011,6,'f');
		PhD p3 = new PhD("John Newman", 2006,5,'f');
		assertEquals(true,p1.gotBefore(p2));
		assertEquals(false,p1.gotBefore(p3));
	}
	@Test
	public void testAreSiblings(){
		PhD p1 = new PhD("William Tse",2006,7,'m');
		PhD p2 = new PhD("Lala Tse",2011,6,'f',p1);
		PhD p3 = new PhD("John Newman", 2015,5,'m',p1,p2);
		PhD p4 = new PhD("Mary Mary", 2020,8,'f',p2);
		PhD p5 = new PhD("Mary John", 2020,8,'f',p2,p3);
		PhD p6 = new PhD("Mary John", 2020,8,'f',p3);
		PhD p7 = new PhD("Mary John", 2020,8,'f',p3,p4);
		assertEquals(false,p1.arePhDSiblings(p1));
		assertEquals(false,p1.arePhDSiblings(p2));
		assertEquals(false,p1.arePhDSiblings(p3));
		
		assertEquals(true,p2.arePhDSiblings(p3));
		assertEquals(false,p2.arePhDSiblings(p4));
		assertEquals(false,p2.arePhDSiblings(p5));
		
		assertEquals(true,p3.arePhDSiblings(p4));
		assertEquals(true,p3.arePhDSiblings(p5));
		assertEquals(false,p3.arePhDSiblings(p6));
		assertEquals(false,p3.arePhDSiblings(p7));
		
	}
}


