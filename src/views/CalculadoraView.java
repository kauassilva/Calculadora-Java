package views;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.CalculadoraController;

public class CalculadoraView {

  private Scanner sc;
  private CalculadoraController controller;

  // Constantes para as opções do menu
  private static final int OPCAO_SOMAR = 1;
  private static final int OPCAO_SUBTRAIR = 2;
  private static final int OPCAO_MULTIPLICAR = 3;
  private static final int OPCAO_DIVIDIR = 4;
  private static final int OPCAO_SAIR = 5;

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
      System.out.println("========== Calculadora ==========");
      System.out.println("| "+OPCAO_SOMAR+". Somar números              |");
      System.out.println("| "+OPCAO_SUBTRAIR+". Subtrair números           |");
      System.out.println("| "+OPCAO_MULTIPLICAR+". Multiplicar números        |");
      System.out.println("| "+OPCAO_DIVIDIR+". Dividir números            |");
      System.out.println("| "+OPCAO_SAIR+". Sair                       |");
      System.out.println("+-------------------------------+");
      System.out.println();
      System.out.print("Digite uma opção: ");

      try {
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        System.out.println();
  
        switch (opcao) {
          case OPCAO_SOMAR:
            realizarSoma();
            break;
          case OPCAO_SUBTRAIR:
            realizarSubtracao();
            break;
          case OPCAO_MULTIPLICAR:
            realizarMultiplicacao();
            break;
          case OPCAO_DIVIDIR:
            realizarDivisao();
            break;
          case OPCAO_SAIR:
            sair = true;
            break;
          default: 
            System.out.println("Erro: Opção inválida! Tente novamente.\n");
        }
  
      } catch (InputMismatchException e) {
        System.out.println("\nErro: Opção inválida! Tente novamente.\n");
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
    System.out.println("===== Soma de Números =====");

    do {
      BigDecimal num = lerNumero();
      controller.adicionarNumero(num);
      String resposta;

      do {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        resposta = sc.next();
        
        if (resposta.equalsIgnoreCase("S")) {
          break;
        } else if (resposta.equalsIgnoreCase("N")) {
          continuar = false;
          break;
        } else {
          System.out.println("Erro: Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      } while (true);
    } while (continuar);

    BigDecimal resultado = controller.realizarSoma();
    System.out.println("\n===== Resultado da Soma =====");
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
    System.out.println("===== Subtração de Números =====");

    do {
      BigDecimal num = lerNumero();
      controller.adicionarNumero(num);
      String resposta;

      
      do {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        resposta = sc.next();

        if (resposta.equalsIgnoreCase("S")) {
          break;
        } else if (resposta.equalsIgnoreCase("N")) {
          continuar = false;
          break;
        } else {
          System.out.println("Erro: Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      } while (true);
    } while (continuar);

    BigDecimal resultado = controller.realizarSubtracao();
    System.out.println("\n===== Resultado da Subtração =====");
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
    System.out.println("===== Multiplicação de Números =====");

    do {
      BigDecimal num = lerNumero();
      controller.adicionarNumero(num);
      String resposta;

      do {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        resposta = sc.next();
        
        if (resposta.equalsIgnoreCase("S")) {
          break;
        } else if (resposta.equalsIgnoreCase("N")) {
          continuar = false;
          break;
        } else {
          System.out.println("Erro: Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      } while (true);
    } while (continuar);

    BigDecimal resultado = controller.realizarMultiplicacao();
    System.out.println("\n===== Resultado da Multiplicação =====");
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
    System.out.println("===== Divisão de Números =====");

    do {
      BigDecimal num = lerNumero();
      controller.adicionarNumero(num);
      String resposta;

      do {
        System.out.print("Deseja adicionar outro número? (S/N): ");
        resposta = sc.next();

        if (resposta.equalsIgnoreCase("S")) {
          break;
        } else if (resposta.equalsIgnoreCase("N")) {
          continuar = false;
          break;
        } else {
          System.out.println("Erro: Opção inválida! Digite 'S' para continuar ou 'N' para parar.");
        }
      } while (true);
    } while (continuar);

    BigDecimal resultado = controller.realizarDivisao();
    System.out.println("\n===== Resultado da Divisão =====");

    if (resultado.compareTo(BigDecimal.ZERO) == 0) {
      System.out.println("Erro: Não pode dividir por 0!");
    } else {
      exibirResultado(resultado);
    }

    controller.reiniciarCalculadora();
  }

  /*
   * Exibe o resultado da operação realizada. Se o resultado for um número inteiro,
   * ele exibe sem o ponto decimal ".0".
   */
  private void exibirResultado(BigDecimal resultado) {
    BigDecimal resultadoSemZeros = resultado.stripTrailingZeros();

    if (resultadoSemZeros.scale() <= 0) {
      System.out.println("Resultado: "+resultadoSemZeros.toBigInteger());
    } else {
      System.out.println("Resultado: "+resultado);
    }
  }

  /*
   * Solicita ao usuário que digite um número e realiza a validação da entrada para
   * garantir que seja um número válido. Ele continua solicitando a entrada até que
   * o usuário forneça um número válido, exibindo uma mensagem de erro caso
   * contrário. O número válido é convertido para o tipo 'double' e retornado pelo
   * método.
   */
  private BigDecimal lerNumero() {
    BigDecimal numero = BigDecimal.ZERO;
    boolean entradaValida = false;

    while (!entradaValida) {
      System.out.print("Digite um número: ");
      String input = sc.next();

      // Substitui vírgula por ponto
      input = input.replace(",",".");
      
      // Verifica se a entrada corresponde a um número válido utilizando expressão regular
      if (validarEntrada(input)) {
        numero = new BigDecimal(input);
        entradaValida = true;
      } else {
        System.out.println("Erro: Entrada inválida! Digite um número válido.");
      }
    }
    
    return numero;
  }
  
  private boolean validarEntrada(String entrada) {
    return entrada.matches("-?\\d+(\\.\\d+)?");
  }
  
}
