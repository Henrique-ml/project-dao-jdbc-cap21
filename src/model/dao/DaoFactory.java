// Classe auxiliar respons�vel por instanciar os DAOs
package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// Instancia um SellerDao com a implementa��o SellerDaoJDBC internamente
	// Macete para n�o precisar expor a implementa��o e o programa conhecer somente a interface 
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
	}
}
