package com.epam.adk.web.news.util;

/**
 * TODO: Comment
 * <p>
 * Created on 5/18/2017.
 *
 * @author Kaikenov Adilkhan
 */
public final class ConstantHolder {

    public static final String SHOW_ADD_OR_EDIT_SUCCESS = "show_add_or_edit_success";
    public static final String SHOW_NEWS_LIST_SUCCESS = "show_news_list_success";
    public static final String SHOW_VIEW_NEWS_SUCCESS = "show_view_news_success";
    public static final String REGION_PARAMETER = "region";
    public static final String DATE_PROPERTY_NAME = "date";
    public static final String SUCCESS = "success";
    public static final String REFERER = "referer";
    public static final String NEWS = "news";

    public static final String ID_PARAMETER = "id";
    public static final String TITLE_PARAMETER = "title";
    public static final String BRIEF_PARAMETER = "brief";
    public static final String DATETIME_PARAMETER = "datetime";
    public static final String CONTENT_PARAMETER = "content";

    public static final int ZERO = 0;

    public static final String SELECT_LAST_INSERTED_ID = "SELECT NEWS_SEQ.currval FROM dual";
    public static final String ID_LIST = "idList";

    public static final String NAMED_QUERY_NEWS_DELETE_LIST = "News.deleteList";
    public static final String NAMED_QUERY_NEWS_DELETE_BY_ID = "News.deleteById";
    public static final String NAMED_QUERY_NEWS_COUNT_ROWS = "News.countRows";
    public static final String NAMED_QUERY_NEWS_READ_BY_ID = "News.readById";
    public static final String NAMED_QUERY_NEWS_READ_ALL = "News.readAll";
    public static final String NAMED_QUERY_NEWS_UPDATE = "News.update";
    public static final String NAMED_QUERY_NEWS_SAVE = "News.save";



    private ConstantHolder() {
    }
}
