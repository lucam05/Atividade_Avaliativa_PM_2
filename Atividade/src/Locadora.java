import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Aluguel> alugueis = new ArrayList<>();
    private int proximoCodigo = 1;

    public List<Veiculo> getVeiculos() { return veiculos    ; }
    public List<Aluguel> getAlugueis() { return alugueis; }

    public void adicionarVeiculo(Veiculo item) {
        for (Veiculo existente : veiculos) {
            if (existente.getPlaca().equalsIgnoreCase(item.getPlaca()))
                throw new IllegalArgumentException("Já existe veículo com placa " + item.getPlaca());
        }
        veiculos.add(item);
    }

    public Aluguel criarAluguel(int tipo, String cliente, int dias) {
        Aluguel c;
        switch (tipo) {
            case 1 -> c = new AluguelBasico(proximoCodigo, cliente, dias);
            case 2 -> c = new AluguelPremium(proximoCodigo, cliente, dias);
            case 3 -> c = new AluguelExecutivo(proximoCodigo, cliente, dias);
            default -> throw new IllegalArgumentException("Tipo inválido.");
        }
        proximoCodigo++;
        alugueis.add(c);
        return c;
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo item : veiculos) {
            if (item.getPlaca().equalsIgnoreCase(placa)) return item;
        }
        throw new IllegalArgumentException("Veículo não encontrado(a): " + placa);
    }

    public Aluguel buscarAluguel(int codigo) {
        for (Aluguel c : alugueis) {
            if (c.getCodigo() == codigo) return c;
        }
        throw new IllegalArgumentException("Aluguel não encontrado(a): " + codigo);
    }

    
    public void associarVeiculo(int codigoAluguel, String placa) {
        buscarAluguel(codigoAluguel).adicionarVeiculo(buscarVeiculo(placa));
    }

  
    public List<Veiculo> getDisponiveis() {
        List<Veiculo> lista = new ArrayList<>();
        for (Veiculo item : veiculos) {
            if (item.getStatus() == StatusVeiculo.DISPONIVEL) lista.add(item);
        }
        return lista;
    }


    public List<Avaliavel> getAvaliaveis() {
        List<Avaliavel> lista = new ArrayList<>();
        for (Veiculo item : veiculos) {
            if (item instanceof Avaliavel) lista.add((Avaliavel) item);
        }
        for (Aluguel c : alugueis) {
            if (c instanceof Avaliavel) lista.add((Avaliavel) c);
        }
        return lista;
    }

    public List<Inspecionavel> getInspecionaveis() {
        List<Inspecionavel> lista = new ArrayList<>();
        for (Veiculo item : veiculos) {
            if (item instanceof Inspecionavel) lista.add((Inspecionavel) item);
        }
        return lista;
    }

    
    public int removerEmManutencao() {
        List<Veiculo> remover = new ArrayList<>();
        for (Veiculo item : veiculos) {
            if (item.getStatus() == StatusVeiculo.MANUTENCAO) remover.add(item);
        }
        for (Veiculo item : remover) {
            veiculos.remove(item);
            for (Aluguel c : alugueis) c.removerVeiculo(item);
        }
        return remover.size();
    }
}
