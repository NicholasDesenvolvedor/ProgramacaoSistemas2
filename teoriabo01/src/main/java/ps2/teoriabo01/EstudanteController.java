package ps2.teoriabo01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EstudanteController {
    private List<Estudante> estudantes;
    public EstudanteController(){
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1, "Nicholas", 10723200, "Sistemas De Informação"));
        estudantes.add(new Estudante(2, "Lucas", 123456, "Sistemas De Informação"));
        estudantes.add(new Estudante(3, "Eduardo", 7891011, "Administração"));
    }

    @GetMapping("/mackenzie/alunos")
    public List<Estudante> getEstudantes(){
        return estudantes;
    }
    @GetMapping("/mackenzie/alunos/{id}")
    public Estudante getEstudante (@PathVariable long id){
        for (Estudante e: estudantes){
            if (id == e.getId()){
                return e;
            }
        }
        return null;
    }
    @PostMapping("/mackenzie/alunos")
    public Estudante create (@RequestBody Estudante e){
        long maior = 0;
        for (Estudante estudante: estudantes){
            if (estudante.getId() > maior){
                maior = estudante.getId();
            }
        }
        e.setId(maior + 1);
        estudantes.add(e);
        return e;
    }
}
