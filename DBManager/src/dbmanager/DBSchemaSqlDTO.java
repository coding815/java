package dbmanager;

public class DBSchemaSqlDTO {

	int index;
	String date;
	String author;
	String textContent;
	String type;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}

