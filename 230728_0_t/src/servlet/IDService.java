package servlet;

public class IDService {
	private IDDao dao = new IDDao();

	public boolean isExist(String id) {
		int count = dao.count(id);

		return count >= 1;
	}
	
	// 커넥션 제어, 트랜젝션 제어 생략
	public int add(String id) {
		if (isExist(id)) {
			throw new RuntimeException("중복입니다.");
		}
		return dao.insert(id);
	}
}