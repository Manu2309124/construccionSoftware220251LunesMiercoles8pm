package app.domain.models;

public class Person //suario{
	private long PersonId;
	private String name;
	private long document;
	private int age;
	public Person(long PersonId, String name, long document, int age) {
		super();
		this.PersonId = PersonId;
		this.name = name;
		this.document = document;
		this.age = age;
	}
	public long getPersonId() {
		return PersonId;
	}
	public void setId( long PersonId) {
		this.PersonId = PersonId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
