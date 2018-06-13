package test;

import Entity.AccountEntity;
import dao.AccountDAO;

public class acctest {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testFindBysche1();
	}
	public static void testFindBysche1(){

		AccountDAO schedao = new AccountDAO();
		AccountEntity en = new AccountEntity("izumi","1234");
		AccountEntity result = schedao.findByLogin(en);
		if(result != null){

			result.getUserId().equals("テスト");
			System.out.println("testFindByLogin1成功");
		}
		else {
			//失敗しました
			System.out.println("testFindByLogin1失敗");
		}

	}
}
