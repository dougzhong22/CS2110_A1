import java.util.Arrays;

/** NetIds: ht385, dz85. Time spent: hh hours, mm minutes. */

/** An instance contains static methods for assignment A2 */
public class A2 {

	/*
	 * NOTE: You will have to rely on methods that are declared in class String.
	 * Visit docs.oracle.com/javase/8/docs/api/index.html?java/lang/String.html,
	 * scroll down to the Method Summary, and peruse the available methods.
	 * Oft-used ones are charAt, length, trim, substring, indexOf, isEmpty,
	 * lastIndexOf, startsWith, endsWith, split, toLowerCase, toUpperCase.
	 *
	 * In all these methods, assume that String parameters are not null. Also
	 * assume that the preconditions of the methods are true; you do not have to
	 * deal with the cases that the input is malformed.
	 * 
	 * Of course, you can, if you want, use assert statement to test
	 * preconditions, but you do not have to.
	 * 
	 * It is OK to have return statements within the body of a loop. However,
	 * try to write loops that do NOT us break or continue; these statements
	 * often lead to loop bodies that are hard to understand.
	 * 
	 * Each function (except the first two, which we give you to help you learn
	 * Java) has a dummy return statement so that the class will compile.
	 * Replace that return statement as you write the function body.
	 * 
	 * Your submission must NOT have println statements in it. Lots of points
	 * could be deducted for this, for it will mess up out grading output. A
	 * function does what the spec says and nothing else.
	 */

	/**
	 * if b, return the sum of s1 and s2. if not b, return the difference of s1
	 * and s2
	 */
	public static int sumDif(boolean b, int s1, int s2) {
		if (b) {
			return s1 + s2;
		}
		// b is false;
		return s1 - s2;
	}

	/**
	 * if b, return the sum of s1 and s2. if not b, return the difference of s1
	 * and s2
	 */
	public static int sumDif1(boolean b, int s1, int s2) {
		/*
		 * sumDif1 and sumDIf have the same specifications. We show two ways of
		 * writing the body. In the then-part below, you see a declaration of
		 * local variable s, an assignment to it, and then the use of s in the
		 * return statement. The declaration and assignment could have been
		 * written in one statement: int s= s1 + s2;
		 */
		if (b) {
			int s;
			s = s1 + s2;
			return s;
		} else {
			return s1 - s2;
		}
	}

	/**
	 * Return true iff s reads the same backward and forward. Examples: For s =
	 * "b", return true For s = "", return true For s = "ab", return false For s
	 * = "aba", return true. For s = "abba", return true. For s =
	 * "Madam, I'm Adam", return false. For s = "MadamImAdam", return false. For
	 * s = "madamimadam", return true.
	 */
	public static boolean sameBackAndForth(String s) {
		int L = s.length();
		int mid_index = L / 2;
		for (int i = 0; i < mid_index; i++) {
			if (s.charAt(i) != s.charAt(L - 1 - i)) {
				return false;
			}
		}
		return true;
		/*
		 * Do not use recursion.. Use one loop... Do not use an array; just
		 * process the characters of s, looking at each character at most once.
		 */
	}

	/**
	 * Return the number of times q occurs as a substring of src (different
	 * occurrences may overlap). Precondition: q is not the empty string "".
	 * Examples: For src = "ab", query = "b", return 1. For src =
	 * "Luke Skywalker", query = "ke", return 2. For src = "abababab", query =
	 * "aba", return 3. For src = "aaaa", query = "aa", return 3.
	 */
	public static int numOccurrences(String src, String q) {
		/*
		 * This should be done with one loop. If possible, don't have each
		 * iteration of the loop process one character of src. Instead, see
		 * whether some method of class String can be used to jump from one
		 * occurrence of query to the next.
		 */
		/*
		 * for every time String q appears in String src, x++, return x++ after
		 * the full scan.
		 */
		int L_src = src.length();
		int L_q = q.length();
		int num_of_occurrences = 0;
		for (int i = 0; i <= L_src - L_q; i++) {
			if (src.substring(i, L_q + i).equals(q)) {
				num_of_occurrences++;
			}
		}
		return num_of_occurrences;
	}

	/**
	 * String s is written in a form that looks something like this:
	 * "b3c1x2a013b2". For this s, return the decompressed string "bbbcxx111bb".
	 *
	 * More formally, we have: Precondition: s is in "compressed form": it
	 * consists of a sequence of pairs of characters, with the second character
	 * being a digit in 0..9. Return the decompressed form of s, which is found
	 * by replacing each pair "ci" by i occurrences of character c.
	 */
	public static String decompress(String s) {
		/*
		 * You can use function Integer.parseInt(s1) to get the int that is in
		 * s1. Remember that a character c is not a String, and to change c into
		 * a String you can catenate it with the empty String "". This function
		 * may need a loop within a loop.
		 */
		// given a string. Read the digit behind a character and then
		// concatenate the character in a loop.
		String ds = ""; // decompressed string
		for (int i = 1; i < s.length(); i = i + 2) {
			int digit = Integer.parseInt(Character.toString(s.charAt(i)));
			for (int o = 1; o <= digit; o++) {
				ds = ds + s.charAt(i - 1);
			}
		}
		return ds;
	}

	/**
	 * Precondition: String s consists of a last-name, a comma ',', a
	 * first-name, and an optional middle-name. There are one or more blank
	 * characters (spaces) before the first-name and before the optional
	 * middle-name. There are 0 or more blanks at the beginning and end of s.
	 * Any of the characters in the names may be in lower or upper case. Return
	 * the correctly formatted name as first-name middle-name (if present)
	 * last-name The first character of each name must be in uppercase and the
	 * rest of the characters in lowercase. Exactly one blank must separate
	 * adjacent names. There should be no blank before the first-name and after
	 * the last-name.
	 *
	 * Examples: For s = "   gRies,  DAVID     " return "David Gries" For s =
	 * "tate,    ross" return "Ross Tate" For s = "GOSLING, JAMES   ARTHUR"
	 * return "James Arthur Gosling"
	 */
	public static String fixName(String s) {
		/*
		 * As you know, String is a class. An object of class String is
		 * immutable -- you cannot change the sequence of chars that it
		 * contains. However, you can create new strings by catenating together
		 * parts of the original string.
		 *
		 * Do not use a loop or recursion. Use only if-statements, assignments,
		 * and return statements.
		 *
		 * This method can be written using an oft-used pattern: 1. Break the
		 * string into its parts 2. Modify the parts (How can you make the first
		 * letter of each part of the name uppercase? How can you extract the
		 * first name?) 3. Build the result from the modified parts.
		 */
		// first , find the last name
		int ln_i = s.lastIndexOf(',');
		String ln = s.substring(0, ln_i);
		ln = ln.trim();
		ln = ln.toLowerCase();
		String fc_ln = (ln.substring(0, 1)).toUpperCase(); // Capitalize first
															// character
		// second, break down the string to first name plus middle name
		String fmn = s.substring(ln_i + 1);
		fmn = fmn.trim(); // remove all the trailing and preceding spaces
		fmn = fmn.toLowerCase(); // change all characters to lowercase
		// change the first character of the first name to uppercase
		String fc_fn = fmn.substring(0, 1);
		fc_fn = fc_fn.toUpperCase();
		// Check if there is a middle name, if so, break down first name and
		// middle name, otherwise the entire string is the first name
		String fn = "";
		String mn = "";
		String fc_mn = "";
		int space_i = fmn.lastIndexOf(" ");
		if (space_i != -1) {
			fn = fmn.substring(0, space_i);
			fn = fn.trim();
			mn = fmn.substring(space_i + 1);
			fc_mn = mn.substring(0, 1);
			fc_mn = fc_mn.toUpperCase(); // with space if middle name existed
			return fc_fn + fn.substring(1) + " " + fc_mn + mn.substring(1) + " "
					+ fc_ln + ln.substring(1);
		} else {
			return fc_fn + fmn.substring(1) + " " + fc_ln + ln.substring(1);
		}
	}

	/**
	 * Return a string that is s but with all upper-case consonants (letters of
	 * the English alphabet other than the vowels a, e, i, o, u) replaced with
	 * _, and all lower-case consonants replaced with their upper-case version.
	 *
	 * Examples: For s = "Minecraft" return "_iNeCRaFT". For s = "Alan Turing"
	 * return "ALaN _uRiNG".
	 */
	public static String replaceConsonants(String s) {
		/*
		 * Writing a long list of 42 statements, one for each (upper-case or
		 * lower-case) consonant is not a great idea. Instead, put the 21
		 * lower-case consonants in a string and the upper-case consonants in
		 * another string. Then write a loop that sequences through the chars in
		 * s in turn, replacing the upper and lowercase versions of each letter
		 * in s. This should be the ONLY loop you write!
		 *
		 * A for-loop to loop through a range b..c-1 of integers can look like
		 * this: for (int k = b; k < c ; k= k + 1) { ... }
		 */
		String L = "bcdfghjklmnpqrstvwxyz";
		String U = L.toUpperCase();
		// Replace all upper case characters that are consonants with '_' and
		// then replace all lower case consonants with upper case consonants.
		for (int i = 0; i < L.length(); i++) {
			s = s.replace(U.charAt(i), '_');
			s = s.replace(L.charAt(i), U.charAt(i));
		}
		return s;
	}

	/**
	 * Return true iff s and t are anagrams. An anagram of a string is another
	 * string that has the same characters, but possibly in a different order.
	 * Note: 'a' and 'A' are considered different characters; the space is a
	 * character.
	 *
	 * Examples: For s = "non", t = "noon", return false. For s = "noon", t =
	 * "noon", return true. For s = "mary", t = "army", return true. For s =
	 * "tom marvolo riddle", t = "i am lordvoldemort", return true. For s =
	 * "tommarvoloriddle", t = "i am lordvoldemort", return false. For s =
	 * "hello", t = "world", return false.
	 */
	public static boolean areAnagrams(String s, String t) {
		/*
		 * Do not use a loop or recursion! This is tricky but can in fact be
		 * done in a few lines. Hint: how can a sequence of characters be
		 * uniquely ordered (sorted)? You might need to first convert the string
		 * to an array of characters and then use functions in class Arrays
		 * (http://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html).
		 * This is an exercise in learning to use already-existing functions.
		 */
		char[] a = s.toCharArray();
		char[] b = t.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		if (Arrays.equals(a,b)) {
			return true;
		}
		return false;
	}
}
