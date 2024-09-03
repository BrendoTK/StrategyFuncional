import lombok.Setter;

import java.util.List;
import java.util.function.Function;

@Setter
public class ProcessarBoletos {
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo) {
        String nome = "   Brendo   ";
        Function<String, String> trim = String::trim;
        var trimLowercase = trim.andThen(String::toLowerCase);
        System.out.println(trimLowercase.apply(nome));

        var listaBoletos = leituraRetorno.apply(nomeArquivo);
        System.out.println(listaBoletos);
    }
}
