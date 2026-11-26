public class AluguelExecutivo extends Aluguel implements Avaliavel {
    private boolean quilometragemIlimitada = true;
    private boolean motoristaParticular = true;
    private int somaNotas;
    private int totalAvaliacoes;

    public AluguelExecutivo(int codigo, String cliente, int dias) { super(codigo, cliente, dias); }

    @Override
    public void avaliar(int nota) {
        if (nota < 1 || nota > 5) throw new IllegalArgumentException("A nota deve ser de 1 a 5.");
        somaNotas += nota;
        totalAvaliacoes++;
    }

    public double getMedia() { return totalAvaliacoes == 0 ? 0 : (double) somaNotas / totalAvaliacoes; }

    @Override
    public void exibirDetalhes() {
        
        System.out.printf("Km ilimitada: %s | Motorista particular: %s | Média: %.1f", (quilometragemIlimitada ? "sim" : "não"), (motoristaParticular ? "sim" : "não"), getMedia());
    }

    @Override
    public boolean possuiSeguroIncluso() {
        
        throw new UnsupportedOperationException("Possui seguro incluso");
    }
}
