package ps2.teoriab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeController {
    @Autowired
    private FilmeRepo filmeRepo;
    
    @GetMapping ("/api/filmes")
    public Iterable<Filme> consultarFilmes(){
        return filmeRepo.findAll();
    }

    @PostMapping ("/api/filmes")
    public Filme criar(@RequestBody Filme f) {
        return filmeRepo.save(f);
    }

}
