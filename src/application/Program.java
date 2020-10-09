package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		// Forma de INJE��O DE DEPED�NCIA sem explicitar a implementa��o
		// Programa n�o conhece a implementa��o, somente a interface

		// SellerDao sellerDao = new SellerDaoJDBC
		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);
	}
}