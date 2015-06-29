package chemtrade.entity;

public class CountryCode {
	private int id;
	private String cCode;
	private String country;
	private String longName;
	private String iso3;
	private String numCode;
	private String callingCode;
	private String tld;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLongName() {
		return longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}
	public String getIso3() {
		return iso3;
	}
	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}
	public String getNumCode() {
		return numCode;
	}
	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}
	public String getCallingCode() {
		return callingCode;
	}
	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}
	public String getTld() {
		return tld;
	}
	public void setTld(String tld) {
		this.tld = tld;
	}
	
}
