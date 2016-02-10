/** NetId: dz85, ht385. Time spent: 02 hours, 30 minutes.  An instance maintains info about the PhD of a person. */

public class PhD {

	private String name; //name of person with PhD, length > 0
	private int month; //month PhD was awarded, in range 1..12, 1 means January etc.
	private int year; //year PhD was award
	private char sex; //gender of person, 'f' for female and 'm' for male
	private PhD advr1; //first PhD advisor of this person, null if unknown
	private PhD advr2; //second PhD advisor of this person, null if advr1 is null and null if unknown
	private int num_adve; //number of PhD advisees of this person, value >=0

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/** 
	 * Constructor: an instance for a person with a name n, PhD year y,
	 * PhD month m, and a gender g. Its advisors are unknown and it has no
	 * advisees.
	 * Preconditions: n has at least 1 character, m is in 1...12, and g is
	 * 'f' for female or 'm' for male
	 */
	public PhD (String n, int y, int m, char g) {
		name=n; 
		month=m;
		year=y;
		sex=g;
		advr1=null;
		advr2=null;
		num_adve=0;
	}

	/**
	 * Constructor: a PhD with name n, PhD year y, PhD month m, gender g,
	 * first advisor adv, and no second advisor.
	 * Precondition: n has at least 1 char, m is in 1..12, g is 'f' for
	 * female or 'm' for male, and adv is not null.
	 */
	public PhD (String n, int y, int m, char g, PhD adv) {
		name=n;
		month=m;
		year=y;
		sex=g;
		advr1=null;
		advr2=null;
		this.addAdvisor1(adv);
		num_adve=0;	
	}

	/**
	 * Constructor: a PhD with name n, PhD year y, PhD month m, gender g,
	 * first advisor adv1, and second advisor adv2.
	 * Precondition: n has at least 1 char, m is in 1..12, g is 'f' for
	 * female or 'm' for male, adv1 and adv2 are not null, and adv1 and
	 * adv2 are different.
	 */
	public PhD (String n, int y, int m, char g, PhD adv1, PhD adv2) {
		name=n;
		month=m;
		year=y;
		sex=g;
		advr1=null;
		advr2=null;
		this.addAdvisor1(adv1);
		this.addAdvisor2(adv2);
		num_adve=0;	
	}

	//Return this person's name.
	public String getName() {
		return name;
	}

	//Return the year this person got their PhD.
	public int getYear() {
		return year;
	}

	//Return the month this person got their PhD.
	public int getMonth() {
		return month;
	}

	//Return the value of the sentence "this person is female.”
	public boolean isFemale() {
		return sex=='f';
	}

	//Return this Phd's first advisor (null if unknown).
	public PhD advisor1() {
		return advr1;
	}

	//Return this PhD's second advisor (null if unknown or non- existent).
	public PhD advisor2() {
		return advr2;
	}

	//Return the number of PhD advisees of this person.
	public int numAdvisees() {
		return num_adve;
	}

	/**
	 * Add p as this person's first PhD advisor.
	 * Precondition: this person's first advisor is unknown and p is not null.
	 */
	public void addAdvisor1(PhD p) {
		p.num_adve++;
		advr1=p;
	}

	/**
	 * Add p as this person's second advisor.
	 * Precondition: This person's first advisor is known, their second
	 * advisor is unknown, p is not null, and p is different from this
	 * person's first advisor.
	 */
	public void addAdvisor2(PhD p) {
		p.num_adve++;
		advr2=p;
	}


	/**
	 * Return value of "this person got their PhD before p did."
	 * Precondition: p is not null.
	 */
	public boolean gotBefore(PhD p) {
		return (year*12+month)<(p.getYear()*12+p.getMonth());
	}


	/**
	 * Return value of "this person and p are intellectual sib- lings."
	 * Note: if p is null, they are not siblings.
	 */

	public boolean arePhDSiblings(PhD p) {
		return advr1!=null && this!=p && (advr1==p.advisor1()||advr1==p.advisor2()||
				(advr2==p.advisor1() && advr2!=null)||
				(advr2==p.advisor2() && advr2!=null));
	}

}
