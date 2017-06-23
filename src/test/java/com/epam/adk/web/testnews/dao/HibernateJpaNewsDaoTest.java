package com.epam.adk.web.testnews.dao;

import com.epam.adk.web.news.dao.NewsDao;
import com.epam.adk.web.news.exception.DateParsingException;
import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.util.DateUtil;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * TODO: Comment
 * <p>
 * Created on 6/13/2017.
 *
 * @author Kaikenov Adilkhan
 */
@RunWith(SpringJUnit4ClassRunner.class) // Indicates that the class should use Spring's JUnit facilities.
@ContextConfiguration(locations = "classpath:test-spring-context.xml") // Indicates which XML files contain the ApplicationContext.
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@DirtiesContext // Annotate @DirtiesContext to indicate that it dirties the ApplicationContext. This will trigger context reloading before execution of next test.
// The @DatabaseSetup annotation can be used to configure database table before tests execute and reset them once tests have completed.
public class HibernateJpaNewsDaoTest {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    public void testCountRowsNumber() throws Exception {

        final int expectedRowsNum = 3;
        int rowsNumber = newsDao.countRowsNumber();
        assertEquals(expectedRowsNum, rowsNumber);
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    public void testRead() throws Exception {

        final int testID = 2;
        News testNews = newsDao.read(testID);

        assertNotNull(testNews); // Assert Check Not Null
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    @ExpectedDatabase(value = "/testNewsSaveDatabase.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testSave() throws Exception {

        News testNews = getTestNewsInstance();

        final int nullID = 0;
        assertEquals(nullID, testNews.getId()); // Assert Check Equals

        newsDao.save(testNews);

    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    @ExpectedDatabase(value = "/testNewsUpdateDatabase.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {

        final int testID = 2;

        News editedNews = new News();
        editedNews.setId(testID);
        editedNews.setTitle("Edited News Title");
        editedNews.setDate(DateUtil.parseStringToDate("1994/08/26"));
        editedNews.setBrief("Edited News Brief");
        editedNews.setContent("Edited News Content");

        newsDao.save(editedNews);
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    @ExpectedDatabase(value = "/testNewsDeleteDatabase.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() throws Exception {
        final int targetID = 3;
        News news = new News();
        news.setId(targetID);
        newsDao.delete(news);
    }

    private News getTestNewsInstance() throws DateParsingException {
        News news = new News();
        news.setTitle("Test News Title");
        news.setDate(DateUtil.parseStringToDate("1994/08/26"));
        news.setBrief("Test News Brief");
        news.setContent("Test News Content");
        return news;
    }
}