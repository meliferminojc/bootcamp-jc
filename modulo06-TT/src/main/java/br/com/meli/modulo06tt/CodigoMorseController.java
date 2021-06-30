package br.com.meli.modulo06tt;

import org.springframework.web.bind.annotation.*;

@RestController
public class CodigoMorseController {

   @RequestMapping(value="/morse", method=RequestMethod.POST, produces="application/json", consumes = "application/json")
    public @ResponseBody String converter(@RequestBody Code code) {
        return code.convertCodeToWord();
    }

}
