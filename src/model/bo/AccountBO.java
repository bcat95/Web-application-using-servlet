package model.bo;

import java.sql.SQLException;
import model.bean.Account;
import model.bean.User;
import model.dao.AccountDAO;

public class AccountBO {
	AccountDAO accountDAO = new AccountDAO();
	public boolean checkLogin(String tenDangNhap, String matKhau) {
		return accountDAO.checkLogin(tenDangNhap, matKhau);
	}
	public void themAcconut(String TenDangNhap, String MatKhau) {
		accountDAO.themAccount(TenDangNhap, MatKhau);
	}
	public Account selectOne(String username) {
		return accountDAO.selectOne(username);
	}
	public User getLogin(String user) throws ClassNotFoundException, SQLException
	{
		Account khoan = accountDAO.selectOne(user);
		return new User(user, khoan.getUserName());
	}
}
