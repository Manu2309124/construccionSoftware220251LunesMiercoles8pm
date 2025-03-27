package app.domain.models;

public class Pet {
	private String name;
	private long OwnerId;
	private int age;
	private long id;
	private String species;
	private String race;
	private String characteristics;
	private long weight;
	public Pet(String name, long ownerId, int age, long id, String species, String race, String characteristics,
			long weight) {
		super();
		this.name = name;
		this.OwnerId = ownerId;
		this.age = age;
		this.id = id;
		this.species = species;
		this.race = race;
		this.characteristics = characteristics;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(long ownerId) {
		OwnerId = ownerId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	


}
