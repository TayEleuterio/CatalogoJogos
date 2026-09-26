package br.uel.CatalogoJogos.service;

import br.uel.CatalogoJogos.model.Jogo;
import br.uel.CatalogoJogos.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JogoService {
    @Autowired
    private JogoRepository jogoRepository;

    //Listar todos os jogos
    public List<Jogo> listarTodos() {
        return jogoRepository.findAll();
    }

    //busca com filtro de título e ordenação por coluna
    public List<Jogo> buscarEOrdenar(String titulo, String campoOrdem,String direcao) {
        Sort sort = direcao.equalsIgnoreCase("desc") ?
                Sort.by(campoOrdem).descending() : Sort.by(campoOrdem).ascending();
        if (titulo != null && !titulo.isBlank()) {
            return jogoRepository.findByTituloContainingIgnoreCase(titulo);
        }
        return jogoRepository.findAll(sort);
    }

    //salvar ou atualizar jogo
    public Jogo salvar(Jogo Jogo) {
        return Repository.save(jogo);
    }

    //busca por ID para edição
    public  Jogo buscarPorId(Long id){
        return repository.finbyId(id)
                .orElseThrow(()  -> new IllegalArgumentException("jogo não encontrado com o ID; " + id));
    }


    //excluir por id
    public void excluir(Long id) {
        jogoRepository.deleteById(id);
    }
}
