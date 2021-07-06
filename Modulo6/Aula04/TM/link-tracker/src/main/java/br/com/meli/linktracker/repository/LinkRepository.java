package br.com.meli.linktracker.repository;

import br.com.meli.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository {
    private static List<Link> links = new ArrayList<>();

    public List<Link> getAll() {
        return links;
    }

    public Link getLinkById(Long id) {
        Optional<Link> optionalLink = links.stream().filter(link -> link.getId().equals(id)).findAny();

        return optionalLink.orElse(null);
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void deleteLink(Long id) {
        Optional<Link> optionalLink = links.stream().filter(link -> link.getId().equals(id)).findAny();

        optionalLink.ifPresent(link -> links.remove(link));
    }
}
