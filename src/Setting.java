
public enum Setting {
	OFF("---", 0), LOW("--+", 1), MEDIUM("-++", 3), HIGH("+++", 4);
	private String setting;
	public int numEqv;
	Setting (String setting, int numEqv) {
		this.setting = setting;
		this.numEqv = numEqv;
	}
	public String toString() {
		return setting;
	}
}
