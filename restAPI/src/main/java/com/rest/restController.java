package com.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class restController {

	@Autowired
	private bookDao bookdao;
	
	
	//@RequestMapping(value = "/books",method=RequestMethod.GET)
	@GetMapping("/books")
	//@ResponseBody
	public ResponseEntity< List<bookentity>> getBooks() {
		/*
		 * bookentity book=new bookentity(); book.setBookid(01);
		 * book.setTitle("ramayan"); book.setAuthor("valmiki");
		 */
		
		List<bookentity> list=bookdao.getAllBooks();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
		// internally jackson is used and convert this object into json format and vice versa
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<bookentity> getsinglebook(@PathVariable("id") int id) {
		bookentity book=this.bookdao.getById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<bookentity> insertbook(@RequestBody bookentity book) {
		bookentity book1=null;
		
		try {
			book1=this.bookdao.insertbook(book1);
			System.out.println(book1);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
		 	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
		
		
		
		
	}
	
	@DeleteMapping("/books/{bookid}")
	public ResponseEntity deletebook(@PathVariable("bookid") int bid) {
		try {
			 this.bookdao.deletebook(bid);
			 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/books/{bookid}")
		public ResponseEntity<bookentity> updatebook(@RequestBody bookentity book,@PathVariable("bookid") int Bid) {
			
			try {
				this.bookdao.updatebook(book,Bid);
				return ResponseEntity.status(HttpStatus.OK).body(book);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		
		
	}
}
