package br.com.meli.linktracker.converter;

import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.entity.Link;
import br.com.meli.linktracker.form.LinkForm;
import br.com.meli.linktracker.utils.generateIds;

import java.util.ArrayList;
import java.util.List;

public class LinkConverter {
    public static Link linkFormToEntity(LinkForm linkForm) {
        return new Link(
                generateIds.generate(),
                0l,
                linkForm.getUrl(),
                token()
        );
    }

    public static List<Link> linkFormToEntity(List<LinkForm> linkForms) {
        List<Link> links = new ArrayList<>();

        for (LinkForm linkForm : linkForms) {
            links.add(linkFormToEntity(linkForm));
        }

        return links;
    }

    public static LinkDTO linkEntityToDTO(Link link) {
        return new LinkDTO(
                link.getId(),
                link.getToken()
        );
    }

    public static List<LinkDTO> linkEntityToDTO(List<Link> links) {
        List<LinkDTO> linkDTOS = new ArrayList<>();

        for (Link link : links) {
            linkDTOS.add(linkEntityToDTO(link));
        }

        return linkDTOS;
    }

    private static String token() {
        String encode = "mectrab";
        String passDecoded = "GoMeliGo";

        int min = 1;
        int max = 30;
        int range = max - min + 1;

        int k = (int) (Math.random() * range) + min;

        StringBuilder passEncoded = new StringBuilder();

        for(int i = 0; i < passDecoded.length(); i++) {
            int posChar = (encode.indexOf(passDecoded.charAt(i)) + 1 + k) % 30;
            passEncoded.append(encode.charAt(posChar));
        }

        return passEncoded.toString();
    }
}
