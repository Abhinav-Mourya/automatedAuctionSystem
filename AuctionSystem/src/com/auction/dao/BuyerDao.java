package com.auction.dao;

import java.sql.Date;
import java.util.Map;

import com.auction.exception.BuyerException;
import com.auction.exception.ProductException;
import com.auction.model.Buyer;
import com.auction.model.Buyer_Item;
import com.auction.model.Products;

public interface BuyerDao {
	
public String registerBuyer(Buyer buyer) throws BuyerException;
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;

	public String resetPasswordByBuyer(String username, String password) throws BuyerException;
	
	public String resetUsernameByBuyer(String firstName, String username, Date dob, String mobile) throws BuyerException;
	
	public Map<Integer, Products> SearchItemByName (String itemName) throws  ProductException;
	
	public Map<Integer, Products> SearchItemByCategory (String categoryName) throws  ProductException;
	
	public Map<Integer, Products> viewAllItem() throws  ProductException;
	
	public Map<Integer, Buyer_Item> listOfBuyerAndItemCategoryWise() throws BuyerException,  ProductException;
	
	public Products selectItemWithBuyerList(Map<Integer, Buyer_Item> listBuyerAndItem, int index) throws  ProductException;
	
	public String selectItemToBuy(Products item) throws ProductException;

}
