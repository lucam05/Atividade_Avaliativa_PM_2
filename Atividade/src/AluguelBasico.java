public class AluguelBasico extends Aluguel {
    private int limiteKmPorDia = 100;
    private boolean seguroIncluso = false;

    public AluguelBasico(int codigo, String cliente, int dias) { super(codigo, cliente, dias); }


    @Override
    public void exibirDetalhes() {
       System.out.printf("Limite de km/dia: %d | Seguro incluso: %s", limiteKmPorDia, (seguroIncluso ? "sim" : "não"));
    }

    @Override
    public boolean possuiSeguroIncluso() {
        
        throw new UnsupportedOperationException("Não possui seguro incluso'");
    }
}
