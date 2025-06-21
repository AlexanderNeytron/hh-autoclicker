package utils;

import config.Config;

public class UrlBuilder {
    public String buildSearchUrl(Config config) {
        StringBuilder url = new StringBuilder(config.getBaseUrl()).append("?");
        url.append("items_on_page=").append(config.getItemsOnPage());
        url.append("&L_save_area=true");
        url.append("&enable_snippets=true");
        url.append("&area=").append(config.getArea());
        for (String field : config.getSearchFields()) {
            url.append("&search_field=").append(field.trim());
        }
        url.append("&text=").append(config.getText().replace(" ", "+"));
        return url.toString();
    }
}