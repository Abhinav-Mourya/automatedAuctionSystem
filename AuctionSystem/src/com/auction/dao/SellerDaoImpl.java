package com.auction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.exception.ProductException;
import com.auction.exception.SellerException;
import com.auction.model.Products;
import com.auction.model.Seller;
import com.auction.model.products_sold;
import com.auction.utility.DBUtility;

public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) throws SellerException {
	
		String message = "";
		
		try (Connection conn=DBUtility.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into seller (sellerFirstName, sellerLastName, sellerEmail, sellerPassword, sellerMobile, sellerDob) values(?, ?, ?, ?, ?, ?)");
			
            ps.setString(1, seller.getSellerFirstName());
			ps.setString(2, seller.getSellerLastName());
			ps.setString(3, seller.getSellerEmail());
			ps.setString(4, seller.getSellerPassword());
			ps.setString(5, seller.getSellerMobile());
			ps.setDate(6, seller.getSellerDob());
			
			
			int x = ps.executeUpdate();
			
			if(x> 0 ) {
				message= "Seller successfully register ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
	}

	
	
	

	
	
	@Override
	public Seller loginBySeller(String username, String password) throws SellerException {
		
		Seller seller= null;
		
try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Seller where sellerEmail = ? AND sellerPassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();

			if(rs.next()) {
				
				seller= new Seller();
				
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerFirstName(rs.getString("sellerFirstName"));
				seller.setSellerLastName(rs.getString("sellerLastName"));
				seller.setSellerEmail(rs.getString("sellerEmail"));
				seller.setSellerPassword(rs.getString("sellerPassword"));
				seller.setSellerMobile(rs.getString("sellerMobile"));
				seller.setSellerDob(rs.getDate("sellerDob"));
			}
			else {
				throw new SellerException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		return seller;
		
		
	}
	
	
	


	@Override
	public String resetPasswordBySeller(String username, String password) throws SellerException {
		
		
		String message = "Email/username does not exist ...";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update seller set sellerPassword = ? where sellerEmail = ?");
			
			ps.setString(1, password);
			
			ps.setString(2, username);
			
			int x = ps.executeUpdate();
			
			if(x > 0 ) {
				message= "Password successfully reset, login again ...";
			}
			else {
				throw new SellerException(message);
			}
			
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return message;
	}
	
	
	

	@Override
	public String resetUsernameBySeller(String sellerFirstName, String username, Date dob, String mobile) throws SellerException{
	
	
	String message = "Email/username reset was unsuccessfull";
	
	try (Connection conn = DBUtility.provideConnection()) {
		
		PreparedStatement ps = conn.prepareStatement("update seller set sellerEmail= ? where sellerFirstName= ? AND sellerDob= ? AND sellerMobile = ?");
		
		ps.setString(1, username);
		
		ps.setString(2, sellerFirstName);
		
		ps.setDate(3, dob);
		
		ps.setString(4, mobile);
					
		int x = ps.executeUpdate();
		
		if(x> 0 ) {
			message= "Email/username successfully reset ...";
		}
		else {
			throw new SellerException("seller does not exist");
		}
		
	} catch (SQLException e) {
		throw new SellerException(e.getMessage());
	}
	
	
	return message;
	}
	
	
	
	
	
	
	
	

	@Override
	public String addListOfItems(List<Products> arr) throws ProductException {
		
		String msg= "items are duplicate, so not inserted";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			int x= 0;
			PreparedStatement ps = conn.prepareStatement("insert into Products(sellerId, categoryId, productAddedDate, sellingPrice, productName, productQuantity, auctionAddress, auctionDate) values(?, ?, sysdate(), ?, ?, ?, ?, adddate(sysdate(), INTERVAL ? DAY))");

			for(Products p : arr) {
				ps.setInt(1, p.getSellerId());
				ps.setInt(2, p.getCategoryId());
				ps.setInt(3, p.getSellingPrice());
				ps.setString(4, p.getProductName());
				ps.setInt(5, p.getProductQuantity());
				ps.setString(6, p.getAuctionAddress());
				ps.setInt(7, p.getDays());
				x=x+ps.executeUpdate();
				
			}
			
			if(x > 0) {
				msg= x+ " records successfully inserted...";
			}
			else {
				throw new ProductException(msg);
			}
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		return msg;
		
	}

	
	
	
	
	@Override
	public String updateItemPrice(int sid, String itemName, int updatePrice) throws ProductException {

		
		String message = "Product is not present in the list!!!";
		
		try (Connection conn = DBUtility.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("update products set sellingPrice = ? where sellerId  = ? and productName= ?");
			
			ps.setInt(1, updatePrice);
			ps.setInt(2, sid);
			ps.setString(3, itemName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Price successfully updated ";
			}
			else {
				throw new ProductException(message);
			}
			
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return message;

	}
	
	
	
	
	
	
	
	
	

	@Override
	public String updateItemQuantity(int sid, String itemName, int itemQuantity) throws ProductException {
	
		
		String message = "Product is not present in the list!!!";
		
		try (Connection conn = DBUtility.provideConnection()) {
			PreparedStatement ps= conn.prepareStatement("update products set productQuantity = ? where sellerId  = ? and productName= ?");
			
			ps.setInt(1, itemQuantity);
			ps.setInt(2, sid);
			ps.setString(3, itemName);
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = " Quantity successfully updated";
			}
			else {
				throw new ProductException(message);
			}
			
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return message;
	}

	
	
	
	
	
	
	
	@Override
	public String updateItemPriceAndQuantity(int sid, String itemName, int updatePrice, int itemQuantity) throws ProductException{
	
	String message = "Product is not present in the list!!!";
	
	try (Connection conn = DBUtility.provideConnection()) {
		PreparedStatement ps= conn.prepareStatement("update products set productQuantity = ?, sellingPrice = ? where sellerId  = ? and productName= ?");
		
		ps.setInt(1, itemQuantity);
		ps.setInt(2, updatePrice);
		ps.setInt(3, sid);
		ps.setString(4, itemName);
		
		int x = ps.executeUpdate();
		
		if(x > 0) {
			message = x+ " successfully updated";
		}
		else {
			throw new ProductException(message);
		}
		
	} catch (SQLException e) {
		throw new ProductException(e.getMessage());
	}
	
	
	return message;
	
	}

	
	
	
	
	
	
	
	@Override
	public String addItemInTheList(Products item) throws ProductException {
		
		
		String msg= "item is duplicate, so not inserted";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into products (sellerId, categoryId, productAddedDate, sellingprice, productName, productQuantity, auctionAddress, auctionDate) values(?, ?, sysdate(), ?, ?, ?, ?, adddate(sysdate(), INTERVAL ? DAY))");

			
				ps.setInt(1, item.getSellerId());
				ps.setInt(2, item.getCategoryId());
				ps.setInt(3, item.getSellingPrice());
				ps.setString(4, item.getProductName());
				ps.setInt(5, item.getProductQuantity());
				ps.setString(6, item.getAuctionAddress());
				ps.setInt(7, item.getDays());
			
				int x = ps.executeUpdate();
			
			if(x > 0) {
				msg= x+ " records successfully inserted...";
			}
			else {
				throw new ProductException(msg);
			}
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		return msg;
	}

	
	
	
	
	@Override
	public String removeItemFromTheList(int sid, String itemName) throws ProductException {
	
		
		String message = "Such item name is not present";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from products where sellerId=? AND productName = ?");
			
			ps.setInt(1, sid);
			ps.setString(2, itemName);
			
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Item successfully remove..";
			}
			else {
				throw new ProductException(message);
			}
			
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return message;
	}
	
	
	
	
	
	

	@Override
	public List<products_sold> soldItemList(int sid) throws ProductException {
		
           List<products_sold> soldItems =  new ArrayList<>();
		
		try(Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from products_sold where sellerId = ? order by auctionDate desc");
			ps.setInt(1, sid);
			
			ResultSet rs = ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				products_sold sold = new products_sold();
				sold.setAuctionId(rs.getInt("auctionId"));
				sold.setSellerId(rs.getInt("sellerId"));
				sold.setBuyerId(rs.getInt("buyerId"));
				sold.setCategoryId(rs.getInt("categoryId"));
				sold.setProductName(rs.getString("productName"));
				sold.setProductQuantity(rs.getInt("productQuantity"));
				sold.setProductAddedDate(rs.getDate("productAddedDate"));
				sold.setSellingPrice(rs.getInt("sellingPrice"));
				sold.setAuctionPrice(rs.getInt("auctionPrice"));
				sold.setAuctionAddress(rs.getString("auctionAddress"));
				sold.setAuctionDate(rs.getDate("auctionDate"));
				
				soldItems.add(sold);
			}
			if(flag) {
				throw new ProductException("No any item sold");
			}
			
		}
		catch(SQLException e) {
			throw new ProductException(e.getMessage());
		}
		return soldItems;
		
		
	}
	
	
	
	
	
	
	
	
	

	@Override
	public List<Products> sellingItemList(int sid) throws ProductException {
		
        List<Products> sellingItems = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from products where sellerId = ? order by productAddedDate desc");
			
			ps.setInt(1, sid);
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				
				Products sellingItem = new Products();
				sellingItem.setAutionID(rs.getInt("auctionID"));
				sellingItem.setSellerId(rs.getInt("sellerId"));
				sellingItem.setCategoryId(rs.getInt("categoryId"));
				sellingItem.setProductAddedDate(rs.getDate("productAddedDate"));
				sellingItem.setSellingPrice(rs.getInt("sellingPrice"));
				sellingItem.setProductName(rs.getString("productName"));
				sellingItem.setProductQuantity(rs.getInt("productQuantity"));
				sellingItem.setAuctionAddress(rs.getString("auctionAddress"));
				sellingItem.setAuctionDate(rs.getDate("auctionDate"));
				sellingItems.add(sellingItem);
			}
			if(flag) {
				throw new ProductException("No items available for selling...");
			}
			
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return sellingItems;	
		
	}
	

}
