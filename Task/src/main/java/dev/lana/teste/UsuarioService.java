package dev.lana.teste;
import org.springframework.stereotype.Service;

// service: é uma classe de serviço, que contém a lógica de negócio da aplicação. Ela é responsável por orquestrar as operações entre o controller e o repository.
@Service
public class UsuarioService {
    //Composição: UsuarioService tem um UsuarioRepository, UsuarioService depende de UsuarioRepository para funcionar.
    private final UsuarioRepository repository;

    //injeção de dependência: UsuarioService depende de UsuarioRepository para funcionar, então o Spring vai injetar o UsuarioRepository no UsuarioService.
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository; 
    }


    public Usuario cadastrar(String nome) {
        //validação: verifica se o nome é nulo ou vazio, se for lança uma exceção.
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome Obrigatório");//lança uma exceção, que vai ser tratada pelo controller e retornada para o cliente.
        }
        Usuario usuario = new Usuario(nome.trim()); //cria um novo usuário com o nome informado, removendo espaços em branco.

        return repository.save(usuario);//salva o usuário no banco de dados e retorna o usuário salvo, que agora tem um id gerado pelo banco.
    }

}
