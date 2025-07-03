
public class Burner {
	private enum Temperature { 
		BLAZING(3), 
		HOT(2), 
		WARM(1), 
		COLD(0);

		public int numLevel;
		Temperature(int lvl) {
			this.numLevel = lvl;
		}
		
	};

	private Temperature myTemperature = Temperature.COLD;
	private Setting mySetting = Setting.OFF;
	private int timer = 0;
	private final static int TIME_DURATION = 2;


	public Temperature getMyTemperature() {
		return myTemperature;
	}

	public void plusButton() {
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


	public void updateTemperature() {
		if (++timer == TIME_DURATION) {
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
			timer = 0;
		}
	}

	public void display() {

	}


}
