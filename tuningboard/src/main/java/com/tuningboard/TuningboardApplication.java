package com.tuningboard;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TuningboardApplication {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	//private static final Logger log = LoggerFactory.getLogger(TuningboardApplication.class);
	

	/*
     * SqlSessionFactory 설정 
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();      
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
        return sessionFactory.getObject();
    }
    
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(TuningboardApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner runner(UserInfoRepository userinfoRepository, SvcInfoRepository svcinfoRepository) throws Exception {
		return (args) -> {
			UserInfo userinfo = userinfoRepository.save(UserInfo.builder()
					.userName("shpark88431")
					.password("Pink2112")
					.fullName("박성훈1")
					.email("shpark8843@gmail.com")
					.createdDate(LocalDateTime.now())
					.build());
		
		IntStream.rangeClosed(1,200).forEach(index -> svcinfoRepository.save(SvcInfo.builder()
				.svcid("SSPSE1802R")
				.svcName("판독의, 방사선사 목록 조회")
				.type("IMR")
				.bizType("진료지원")
				.bizDetail("환자검사")
				.scnId("VSPSEEJ198S")
				.scnName("핵의학 검사단계 서식")
				.priority("MCP")
				.leader("김양수/박정해")
				.developer("홍상길")
				.designer("최준성")
				.customer("조하형")
				.perftest("Y")
				.funName("처방저장")
				.subFunName("처방저장")
				.createdDate(LocalDateTime.now())
				.build())
				);
			};
		}*/
	}
