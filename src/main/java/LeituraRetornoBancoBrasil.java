
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoBrasil {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static List<Boleto> lerArquivo(String caminhoArquivo) {
        var boletos = new ArrayList<Boleto>();

        try {
            var linhas = Files.readAllLines(Path.of(caminhoArquivo));
            for (String linha : linhas) {
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDataPagamento((LocalDate.parse(vetor[3], FORMATO_DATA)).atStartOfDay());
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));

                boletos.add(boleto);

                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return boletos;
    }
}
