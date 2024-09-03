public class Principal {
    public static void main(String[] args) {
        var processarBoletos1 = new ProcessarBoletos(LeituraRetornoBancoBrasil::lerArquivo);
        var processarBoletos2 = new ProcessarBoletos(LeituraRetornoBradesco::lerArquivo);
        processarBoletos1.processar("banco-brasil-1.csv");
        processarBoletos2.processar("bradesco-1.csv");
    }
}
