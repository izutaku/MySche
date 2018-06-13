package model;

import Entity.AccountEntity;
import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(AccountEntity login){
		AccountDAO dao = new AccountDAO();
		AccountEntity account = dao.findByLogin(login);
		return account != null;
	}
}
