
public class functions {
	// Return true if the given non-negative number
	// is a multiple of 3 or a multiple of 5. Use the % "mod" operator
	public boolean or35(int n) {
		if (n % 5 == 0 || n % 3 == 0)
			return true;
		else
			return false;
	}

	// -------------------------------------------------------------------------------------
	// Given a string, take the first 2 chars and
	// return the string with the 2 chars added at
	// both the front and back, so "kitten" yields"kikittenki".
	// If the string length is less than 2, use whatever chars are there.

	// front22("kitten") "kikittenki"
	// front22("Ha") "HaHaHa"
	// front22("abc") "ababcab"

	public String front22(String str) {
		if (str.length() < 2)
			return str + str + str;
		else {
			String result;
			result = str.substring(0, 2) + str + str.substring(0, 2);
			return result;
		}
	}

	// ---------------------------------------------------------------------------------------

	// Given a string, return true if the string starts with "hi" and false
	// otherwise.

	// startHi("hi there") true
	// startHi("hi") true
	// startHi("hello hi") false
	public boolean startHi(String str) {
		if (str.length() > 1)
			return (str.substring(0, 2).equals("hi"));
		else
			return false;
	}

	// ---------------------------------------------------------------------------------------

	// Given two temperatures, return true if one is less than 0
	// and the other is greater than 100.

	// icyHot(120, -1) true
	// icyHot(-1, 120) true
	// icyHot(2, 120) false

	public boolean icyHot(int temp1, int temp2) {
		return ((temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0));
	}

	// -------------------------------------------------------------------------------------
	// Given 2 int values, return true if either of them is in the range 10..20
	// inclusive.

	// in1020(12, 99) true
	// in1020(21, 12) true
	// in1020(8, 99) false

	public boolean in1020(int a, int b) {
		return (a <= 20 && a >= 10 || b <= 20 && b >= 10);
	}

	// -----------------------------------------------------------------------------------
	// We'll say that a number is "teen" if
	// it is in the range 13..19 inclusive.
	// Given 3 int values, return true if 1 or more of them are teen.

	// hasTeen(13, 20, 10) true
	// hasTeen(20, 19, 10) true
	// hasTeen(20, 10, 13) true
	public boolean hasTeen(int a, int b, int c) {
		return ((a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19));
		// return true;
	}

	// -----------------------------------------------------------------------------------

	// We'll say that a number is "teen" if it is in the range 13..19 inclusive.
	// Given 2 int values, return true if one or the other is teen, but not
	// both.

	// loneTeen(13, 99) true
	// loneTeen(21, 19) true
	// loneTeen(13, 13) false

	public boolean loneTeen(int a, int b) {
		return (((a >= 13 && a <= 19) && !(b >= 13 && b <= 19)) || (!(a >= 13 && a <= 19) && (b >= 13 && b <= 19)));
	}

	// ------------------------------------------------------------------------------
	// Given a string, if the string "del" appears starting at index 1
	// , return a string where that "del" has been deleted.
	// Otherwise, return the string unchanged.

	// delDel("adelbc") "abc"
	// delDel("adelHello") "aHello"
	// delDel("adedbc") "adedbc"
	public String delDel(String str) {
		if (str.length() < 4)
			return str;
		else {
			if (str.substring(1, 4).equals("del"))
				return str.substring(0, 1) + str.subSequence(4, str.length());
			else
				return str;
		}
	}

	// ---------------------------------------------------------------------------

	// Return true if the given string begins with "mix",
	// except the 'm' can be anything, so "pix", "9ix" .. all count.

	// mixStart("mix snacks") true
	// mixStart("pix snacks") true
	// mixStart("piz snacks") false

	public static boolean mixStart(String str) {
		if (str.length() < 3) {
			System.out.println(str.substring(1, 2));
			return false;
		} else if (str.substring(1, 3).equals("ix")) {
			System.out.println(str.substring(1, 2));
			return true;
		} else {
			System.out.println(str.substring(1, 2));
			return false;
		}
	}

	// ---------------------------------------------------------------------------
	// Given a string, return a string made of the
	// first 2 chars (if present), however include first
	// char only if it is 'o' and include the second
	// only if it is 'z', so "ozymandias" yields "oz".

	// startOz("ozymandias") "oz"
	// startOz("bzoo") "z"
	// startOz("oxx") "o"
	public String startOz(String str) {
		String result;
		if (str.length() < 1)
			return "";
		else if (str.substring(0, 1).equals("o"))
			result = "o";
		else
			result = "";
		if (str.length() < 2)
			return result;
		else if (str.substring(1, 2).equals("z"))
			return result += "z";
		else
			return result;
	}

	// ----------------------------------------------------------------------------

	// Given three int values, a b c, return the largest.
	// intMax(1, 2, 3) 3
	// intMax(1, 3, 2) 3
	// intMax(3, 2, 1) 3
	public int intMax(int a, int b, int c) {
		int currMax = 0;
		if (a > b) {
			currMax = a;
			if (a > c) {
				currMax = a;
				return currMax;
			} else {
				currMax = c;
				return currMax;
			}
		} else
			currMax = b;

		{
			if (b > c) {
				currMax = b;
				return currMax;
			} else {
				currMax = c;
				return currMax;
			}
		}
	}

	// --------------------------------------------------------------------------
	// Given 2 int values, return whichever value is nearest to the value 10,
	// or return 0 in the event of a tie.
	// Note that Math.abs(n) returns the absolute value of a number.

	// close10(8, 13) 8
	// close10(13, 8) 8
	// close10(13, 7) 0
	public int close10(int a, int b) {
		if (Math.abs(a - 10) == Math.abs(b - 10))
			return 0;
		else {
			if (Math.abs(a - 10) > Math.abs(b - 10))
				return b;
			else {
				return a;
			}
		}
		// return (Math.min(Math.abs(a-10),Math.abs(b-10)));
	}

	// --------------------------------------------------------------------------------
	// Given 2 int values, return true if they are both in the range 30..40
	// inclusive,
	// or they are both in the range 40..50 inclusive.

	// in3050(30, 31) true
	// in3050(30, 41) false
	// in3050(40, 50) true
	public boolean numberInRange(int number, int rangeStart, int rangeStop) {
		return (number >= rangeStart && number <= rangeStop);
	}

	public boolean in3050(int a, int b) {
		return ((numberInRange(a, 30, 40) && numberInRange(b, 30, 40)) || (numberInRange(
				a, 40, 50) && numberInRange(b, 40, 50)));
	}

	// ------------------------------------------------------------------------------------------
	// Given 2 positive int values, return the larger
	// value that is in the range 10..20 inclusive, or return 0 if neither is in
	// that range.

	// max1020(11, 19) 19
	// max1020(19, 11) 19
	// max1020(11, 9) 11
	public int max1020(int a, int b) {
		if (numberInRange(a, 10, 20) && numberInRange(b, 10, 20)) {
			if (a > b)
				return a;
			else
				return b;
		} else if (numberInRange(a, 10, 20))
			return a;
		else if (numberInRange(b, 10, 20))
			return b;
		return 0;
	}

	// -------------------------------------------------------------------------------------------

	private static String str_piece(String str, char separator, int index) {
		String str_result = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				count++;
				if (count == index) {
					break;
				}
			} else {
				if (count == index - 1) {
					str_result += str.charAt(i);
				}
			}
		}
		return str_result;
	}

	// -------------------------------------------------------------------------------------------
	// Return true if the given string contains between 1 and 3 'e' chars.

	// stringE("Hello") true
	// stringE("Heelle") true
	// stringE("Heelele") false

	public boolean stringE(String str) {

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char currentAnalizing;
			currentAnalizing = str.charAt(i);
			if (currentAnalizing == 'e')
				count++;
		}
		if (numberInRange(count, 1, 3))
			return true;
		return false;
	}

	// ---------------------------------------------------------------------------------------------
	// Given two non-negative int values, return true if they have
	// the same last digit, such as with 27 and 57. Note that the % "mod"
	// operator computes remainders, so 17 % 10 is 7.

	// lastDigit(7, 17) true
	// lastDigit(6, 17) false
	// lastDigit(3, 113) true

	public boolean lastDigit(int a, int b) {
		return (a % 10 == b % 10);
	}

	// ------------------------------------------------------------------------------------------
	// Given a string, return a new string where the last
	// 3 chars are now in upper case. If the string has less
	// than 3 chars, uppercase whatever is there. Note that str.toUpperCase()
	// returns the uppercase version of a string.

	// endUp("Hello") "HeLLO"
	// endUp("hi there") "hi thERE"
	// endUp("hi") "HI"

	public String endUp(String str) {
		if (str.length() < 3)
			return str.toUpperCase();
		else {
			String lastThreeCharacters;
			lastThreeCharacters = str.substring(str.length() - 3, str.length());
			lastThreeCharacters = lastThreeCharacters.toUpperCase();
			str = str.substring(0, str.length() - 3) + lastThreeCharacters;
			return str;
		}
	}

}
