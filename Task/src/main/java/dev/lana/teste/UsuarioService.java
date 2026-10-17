package dev.lana.teste;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    // composição
    // service: regras de negócio, verifica se o usuario e valido, se atende as
    // regras de negócio se sim chama repository para retornar os dados.
    private final UsuarioRepository repository;

    
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome Obrigatório");
        }
        Usuario usuario = new Usuario(nome.trim());
        return repository.save(usuario);
    }

}
