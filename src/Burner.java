
public class Burner {
	private enum Temperature { 
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
	private final static int TIME_DURATION = 2;
	
	Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}


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

	public void display() {
		System.out.println("[" + this.mySetting + "]....." + this.myTemperature.displayStr);
	}


}
