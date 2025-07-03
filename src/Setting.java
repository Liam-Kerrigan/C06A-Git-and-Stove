/*
Class: Small Enumerated type, Used to track the current setting of a burner. 
has a toString function for the burner.display() function.
Author(s): Hiram Despain and Liam Kerrigan.
Date: 7/2/2025
*/
public enum Setting {
	
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");

	private String setting;

	Setting (String setting) {
		this.setting = setting;
	}

	public String toString() {
		return setting;
	}
}
