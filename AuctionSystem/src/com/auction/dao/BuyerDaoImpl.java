package com.auction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.auction.exception.BuyerException;
import com.auction.exception.ProductException;
import com.auction.model.Buyer;
import com.auction.model.Buyer_Item;
import com.auction.model.Products;
import com.auction.utility.DBUtility;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) throws BuyerException {
	
		String message = "Buyer`s email is already registered.";
		
		try (Connection conn = DBUtility.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into buyer (buyerFirstName, buyerLastName, buyerEmail, buyerPassword, buyerMobile, buyerDob) values(?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, buyer.getBuyerFirstName());
			ps.setString(2, buyer.getBuyerLastName());
			ps.setString(3, buyer.getBuyerEmail());
			ps.setString(4, buyer.getBuyerPassword());
			ps.setString(5, buyer.getBuyerMobile());
			ps.setDate(6, buyer.getBuyerDob());
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Buyer successfully register...";
			}
			else {
				throw new BuyerException(message);
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}

		return message;
		
		
	}

	
	
	
	
	
	@Override
	public Buyer loginBuyer(String username, String password) throws BuyerException {
	
		Buyer buyer= null;
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Buyer where buyerEmail = ? AND buyerPassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();

			if(rs.next()) {
				buyer= new Buyer();
				buyer.setBuyerId(rs.getInt("buyerId"));
				buyer.setBuyerFirstName(rs.getString("buyerFirstName"));
				buyer.setBuyerLastName(rs.getString("buyerLastName"));
				buyer.setBuyerEmail(rs.getString("buyerEmail"));
				buyer.setBuyerPassword(rs.getString("buyerPassword"));
				buyer.setBuyerMobile(rs.getString("buyerMobile"));
				buyer.setBuyerDob(rs.getDate("buyerDob"));
			}
			else {
				throw new BuyerException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		return buyer;
	}

	
	
	

	@Override
	public String resetPasswordByBuyer(String username, String password) throws BuyerException {
	
		
		String message = "Email/username does not exist ...";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update buyer set buyerPassword = ? where buyerEmail = ?");
			
			ps.setString(1, password);
			
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Password successfully reset, login again ...";
			}
			else {
				throw new BuyerException(message);
			}
			
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return message;
		
		
	}

	@Override
	public String resetUsernameByBuyer(String firstName, String username, Date dob, String mobile) throws BuyerException{
	
	String message = "Email/username already exist ...";
	
	try (Connection conn = DBUtility.provideConnection()) {
		
		PreparedStatement ps = conn.prepareStatement("update buyer set buyerEmail= ? where buyerFirstName= ? AND buyerDob= ? AND buyerMobile = ?");
		
		ps.setString(1, username);
		
		ps.setString(2, firstName);
		
		ps.setDate(3, dob);
		
		ps.setString(4, mobile);
					
		int x = ps.executeUpdate();
		
		if(x > 0 ) {
			message= "Email/username successfully reset ...";
		}
		else {
			throw new BuyerException(message);
		}
		
	} catch (SQLException e) {
		throw new BuyerException(e.getMessage());
	}
	
	
	return message;
	}
	
	
	
	
	
	
	

	@Override
	public Map<Integer, Products> SearchItemByName(String itemName) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Products> SearchItemByCategory(String categoryName) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Products> viewAllItem() throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Buyer_Item> listOfBuyerAndItemCategoryWise() throws BuyerException, ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Products selectItemWithBuyerList(Map<Integer, Buyer_Item> listBuyerAndItem, int index)
			throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectItemToBuy(Products item) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}



}
