package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.CalculadoraController;

public class CalculadoraView {

  private Scanner sc;
  private CalculadoraController controller;

  public CalculadoraView() {
    sc = new Scanner(System.in);
  }

  public void setController(CalculadoraController controller) {
    this.controller = controller;
  }

  /*
   * Exibe um menu com opções para realizar diferentes operações matemáticas. Ele lê
   * a opção selecionada pelo usuário e executa o método correspondente no
   * controlador. Se o usuário fornecer uma opção inválida, uma mensagem de erro é
   * exibida e o menu é mostrado novamente.
   */
  public void exibirMenu() {
    boolean sair = false;
    
    while (!sair) {
      System.out.println();
      System.out.println("========== Menu ==========");
      System.out.println("1. Somar números");
      System.out.println("2. Subtrair números");
      System.out.println("3. Multiplicar números");
      System.out.println("4. Dividir números");
      System.out.println("5. Sair");
      System.out.print("Digite uma opção: ");

      try {
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        System.out.println();
  
        switch (opcao) {
          case 1:
            realizarSoma();
            break;
          case 2:
            realizarSubtracao();
            break;
          case 3:
            realizarMultiplicacao();
            break;
          case 4:
            realizarDivisao();
            break;
          case 5:
            sair = true;
            break;
          default: 
            System.out.println("Opção inválida! Tente novamente.\n");
        }
  
      } catch (InputMismatchException e) {
        System.out.println("\nOpção inválida! Tente novamente.\n");
        sc.nextLine(); // Limpar o buffer do scanner
      }
    }
  }

  /*
   * Este método permite ao usuário números para realizar uma operação de soma. Ele
   * solicita os números e verifica se o usuário deseja adicionar mais números. O
   * método 'realizarSoma()' do controlador para calcular a soma dos números
   * inseridos e exibe o resultado
   */
  private void realizarSoma() {
    boolean continuar = true;

    while (continuar) {
      double num = lerNumero();
      controller.adicionarNumero(num);

      boolean respostaValida = false;

      while (!respostaValida) {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        String resposta = sc.next();
        
        if (resposta.equalsIgnoreCase("S")) {
          respostaValida = true;
        } else if (resposta.equalsIgnoreCase("N")) {
          respostaValida = true;
          continuar = false;
        } else {
          System.out.println("Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      }
    }

    double resultado = controller.realizarSoma();
    exibirResultado(resultado);
    controller.reiniciarCalculadora();
  }

  /*
   * Este método permite ao usuário números para realizar uma operação de subtração.
   * Ele solicita os números e verifica se o usuário deseja adicionar mais números.
   * O método 'realizarSubtracao()' do controlador para calcular a subtração dos
   * números inseridos e exibe o resultado.
   */
  private void realizarSubtracao() {
    boolean continuar = true;

    while (continuar) {
      double num = lerNumero();
      controller.adicionarNumero(num);

      boolean respostaValida = false;

      while (!respostaValida) {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        String resposta = sc.next();

        if (resposta.equalsIgnoreCase("S")) {
          respostaValida = true;
        } else if (resposta.equalsIgnoreCase("N")) {
          respostaValida = true;
          continuar = false;
        } else {
          System.out.println("Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      }
    }

    double resultado = controller.realizarSubtracao();
    exibirResultado(resultado);
    controller.reiniciarCalculadora();
  }

  /*
   * Este método permite ao usuário números para realizar uma operação de
   * multiplicação. Ele solicita os números e verifica se o usuário deseja adicionar
   * mais números. O método 'realizarMultiplicacao()' do controlador para calcular a
   * multiplicação dos números inseridos e exibe o resultado.
   */
  private void realizarMultiplicacao() {
    boolean continuar = true;

    while (continuar) {
      double num = lerNumero();
      controller.adicionarNumero(num);

      boolean respostaValida = false;

      while (!respostaValida) {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        String resposta =sc.next();
        
        if (resposta.equalsIgnoreCase("S")) {
          respostaValida = true;
        } else if (resposta.equalsIgnoreCase("N")) {
          respostaValida = true;
          continuar = false;
        } else {
          System.out.println("Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      }
    }

    double resultado = controller.realizarMultiplicacao();
    exibirResultado(resultado);
    controller.reiniciarCalculadora();
  }

  /*
   * Este método permite ao usuário números para realizar uma operação de divisão.
   * Ele solicita os números e verifica se o usuário deseja adicionar mais números.
   * O método 'realizarDivisao()' do controlador para calcular a divisão dos
   * números inseridos e exibe o resultado.
   */
  private void realizarDivisao() {
    boolean continuar = true;

    while (continuar) {
      double num = lerNumero();
      controller.adicionarNumero(num);

      boolean respostaValida = false;

      while (!respostaValida) {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        String resposta = sc.next();

        if (resposta.equalsIgnoreCase("S")) {
          respostaValida = true;
        } else if (resposta.equalsIgnoreCase("N")) {
          respostaValida = true;
          continuar = false;
        } else {
          System.out.println("Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      }
    }

    double resultado = controller.realizarDivisao();
    exibirResultado(resultado);
    controller.reiniciarCalculadora();
  }

  /*
   * Exibe o resultado da operação realizada. Se o resultado for um número inteiro,
   * ele exibe sem o ponto decimal ".0".
   */
  private void exibirResultado(double resultado) {
    if (resultado % 1 == 0) {
      System.out.println("Resultado: "+ (int) resultado);
    } else {
      System.out.println("Resultado: "+resultado);
    }
  }

  private double lerNumero() {
    double numero = 0;
    boolean entradaValida = false;

    while (!entradaValida) {
      System.out.print("Digite um número: ");
      String input = sc.next();

      if (input.matches("-?\\d+(\\.\\d+)?")) {
        numero = Double.parseDouble(input);
        entradaValida = true;
      } else {
        System.out.println("Entrada inválida! Digite um número válido.");
      }
    }

    return numero;
  }
  
}
