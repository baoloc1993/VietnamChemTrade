package chemtrade.entity;

/**
 * Wrapper class which store information to display in downloadCenter.jsp
 * @author ngolebaoloc
 *
 */
public class DownloadWrapper{
	private Product product;
	private String background;
	private String country;
	private String label1;
	private String label2;
	private int number;
	private int showPage;
	private int pageCount;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void setBackground(String background) {
		this.background = background;
	}
	
	public String getBackground() {
		return background;
	}
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLabel1() {
		return label1;
	}

	public void setLabel1(String label1) {
		this.label1 = label1;
	}

	public String getLabel2() {
		return label2;
	}

	public void setLabel2(String label2) {
		this.label2 = label2;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}
	
	
}
