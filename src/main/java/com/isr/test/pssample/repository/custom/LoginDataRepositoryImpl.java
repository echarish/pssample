package com.isr.test.pssample.repository.custom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.isr.test.pssample.model.Login;
import com.isr.test.pssample.utils.PSSampleConst;
import com.isr.test.pssample.utils.PSUtil;

@Service
public class LoginDataRepositoryImpl implements LoginDataRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<String> getAllDates() {
		String sql = "select distinct to_char(login_time, '" + PSSampleConst.DATE_FORMAT_SQL
				+ "') as login_time  from login order by login_time ASC";
		List<String> loginDates = em.createNativeQuery(sql).getResultList();
		System.out.println(loginDates);
		return loginDates;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUsers(String startDate, String endDate) {
		List<String> loginUser = new ArrayList<>();
		Criteria crit = em.unwrap(Session.class).createCriteria(Login.class);
		crit.setProjection(Projections.distinct(Projections.property("user")));
		try {

			setDateRangeRestrictions(crit, startDate, endDate);
			crit.addOrder(Order.asc("user"));

			loginUser = crit.list();

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return loginUser;
	}

	@Override
	public List<String> getAllLogins(String startDate, String endDate, List<String> attribute1List,
			List<String> attribute2List, List<String> attribute3List, List<String> attribute4List) {
		List<String> loginUser = new ArrayList<>();
		Criteria crit = em.unwrap(Session.class).createCriteria(Login.class);
		crit.setProjection(Projections.property("user"));
		// crit.setProjection(Projections.countDistinct("user"));
		// crit.setProjection(Projections.groupProperty("user"));
		try {
			setDateRangeRestrictions(crit, startDate, endDate);
			setAttributeRestrictions(crit, attribute1List, attribute2List, attribute3List, attribute4List);
			crit.addOrder(Order.asc("user"));
			loginUser = crit.list();
			Collections.sort(loginUser);
			System.out.println(loginUser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return loginUser;
	}

	private void setAttributeRestrictions(Criteria crit, List<String> attribute1List, List<String> attribute2List,
			List<String> attribute3List, List<String> attribute4List) {
		if (attribute1List != null && attribute1List.size() != 0) {
			crit.add(Restrictions.in("attribute1", attribute1List));
		}
		if (attribute2List != null && attribute2List.size() != 0) {
			crit.add(Restrictions.in("attribute2", attribute2List));
		}
		if (attribute3List != null && attribute3List.size() != 0) {
			crit.add(Restrictions.in("attribute3", attribute3List));
		}
		if (attribute4List != null && attribute4List.size() != 0) {
			crit.add(Restrictions.in("attribute4", attribute4List));
		}

	}

	private void setDateRangeRestrictions(Criteria crit, String startDate, String endDate) throws ParseException {
		if (!StringUtils.isBlank(startDate) && !StringUtils.isBlank(endDate)) {
			Criterion betweenCr = Restrictions.between("loginTime", PSUtil.getDateFromString(startDate),
					PSUtil.getDateFromString(endDate));
			crit.add(betweenCr);
		} else if (!StringUtils.isBlank(startDate)) {
			Criterion startDateCr = Restrictions.sqlRestriction(
					"to_char(login_time, '" + PSSampleConst.DATE_FORMAT_SQL + "') = '" + startDate + "'");
			crit.add(startDateCr);
		} else if (!StringUtils.isBlank(endDate)) {
			Criterion endDateCr = Restrictions
					.sqlRestriction("to_char(login_time, '" + PSSampleConst.DATE_FORMAT_SQL + "') = '" + endDate + "'");
			crit.add(endDateCr);
		}

	}

}
