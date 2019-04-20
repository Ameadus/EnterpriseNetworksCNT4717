/*
 * Alexander Meade
 * CNT4714 SPR18
 * PROJECT 1 Event Driven Programming 
 * Due: 1/28/18
*/
package Store;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Invoice {
	private ArrayList<Order> storeOrder;
	private int totalBooks = 0;
	private float subTotal = 0;
	private float grandTotal = 0;
	private String timeStamp;
	private String transaction;
	
	
	public Invoice() {
		this.storeOrder = new ArrayList<Order>();
	}
	
	public ArrayList<Order> getstoreOrder(){
		return this.storeOrder; 
	}
	
	public void settotalBooks(int totalBooks) {
	this.totalBooks = totalBooks;
	}
	
	public int gettotalBooks() {
		return totalBooks; 
	}
	
	public float getsubTotal() {
		return  subTotal; 
	}
	public void setsubTotal(float subTotal) {
		this.subTotal = subTotal; 
	}
	public float getgrandTotal() {
		return grandTotal;
	}
	public void setgrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	//only getters for transaction and timestamp will be set by user input 
	public String getTransaction() {
		return this.transaction;
	}
	public String gettimeStamp() {
		return this.timeStamp;	
	}
	//add to invoice 
	public void addOrder(Order storeOrder) {
		this.storeOrder.add(storeOrder);
	}
	//generate date info 
	public void setDate() {
		Date orderDate = new Date(); //date var
		DateFormat oDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a z");
		//above sets date format 
		this.timeStamp = oDateFormat.format(orderDate); //save timestamp
		oDateFormat = new SimpleDateFormat("yyMMddHHmmss"); //adjust for transaction
		this.transaction = oDateFormat.format(orderDate); //save tranasaction 
	}
}
