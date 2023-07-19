package country;

public class Country {
	private String name;
	private int population;
	private String continent;
	
	
	public Country() {
	}
	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}
	
	public Country(String continent, String name) {
		super();
		this.name = name;
		this.continent = continent;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
}
