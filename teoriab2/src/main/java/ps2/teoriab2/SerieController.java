package ps2.teoriab2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {
    @Autowired
    private SerieRepo serieRepo;

    @GetMapping("/api/series")
    public Iterable<Serie> consultar(){
        return serieRepo.findAll();
    }

    @PostMapping("/api/series")
    public Serie criar(@RequestBody Serie s){
        return serieRepo.save(s);
    }
}
