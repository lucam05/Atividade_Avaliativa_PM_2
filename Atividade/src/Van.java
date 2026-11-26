public class Van extends Veiculo implements Avaliavel, Inspecionavel {
    private int maxPassageiros;
    private int somaNotas;
    private int totalAvaliacoes;

    public Van(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, int maxPassageiros, StatusVeiculo status) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.maxPassageiros = maxPassageiros;
    }

    public int getMaxPassageiros() { return maxPassageiros; }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("A nota deve ser de 1 a 5.");
        somaNotas += nota;
        totalAvaliacoes++;
    }

    public double getMedia() { return totalAvaliacoes == 0 ? 0 : (double) somaNotas / totalAvaliacoes; }

    @Override
    public void realizarInspecao() {
        if (getStatus() == StatusVeiculo.MANUTENCAO) setStatus(StatusVeiculo.DISPONIVEL);
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.printf(" | Máx. de passageiros: %d | Média: %.1f", maxPassageiros, getMedia());
    }
}
