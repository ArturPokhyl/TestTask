package core.data_models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePageResponse {
    @JsonProperty("url")
    private String url;

    @JsonProperty("guid")
    private String guid;

    @JsonProperty("id")
    private String id;

    public String getUrl() {
        return url;
    }

    public String getGuid() {
        return guid;
    }

    public String getId() {
        return id;
    }

}
