package com.sms.app.smart.persistence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sms.app.smart.persistence.entities.SmBuiIderInfo;
import com.sms.app.smart.persistence.repositories.SmBuilderInfoRepository;

@Component
public class BuilderInfoDAO {
	
	private static final Logger logger = LogManager.getLogger(BuilderInfoDAO.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SmBuilderInfoRepository smBuilderInfoRepository;

	public SmBuiIderInfo getBuiIderInfo() {
		
		RowMapper<SmBuiIderInfo> buiIderInfo = new RowMapper<SmBuiIderInfo>() {
			
			@Override
			public SmBuiIderInfo mapRow(ResultSet rs, int arg1) throws SQLException {
				SmBuiIderInfo smBuiIderInfo = new  SmBuiIderInfo();
				smBuiIderInfo.setId(rs.getInt("id"));
				smBuiIderInfo.setName(rs.getString("name"));
				return smBuiIderInfo;
			}
		};
		
		List<SmBuiIderInfo> builderList = jdbcTemplate.query("select * from sm_builder_info where id=?", new PreparedStatementSetter() {
			   
	         public void setValues(PreparedStatement preparedStatement) throws SQLException {
	            preparedStatement.setInt(1, 1);
	         }
	      },buiIderInfo);
		
		System.out.println("No of records returned:: "+builderList.size());
		
		return builderList.get(0);
	}
	
	public List<SmBuiIderInfo> getBuiIderInfoList() {
		System.out.println("==== Fetching Builder info from repository ====");
		List<SmBuiIderInfo> builderList = smBuilderInfoRepository.findAll();
		System.out.println("No of records returned:: "+builderList.size());
		return builderList;
	}
	
	
	public void insertBuiIderInfo(List<SmBuiIderInfo> BuiIderList) {
		System.out.println("==== Saving Builder info ====");
		smBuilderInfoRepository.save(BuiIderList);
		smBuilderInfoRepository.flush();
		System.out.println("==== Builder info Saved ====");
	}
	
	public void fetchBuiIderDetails(int id) {
		
		SmBuiIderInfo  buiIderInfo = entityManager.find(SmBuiIderInfo.class, new Integer(id));
		logger.info("BuiIder info:: "+buiIderInfo);
	}

	public void persistBuilderDetails(SmBuiIderInfo smBuiIderInfo) {
		System.out.println("====Persisting Builder Details====");
		entityManager.persist(smBuiIderInfo);
		System.out.println("====Builder Details Saved====");
		
	}
	
	public void queryBuilderDetails() {
		
		Query query = entityManager.createQuery("select bi from SmBuiIderInfo bi where bi.id=:builderId");
		query.setParameter("builderId", 955);
		SmBuiIderInfo smBuiIderInfo = (SmBuiIderInfo)query.getSingleResult();
		System.out.println("BuiIder name:: "+smBuiIderInfo.getName());
		
	}
	
	public void updateBuilderDetails() {
		Query query = entityManager.createQuery("update SmBuiIderInfo bi set bi.phone1=:phone1  where bi.id=:builderId");
		query.setParameter("phone1", "020-1225678");
		query.setParameter("builderId", 955);
		int result = query.executeUpdate();
		System.out.println("Records updated:: "+result);
	}
	
	
	
}
