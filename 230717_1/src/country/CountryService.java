package country;

import java.util.List;

public class CountryService {
	// 페이징된 리스트와 페이지 수, 두 개의 정보를 return해야 됨
	public CountryDTO getPage(int pageNum, int pagePer) {
		CountryDAO dao = new CountryDAOMySQL();
		int count = dao.countAll();
		
		int totalPage = count / pagePer;
		totalPage += count % pagePer == 0 ? 0 : 1;
		
		List<Country> list = dao.getByPage(pageNum, pagePer);
		
		return new CountryDTO(list, totalPage);
	}
}