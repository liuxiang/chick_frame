package basic;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * SpringJUnitTest
 *
 * @author jianhao.dai@fraudmetrix.cn 16/4/26 13:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:app.xml"})
@PropertySource("classpath:application.properties")
@TransactionConfiguration(transactionManager = "mainTransactionManager", defaultRollback = true)
public abstract class SpringJUnitTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Override
    @Resource(name = "mainDataSource")
    public void setDataSource(DataSource dataSource) {
        super.setDataSource(dataSource);
    }
}