// Estrutura��o do Seller Data Access Object (DAO)

// A classe � respons�vel por transformar os dados do Banco de Dados Relacional e transform�-los em objetos associados (transormar em OO) 
// Ou seja, na mem�ria do PC, quero ter os objetos associados instanciados em mem�ria

package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	// --------------Depend�ncia-------------- //

	// Objeto conn � disposi��o em qualquer lugar da classe
	private Connection conn = null;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	// --------------------------------------- //

	@Override
	public void insert(Seller obj) {

	}

	@Override
	public void update(Seller obj) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	// opera��o de Acesso a Dados (DAO)
	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null; // ResultSet: Apresentar dados em forma de tabela - aponta por padr�o para o 0
								// (n�o h� nenhum objeto)
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName" 
					+ "FROM seller INNER JOIN department"
					+ "ON seller.DepartmentId = department.Id" 
					+ "WHERE seller.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();

			// Testar se retornou da Query algum resultado (j� que o rs aponta primeramente
			// por padr�o para o 0)
			// Se der TRUE, significa que retornou aquele UM registro
			if (rs.next()) {
				// Instancias dos objetos a partir do registro retornado com m�todos
				Department dep = instantiateDepartament(rs);

				Seller obj = instantiateSeller(rs, dep);

				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			// N�o fechar o Connection para utilizar outros m�todos - fechar no Program
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setDepartment(dep);
		return obj;
		// N�o h� o try-catch pois nos outros m�todos j� ter�o os try-catchs
	}
	
	private Department instantiateDepartament(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
		// N�o h� o try-catch pois nos outros m�todos j� ter�o os try-catchs
	}
	
	@Override
	public List<Seller> findAll() {
		return null;
	}

}
