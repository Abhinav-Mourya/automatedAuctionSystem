package com.auction.dao;

import java.sql.Date;
import java.util.List;

import com.auction.exception.ProductException;
import com.auction.exception.SellerException;
import com.auction.model.Products;
import com.auction.model.Seller;
import com.auction.model.products_sold;

public interface SellerDao {
	
	public String registerSeller(Seller seller)throws SellerException;
	
	public Seller loginBySeller(String username, String password) throws SellerException;
	
	public String resetPasswordBySeller (String username, String password) throws SellerException;
	
	public String resetUsernameBySeller (String sellerFirstName, String username, Date dob, String mobile) throws SellerException;
	
	public String addListOfItems(List<Products> list) throws ProductException;
	
	public String updateItemPrice(int sid, String itemName, int updatePrice) throws ProductException;
	
	public String updateItemQuantity(int sid, String itemName, int itemQuantity) throws ProductException;
	
	public String updateItemPriceAndQuantity(int sid, String itemName, int updatePrice, int itemQuantity) throws ProductException;
	
	public String addItemInTheList(Products item) throws ProductException;
	
	public String removeItemFromTheList(int sid, String itemName) throws ProductException;
	
	public List<products_sold> soldItemList(int sid) throws ProductException;
	
	public List<Products> sellingItemList(int sid) throws ProductException;

}
