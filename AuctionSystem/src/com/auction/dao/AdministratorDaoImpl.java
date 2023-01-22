package com.auction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.exception.AdministratorException;
import com.auction.exception.BuyerException;
import com.auction.exception.DisputeException;
import com.auction.exception.ProductException;
import com.auction.exception.SellerException;
import com.auction.model.Administrator;
import com.auction.model.Buyer;
import com.auction.model.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import com.auction.model.DisputeSellerToAppWithTeamNameDto;
import com.auction.model.Seller;
import com.auction.model.products_sold;
import com.auction.utility.DBUtility;

public class AdministratorDaoImpl implements AdministratorDao{

	@Override
	public Administrator loginAdministrator(String username, String password) throws AdministratorException {
		
		Administrator administrator= null;
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("select * from Administrator where adminEmail = ? AND adminPassword = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				administrator= new Administrator();
				administrator.setAdminId(rs.getInt("adminId"));
				administrator.setAdminFirstName(rs.getString("adminFirstName"));
				administrator.setAdminLastName(rs.getString("adminLastName"));
				administrator.setAdminEmail(rs.getString("adminEmail"));
				administrator.setAdminPassword(rs.getString("adminPassword"));
				administrator.setAdminMobile(rs.getString("adminMobile"));
				administrator.setAdminDob(rs.getDate("adminDob"));
			}
			else {
				throw new AdministratorException("Invalid username or password..."); 
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		return administrator;
		
	}
	
	
	
	

	@Override
	public String changePasswordAdmin(String username, String password) throws AdministratorException {

		
		String message = "Password can not change...";
		
		try (Connection conn = DBUtility.provideConnection()) {
			
			PreparedStatement ps =  conn.prepareStatement("update administrator set adminPassword = ? where adminEmail= ?");
			
			
			ps.setString(1, password);
			ps.setString(2, username);
			
			int x= ps.executeUpdate();
            
			if(x> 0) {
				message = "Password change successfully...";
			}
			else {
				throw new AdministratorException(message); 
			}
			
		} catch (SQLException e) {
			throw new AdministratorException(e.getMessage());
		}
		
		
		return message;
	}
	
	
	
	
	
	
	
	

	@Override
	public List<Buyer> listOfBuyers() throws BuyerException {
		
		
	List<Buyer> buyers = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			
			while(rs.next()) {
				flag= false;
				Buyer buyer = new Buyer();
				buyer.setBuyerId(rs.getInt("buyerId"));
				buyer.setBuyerFirstName(rs.getString("buyerFirstName"));
				buyer.setBuyerLastName(rs.getString("buyerLastName"));
				buyer.setBuyerEmail(rs.getString("buyerEmail"));
				buyer.setBuyerPassword(rs.getString("buyerPassword"));
				buyer.setBuyerMobile(rs.getString("buyerMobile"));
				buyer.setBuyerDob(rs.getDate("buyerDob"));
				buyers.add(buyer);
			}
			if(flag) {
				throw new BuyerException("Buyer information is not present...");
			}
		} catch (SQLException e) {
			throw new BuyerException(e.getMessage());
		}
		
		
		return buyers;
		
	}
	
	
	
	
	

	@Override
	public List<Seller> listOfSeller() throws SellerException {
		
		
List<Seller> sellers = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from seller");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				Seller seller = new Seller();
				seller.setSellerId(rs.getInt("sellerId"));
				seller.setSellerFirstName(rs.getString("sellerFirstName"));
				seller.setSellerLastName(rs.getString("sellerLastName"));
				seller.setSellerEmail(rs.getString("sellerEmail"));
				seller.setSellerPassword(rs.getString("sellerPassword"));
				seller.setSellerMobile(rs.getString("sellerMobile"));
				seller.setSellerDob(rs.getDate("sellerDob"));
				sellers.add(seller);
			}
			if(flag) {
				throw new SellerException("Seller information is not present...");
			}
		} catch (SQLException e) {
			throw new SellerException(e.getMessage());
		}
		
		
		return sellers;
	}
	
	
	
	
	
	

	@Override
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> disputeListBuyerToSeller() throws DisputeException {
		
		
List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> dispute = new ArrayList<>(); 
		
		try (Connection conn = DBUtility.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.disputeId, s.buyerId, s.sellerId, c.categoryName, s.disputeDetails, s.disputeDate, s.solutionDate, s.IsSolve, t.disputeTeamName from buyer_to_seller s INNER JOIN disputeHandleTeam t INNER JOIN category c ON s.categoryId = t.categoryId AND s.categoryId = c.categoryId AND s.IsSolve = false");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			
			
			while(rs.next()) {
				flag= false;
				DisputeBuyerToSellerWithTeamAndCategoryNameDTO buyertoSeller = new DisputeBuyerToSellerWithTeamAndCategoryNameDTO();
				buyertoSeller.setDisputeId(rs.getInt("did"));
				buyertoSeller.setBuyerId(rs.getInt("bid"));
				buyertoSeller.setSellerId(rs.getInt("sid"));
				buyertoSeller.setCategoryName(rs.getString("cname"));
				buyertoSeller.setDisputeDetails(rs.getString("disputeDetail"));
				buyertoSeller.setDisputeDate(rs.getDate("dDate"));
				buyertoSeller.setSolutionDate(rs.getDate("solutionDate"));
				buyertoSeller.setIsSolve(rs.getBoolean("IsSolve"));
				buyertoSeller.setDisputeTeamName(rs.getString("DTname"));
				
				dispute.add(buyertoSeller);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		return dispute;
	}
	
	
	

	
	
	
	
	@Override
	public List<DisputeSellerToAppWithTeamNameDto> disputeListSellerToApp() throws DisputeException {
		
		List<DisputeSellerToAppWithTeamNameDto> dispute = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.disputeId, s.sellerId, s.categoryId, s.disputeDetails, s.disputeDate, s.solutionDate, s.IsSolve, t.disputeTeamName from seller_app s INNER JOIN disputHandleTeam t ON s.categoryId = t.categoryId AND s.IsSolve = false");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				DisputeSellerToAppWithTeamNameDto sellerdto = new DisputeSellerToAppWithTeamNameDto();
				sellerdto.setDisputeId(rs.getInt("did"));
				sellerdto.setSellerId(rs.getInt("sid"));
				sellerdto.setCategoryId(rs.getInt("cid"));
				sellerdto.setDisputeDetails(rs.getString("disputDetail"));
				sellerdto.setDisputeDate(rs.getDate("dDate"));
				sellerdto.setSolutionDate(rs.getDate("solutionDate"));
				sellerdto.setIsSolve(rs.getBoolean("IsSolve"));
				sellerdto.setDisputeTeamName(rs.getString("DTname"));
				dispute.add(sellerdto);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		
		
		return dispute;	
		
	}
	
	
	
	
	
	
	

	@Override
	public List<products_sold> SoldItemListDatewise() throws ProductException {
		
        List<products_sold> soldReport = new ArrayList<>();
		
		try (Connection conn = DBUtility.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select * from products_sold order by auctionDate desc");
			
			ResultSet rs= ps.executeQuery();
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
				
				soldReport.add(sold);
			}
			if(flag) {
				throw new ProductException("No items sold yet !!");
			}
		} catch (SQLException e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return soldReport;
		
		
	}

	
	
	
	
	
	
	
	@Override
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> solvedDisputeListBuyerToSeller() throws DisputeException{
		
	
	List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> dispute = new ArrayList<>(); 
	
	try (Connection conn = DBUtility.provideConnection()){

		PreparedStatement ps = conn.prepareStatement("select s.disputeId, s.buyerId, s.sellerId, c.categoryName, s.disputeDetails, s.disputeDate, s.solutionDate, s.IsSolve, t.disputeTeamName from buyer_to_seller s INNER JOIN disputeHandleTeam t INNER JOIN category c ON s.categoryId = t.categoryId AND s.categoryId = c.categoryId AND s.IsSolve = true");
		
		ResultSet rs= ps.executeQuery();
		boolean flag= true;
		
		
		while(rs.next()) {
			flag= false;
			DisputeBuyerToSellerWithTeamAndCategoryNameDTO buyertoSeller = new DisputeBuyerToSellerWithTeamAndCategoryNameDTO();
			
			buyertoSeller.setDisputeId(rs.getInt("disputeId"));
			buyertoSeller.setBuyerId(rs.getInt("buyerId"));
			buyertoSeller.setSellerId(rs.getInt("sellerId"));
			buyertoSeller.setCategoryName(rs.getString("categoryName"));
			buyertoSeller.setDisputeDetails(rs.getString("disputeDetails"));
			buyertoSeller.setDisputeDate(rs.getDate("disputeDate"));
			buyertoSeller.setSolutionDate(rs.getDate("solutionDate"));
			buyertoSeller.setIsSolve(rs.getBoolean("IsSolve"));
			buyertoSeller.setDisputeTeamName(rs.getString("disputeTeamName"));
			
			dispute.add(buyertoSeller);
		}
		if(flag) {
			throw new DisputeException("Any dispute is not avaliable ...");
		}
	} catch (SQLException e) {
		throw new DisputeException(e.getMessage());
	}
	return dispute;
	
	
	
	}
	
	
	
	
	
	
	

	@Override
	public List<DisputeSellerToAppWithTeamNameDto> solvedDisputeListSellerToApp() throws DisputeException {
		
		List<DisputeSellerToAppWithTeamNameDto> dispute = new ArrayList<>();
		try (Connection conn = DBUtility.provideConnection()){

			PreparedStatement ps = conn.prepareStatement("select s.disputeId, s.sellerId, s.categoryId, s.disputeDetails, s.disputeDate, s.solutionDate, s.IsSolve, t.disputeTeamName from seller_app s INNER JOIN disputeHandleTeam t ON s.categoryId = t.categoryId AND s.IsSolve = true");
			
			ResultSet rs= ps.executeQuery();
			boolean flag= true;
			while(rs.next()) {
				flag= false;
				DisputeSellerToAppWithTeamNameDto sellerdto = new DisputeSellerToAppWithTeamNameDto();
				sellerdto.setDisputeId(rs.getInt("did"));			
				sellerdto.setSellerId(rs.getInt("sid"));			
				sellerdto.setCategoryId(rs.getInt("cid"));			
				sellerdto.setDisputeDetails(rs.getString("disputDetail"));			
				sellerdto.setDisputeDate(rs.getDate("dDate"));			
				sellerdto.setSolutionDate(rs.getDate("solutionDate"));			
				sellerdto.setIsSolve(rs.getBoolean("isSolve"));			
				sellerdto.setDisputeTeamName(rs.getString("DTname"));			
				dispute.add(sellerdto);
			}
			if(flag) {
				throw new DisputeException("Any dispute is not avaliable ...");
			}
		} catch (SQLException e) {
			throw new DisputeException(e.getMessage());
		}
		
		
		return dispute;
		
	}
	
	

}
