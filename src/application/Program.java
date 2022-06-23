package application;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		System.out.print("Enter the seller id: ");
		int sellerId = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(sellerId);		
		System.out.println(seller);
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		System.out.print("Enter the department id: ");
		int departmentId = sc.nextInt();
		List<Seller> sellers = sellerDao.findByDepartment(new Department(departmentId, null));		
		for (Seller s : sellers) {			
			System.out.println(s);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");		
		sellers = sellerDao.findAll();		
		for (Seller s : sellers) {			
			System.out.println(s);
		}
		
		System.out.println("=== TEST 4: seller insert ===");		
		Seller seller2 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, new Department(3, null));	
		sellerDao.insert(seller2);
		System.out.println("Inserted! New Id = " + seller2.getId());
		
		System.out.println("=== TEST 5: seller update ===");		
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 6: seller delete ===");	
		System.out.print("Enter the seller id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);		
		System.out.println("Delete completed!");
		
		sc.close();
		
	}

}
