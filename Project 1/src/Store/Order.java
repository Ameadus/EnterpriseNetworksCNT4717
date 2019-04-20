/*
 * Alexander Meade
 * CNT4714 SPR18
 * PROJECT 1 Event Driven Programming 
 * Due: 1/28/18
*/
package Store;

public class Order {
	private Books bookOrder;
	private int numBooks;
	private float bookDiscount;
	private float orderSubtotal;
	
	//getter and setter for book order 
	public Books getbookOrder() {
		return this.bookOrder;
	}
	
	public void setbookOrder(Books bookOrder) {
		this.bookOrder = bookOrder; 
	}
	//gettter setters for quantity 
	public int getnumBooks() {
		return this.numBooks;
	}
	public void setnumBooks(int numBooks) {
		 this.numBooks = numBooks;
	}
	//getter setters for subtotal 
	public void setorderSubtotal(float orderSubtotal) {
		this.orderSubtotal = orderSubtotal; 
	}
	public float getorderSubtotal() {
		return this.orderSubtotal; 
	}
	//getters and setters for discounts 
	public float getbookDiscount() {
		return this.bookDiscount;
	}
	public void setbookDiscount(float bookDiscount) {
		this.bookDiscount = bookDiscount; 
	}
}
