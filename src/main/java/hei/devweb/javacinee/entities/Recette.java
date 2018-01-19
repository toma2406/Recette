package hei.devweb.javacinee.entities;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class Recette {

	private Integer id;
	private String Nom;
	private String Text;
	private String Ingredients;
	private String Difficulte;
	private String Type;
	private Integer deleted;


	public Recette(Integer id, String Nom,  String Text,String Ingredients, String Difficulte, String Type, int deleted) {
		super();
		this.id = id;
		this.Nom = Nom;
		this.Text = Text;
		this.Ingredients = Ingredients;
		this.Difficulte= Difficulte;
		this.Type= Type;
		this.deleted=deleted;


	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String Nom) {
		this.Nom = Nom;
	}

	public String getText() {
		return Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}

	public String getIngredients() {
		return Ingredients;
	}

	public void setIngredients(String Ingredients) {
		this.Ingredients = Ingredients;
	}
	public String getDifficulte(){
		return Difficulte;
	}

	public void setDifficulte(String Difficulte) {
		this.Difficulte=Difficulte;

	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = Type;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}




