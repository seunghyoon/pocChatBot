package com.poc.chatbot.config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
/**
*
* DataSource Config 관련 설정
* <p>
*
* <pre>
* 개정이력(Modification Information)·
* 수정일   수정자    수정내용
* ------------------------------------
* 2019.08.07 seunghyoon 최초작성
* </pre>
*
* @author seunghyoon@kt.com
* @since 2019.08.07
* @version 1.0.0
* @see
*
*/
@Configuration
@EnableConfigurationProperties
@EnableTransactionManagement
@MapperScan(basePackages = {"com.poc.chatbot.**.mapper"}, 
			sqlSessionFactoryRef="defaultDbSqlSessionFactory")
public class DefaultDataSourceConfiguration {
	@Value("${datasource.defaultdb.jndi-name}")
	private String jndiName;
	
	@Value("${datasource.defaultdb.dbSettingType}")
	private String dbSettingType;
	
	
	@Primary
    @Bean(name="defaultDbDataSource")//, destroyMethod = "close")
    @ConfigurationProperties(prefix="datasource.defaultdb")
    public DataSource dataSource() {
		if("JNDI".equals(dbSettingType)){
			JndiDataSourceLookup jdni = new JndiDataSourceLookup();
	        jdni.setResourceRef(true);
	        return jdni.getDataSource(jndiName);       
		}else{
			return DataSourceBuilder.create().build();
		}
    }
	
	
	@Bean(name = "defaultDbSqlSessionFactory")
    public SqlSessionFactory getDbSqlSessionFactory(@Qualifier("defaultDbDataSource") DataSource defaultDbDataSource
    		, ApplicationContext applicationContext) { 
        
    	SqlSessionFactoryBean sqlSessionFactoryBean = null;
        try {
        	sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(defaultDbDataSource);
            sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
            sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:biz/defaultapi/mapper/**/*.xml"));

            return sqlSessionFactoryBean.getObject();
		} catch (Exception e) {
			//throw new FrameworkException(e);
			throw new RuntimeException(e);
		}
    }
	
    @Bean(name = "defaultDbSqlSessionTemplate", destroyMethod = "clearCache")
    public SqlSessionTemplate defaultDbSqlSessionTemplate(SqlSessionFactory sqldbSqlSessionFactory){ 
    	try {
    		return new SqlSessionTemplate(sqldbSqlSessionFactory);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    	
    }
}
