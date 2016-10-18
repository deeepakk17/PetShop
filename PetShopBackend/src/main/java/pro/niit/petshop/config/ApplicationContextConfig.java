package pro.niit.petshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pro.niit.petshop.dao.CategoryDAO;
import pro.niit.petshop.dao.CategoryDAOImpl;
import pro.niit.petshop.dao.UserDAO;
import pro.niit.petshop.dao.UserDAOImpl;
import pro.niit.petshop.model.Address;
import pro.niit.petshop.model.CartHistory;
import pro.niit.petshop.model.CartItem;
import pro.niit.petshop.model.CategoryDetails;
import pro.niit.petshop.model.OTP;
import pro.niit.petshop.model.OrderDetails;
import pro.niit.petshop.model.ProductDetails;
import pro.niit.petshop.model.SupplierDetails;
import pro.niit.petshop.model.UserCart;
import pro.niit.petshop.model.UserDetails;
import pro.niit.petshop.model.UserRole;

@Configuration
@EnableTransactionManagement
@ComponentScan("pro.niit.petshop")
public class ApplicationContextConfig {
//Configuration Class for Connecting with database
	
	@Bean(name = "dataSource")	//defining the datasource
	public DataSource getH2DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		//dataSource.setUrl("jdbc:h2:tcp://localhost/~/chec");
		
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/petshop");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		return dataSource;
	}
//setting hibernate properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}
//Session factory creation
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserDetails.class);
		sessionBuilder.addAnnotatedClass(CategoryDetails.class);
		sessionBuilder.addAnnotatedClass(ProductDetails.class);
		sessionBuilder.addAnnotatedClass(SupplierDetails.class);
		sessionBuilder.addAnnotatedClass(UserRole.class);
		sessionBuilder.addAnnotatedClass(Address.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(UserCart.class);
		sessionBuilder.addAnnotatedClass(OrderDetails.class);
		sessionBuilder.addAnnotatedClass(CartHistory.class);
		sessionBuilder.addAnnotatedClass(OTP.class);
		

		return sessionBuilder.buildSessionFactory();
	}
//defining the transaction manager
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
	
	@Autowired
    @Bean(name = "categoryDAO")
    public CategoryDAO getCategoryDao(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getProductDAO(SessionFactory sessionFactory) {

		return new UserDAOImpl(sessionFactory);
	}
	
	
}
