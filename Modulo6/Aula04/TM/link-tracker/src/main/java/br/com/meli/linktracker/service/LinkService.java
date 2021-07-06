package br.com.meli.linktracker.service;

import br.com.meli.linktracker.converter.LinkConverter;
import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.entity.Link;
import br.com.meli.linktracker.exception.InvalidLinkException;
import br.com.meli.linktracker.form.LinkForm;
import br.com.meli.linktracker.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    public LinkService(){ }

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String redirectTo(Long id, String token) {
        Link link = linkRepository.getLinkById(id);

        if(link == null || !link.getToken().equals(token)) {
            throw new InvalidLinkException("Link invalido");
        }

        long redirects = 1L;
        redirects += link.getRedirects();
        link.setRedirects(redirects);

        return link.getUrl();
    }

    public Long linkMetrics(Long id) {
        Link link = linkRepository.getLinkById(id);
        if(link == null) {
            throw new InvalidLinkException("Link invalido");
        }
        return link.getRedirects();
    }

    public LinkDTO createLink(LinkForm linkForm) {
        Link link = LinkConverter.linkFormToEntity(linkForm);

        linkRepository.addLink(link);

        return LinkConverter.linkEntityToDTO(link);
    }

    public LinkDTO invalidateLink(Long id) {
        Link link = linkRepository.getLinkById(id);

        if (link == null) {
            throw new InvalidLinkException("Link invalido");
        }

        linkRepository.deleteLink(id);

        return LinkConverter.linkEntityToDTO(link);
    }



    public LinkDTO creatLink(LinkForm linkForm) {
        Link link = LinkConverter.linkFormToEntity(linkForm);

        linkRepository.addLink(link);

        return LinkConverter.linkEntityToDTO(link);
    }
}
