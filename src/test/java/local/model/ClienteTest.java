package local.model;

import local.exception.ClienteException;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    String NOME_NAO_PODE_SER_NULO = "O nome não pode ser nulo";
    String NOME_DEVE_TER_ENTRE_3_E_55_CARACTERES = "nome deve possuir entre 4 e 55 caracteres (inclusive)";


    //TODO: O nome não pode ser nulo.
    // Lança ClienteException -  Nome é um campo obrigatório

    @Test
    @DisplayName("Nome não pode ser nulo")
    public void nomeNaoDeveSerNulo() {
        Cliente cliente = new Cliente();
        ClienteException clienteException = assertThrows(ClienteException.class, () -> cliente.setNome(null));
        assertThat(clienteException.getMessage(), is(equalTo(NOME_NAO_PODE_SER_NULO)));
    }

    //TODO: nome deve possuir entre 4 e 55 caracteres (inclusive).
    // Lança ClienteException - O nome do cliente deve possuir entre 4 e 55 caracteres

    @Test
    @DisplayName("Não deve aceitar nome com 3 caracteres")
    public void NaoDeveAceitarNomeCom3Caracteres() {
        Cliente cliente = new Cliente();
        ClienteException clienteException = assertThrows(ClienteException.class, () -> cliente.setNome("Nom"));
        assertThat(clienteException.getMessage(), is(equalTo(NOME_DEVE_TER_ENTRE_3_E_55_CARACTERES)));
    }

    @Test
    @DisplayName("Não deve aceitar nome com 56 caracteres")
    public void NaoDeveAceitarNomeCom56Caracteres() {
        Cliente cliente = new Cliente();
        ClienteException clienteException = assertThrows(ClienteException.class, () -> cliente.setNome("NomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNome"));
        assertThat(clienteException.getMessage(), is(equalTo(NOME_DEVE_TER_ENTRE_3_E_55_CARACTERES)));
    }

    @Test
    @DisplayName("Deve aceitar nome com 4 caracteres")
    public void DeveAceitarNomeCom4Caracteres() {
        Cliente cliente = new Cliente();
        ClienteException clienteException = assertThrows(ClienteException.class, () -> cliente.setNome("No e"));
        assertThat(clienteException.getMessage(), is(equalTo(NOME_DEVE_TER_ENTRE_3_E_55_CARACTERES)));
    }

    @Test
    @DisplayName("Deve aceitar nome com 55 caracteres")
    public void NaoDeveAceitarNomeCom55Caracteres() {
        Cliente cliente = new Cliente();
        ClienteException clienteException = assertThrows(ClienteException.class, () -> cliente.setNome("Nome omeNomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNomeNom"));
        assertThat(clienteException.getMessage(), is(equalTo(NOME_DEVE_TER_ENTRE_3_E_55_CARACTERES)));
    }

    //TODO: O nome do cadastro deve possuir pelo menos 2 nomes.
    // Lança ClienteException -  necessário adicionar um sobrenome (ex.: Angelo Luz)

    @Test
    @DisplayName("Deve aceitar nome com 55 caracteres")
    public void DeveTerNomeESobrenome() {
        Cliente cliente = new Cliente();
        cliente.setNome("No e");
    }

    //TODO: Espaços no início e fim de nomes devem ser descartados

    //TODO: Nomes não devem possuir símbolos ou números.
    // Lança ClienteException - Números e símbolos não são permitidos



}
