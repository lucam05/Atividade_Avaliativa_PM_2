/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glbra
 */
public abstract class Aluguel {
    private int codigo;
    private String nomeCliente;
    private int quantidadeDias;
    private double valorTotal;
    private StatusAluguel status;
    private List<Veiculo> veiculos = new ArrayList<>();

    public Aluguel(String nomeCliente, int quantidadeDias, double valorTotal, StatusAluguel status,int codigo) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Aluguel(int codigo, String cliente, int dias) {
        
    }
    public int getCodigo() { return codigo; }
    public List<Veiculo> getVeiculos() { return veiculos; }
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusAluguel getStatus() {
        return status;
    }

    public void setStatus(StatusAluguel status) {
        this.status = status;
    }
    public void adicionarVeiculo(Veiculo item) {
        if (item.getStatus() != StatusVeiculo.DISPONIVEL)
            throw new IllegalStateException("Veículo " + item.getPlaca() + " não está disponível.");
        veiculos.add(item);
        item.setStatus(StatusVeiculo.ALUGADO);
    }

    public void removerVeiculo(Veiculo item) { veiculos.remove(item); }

    public double calcularValor() {
        double total = 0;
        for (Veiculo item : veiculos) total += item.getValorDiaria() * quantidadeDias;
        return total;
    }

    public abstract void exibirDetalhes();

    public abstract boolean possuiSeguroIncluso();
    
}
