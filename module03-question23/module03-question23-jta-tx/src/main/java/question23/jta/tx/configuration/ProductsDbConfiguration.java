package question23.jta.tx.configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories(
        basePackages = {"question23.jta.tx.db.products.dao"},
        entityManagerFactoryRef = "productsEntityManagerFactory"
)
public class ProductsDbConfiguration {

    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean productsEntityManagerFactory(DataSource productsDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJtaDataSource(productsDataSource);
        em.setPackagesToScan("question23.jta.tx.db.products.ds");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource productsDataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setURL("jdbc:mysql://192.168.1.170:3306/spring_tutorial_products");
        mysqlXADataSource.setUser("user");
        mysqlXADataSource.setPassword("pass");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("productsDb");
        return atomikosDataSourceBean;
    }
}
