package com.slpl.web.service.test;

import java.util.List;

import com.slpl.web.dao.jdbc.JdbcTestReportDao;
import com.slpl.web.dao.test.TestReportDao;
import com.slpl.web.entity.test.TestReport;

public class TestReportService {
	private TestReportDao reportDao;

	public TestReportService() {
		reportDao = new JdbcTestReportDao();
	}

	public int insert(TestReport testReport) {
		// TODO Auto-generated method stub
		return reportDao.insert(testReport);
	}

	public int update(TestReport testReport) {
		// TODO Auto-generated method stub
		return reportDao.update(testReport);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return reportDao.delete(id);
	}

	public List<TestReport> getList(int page, int size, String key, String keyword) {
		if( key != null) {
			switch (key) {
			case "testId":
				key = "test_id";
				break;
			case "memberId":
				key = "member_id";
			default:
				break;
			}			
		}
		int startIndex = 1 + (page - 1) * size;
		int endIndex = page * size;
		return reportDao.getList(startIndex, endIndex, key, keyword);
	}

	public TestReport upState(int id, String keyword) {
		TestReport testReport = reportDao.get(id);
		switch (keyword) {
		case "type1":
			keyword = "1. 신고";
			break;
		case "type2":
			keyword = "2. 수정 중";
			break;
		case "type3":
			keyword = "3. 수정 완료";
			break;
		case "type4":
			keyword = "4. 수정 미완료";
			break;
		default:
			break;
		}
		testReport.setState(keyword);
		reportDao.update(testReport);

		return testReport;
	}

	public TestReport getDetail(int id) {
		return reportDao.get(id);
	}
}