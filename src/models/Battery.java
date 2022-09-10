package models;

public class Battery {

	private int soc;
	private int temp;


	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Battery{" +
				"soc=" + soc +
				", temp=" + temp +
				'}';
	}
}
