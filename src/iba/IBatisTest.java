package iba;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kosta.j0516.Emp;

public class IBatisTest {
	public static void main(String[] args) {
		// empcopy테이블 : 사원 추가
		SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
		// smc.insert(String id);
		// smc.insert(String id, object param)
		try {
			/*
			 * smc.insert("empAdd"); System.out.println("홍길동 사원 추가 성공");
			 */

			// smc.insert("empAdd2", "주원");
			Emp emp = new Emp(8010, "김유신", 3500, 30);
			smc.insert("empAdd3", emp);
			System.out.println("사원 추가");

			int t = smc.delete("deleteEmp");
			System.out.println("8000번 사원 삭제");
			System.out.println("삭제된 행의 갯수" + t);

			String delename = "주원";
			t = smc.delete("deleteEmp2", delename);
			if (t == 1) {
				System.out.println("# [ " + delename + " ] 사원 삭제");
			} else {
				System.out.println("# [ " + delename + " ] 사원은 존재하지 않습니다");
			}
			// 7788 사번의 이름을 조회
			String ename = (String) smc.queryForObject("selectEname");
			System.out.println("조회된 결과 : " + ename);

			String ename2 = (String) smc.queryForObject("selectEname2", 7369);
			System.out.println("조회된 결과 : " + ename2);

			// 30번 부사에 근무하는 사원명을 조회
			List<String> list = smc.queryForList("emp.selectEname");
			for (String en : list) {
				System.out.println("30부서 : " + en);
			}
			// 특정 부서에 근무하는 사원의 사번,이름,급여,부서번호을 조회하시오.
			List<Emp> empList = smc.queryForList("emp.selectEmp", 30);

			for (Emp emp_ : empList) {
				System.out.println("사번 : " + emp_.getEmpno() + " 이름 : " + emp_.getEname() + " 급여 : " + emp_.getSal()
						+ " 부서번호 : " + emp_.getDeptno());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
