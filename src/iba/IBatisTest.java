package iba;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kosta.j0516.Emp;

public class IBatisTest {
	public static void main(String[] args) {
		// empcopy테이블 : 사원 추가
		SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
		// smc.insert(String id);
		// smc.insert(String id, object param)
		try {
/*			smc.insert("empAdd");
			System.out.println("홍길동 사원 추가 성공");*/

			//smc.insert("empAdd2", "주원");
			Emp emp = new Emp(8010, "김유신", 3500, 30);
			smc.insert("empAdd3",emp);
			System.out.println("사원 추가");
			
			int t= smc.delete("deleteEmp");
			System.out.println("8000번 사원 삭제");
			System.out.println("삭제된 행의 갯수"+t);
			
			String delename="주원";
			t= smc.delete("deleteEmp2",delename);
			if(t==1){
				System.out.println("# [ "+delename+" ] 사원 삭제");
			}else{
				System.out.println("# [ "+delename+" ] 사원은 존재하지 않습니다");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
