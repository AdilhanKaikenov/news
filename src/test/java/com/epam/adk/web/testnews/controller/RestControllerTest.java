package com.epam.adk.web.testnews.controller;

import com.epam.adk.web.news.model.News;
import com.epam.adk.web.news.service.NewsService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * TODO: Comment
 * <p>
 * Created on 6/15/2017.
 *
 * @author Kaikenov Adilkhan
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"/test-spring-context.xml", "classpath:dispatcher-servlet.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        DbUnitTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
@WebAppConfiguration
@DirtiesContext
public class RestControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private NewsService newsService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    public void testCreate() throws Exception {

        final int expectedID = 1;

        News news = getTestNewsInstance();

        News noExistNews = newsService.readNews(expectedID);
        assertNull(noExistNews); // Assert Check Null

        mockMvc.perform(post("/rest/news")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(convertObjectToJson(news))
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(expectedID)))
                .andExpect(jsonPath("$.title", is("News Test Title")))
                .andExpect(jsonPath("$.date", is(news.getDate().getTime())))
                .andExpect(jsonPath("$.brief", is("News Test Brief")))
                .andExpect(jsonPath("$.content", is("News Test Content")));
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    public void testRead() throws Exception {

        final int targetID = 2;
        final long dateTime = 777837661000L;

        mockMvc.perform(get("/rest/news/{id}", targetID)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(targetID)))
                .andExpect(jsonPath("$.title", is("Test Title #2")))
                .andExpect(jsonPath("$.date", is(dateTime)))
                .andExpect(jsonPath("$.brief", is("Test Brief #2")))
                .andExpect(jsonPath("$.content", is("Test Content #2")));
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    public void testUpdate() throws Exception {

        final int targetID = 3;

        News edited = getTestNewsInstance();
        News original = newsService.readNews(targetID);

        assertNotNull(original); // Assert Check Not Null
        assertNotEquals(edited, original); // Assert Check Not Equals

        edited.setId(targetID);

        mockMvc.perform(put("/rest/news/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(convertObjectToJson(edited))
        )
                .andExpect(status().isOk());

        News result = newsService.readNews(targetID);
        assertEquals(edited, result); // Assert Check Null
    }

    @Test
    @DatabaseSetup(value = "/newsTestDatabase.xml")
    @ExpectedDatabase(value = "/testNewsDeleteDatabase.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testDelete() throws Exception {

        final int targetID = 3;

        mockMvc.perform(delete("/rest/news/{id}", targetID))
                .andExpect(status().isOk());

    }

    private News getTestNewsInstance() {
        final long dateTime = 777834000000L;

        News news = new News();
        news.setTitle("News Test Title");
        news.setDate(new Date(dateTime));
        news.setBrief("News Test Brief");
        news.setContent("News Test Content");
        return news;
    }

    private byte[] convertObjectToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
