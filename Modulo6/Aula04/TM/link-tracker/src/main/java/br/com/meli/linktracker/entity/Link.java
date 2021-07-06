package br.com.meli.linktracker.entity;

public class Link {
    private Long id;
    private Long redirects;
    private String url;
    private String token;

    public Link(Long id, Long redirects, String url, String token) {
        this.id = id;
        this.redirects = redirects;
        this.url = url;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public Long getRedirects() {
        return redirects;
    }

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRedirects(Long redirects) {
        this.redirects = redirects;
    }
}
