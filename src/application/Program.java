package application;

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
		System.out.print("Enter with the seller's id: ");
		int sellerId = sc.nextInt();
		sc.nextLine();
		Seller seller = sellerDao.findById(sellerId);		
		System.out.println(seller);
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		System.out.print("Enter with the department's id: ");
		int departmentId = sc.nextInt();
		List<Seller> sellers = sellerDao.findByDepartment(new Department(departmentId, null));		
		for (Seller s : sellers) {
			
			System.out.println(s);
		}
		
		sc.close();
		
	}

}
