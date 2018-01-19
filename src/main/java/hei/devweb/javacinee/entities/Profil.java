package hei.devweb.javacinee.entities;

public class Profil {
	private Integer id;
	private String Prenom;
	private String Nom;
	private int Age;
	private String Ecole;
	private String Pseudo;

	public Profil(Integer id,String Prenom, String Nom, int Age, String Ecole, String Pseudo){
		this.Nom=Nom;
		this.id=id;
		this.Prenom=Prenom;
		this.Age=Age;
		this.Ecole=Ecole;
		this.Pseudo=Pseudo;
	}

	public int getAge() {
		return Age;
	}

	public String getEcole() {
		return Ecole;
	}

	public String getNom() {
		return Nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public Integer getId() {
		return id;
	}

	public String getPseudo() {
		return Pseudo;
	}

	public void setAge(int age) {
		Age = age;
	}

	public void setEcole(String ecole) {

	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public void setPseudo(String pseudo) {
		Pseudo = pseudo;
	}
}
