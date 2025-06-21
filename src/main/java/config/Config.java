package config;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;
@Getter
public class Config {
    private final String baseUrl;
    private final String text;
    private final String area;
    private final String itemsOnPage;
    private final String[] searchFields;
    private final Properties props = new Properties();
    @SneakyThrows
    public Config(){
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        props.load(input);
        baseUrl = props.getProperty("baseUrl");
        text = props.getProperty("text");
        area = props.getProperty("area");
        itemsOnPage = props.getProperty("items_on_page");
        searchFields = props.getProperty("search_fields").split(",");
    }
}
