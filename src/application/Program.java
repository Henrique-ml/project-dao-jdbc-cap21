package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		// Forma de INJEÇÃO DE DEPEDÊNCIA sem explicitar a implementação
		// Programa não conhece a implementação, somente a interface

		// SellerDao sellerDao = new SellerDaoJDBC
		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department); // findByDepartment: Pode retornar mais de um registro
		list.forEach(System.out::println);
	}
}