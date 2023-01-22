package com.auction.usecase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.auction.color.ConsoleColor;
import com.auction.dao.AdministratorDao;
import com.auction.dao.AdministratorDaoImpl;
import com.auction.dao.BuyerDao;
import com.auction.dao.BuyerDaoImpl;
import com.auction.dao.SellerDao;
import com.auction.dao.SellerDaoImpl;
import com.auction.exception.AdministratorException;
import com.auction.exception.BuyerException;
import com.auction.exception.DisputeException;
import com.auction.exception.ProductException;
import com.auction.exception.SellerException;
import com.auction.model.Administrator;
import com.auction.model.Buyer;
import com.auction.model.DisputeBuyerToSellerWithTeamAndCategoryNameDTO;
import com.auction.model.DisputeSellerToAppWithTeamNameDto;
import com.auction.model.Products;
import com.auction.model.Seller;
import com.auction.model.products_sold;

public class Main {
	
	private static AdministratorDao admin;
	private static BuyerDao buyer;
	private static SellerDao seller;
	
	
	public static Administrator adminProfile;
	public static Buyer buyerProfile;
	public static Seller sellerProfile;
	
	static {
		System.out.println("+----------------------------------------------+"+ConsoleColor.BLUE);
		System.out.println("|**********************************************|");
		System.out.println("|********"+ConsoleColor.BOLDON+ " Hello Welcome to AuctionKing "+ ConsoleColor.BOLDOFF+ConsoleColor.BLUE +"********|");
		System.out.println("|**********************************************|" + ConsoleColor.RESET);
		System.out.println("+----------------------------------------------+");
		
		admin= new AdministratorDaoImpl();
		buyer = new BuyerDaoImpl();
		seller = new SellerDaoImpl();
		
	};
	public static void main(String[] args) {
		
		System.out.println("\n" +ConsoleColor.BOLDON+ "Please press following number:- who are you? " +ConsoleColor.BOLDOFF+"\n");
		
		System.out.println("1. Are you Administrator..");
		System.out.println("2. Are you Seller..");
		System.out.println("3. Are you Buyer..");
		System.out.println("4. Exit");
		
		
		
		try (Scanner sc = new Scanner(System.in)) {
			int num= sc.nextInt();
			sc.nextLine();

			
			switch(num){
			
				case 1:{
						while(true) {
							System.out.println("Enter username/email: ");
							String username=sc.nextLine();
							
							System.out.println("Enter password : ");
							String password = sc.nextLine();
							
							try {
								adminProfile = admin.loginAdministrator(username, password);
								System.out.print("\n Welcome Administrator "+adminProfile.getAdminFirstName());
								if(adminProfile.getAdminLastName()!=null) {
									System.out.println(" "+adminProfile.getAdminLastName());
								}
								else {
									
									System.out.println();
								}
								break;
							} catch (AdministratorException e) {
								System.out.println(e.getMessage());
								System.out.println("Do you want exit: (y/n) ?");
								String ex= sc.nextLine();
								if(ex.equalsIgnoreCase("Y")) {
									System.out.println("Thank you for visiting...");
									return;
								}
							}
						}
						adminDashboard();
					}
				break;
			case 2:
					{
						System.out.println(ConsoleColor.BOLDON+ConsoleColor.BLUE+"Hey Seller.."+ConsoleColor.BOLDOFF+ConsoleColor.RESET+"\n");
						System.out.println("1. New user? register..");
						System.out.println("2. Login..");
						System.out.println("3. Exit");
						
						int number= sc.nextInt();
						sc.nextLine();
						switch(number) {
							case 1:{
								Seller sellerRegistration= new Seller();
								System.out.println("\n Enter your First Name: ");
								sellerRegistration.setSellerFirstName(sc.nextLine());
								
								System.out.println("\n Enter your Last Name: ");
								sellerRegistration.setSellerLastName(sc.nextLine());
								
								System.out.println("\n Enter your email id: ");
								sellerRegistration.setSellerEmail(sc.nextLine());
								
								System.out.println("\n Enter your password: ");
								sellerRegistration.setSellerPassword(sc.nextLine());
								
								System.out.println("\n Enter your mobile number: ");
								sellerRegistration.setSellerMobile(sc.nextLine());
								
								System.out.println("\n Enter your Date of dirth (in yyyy-mm-dd format): ");
								sellerRegistration.setSellerDob(Date.valueOf(sc.nextLine()));
								
								try {
									String str= seller.registerSeller(sellerRegistration);
									System.out.println(str+"\n");
									loginSeller();
								} catch (SellerException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
							}
							break;
							case 2:{
								loginSeller();
							}
							break;
							case 3:{
								System.out.println("Thanking you for visiting...");
								return;
							}
							default: {
								System.out.println("Invalid number, Thanking you! visiting again...");							
								break;
							}
						}
					}
					break;
					
				case 3:
					{
						System.out.println(ConsoleColor.BOLDON+ConsoleColor.BLUE+"Hey Buyer.."+ConsoleColor.BOLDOFF+ConsoleColor.RESET+"\n");
						System.out.println("1. New user? register..");
						System.out.println("2. Login..");
						System.out.println("3. Exit");
						
						int option= sc.nextInt();
						sc.nextLine();
						switch(option) {
							case 1:{
								Buyer buyerRegistration= new Buyer();
								System.out.println("\n Enter your First Name: ");
								buyerRegistration.setBuyerFirstName(sc.nextLine());
								
								System.out.println("\n Enter your Last Name: ");
								buyerRegistration.setBuyerLastName(sc.nextLine());
								
								System.out.println("\n Enter your email id: ");
								buyerRegistration.setBuyerEmail(sc.nextLine());
								
								System.out.println("\n Enter your password: ");
								buyerRegistration.setBuyerPassword(sc.nextLine());
								
								System.out.println("\n Enter your mobile number: ");
								buyerRegistration.setBuyerMobile(sc.nextLine());
								
								System.out.println("\n Enter your Date of dirth (in yyyy-mm-dd format): ");
								buyerRegistration.setBuyerDob(Date.valueOf(sc.nextLine()));
								
								try {
									String mesg= buyer.registerBuyer(buyerRegistration);
									
									System.out.println(mesg+"\n");
									loginBuyer();
								} catch (BuyerException e) {
									System.out.println(e.getMessage());
								}
							}
							break;
							case 2:{
								loginBuyer();
							}
							break;
							case 3:{
								System.out.println("Thanking you for visiting...");
								return;
							}
							default: {
								System.out.println("Invalid number, Thanking you! visiting again...");							
								break;
							}
						}
					}
					break;
					
				case 4:
					{
						System.out.println("Thanking you for visiting...");
						return;
					}
					
				default:
					System.out.println("Invalid number, try again ...");
					main(args);
					break;

					
			}
		}
	}
	public static void loginBuyer(){
		System.out.println(ConsoleColor.BOLDON+ ConsoleColor.GREEN_BACKGROUND+"Hey, Buyer! Welcome Login panel..."+ConsoleColor.RESET+ConsoleColor.BOLDOFF);
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\n 1. Enter your login detail..");
			System.out.println("2. forget username..");
			System.out.println("3. forget password..");
			System.out.println("4. Exit");
			int option2 = sc.nextInt();
			sc.nextLine();
			
			switch(option2) {
				case 1:{
					System.out.println("\n Enter your emailid/username...");
					String username= sc.nextLine();
					
					System.out.println("\n Enter your password...");
					String password= sc.nextLine();
					
					try {
						buyerProfile = buyer.loginBuyer(username, password);
						System.out.print("\n Welcome Buyer "+buyerProfile.getBuyerFirstName());
						if(buyerProfile.getBuyerLastName() !=null) {
							System.out.println(" "+buyerProfile.getBuyerLastName());
						}
						else {
							
							System.out.println();
						}
						buyerDashboard();
					} catch (BuyerException e) {
						System.out.println(e.getMessage());
						System.out.println("Do you want exit: press 4, else press any key...");
						String numb= sc.nextLine();
						if(numb.equals("4")) {
							System.out.println("Thanking you for visiting...");
							return;
						}
						else {
							loginBuyer();
						}
					}
				}
				break;
				case 2:{
					System.out.println("\n Enter your new emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter your first name: ");
					String firstname = sc.nextLine();
					
					System.out.println("\n Enter your Date of birth (in yyyymmdd format): ");
					Date dob= Date.valueOf(sc.nextLine());
					
					System.out.println("\n Enter your mobile number: ");
					String mobileNumber = sc.nextLine();
					
					try {
						String message = buyer.resetUsernameByBuyer(firstname, username, dob, mobileNumber);
						System.out.println(message);
						loginBuyer();
					} catch (BuyerException e) {
						System.out.println(e.getMessage());
						System.out.println(" Thanking you! visit again ...");
						return;
					}
				}
				break;
				case 3:{

					System.out.println("\n Enter your emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter new password");
					String password = sc.nextLine();
					
					try {
						String message = buyer.resetPasswordByBuyer(username, password);
						System.out.println(message);
						loginBuyer();
					} catch (BuyerException e) {
						System.out.println(e.getMessage());
						System.out.println(" Thanking you! try again ...");
						loginBuyer();
						
					}
					
				}
				break;
				case 4:{
					System.out.println("Thanking you for visiting...");
					return;
				}
				
				default: {
					System.out.println("Invalid number, Thanking you! visit again ...");
					loginBuyer();
				}
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void buyerDashboard(){
		

	}
	public static void buyerProfileSetting() {
		/*
		
		
		*/
	}
	
	
	public static void loginSeller() {
		System.out.println(ConsoleColor.BOLDON+ ConsoleColor.GREEN_BACKGROUND+"Welcome To Seller Login panel  ..."+ConsoleColor.RESET+ConsoleColor.BOLDOFF);
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\n 1. Enter your login detail..");
			System.out.println("2. forget username..");
			System.out.println("3. forget password..");
			System.out.println("4. Exit");
			int number2 = sc.nextInt();
			sc.nextLine();
			
			switch(number2) {
				case 1:{
					System.out.println("\n Enter your emailid/username...");
					String username= sc.nextLine();
					
					System.out.println("\n Enter your password...");
					String password= sc.nextLine();
					
					try {
						sellerProfile = seller.loginBySeller(username, password);
						System.out.print("\n Welcome Seller "+sellerProfile.getSellerFirstName());
						if(sellerProfile.getSellerLastName()!=null) {
							System.out.println(" "+sellerProfile.getSellerLastName());
						}
						else {
							
							System.out.println();
						}
						sellerDashboard(sellerProfile);
					} catch (SellerException e) {
						System.out.println(e.getMessage());
						System.out.println("Do you want exit: press 4, else press any key...");
						String ex= sc.nextLine();
						if(ex.equals("4")) {
							System.out.println("Thanking you for visiting...");
							return;
						}
						else {
							loginSeller();
						}
					}
				}
				break;
				case 2:{
					System.out.println("\n Enter your new emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter your first name: ");
					String firstname = sc.nextLine();
					
					System.out.println("\n Enter your Date of birth (in yyyymmdd format): ");
					Date dob= Date.valueOf(sc.nextLine());
					
					System.out.println("\n Enter your mobile number: ");
					String mobileNumber = sc.nextLine();
					
					try {
						String message = seller.resetUsernameBySeller(firstname, username, dob, mobileNumber);
						System.out.println(message);
						loginSeller();
					} catch (SellerException e) {
						System.out.println(e.getMessage());
						System.out.println(" Thanking you! visit again ...");
						return;
					}
				}
				break;
				case 3:{
					System.out.println("\n Enter your emailid/username");
					String username= sc.nextLine();
					
					System.out.println("\n Enter new password");
					String password = sc.nextLine();
					
					try {
						String message = seller.resetPasswordBySeller(username, password);
						System.out.println(message);
						loginSeller();
					} catch (SellerException e) {
						System.out.println(e.getMessage());
						System.out.println(" Thanking you! visit again ...");
						return;
					}
				}
				break;
				case 4:{
					System.out.println("Thanking you for visiting...");
					return;
				}
				
				default: {
					System.out.println("Invalid number, Thanking you! visit again ...");
				}
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	public static void sellerDashboard(Seller sellerProfile) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("\n"+ ConsoleColor.BOLDON+ ConsoleColor.GREEN_BACKGROUND+"Please Choose one of them"+ConsoleColor.RESET+ConsoleColor.BOLDOFF);
			System.out.println("1. Create list of item to sell.");
			System.out.println("2. Update item price, quantity...");
			System.out.println("3. Add new item in the list.");
			System.out.println("4. Remove item from the list.");
			System.out.println("5. View Sold item report.");
			System.out.println("6. View selling item list.");
			System.out.println("7. Profile Setting..");
			System.out.println("8. LogOut And Exit");
			
			int number3 = sc.nextInt();
		//	sc.nextLine();
			switch(number3) {
				case 1:{
					List<Products> items = new ArrayList<>();
					while(true) {
						Products item= new Products();
						int category=0;
						while(true) {
							System.out.println("Enter number for category as following:-");
							System.out.println("1. Property");
							System.out.println("2. Electronic");
							System.out.println("3. Automobile");
							System.out.println("4. Miscellanouse");
							
							boolean flag= false;
							int number4= sc.nextInt();
							sc.nextLine();
							switch(number4) {
								case 1:{
									category= 1;
									flag= true;
								}
								break;
								case 2:{
									category= 2;
									flag= true;
								}
								break;
								case 3:{
									category= 3;
									flag= true;
								}
								break;
								case 4:{
									category= 4;
									flag= true;
								}
								break;
								default :{
									System.out.println("Invalid Entry.. try again.");
									flag= false;
									break;
								}

	
							}
							if(flag) {
								break;
							}
						}
						item.setCategoryId(category);
						System.out.println("Enter item selling price: ");
						item.setSellingPrice(sc.nextInt());
						sc.nextLine();
						
						System.out.println("Enter item name: ");
						item.setProductName(sc.nextLine());
						
						System.out.println("Enter item quantity: ");
						item.setProductQuantity(sc.nextInt());
						sc.nextLine();
						
						item.setSellerId(sellerProfile.getSellerId());
						
						System.out.println("Enter auction address: ");
						item.setAuctionAddress(sc.nextLine());
						
						System.out.println("Enter the number of days from today, when auction occur: ");
						item.setDays(sc.nextInt());
						//sc.nextInt();
						
						items.add(item);
						
						System.out.println("Do you want enter more item:- Y/N");
						String permision= sc.next();
						if(permision.equals("N") || permision.equals("n")) {
							break;
						}
					}
					try {
						String result= seller.addListOfItems(items);
						
						System.out.println(ConsoleColor.YELLOW_BACKGROUND+result+ConsoleColor.RESET);
						System.out.println("========================");
					}
					catch(ProductException e) {
						System.out.println(ConsoleColor.RED+e.getMessage()+ConsoleColor.RESET);
						System.out.println("========================");
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							sellerProfileSetting();
							break;
						}
						case 2 : {
							sellerDashboard(sellerProfile);
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							break;
						}
					}
					
					
				}
				break;
				case 2:{
					System.out.println("\n"+ConsoleColor.GREEN+ "choose following option for updating item....\n"+ConsoleColor.RESET);
					System.out.println("1. Change quantity..");
					System.out.println("2. Change price..");
					System.out.println("3. Change quantity & price both..");
					System.out.println("4. Profile Setting..");
					System.out.println("5. Back..");
					System.out.println("6. Logout & Exit..");
					int number7= sc.nextInt();
					sc.nextLine();
					switch(number7) {
						case 1:{
							System.out.println("Enter Item name: ");
							String name= sc.nextLine();
							System.out.println("Enter quantity no.: ");
							int quantity = sc.nextInt();
							sc.nextLine();
							try {
								String result= seller.updateItemQuantity(sellerProfile.getSellerId(), name, quantity);
								System.out.println(ConsoleColor.YELLOW_BACKGROUND+result+ConsoleColor.RESET);
								System.out.println("============================");
							}
							catch(ProductException e) {
								System.out.println(ConsoleColor.RED+e.getMessage()+ConsoleColor.RESET);
								System.out.println("============================");
							}
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									sellerProfileSetting();
									break;
								}
								case 2 : {
									sellerDashboard(sellerProfile);
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									sellerDashboard(sellerProfile);
									break;
								}
							}
							
						}
						break;
						case 2:{
							System.out.println("Enter item name :");
							String itemName= sc.nextLine();
							
							System.out.println("Enter item price :");
							int price= sc.nextInt();
							
							sc.nextLine();
							
							try {
								String result1= seller.updateItemPrice(sellerProfile.getSellerId(), itemName, price);
								System.out.println(result1);
							}
							catch(ProductException e) {
								System.out.println(e.getMessage());
							}
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int number9 = sc.nextInt();
							sc.nextLine();
							switch(number9) {
								case 1 : {
									sellerProfileSetting();
									break;
								}
								case 2 : {
									sellerDashboard(sellerProfile);
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									sellerDashboard(sellerProfile);
									break;
								}
							}
						}
						break;
						case 3:{
							System.out.println("Enter item name :");
							String itemName2= sc.nextLine();
							
							System.out.println("Enter item price :");
							int price2= sc.nextInt();
							
							System.out.println("Enter item quantity");
							int quantity2 = sc.nextInt();
							
							sc.nextLine();
							
							try {
								String result3= seller.updateItemPriceAndQuantity(sellerProfile.getSellerId(), itemName2, price2, quantity2);
								System.out.println(result3);
							}
							catch(ProductException e) {
								System.out.println(e.getMessage());
							}
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int number10 = sc.nextInt();
							sc.nextLine();
							switch(number10) {
								case 1 : {
									sellerProfileSetting();
									break;
								}
								case 2 : {
									sellerDashboard(sellerProfile);
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									sellerDashboard(sellerProfile);
									break;
								}
							}
						}
						break;
						case 4:{
							sellerProfileSetting();
						}
						break;
						case 5:{
							sellerDashboard(sellerProfile);
						}
						break;
						case 6:{
							System.out.println("Thanking you for visiting...");
							return;
						}
						
						default:{
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							
						}
						break;
					}
				}
				break;
				case 3:{
					Products item2= new Products();
					int category2=0;
					while(true) {
						System.out.println("Enter number for category as following:-");
						System.out.println("1. Property");
						System.out.println("2. Electronic");
						System.out.println("3. Automobile");
						System.out.println("4. Miscellanouse");
						
						boolean flag2= false;
						int number11= sc.nextInt();
						//sc.nextLine();
						switch(number11) {
							case 1:{
								category2= 1;
								flag2= true;
								break;
							}
							
							case 2:{
								category2= 2;
								flag2= true;
								break;
							}
							
							case 3:{
								category2= 3;
								flag2= true;
								break;
							}
							
							case 4:{
								category2= 4;
								flag2= true;
								break;
							}
							
							default :{
								System.out.println("Invalid Entry.. try again.");
								flag2= false;
								break;
							}


						}
						if(flag2) {
							break;
						}
					}
					item2.setCategoryId(category2);
					System.out.println("Enter item selling price: ");
					item2.setSellingPrice(sc.nextInt());
					sc.nextLine();
					
					System.out.println("Enter item name: ");
					item2.setProductName(sc.nextLine());
					
					System.out.println("Enter item quantity: ");
					item2.setProductQuantity(sc.nextInt());
					sc.nextLine();
					
					item2.setSellerId(sellerProfile.getSellerId());
					
					System.out.println("Enter auction address: ");
					item2.setAuctionAddress(sc.nextLine());
					
					System.out.println("Enter the number of days from today, when auction occur: ");
					item2.setDays(sc.nextInt());
					sc.nextLine();
					
					
					
					

					try {
						String result= seller.addItemInTheList(item2);
						
						System.out.println(ConsoleColor.YELLOW_BACKGROUND+result+ConsoleColor.RESET);
						System.out.println("========================");
					}
					catch(ProductException e) {
						System.out.println(ConsoleColor.RED+e.getMessage()+ConsoleColor.RESET);
						System.out.println("========================");
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							sellerProfileSetting();
							break;
						}
						case 2 : {
							sellerDashboard(sellerProfile);
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							break;
						}
					}

				}
				break;
				case 4:{
					System.out.println("Enter item Name: ");
					String itemName3= sc.next();
					try {
						String result4= seller.removeItemFromTheList(sellerProfile.getSellerId(), itemName3);
						System.out.println(ConsoleColor.YELLOW_BACKGROUND+result4+ConsoleColor.RESET);
						System.out.println("========================");
					}
					catch(ProductException e) {
						System.out.println(ConsoleColor.RED+e.getMessage()+ConsoleColor.RESET);
						System.out.println("========================");
					}
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int number13 = sc.nextInt();
					sc.nextLine();
					switch(number13) {
						case 1 : {
							sellerProfileSetting();
							break;
						}
						case 2 : {
							sellerDashboard(sellerProfile);
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							break;
						}
					}
					
				}
				break;
				case 5:{
					System.out.println("\n"+ConsoleColor.PURPLE+"View Sold item report..."+ConsoleColor.RESET+"\n");
					try {
						List<products_sold> soldItems= seller.soldItemList(sellerProfile.getSellerId());
						soldItems.forEach(l -> {
							System.out.println(ConsoleColor.BOLDON+" Auction ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Buyer ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerId()+ConsoleColor.RESET);
												
							System.out.println(ConsoleColor.BOLDON+" Category ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductName()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Quantity is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductQuantity()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item insert date by seller is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductAddedDate()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item sold price is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellingPrice()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Auction price is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionPrice()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Auction address is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionAddress()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item sold date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionDate()+ConsoleColor.RESET);
							
							System.out.println("===========================");
						});
					}
					catch(ProductException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int number14 = sc.nextInt();
					sc.nextLine();
					switch(number14) {
						case 1 : {
							sellerProfileSetting();
							break;
						}
						case 2 : {
							sellerDashboard(sellerProfile);
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							break;
						}
					}
					
					
					
				}
				break;
				case 6:{
					System.out.println("\n"+ConsoleColor.PURPLE+"View selling item Report..."+"\n"+ConsoleColor.RESET);
					try {
						List<Products> sellingItems = seller.sellingItemList(sellerProfile.getSellerId());
						sellingItems.forEach(l -> {
							System.out.println(ConsoleColor.BOLDON+" Auction ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAutionID()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Category ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryId()+ConsoleColor.RESET);
												
							System.out.println(ConsoleColor.BOLDON+" Item insert date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductAddedDate()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item selling price is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellingPrice()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductName()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item quantity is "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductQuantity()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item auction address is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionAddress()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Auction date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionDate()+ConsoleColor.RESET);
							
							System.out.println("===========================");
						});
						
					}
					catch(ProductException e) {
						System.out.println(e.getMessage());
						
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int number15 = sc.nextInt();
					sc.nextLine();
					switch(number15) {
						case 1 : {
							sellerProfileSetting();
							break;
						}
						case 2 : {
							sellerDashboard(sellerProfile);
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							sellerDashboard(sellerProfile);
							break;
						}
					}
				}
				break;
				case 7:{
					sellerProfileSetting();
				}
				break;
				case 8:{
					System.out.println("Thanking you for visiting...");
					return;
				}
				
				default:{
					System.out.println("Invalid entry, try again...");
					sellerDashboard(sellerProfile);
				}
				break;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void sellerProfileSetting(){
		System.out.println(ConsoleColor.BOLDON+" Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerId()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Seller first Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerFirstName()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Seller last Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerLastName()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Seller email is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerEmail()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Seller mobile number is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerMobile()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Seller date of birth is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+sellerProfile.getSellerDob()+ConsoleColor.RESET);
		System.out.println("===========================");
				
		System.out.println("\n 1. Change Password..");
		System.out.println("2. Go to dashboard..");
		System.out.println("3. LogOut And Exit");
		try (Scanner sc = new Scanner(System.in)) {
			int number5 = sc.nextInt();
			
			sc.nextLine();
			switch(number5) {
				case 1 : {
					System.out.println("Enter your new password...");
					String password= sc.nextLine();
					try {
						String msg = seller.resetPasswordBySeller(sellerProfile.getSellerEmail(), password);
						System.out.println(msg);
						System.out.println("===========================");
						
					} catch (SellerException e) {
						System.out.println(e.getMessage());
						System.out.println("===========================");
					}
					sellerProfileSetting();
				}
				break;
				case 2 : {
					sellerDashboard(sellerProfile);
				}
				break;
				case 3 : {
					System.out.println("Successfully logout ...");
					System.out.println("Thanking you for visiting...");
					return;
					
				}
				default : {
					System.out.println("Invalid number, try again ...");
					sellerProfileSetting();
				}
				break;
			}
		}
	}
	
	public static void adminDashboard() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("1. View the registered buyer list.");
			System.out.println("2. View the registered seller list.");
			System.out.println("3. View the daily dispute report.");
			System.out.println("4. View the daily selling report.");
			System.out.println("5. Solved the dispute report.");
			System.out.println("6. Profile Setting..");
			System.out.println("7. LogOut And Exit");
			
			int num = sc.nextInt();
			sc.nextLine();
			
			switch(num) {
				case 1 : {
					
					try {
						List<Buyer> list = admin.listOfBuyers();
						System.out.println(" registered buyer list ....");
						list.forEach(l -> {
							System.out.println(ConsoleColor.BOLDON+" Buyer ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerId()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Buyer first Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerFirstName()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Buyer last Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerLastName()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Buyer email is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerEmail()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Buyer mobile number is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerMobile()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Buyer date of birth is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerDob()+ConsoleColor.RESET);
							System.out.println("===========================");
						});
					} catch (BuyerException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
					break;
				}
				case 2 : {
					try {
						List<Seller> list2 = admin.listOfSeller();
						System.out.println(" registered Seller list ....");
						list2.forEach(l -> {
							System.out.println(ConsoleColor.BOLDON+" Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Seller first Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerFirstName()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Seller last Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerLastName()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Seller email is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerEmail()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Seller mobile number is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerMobile()+ConsoleColor.RESET);
							System.out.println(ConsoleColor.BOLDON+" Seller date of birth is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerDob()+ConsoleColor.RESET);
							System.out.println("===========================");
						});
					} catch (SellerException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
				}
				break;
				case 3 : {
					System.out.println("\n"+"Choose appropriate dispute report.."+"\n");
					System.out.println("\n 1. Dispute list Seller to Application ..");
					System.out.println("2. Dispute list Buyer to Seller ..");
					System.out.println("3. Back");
					int num3= sc.nextInt();
					switch(num3) {
						case 1 : {
							try {
								List<DisputeSellerToAppWithTeamNameDto> list3 = admin.disputeListSellerToApp();
								System.out.println(" Dispute list Seller to Application ....");
								list3.forEach(l -> {
									System.out.println(ConsoleColor.BOLDON+" Dispute ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeId()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute by Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Category ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryId()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute description is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDetails()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute registration date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDate()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute solution except date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSolutionDate()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute status is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+"in process"+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute Assign to solve is by : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeTeamName()+ConsoleColor.RESET);
									System.out.println("===========================");
								});
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 2 : {
							try {
								List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list4 = admin.disputeListBuyerToSeller();
								
								
								
								System.out.println(" Dispute list of Buyer to Seller ....");
								list4.forEach(l -> {
									System.out.println(ConsoleColor.BOLDON+" Dispute ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeId()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute by Buyer ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerId()+ConsoleColor.RESET);
									
									if(l.getSellerId() != 0)
										System.out.println(ConsoleColor.BOLDON+"Dispute On Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+"Dispute Category is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryName()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute description is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDetails()+ConsoleColor.RESET);									
									System.out.println(ConsoleColor.BOLDON+" Dispute registration date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDate()+ConsoleColor.RESET);								
									System.out.println(ConsoleColor.BOLDON+" Dispute solution except date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSolutionDate()+ConsoleColor.RESET);								
									System.out.println(ConsoleColor.BOLDON+" Dispute status is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+"in process"+ConsoleColor.RESET);					
									System.out.println(ConsoleColor.BOLDON+" Dispute Assign to solve is by : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeTeamName()+ConsoleColor.RESET);
									
									System.out.println("===========================");
								});
								
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 3 : {
							adminDashboard();
						}
						break;
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							
						}
						break;
					}

					
				}
				break;
				case 4 : {
					System.out.println(ConsoleColor.PURPLE + "+ ---------------------------- +" +ConsoleColor.RESET);
					System.out.println(ConsoleColor.RED + "|** Datewise Selling Report **|" +ConsoleColor.RESET);
					System.out.println(ConsoleColor.PURPLE + "+ ---------------------------- +" +ConsoleColor.RESET);
					try {
						List<products_sold> list5= admin.SoldItemListDatewise();
						list5.forEach(l -> {
							System.out.println(ConsoleColor.BOLDON+" Auction ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
					
							System.out.println(ConsoleColor.BOLDON+" Buyer ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerId()+ConsoleColor.RESET);
												
							System.out.println(ConsoleColor.BOLDON+" Category ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryId()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductName()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Quantity is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductQuantity()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item insert date by seller is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getProductAddedDate()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item sold price is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellingPrice()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Auction price is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionPrice()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item Auction address is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionAddress()+ConsoleColor.RESET);
							
							System.out.println(ConsoleColor.BOLDON+" Item sold date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getAuctionDate()+ConsoleColor.RESET);
							
							System.out.println("===========================");
						});
					
					} catch (ProductException e) {
						System.out.println(e.getMessage());
					}
					
					System.out.println("\n 1. Profile Setting..");
					System.out.println("2. Back");
					System.out.println("3. LogOut And Exit");
					int num2 = sc.nextInt();
					sc.nextLine();
					switch(num2) {
						case 1 : {
							adminProfileSetting();
							break;
						}
						case 2 : {
							adminDashboard();
							break;
						}
						case 3 : {
							System.out.println("Thanking you for visiting...");
							return;
							
						}
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							break;
						}
					}
					
					
				}
				break;
				case 5 : {
					System.out.println("\n"+"Choose appropriate solved dispute report.."+"\n");
					System.out.println("\n 1. Solve Dispute list Seller to Application ..");
					System.out.println("2. Solve Dispute list Buyer to Seller ..");
					System.out.println("3. Back");
					int num3= sc.nextInt();
					switch(num3) {
						case 1 : {
							try {
								
								
								List<DisputeSellerToAppWithTeamNameDto> list7 = admin.solvedDisputeListSellerToApp();
								System.out.println(" Solve Dispute list Seller to Application ....");
								list7.forEach(l -> {
									System.out.println(ConsoleColor.BOLDON+" Dispute ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeId()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute by Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Category ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryId()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute description is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDetails()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute registration date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDate()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute solution date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSolutionDate()+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute status is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+"Solved"+ConsoleColor.RESET);
									System.out.println(ConsoleColor.BOLDON+" Dispute Assign to solve is by : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeTeamName()+ConsoleColor.RESET);
									System.out.println("===========================");
								});
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 2 : {
							try {
								List<DisputeBuyerToSellerWithTeamAndCategoryNameDTO> list8 = admin.solvedDisputeListBuyerToSeller();
								
								
								
								System.out.println(" Solve Dispute list of Buyer to Seller ....");
								list8.forEach(l -> {
									System.out.println(ConsoleColor.BOLDON+" Dispute ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeId()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute by Buyer ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getBuyerId()+ConsoleColor.RESET);
									
									if(l.getSellerId() != 0)
										System.out.println(ConsoleColor.BOLDON+"Dispute On Seller ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSellerId()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+"Dispute Category is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getCategoryName()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute description is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDetails()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute registration date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeDate()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute solution date is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getSolutionDate()+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute status is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+"Solved"+ConsoleColor.RESET);
									
									System.out.println(ConsoleColor.BOLDON+" Dispute Assign to solve is by : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+l.getDisputeTeamName()+ConsoleColor.RESET);
									
									System.out.println("===========================");
								});
								
							} catch (DisputeException e) {
								System.out.println(e.getMessage());
							}
							
							System.out.println("\n 1. Profile Setting..");
							System.out.println("2. Back");
							System.out.println("3. LogOut And Exit");
							int num2 = sc.nextInt();
							sc.nextLine();
							switch(num2) {
								case 1 : {
									adminProfileSetting();
									break;
								}
								case 2 : {
									adminDashboard();
									break;
								}
								case 3 : {
									System.out.println("Thanking you for visiting...");
									return;
									
								}
								default : {
									System.out.println("Invalid number, try again ...");
									adminDashboard();
									break;
								}
							}
						}
						break;
						case 3 : {
							adminDashboard();
						}
						break;
						default : {
							System.out.println("Invalid number, try again ...");
							adminDashboard();
							
						}
						break;
					}

				}
				break;
				case 6 : {
					adminProfileSetting();
				}
				break;
				case 7 : {
					System.out.println("Thanking you for visiting");
					return;
				}
				default:{
					System.out.println("Invalid Entry, try again...");
					adminDashboard();
				}
				break;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void adminProfileSetting() {

		
		System.out.println(ConsoleColor.BOLDON+" Admin ID is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminId()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Admin first Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminFirstName()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Admin last Name is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminLastName()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Admin email is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminEmail()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Admin mobile number is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminMobile()+ConsoleColor.RESET);
		System.out.println(ConsoleColor.BOLDON+" Admin date of birth is : "+ConsoleColor.BOLDOFF+ConsoleColor.CYAN+adminProfile.getAdminDob()+ConsoleColor.RESET);
		System.out.println("===========================");
				
		System.out.println("\n 1. Change Password..");
		System.out.println("2. Go to dashboard..");
		System.out.println("3. LogOut And Exit");
		try (Scanner sc = new Scanner(System.in)) {
			int num2 = sc.nextInt();
			
			sc.nextLine();
			switch(num2) {
				case 1 : {
					System.out.println("Enter your new password...");
					String password= sc.nextLine();
					try {
						String msg = admin.changePasswordAdmin(adminProfile.getAdminEmail(), password);
						System.out.println(msg);
						System.out.println("===========================");
						
					} catch (AdministratorException e) {
						System.out.println(e.getMessage());
						System.out.println("===========================");
					}
					adminProfileSetting();
				}
				break;
				case 2 : {
					adminDashboard();
				}
				break;
				case 3 : {
					System.out.println("Successfully logout ...");
					System.out.println("Thanking you for visiting...");
					return;
					
				}
				default : {
					System.out.println("Invalid number, try again ...");
					adminProfileSetting();
				}
				break;
			}
		}
	}
}