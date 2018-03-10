package io.github.jorelali.utils;

public class Exponential extends Number implements Comparable<Exponential>{

	private Number base;
	private Number power;
	
	public Exponential(int base, int power) {
		if(power <= 0)
			throw new NumberFormatException("Power must be positive");
		this.base = base;
		this.power = power;
	}
	
	public Exponential(long base, long power) {
		if(power <= 0)
			throw new NumberFormatException("Power must be positive");
		this.base = base;
		this.power = power;
	}
	
	public Number getBase() {
		return base;
	}
	
	public Number getPower() {
		return power;
	}
	
	/**
	 * 
	 * @return ln(base^power)
	 */
	public double getLn() {
		return power.doubleValue() * Math.log(base.doubleValue()); 
	}

	@Override
	public int compareTo(Exponential e) {
		if(power.doubleValue() * Math.log(base.doubleValue()) < e.doubleValue() * Math.log(e.doubleValue()))
			return -1;
		else if(power.doubleValue() * Math.log(base.doubleValue()) > e.doubleValue() * Math.log(e.doubleValue()))
			return 1;
		return 0;
	}

	@Override
	public double doubleValue() {
		return Math.pow((double) base, (double) power);
	}

	@Override
	public float floatValue() {
		return (float) doubleValue();
	}

	@Override
	public int intValue() {
		return (int) doubleValue();
	}

	@Override
	public long longValue() {
		return (long) doubleValue();
	}}
