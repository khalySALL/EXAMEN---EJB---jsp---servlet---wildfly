package sn.isi.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Cv implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String prenom;
	@Column
	private int age;
	@Column
	private String adresse;
	@Column
	private String email;
	@Column
	private String telephone;
	@Column
	private String specialite;
	@Column
	private String niveauetude;
	@Column
	private String experiencepro;
	
	
	@ManyToOne(fetch = FetchType.LAZY)  
	@JoinColumn( name="id_User" )
    private User user;
	
	
	//@ManyToOne
	//@JoinColumn(name="User_ID")
	//private User user = new User();
	
	//@OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	//@JoinColumn(name = "id_user",referencedColumnName = "id")
	//private User user;
	
	
	public Cv(User user) {
		super();
		this.user = user;
	}
	public Cv() {
		super();
	}
	public Cv(int id, String name, String prenom, int age, String adresse, String email, String telephone,
			String specialite, String niveauetude, String experiencepro) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.specialite = specialite;
		this.niveauetude = niveauetude;
		this.experiencepro = experiencepro;
	}
	/*public Cv(User user) {
		super();
		this.user = user;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getNiveauetude() {
		return niveauetude;
	}
	public void setNiveauetude(String niveauetude) {
		this.niveauetude = niveauetude;
	}
	public String getExperiencepro() {
		return experiencepro;
	}
	public void setExperiencepro(String experiencepro) {
		this.experiencepro = experiencepro;
	}
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	
}
