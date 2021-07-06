package br.com.meli.linktracker.controller;

import br.com.meli.linktracker.dto.MetricDTO;
import br.com.meli.linktracker.form.LinkForm;
import br.com.meli.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/link")
public class LinkController {

    private LinkService linkService;

    public LinkController() {
    }

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("")
    public ResponseEntity<?> createLink(@RequestBody LinkForm linkForm) {
        return ResponseEntity.ok(linkService.createLink(linkForm));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable long linkId) {
        linkService.invalidateLink(linkId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{linkID}")
    public RedirectView redirect(@RequestHeader("token") String token, @PathVariable long linkID) {
        String url = linkService.redirectTo(linkID, token);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        return redirectView;
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getRedirects(@PathVariable long linkId) {
        return ResponseEntity.ok(new MetricDTO(linkService.linkMetrics(linkId)));
    }
}
