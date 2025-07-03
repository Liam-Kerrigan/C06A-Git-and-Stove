/*
Authors: Liam Kerrigan and Hiram Despain
Date: 7/2/2025
Class: The Burner class's methods control its setting and temperature. Temperature is updated every two minutes.
		This also controls how the temperature and settings are displayed. 
		Simulates the behavior of the temperature of the stove over time. 
		Contains the Temperature enumerated type.
*/

public class Burner {
	public enum Temperature { 
		BLAZING("VERY HOT! DON'T TOUCH"), 
		HOT("CAREFUL"), 
		WARM("warm"), 
		COLD("cooool");

		public String displayStr;
		Temperature(String displayStr) {
			this.displayStr = displayStr;
		}
		
	};

	private Temperature myTemperature;
	private Setting mySetting;
	private int timer = 0;
	public final static int TIME_DURATION = 2;

// Each burner starts cold and off.
	Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}

// This method was a requirement, but how can this methods return value be useful if it returns an enumeration of a private type?
	public Temperature getMyTemperature() {
		return myTemperature;
	}

	public void plusButton() {
		timer = TIME_DURATION;
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
		case HIGH:
			mySetting = Setting.HIGH;
			break;
		}
	}

	public void minusButton() {
		timer = TIME_DURATION;
		switch (mySetting) {
		case OFF:
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		}
	}

/* There is one to one correspondence between temperatures and settings.
 * Every two updateTemperature calls, the temperature moves one closer to the corresponding setting.
 * The timer variable counts down to keep track of this.
 * */
	public void updateTemperature() {
		if (--timer == 0) {
			switch (mySetting) {
			case OFF:
				switch (myTemperature) {
				case BLAZING:
					myTemperature = Temperature.HOT;
					break;
				case HOT:
					myTemperature = Temperature.WARM;
					break;
				case WARM:
					myTemperature = Temperature.COLD;
				default:
				}
				break;
			case LOW:
				switch (myTemperature) {
				case BLAZING:
					myTemperature = Temperature.HOT;
					break;
				case HOT:
				case COLD:
					myTemperature = Temperature.WARM;
				default:
				}
				break;
			case MEDIUM:
				switch (myTemperature) {
				case BLAZING:
				case WARM:
					myTemperature = Temperature.HOT;
					break;
				case COLD:
					myTemperature = Temperature.WARM;
				default:
				}
				break;
			case HIGH:
				switch (myTemperature) {
				case HOT:
					myTemperature = Temperature.BLAZING;
					break;
				case WARM:
					myTemperature = Temperature.HOT;
					break;
				case COLD:
					myTemperature = Temperature.WARM;
				default:
				}
			}
			timer = TIME_DURATION;
		}
	}

	// Display both setting and temperature info.
	public void display() {
		System.out.println("[" + this.mySetting + "]....." + this.myTemperature.displayStr);
	}
}
