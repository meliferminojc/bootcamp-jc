package br.com.meli.linktracker.dto;

public class MetricDTO {
    private Long redirects;

    public MetricDTO() {
    }

    public MetricDTO(Long redirects) {
        this.redirects = redirects;
    }

    public Long getRedirects() {
        return redirects;
    }
}
