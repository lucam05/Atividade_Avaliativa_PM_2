public class Moto extends Veiculo implements Inspecionavel {
    private double cilindrada;


    public Moto(String placa, String modelo, int anoFabricacao, double valorDiaria, double quilometragem, double cilindrada, StatusVeiculo status) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.cilindrada = cilindrada;
    }

    public double getCilindrada() { 
        return cilindrada; 
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf(" | Cilindrada (cc): %d", cilindrada);
    }

   @Override
    public void realizarInspecao() {
        if (getStatus() == StatusVeiculo.MANUTENCAO) setStatus(StatusVeiculo.DISPONIVEL);
    }


}
