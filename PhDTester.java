import static org.junit.Assert.*;
import org.junit.Test;

public class PhDTester {
	@Test
	public void testGroupA() {
		// Test PhD class constructor with a male PhD named "Eric Tse",
		// graduation year of 2016 and month of 5.
		PhD p1 = new PhD("Eric Tse", 2016, 5, 'm');
		// Test if getName() returns "Eric Tse"
		assertEquals("Eric Tse", p1.getName());
		// Test if getYear() returns 2016
		assertEquals(2016, p1.getYear());
		// Test if getMonth() returns 5
		assertEquals(5, p1.getMonth());
		// Test if isFemale() returns false
		assertEquals(false, p1.isFemale());
		// Test if advisor1() returns null
		assertEquals(null, p1.advisor1());
		// Test if advisor2() returns null
		assertEquals(null, p1.advisor2());
		// Test if numAdvisees() returns 0
		assertEquals(0, p1.numAdvisees());

		// Test PhD class constructor with a female PhD named "Lala Tse",
		// graduation year of 2011 and month of 1.
		PhD p2 = new PhD("Lala Tse", 2011, 1, 'f');
		// Test if getName() returns "Lala Tse"
		assertEquals("Lala Tse", p2.getName());
		// Test if getYear() returns 2016
		assertEquals(2011, p2.getYear());
		// Test if getMonth() returns 5
		assertEquals(1, p2.getMonth());
		// Test if isFemale() returns true
		assertEquals(true, p2.isFemale());
		// Test if advisor1() returns null
		assertEquals(null, p2.advisor1());
		// Test if advisor2() returns null
		assertEquals(null, p2.advisor2());
		// Test if numAdvisees() returns 0
		assertEquals(0, p2.numAdvisees());
	}

	@Test
	public void testGroupB() {
		// Test for the addAdvisor1 and addAdvisor2 methods
		// Create p1, p2 and p3 with the first constructor without any advisors
		PhD p1 = new PhD("Eric Tse", 2016, 5, 'm');
		PhD p2 = new PhD("Lala Tse", 2011, 6, 'f');
		PhD p3 = new PhD("William Tse", 2006, 7, 'm');
		// use the addAdvisor1 method to add p2 as p1's first advisor,
		// addAdvisor2 method to add p3 as p1's second advisor
		p1.addAdvisor1(p2);
		p1.addAdvisor2(p3);
		// Test if p1.advisor1() returns p2 for the first advisor
		assertEquals(p1.advisor1(), p2);
		// Test if p1.advisor2() returns p3 for the second advisor
		assertEquals(p1.advisor2(), p3);
		// Test if p2 and p3 .advisor1 and .advisor2 return null
		assertEquals(null, p2.advisor1());
		assertEquals(null, p2.advisor2());
		assertEquals(null, p3.advisor1());
		assertEquals(null, p3.advisor2());
		// Test if the numbers of advisee for p2 and p3 are 1
		assertEquals(0, p1.numAdvisees());
		assertEquals(1, p2.numAdvisees());
		assertEquals(1, p3.numAdvisees());
		// Add p3 to be the first advisor of p2
		p2.addAdvisor1(p3);
		// Test if p2.advisor1() returns p3
		assertEquals(p2.advisor1(), p3);
		// Test if the number of advisees for p3 increases to 2
		assertEquals(2, p3.numAdvisees());
	}

	@Test
	public void testGroupC() {
		// Test for the new constructors that add advisors
		// Create p1 and p2 with the first constructor with no advisors.
		PhD p1 = new PhD("William Tse", 2006, 7, 'm');
		PhD p2 = new PhD("Lala Tse", 2011, 6, 'f');
		// Create p3 and p4 with the second constructor with one advisor and the
		// third constructor with two advisors respectively
		// Assign p1 as p3's first advisor and no second advisor
		PhD p3 = new PhD("Eric Tse", 2016, 5, 'm', p1);
		// Assign p1 as p4's first advisor and p2 as p4's second advisor
		PhD p4 = new PhD("Andy Tse", 2020, 8, 'm', p1, p2);
		// Since the previous parts are tested, simply need to test if the
		// advisors are properly added with the new constructors
		// Test if p3.advisor1() returns p1
		assertEquals(p1, p3.advisor1());
		// Test if p3.advisor2() returns null
		assertEquals(null, p3.advisor2());
		// Test if p3.numAdvisees return 0 to confirm we are not adding advisees
		// to this PhD
		assertEquals(0, p3.numAdvisees());
		// Test if p4.advisor1() returns p1
		assertEquals(p1, p4.advisor1());
		// Test if p4.advisor2() returns p2
		assertEquals(p2, p4.advisor2());
		// Test if p4.numAdvisees returns 0
		assertEquals(0, p4.numAdvisees());
		// Test if p1.numAdvisees returns 2
		assertEquals(2, p1.numAdvisees());
		// Test if p2.numAdvisees returns 1
		assertEquals(1, p2.numAdvisees());
	}

	@Test
	public void testGroupD() {
		// Test the gotBefore() method
		// Create p1 and p2 with the same graduation year, but p2 has a earlier
		// graduation month
		PhD p1 = new PhD("William Tse", 2006, 7, 'm');
		PhD p2 = new PhD("Lala Tse", 2006, 6, 'f');
		// Create p3 that has a later graduation year than p1 and p2
		PhD p3 = new PhD("John Newman", 2011, 5, 'm');
		// Test if p1.gotBefore(p2) returns false
		assertEquals(false, p1.gotBefore(p2));
		// Test if p2.gotBefore(p1) returns true
		assertEquals(true, p2.gotBefore(p1));
		// Test if p1.gotBefore(p3) returns true
		assertEquals(true, p1.gotBefore(p3));
		// Test if p3.gotBefore(p1) returns false
		assertEquals(false, p3.gotBefore(p1));

		// Test the arePhDSiblings() method
		// Test the null to null cases with p1.arePhDSiblings(p2) which should
		// return false
		assertEquals(false, p1.arePhDSiblings(p2));
		// add p1 as p3's advisor and create p4 with p1 as its advisor
		p3.addAdvisor1(p1);
		// Test the null to other PhD case with p3.arePhDSiblings(p1) and
		// p3.arePhDSiblings(p2) which should still return false in both cases
		assertEquals(false, p3.arePhDSiblings(p1));
		assertEquals(false, p3.arePhDSiblings(p2));
		// Now create a PhD p4 with p1 as its first advisor as well, which makes
		// it a PhD sibling with p3
		PhD p4 = new PhD("Mary Mary", 2020, 8, 'f', p1);
		// Test if p4.arePhDSiblings(p3) returns true
		assertEquals(true, p4.arePhDSiblings(p3));
		// Now create a PhD p5 with p2 as its first advisor
		PhD p5 = new PhD("Mary John", 2020, 8, 'f', p2);
		// Test if p5.arePhDSiblings(p4) returns false
		assertEquals(false, p5.arePhDSiblings(p4));
		// Now create a PhD p6 with p1 as its first advisor and p2 as its second
		// advisor
		PhD p6 = new PhD("Mary John", 2020, 8, 'f', p1, p2);
		// Test if p6.arePhDSiblings(p5) returns true
		assertEquals(true, p6.arePhDSiblings(p5));
		// Now create a PhD p7 with p3 as its first advisor and p2 as its second
		// advisor
		PhD p7 = new PhD("Sam John", 2020, 8, 'f', p3, p2);
		// Test if p7.arePhDSiblings(p6) returns true
		assertEquals(true, p7.arePhDSiblings(p6));
		// Finally create a PhD 8 with p4 as its first advisor and p3 as its
		// second
		PhD p8 = new PhD("Sam John", 2020, 8, 'f', p4, p3);
		// Test if p8.arePhDSiblings(p6) returns false
		assertEquals(false, p8.arePhDSiblings(p6));
		// Test if p8.arePhDSiblings(p7) returns false
		assertEquals(true, p8.arePhDSiblings(p7));
	}
}
