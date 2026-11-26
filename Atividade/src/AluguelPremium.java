public class AluguelPremium extends Aluguel {
    private boolean quilometragemIlimitada = true;
    private boolean seguroIncluso = true;

    public AluguelPremium(int codigo, String cliente, int dias) { super(codigo, cliente, dias); }

 


    @Override
    public void exibirDetalhes() {
       System.out.printf("Km ilimitada: %s | Seguro incluso: %s", (quilometragemIlimitada ? "sim" : "não"), (seguroIncluso ? "sim" : "não"));
    }


    @Override
    public boolean possuiSeguroIncluso() {
     
        throw new UnsupportedOperationException("Possui seguro incluso!");
    }
}
