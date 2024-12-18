package beans;

public class Contact {
	private String email;
	private String contact;
	private String name;
	private String owner;
	
	public Contact(String email, String contact, String name, String owner) {
		super();
		this.email = email;
		this.contact = contact;
		this.name = name;
		this.owner = owner;
	}
	public Contact() {
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Override
	public String toString() {
		return "Contact [email=" + email + ", contact=" + contact + ", name=" + name + ", owner=" + owner + "]";
	}
}
