package be.jarchitects.springbatch.model;
public class ScrapeRecord {
	private Long id;
	private String customerId;
	private String companyName;
	private String address;
	private String city;
	private String street;
	private String houseNumber;
	private String postalCode;
	private String openingHours;
	private String categories;
	private String telephone;
	private String url;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ScrapeRecord=");
        sb.append("{id=").append(id);
        sb.append("{custId='").append(customerId).append('\'');
        sb.append(", compName='").append(companyName).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String custId) {
		this.customerId = custId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
