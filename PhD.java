/**
 * NetId: ht385, dz85. Time spent: 6 hours, 30 minutes. An instance maintains
 * info about the PhD of a person.
 */

public class PhD {
	private String N; // Name of the person with a PhD, a String of length > 0.
	private int yr; // Year PhD was awarded.
	private int mon; // Month PhD was awarded. In range 1..12 with 1 being
						// January
	private char gen; // gender of the person. 'f' for female and 'm' for male.
	private PhD adr1; // Name of the first PhD advisor of this person, a string
						// of length > 0, null if unknown
	private PhD adr2; // Name of the second advisor of this person, a string of
						// length > 0, null if unknown or the person only had
						// one advisor. If the first advisor field is null, then
						// this field must be null.
	private int n_ade; // Number of PhD Advisees of this person

	/**
	 * Constructor: an instance for a person with name n, PhD year y, PhD month
	 * m, and , gender g. Its advisors are unknown, and it has no advisees.
	 * Precondition: n has at least 1 character, m is in 1..12, and g is 'f' for
	 * female or 'm' for male.
	 */
	public PhD(String n, int y, int m, char g) {
		assert (n.length() >= 1); // Test if n has at least 1 character
		assert (m >= 1 && m <= 12); // Test if m is in 1...12
		assert (g == 'f' || g == 'm'); // Test if g is either 'f' or 'm'
		N = n; // Assign values to fields
		mon = m;
		yr = y;
		gen = g;
	}

	/** Return this person's name. */
	public String getName() {
		return N;
	}

	/** Return the year this person got their PhD. */
	public int getYear() {
		return yr;
	}

	/** Return the month this person got their PhD. */
	public int getMonth() {
		return mon;
	}

	/** Return the value of the sentence "this person is female." */
	public boolean isFemale() {
		return gen == 'f';
	}

	/** Return this PhD's first advisor. (null if unknown) */
	public PhD advisor1() {
		return adr1;
	}

	/** Return this PhD's second advisor (null if unknown or non-existent). */
	public PhD advisor2() {
		return adr2;
	}

	/** Return the number of PhD advisees of this person. */
	public int numAdvisees() {
		return n_ade;
	}

	/**
	 * Add p as this person's first PhD advisor. Precondition: This person's
	 * first advisor is unknown and p is not null.
	 */
	public void addAdvisor1(PhD p) {
		assert p != null; // Test if p is not null
		assert adr1 == null; // Test if the first advisor is unknown
		adr1 = p;
		p.n_ade = p.n_ade + 1; // add an advisee to advisor p
	}

	/**
	 * Add p as this person's second PhD advisor. Precondition: This person's
	 * first advisor is known, their second advisor is unknown, p is not null,
	 * and p is different from this person's first advisor.
	 */
	public void addAdvisor2(PhD p) {
		assert adr1 != null; // Test if first advisor is known
		assert p != null; // Test if PhD p is not null
		assert adr2 == null; // Test if advisor 2 of this person is null
		assert !p.equals(adr1); // Test if PhD p is not advisor 1
		adr2 = p;
		p.n_ade = p.n_ade + 1; // add an advisee to advisor p
	}

	/**
	 * Constructor: a PhD with name n, PhD year y, PhD month m, gender g, first
	 * advisor adv, and no second advisor. Precondition: n has at least 1 char,
	 * m is in 1..12, g is 'f' for female or 'm' for male, and adv is not null.
	 */
	public PhD(String n, int y, int m, char g, PhD adv) {
		assert (n.length() >= 1); // Test if n has at least 1 character
		assert (m >= 1 && m <= 12); // Test if m is in 1...12
		assert (g == 'f' || g == 'm'); // Test if g is either 'f' or 'm'
		assert (adv != null); // Test if adv is not null
		N = n; // Assign values into fields
		mon = m;
		yr = y;
		gen = g;
		addAdvisor1(adv);
	}

	/**
	 * Constructor: a PhD with name n, PhD year y, PhD month m, gender g, first
	 * advisor adv1, and second advisor adv2. Precondition: n has at least 1
	 * char, m is in 1..12, g is ‘g' for female or 'g' for male, adv1 and adv2
	 * are not null, and adv1 and adv2 are different.
	 */
	public PhD(String n, int y, int m, char g, PhD adv1, PhD adv2) {
		assert (n.length() >= 1); // Test if n has at least 1 character
		assert (m >= 1 && m <= 12); // Test if m is in 1...12
		assert (g == 'f' || g == 'm'); // Test if g is either 'f' or 'm'
		assert (adv1 != null && adv2 != null); // Test if adv1 and adv2 are not
												// null
		assert (!adv1.equals(adv2)); // Test if adv1 and adv2 are different
		N = n;
		mon = m;
		yr = y;
		gen = g;
		addAdvisor1(adv1);
		addAdvisor2(adv2);
	}

	/**
	 * Return value of "this person got their PhD before p did." Precondition: p
	 * is not null.
	 */
	public boolean gotBefore(PhD p) {
		assert p != null; // Test if p is not null
		return (this.getYear() < p.getYear()) || (this.getYear() == p.getYear()
				&& this.getMonth() < p.getMonth());
	}

	/**
	 * Return value of "this person and p are intellectual siblings." Note: if p
	 * is null, they are not siblings.
	 */
	public boolean arePhDSiblings(PhD p) {
		return this != p && !p.equals(null) && advisor1() != null
				&& p.advisor1() != null
				&& (advisor1().equals(p.advisor1()) 
						|| (p.advisor2() != null
								&& advisor1().equals(p.advisor2()))
						|| (advisor2() != null
								&& advisor2().equals(p.advisor1()))
						|| (advisor2() != null && p.advisor2() != null
								&& advisor2().equals(p.advisor2())));
	}
}
