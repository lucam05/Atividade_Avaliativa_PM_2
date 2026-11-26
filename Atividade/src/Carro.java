public class Carro extends Veiculo implements Avaliavel{
    private int quantidadePortas;
    private int somaNotas;
    private int totalAvaliacoes;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, int quantidadePortas, StatusVeiculo status) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem,status);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("A nota deve ser de 1 a 5.");
        somaNotas += nota;
        totalAvaliacoes++;
    }

    public double getMedia() { return totalAvaliacoes == 0 ? 0 : (double) somaNotas / totalAvaliacoes; }

    @Override
    public void exibirDetalhes() {
        System.out.printf(" | Quantidade de portas: %d | Média: %.1f", quantidadePortas, getMedia());
    }

    
}
