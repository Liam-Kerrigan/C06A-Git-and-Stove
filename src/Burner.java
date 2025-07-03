
public class Burner {
	private enum Temperature { BLAZING, HOT, WARM, COLD };
	private Temperature myTemperature = COLD;
	private Setting mySetting = OFF;
	private int timer;
	private final static int TIME_DURATION = 2;

	public Temperature getMyTemperature() {
		return myTemperature;
	}

	public plusButton() {
		switch (mySetting) {
		case OFF:
			mySetting = LOW;
			break;
		case LOW:
			mySetting = MEDIUM;
			break;
		case MEDIUM:
		case HIGH:
			mySetting = HIGH;
			break;
		}
	}

	public minusButton() {
		switch (mySetting) {
		case OFF:
		case LOW:
			mySetting = OFF;
			break;
		case MEDIUM:
			mySetting = LOW;
			break;
		case HIGH:
			mySetting = MEDIUM;
			break;
		}
	}

	public updateTemperature() {

	}

	public display() {

	}


}
