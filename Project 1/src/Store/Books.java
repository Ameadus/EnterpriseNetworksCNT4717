/*
 * Alexander Meade
 * CNT4714 SPR18
 * PROJECT 1 Event Driven Programming 
 * Due: 1/28/18
*/
package Store;

public class Books {
	private String bookName;  //title of book 
	private float bookPrice; //cost amount in dollars 
	private int bookID; // int ID tied to book 
	private String bookInfo; // book information 



//empty constructor 
public Books() {
	setbookInfo("Given ID doesn't corespond to any book in database.");
}
//rest are all getters and setters of the classes values 
//setter book info 
public void setbookInfo(String bookInfo) {
	this.bookInfo = bookInfo; 
}
//getter book info 
public String getbookInfo() {
	return bookInfo; 
}
//getter book price 
public float getbookPrice() {
	return bookPrice; 
}
//setter book price 
public void setbookPrice(float bookPrice) {
	this.bookPrice = bookPrice; 
}
//getter book ID
public int getbookID() {
	return bookID;
}
//setter book ID 
public void setbookID(int bookID) {
	this.bookID = bookID;
}
//setter book name 
public void setbookName(String bookName) {
	this.bookName = bookName;
}
//getter book name 
public String getbookName() {
	return bookName;
}
}
