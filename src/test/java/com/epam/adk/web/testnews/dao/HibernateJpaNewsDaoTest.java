package com.epam.adk.web.testnews.dao;

import com.epam.adk.web.news.dao.NewsDao;
import com.epam.adk.web.news.model.News;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
@Transactional
@DirtiesContext // Annotate @DirtiesContext to indicate that it dirties the ApplicationContext. This will trigger context reloading before execution of next test.
@DatabaseSetup(value = "/newsTestDatabase.xml") // The @DatabaseSetup annotation can be used to configure database table before tests execute and reset them once tests have completed.
public class HibernateJpaNewsDaoTest {

    @Autowired
    @Qualifier("HibernateJpaNewsDao")
    private NewsDao newsDao;

    @Test

    public void countRowsNumber() throws Exception {
    }

    @Test
    public void read() throws Exception {

        final int testID = 1;

        News testNews = newsDao.read(testID);
        System.out.println(testNews.getTitle());
        assertNotNull(testNews); // Assert Check
    }

    @Test
    public void save() throws Exception {

        News testNews = getTestNewsInstance();

        final int nullID = 0;
        assertEquals(nullID, testNews.getId()); // Assert Check

        System.out.println(testNews.getId());
        newsDao.save(testNews);
        System.out.println(testNews.getId());
        News savedNews = newsDao.read(testNews.getId());

        System.out.println(testNews.getTitle());
        System.out.println(savedNews.getTitle());

        assertEquals(savedNews.getId(), testNews.getId()); // Assert Check
    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void findPaginated() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void deleteAll() throws Exception {

    }

    @Test
    public void findByParameters() throws Exception {

    }

    private News getTestNewsInstance() {
        News news = new News();
        news.setTitle("Test News Title");
        news.setDate(new Date());
        news.setBrief("Test News Brief");
        news.setContent("Test News Content");
        return news;
    }
}