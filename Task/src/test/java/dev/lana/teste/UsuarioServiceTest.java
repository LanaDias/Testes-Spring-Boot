package dev.lana.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // Corrigido o erro de digitação de "MockitoExtensio"
public class UsuarioServiceTest {

    @Mock
    UsuarioRepository repository;

    @InjectMocks
    UsuarioService service;

    @Test
    @DisplayName("Rejeita nome nulo")
    void deveRejeitarNomeNulo() {
        // Executa a ação e valida se a exceção correta é lançada
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.cadastrar(""); // Substitua pelo método real do seu service (ex: cadastrar, criar)
        });

        // Valida se a mensagem da exceção está correta (opcional)
        assertEquals("Nome Obrigatório", exception.getMessage());

        // Garante que o repositório nunca foi chamado para salvar um usuário inválido
        verify(repository, never()).save(any());
    }    
}
