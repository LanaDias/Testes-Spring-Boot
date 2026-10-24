
package dev.lana.teste;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que essa classe é um controller do Spring, que vai receber requisições HTTP e retornar respostas HTTP.
@RequestMapping("/usuarios") //indica que todas as requisições para /usuarios vão ser tratadas por esse controller.
public class UsuarioController {

    private final UsuarioService usuarioService; //injeção de dependência: UsuarioController depende de UsuarioService para funcionar, então o Spring vai injetar o UsuarioService no UsuarioController.

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService; 
    }

    @PostMapping //indica que esse método vai tratar requisições HTTP POST para /usuarios.
    public ResponseEntity<Usuario> cadastrar( //indica que esse método vai receber um objeto do tipo Usuario no corpo da requisição HTTP.
            @RequestBody Usuario usuario) { //indica que o objeto Usuario vai ser desserializado do corpo da requisição HTTP.

               
        try {
            Usuario usuarioCadastrado =
                    usuarioService.cadastrar(usuario.getNome());

            return ResponseEntity //responseEntity é uma classe do Spring que representa uma resposta HTTP, que contém o status HTTP, os headers HTTP e o corpo da resposta HTTP.
                    .status(HttpStatus.CREATED) //indica que a resposta HTTP vai ter o status 201 Created, que indica que o recurso foi criado com sucesso.
                    .body(usuarioCadastrado); //retorna o usuário cadastrado no corpo da resposta HTTP, com o status HTTP 201 Created.
                    
//caso o try não consiga cadastrar o usuário, ele vai lançar uma exceção IllegalArgumentException, que vai ser capturada pelo catch e vai retornar uma resposta HTTP 400 Bad Request, que indica que a requisição HTTP é inválida.
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
