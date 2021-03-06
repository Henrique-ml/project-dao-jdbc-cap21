// Classe auxiliar responsável por instanciar os DAOs
package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	// Instancia um SellerDao com a implementação SellerDaoJDBC internamente
	// Macete para não precisar expor a implementação e o programa conhecer somente a interface 
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
