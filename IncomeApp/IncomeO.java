package IncomeApp;

public class IncomeO {

	private String country;
	  private String city;
	  private String gender;
	  private String currency;
	  private Double avgIncome;


	  public IncomeO(final String country, final String city, final String gender,
	      final String currency,
	      final Double avgIncome) {
	    this.country = country;
	    this.city = city;
	    this.gender = gender;
	    this.currency = currency;
	    this.avgIncome = avgIncome;
	  }

	  @Override
	  public String toString() {
	    return "Income{" +
	        "country='" + country + '\'' +
	        ", city='" + city + '\'' +
	        ", gender='" + gender + '\'' +
	        ", currency=" + currency +
	        ", avgIncome='" + avgIncome + '\'' +
	        '}';
	  }

	  public String getCountry() {
	    return country;
	  }

	  public void setCountry(final String country) {
	    this.country = country;
	  }

	  public String getCity() {
	    return city;
	  }

	  public void setCity(final String city) {
	    this.city = city;
	  }

	  public String getGender() {
	    return gender;
	  }

	  public void setGender( String gender) {
	    this.gender = gender;
	  }

	  public String getCurrency() {
	    return currency;
	  }

	  public IncomeO() {
		
	}

	public void setCurrency( String currency) {
	    this.currency = currency;
	  }

	  public Double getAvgIncome() {
	    return avgIncome;
	  }

	  public void setAvgIncome( Double avgIncome) {
	    this.avgIncome = avgIncome;
	  }
	}
	

