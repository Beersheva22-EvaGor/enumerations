package telran.measure;

public class Length implements Comparable<Length> {
	private float amount;
	private LengthUnit lengthUnit;

	public Length(float amount, LengthUnit lengthUnit) {
		this.amount = amount;
		this.lengthUnit = lengthUnit;
	}

	@Override
	/**
	 * equals two Length objects according to LengthUnit and amount 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Length)) {
			throw new IllegalArgumentException();
		}
		return amount / ((Length) obj).lengthUnit.value == ((Length) obj).amount / lengthUnit.value;
	}

	@Override
	/**
	 * 
	 * @param o
	 * @return < 0 "this" object less than "o" object, > 0 "this" object greater
	 *         than "o" object, == 0 "this" object equals "o" object,
	 */
	public int compareTo(Length o) {
		int res = (int) (amount - o.lengthUnit.value * o.amount / lengthUnit.value);
		return res < 0 ? -1 : (res > 0 ? 1 : 0);
	}

	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit example,
	 *         convert(LengthUnit.M) returns Length in meters
	 */
	public Length convert(LengthUnit unit) {
		return new Length( amount * lengthUnit.value / unit.value, unit);
	}

	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20.0M (string expression of Length object presenting 20 meters)
	 * format of float: trim all the nulls (0), but left not least than one digit after a decimal point
	 */
	public String toString() {
		String amountStr = Float.toString(amount).replaceAll("(.*?)(\\.0||\\d)([0]+$)", "$1$2$3");
		// if need just round to format #.#: String.format("%.1f%s", amount, lengthUnit.name());
		return String.format("%s%s", amountStr, lengthUnit.name());		
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return lengthUnit;
	}

}