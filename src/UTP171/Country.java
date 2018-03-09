package UTP171;

import javax.swing.ImageIcon;

public class Country {
	
	private String name;
	private String capital;
	private int population;
	private ImageIcon flag;
	
	public Country(String name, String capital, int population, ImageIcon flag) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public ImageIcon getFlag() {
		return flag;
	}

	public void setFlag(ImageIcon flag) {
		this.flag = flag;
	}
	
}
