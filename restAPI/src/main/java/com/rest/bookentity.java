package com.rest;

public class bookentity {

	private int bookid;
	private String title;
	private String author;
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public bookentity(int bookid, String title, String author) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
	}
	public bookentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "bookentity [bookid=" + bookid + ", title=" + title + ", author=" + author + "]";
	}
	
}
