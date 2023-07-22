package member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberValidator {
	private void checkNull(String value, String fieldName, Map<String, String> errors) {
		if (value == null || value.trim().isEmpty()) {
			errors.put(fieldName + "Null", fieldName + "을 입력해야 합니다.");
		}
	}
	
	private void checkMaxLength(String value, String fieldName, int max, Map<String, String> errors) {
		if (value != null && value.length() > max) {
			errors.put(fieldName + "TooLong", fieldName + "은 " + max + "자 이하여야 합니다.");
		}
	}
	
	public void duplicationId(String memberid, Map<String, String> errors) {
		MemberRepo repo = new MemberRepo();
		List<Member> list = repo.getAll();
		for(int i = 0; i < list.size(); i++) {
			if (list.get(i).getMemberId().equals(memberid)) {
				errors.put("duplicationId", "중복된 아이디가 존재합니다.");
			}
		}
	}
	
	public Map<String, String> validate(String memberid, String name, String password, String email) {
		Map<String, String> errors = new HashMap<String, String>();
		checkNull(memberid, "memberid", errors);
		checkNull(name, "name", errors);
		checkNull(password, "password", errors);
		
		checkMaxLength(memberid, "memberid", 10, errors);
		checkMaxLength(name, "name", 20, errors);
		checkMaxLength(password, "password", 10, errors);
		checkMaxLength(email, "email", 80, errors);
		
		duplicationId(memberid, errors);
		return errors;
	}

	public Map<String, String> validateName(String name) {
		Map<String, String> errors = new HashMap<String, String>();
		checkNull(name, "name", errors);
		checkMaxLength(name, "name", 20, errors);
		
		return errors;
	}
}
