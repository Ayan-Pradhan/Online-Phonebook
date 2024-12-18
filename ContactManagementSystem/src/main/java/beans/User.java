package beans;

public class User {
	private String email;
	private String contact;
	private String name;
	private String password;
	
	public User(String email, String contact, String name, String password) {
		super();
		this.email = email;
		this.contact = contact;
		this.name = name;
		this.password = password;
	}
	
	public User() {
		super();
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", contact=" + contact + ", name=" + name + ", password=" + password + "]";
	}
}
