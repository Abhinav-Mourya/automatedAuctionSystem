package com.auction.dao;

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

public interface AdministratorDao {
	
public Administrator loginAdministrator(String username, String password) throws AdministratorException;
	
	public String changePasswordAdmin(String username, String password) throws AdministratorException;
	
	public List<Buyer> listOfBuyers() throws BuyerException;
	
	public List<Seller> listOfSeller() throws SellerException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> disputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> disputeListSellerToApp() throws DisputeException;
	
	public List<products_sold> SoldItemListDatewise() throws ProductException;
	
	public List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> solvedDisputeListBuyerToSeller() throws DisputeException;
	
	public List<DisputeSellerToAppWithTeamNameDto> solvedDisputeListSellerToApp() throws DisputeException;

}
