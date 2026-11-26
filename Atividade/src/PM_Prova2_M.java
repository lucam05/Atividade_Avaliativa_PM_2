/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author glbra
 */

import java.util.Scanner;
import java.util.List;

public class PM_Prova2_M {
    private static Scanner sc = new Scanner(System.in);
    private static Locadora locadora = new Locadora();
    public static void main(String[] args) {
        criarDadosIniciais();
        int opcao;

        do {
            System.out.println("\n===== LOCADORA DE AUTOMÓVEIS =====");
            System.out.println("1 - Associar veículo a um(a) aluguel");
            System.out.println("2 - Exibir todos os(as) veículos");
            System.out.println("3 - Exibir todos os(as) aluguéis");
            System.out.println("4 - Exibir veículos disponíveis");
            System.out.println("5 - Avaliar");
            System.out.println("6 - Realizar inspeção");
            System.out.println("7 - Remover veículos em manutenção");
            System.out.println("0 - Sair");
            opcao = lerInt("Opção: ");
            try {
                switch (opcao) {
                    case 1 -> associarVeiculo();
                    case 2 -> exibir(locadora.getVeiculos());
                    case 3 -> exibir(locadora.getAlugueis());
                    case 4 -> exibir(locadora.getDisponiveis());
                    case 5 -> avaliar();
                    case 6 -> inspecionar();
                    case 7 -> System.out.println(locadora.removerEmManutencao() + " removido(s).");
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void criarDadosIniciais() {
        locadora.adicionarVeiculo(new Carro("ABC1D23", "Chevrolet Onix", 2022, 150, 35000, 4, null));
        locadora.adicionarVeiculo(new Moto("MOT4E56", "Honda CB 500", 2021, 90.00, 1800.00, 0, null));
        locadora.adicionarVeiculo(new Van("VAN7F89", "Mercedes Sprinter", 2020, 320, 80000, 15, null));
        locadora.buscarVeiculo("MOT4E56").setStatus(StatusVeiculo.MANUTENCAO);

        Aluguel c1 = locadora.criarAluguel(1, "Ana Souza", 3);
        locadora.criarAluguel(3, "Empresa XPTO", 5);
        locadora.associarVeiculo(c1.getCodigo(), "ABC1D23");
    }

    private static void associarVeiculo() {
        exibir(locadora.getAlugueis());
        int codigoAluguel = lerInt("Código do(a) aluguel: ");
        exibir(locadora.getDisponiveis());
        String placa = lerTexto("Placa: ");
        locadora.associarVeiculo(codigoAluguel, placa);
        System.out.println("Associado com sucesso!");
    }

    private static void avaliar() {
        List<Avaliavel> lista = locadora.getAvaliaveis();
        Avaliavel escolhido = escolher(lista);
        escolhido.avaliar(lerInt("Nota (1 a 5): "));
        System.out.println("Avaliação registrada!");
    }

    private static void inspecionar() {
        List<Inspecionavel> lista = locadora.getInspecionaveis();
        Inspecionavel escolhido = escolher(lista);
        escolhido.realizarInspecao();
        System.out.println("Inspeção realizada! " + escolhido);
    } private static <T> T escolher(List<T> lista) {
        if (lista.isEmpty()) throw new IllegalStateException("Nenhum item disponível para esta operação.");
        for (int i = 0; i < lista.size(); i++) System.out.println((i + 1) + " - " + lista.get(i));
        int indice = lerInt("Escolha: ");
        if (indice < 1 || indice > lista.size()) throw new IllegalArgumentException("Opção inválida.");
        return lista.get(indice - 1);
    }

    private static void exibir(List<?> lista) {
        if (lista.isEmpty()) System.out.println("Nenhum registro.");
        for (Object o : lista) System.out.println(o);
    }

    private static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim();
    }
}