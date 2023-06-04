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
   * exibirMenu()
   * ==================================================
   * Exibe um menu da calculadora em um loop contínuo até que o usuário escolha a
   * opção de sair. Ele mostra as opções disponíveis para o usuário, lê a opção
   * escolhida pelo usuário, executa a operação correspondente com base na opção
   * selecionada e lida com possíveis erros de entrada inválida.
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
   * realizarOperacao(String nomeOperacao)
   * ==================================================
   * Realiza uma operação na calculadora com base no nome da operação fornecido. Ele
   * exibe o cabeçalho da operação, lê os números de entrada do usuário e os
   * adiciona ao controlador da calculadora. Em seguida, ele pergunta ao usuário se
   * deseja adicionar outro número e continua o loop até que o usuário escolha
   * parar. Após obter os números de entrada, o método chama o método apropriado no
   * controlador para realizar a operação desejada. Em seguida, exibe o resultado da
   * operação e reinicia a calculadora no controlador.
   */
  private void realizarOperacao(String nomeOperacao) {
    boolean continuar = true;
    System.out.println("===== "+nomeOperacao+" de Números =====");

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

    BigDecimal resultado = null;

    if (nomeOperacao.equalsIgnoreCase("Soma")) {
      resultado = controller.realizarSoma();
    } else if (nomeOperacao.equalsIgnoreCase("Subtração")) {
      resultado = controller.realizarSubtracao();
    } else if (nomeOperacao.equalsIgnoreCase("Multiplicação")) {
      resultado = controller.realizarMultiplicacao();
    } else if (nomeOperacao.equalsIgnoreCase("Divisão")) {
      resultado = controller.realizarDivisao();
    }

    System.out.println("\n===== Resultado da "+nomeOperacao+" =====");
    
    if (resultado != null) {
      exibirResultado(resultado);
    }

    controller.reiniciarCalculadora();
  }



  /*
   * Esses métodos são responsáveis por chamar o método 
   * 'realizarOperacao(String nomeOperacao)' com o nome da operação correspondente.
   */
  private void realizarSoma() {
    realizarOperacao("Soma");
  }

  private void realizarSubtracao() {
    realizarOperacao("Subtração");
  }

  private void realizarMultiplicacao() {
    realizarOperacao("Multiplicação");
  }

  private void realizarDivisao() {
    realizarOperacao("Divisão");
  }


  /*
   * Exibe o resultado de uma operação realizada pela calculadora. Primeiro, remove
   * os zeros à direita do resultado usando o método 'stripTrailingZeros()', criando
   * um novo BigDecimal chamado 'resultadoSemZeros'. Em seguida, ele verifica se a
   * escala do 'resultadoSemZeros' é menor ou igual a zero. Se for, isso significa
   * que o resultado é um número inteiro, então ele é convertido em 'BigInteger'
   * usando o método 'toBigInteger()' e é exibido como um número inteiro. Caso
   * contrário, o resultado é exibido normalmente com um número decimal.
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
   * lerNumero()
   * ==================================================
   * Ler um número digitado pelo usuário. Ele inicializa uma variável 'numero' com o
   * valor zero. Em seguida, entra em um loop enquanto a entrada não for válida.
   * Dentro do loop, ele exibe a mensagem "Digite um número: " e lê a entrada do
   * usuário usando o scanner. Em seguida, substitui qualquer ocorrência de vírgula
   * por ponto, para garantir que o número seja lido corretamente. Em seguida, tenta
   * converter a entrada em um objeto 'BigDecimal'. Se a conversão for bem-sucedida,
   * a variável 'numero' é atualizada com o valor convertido e 'entradaValida' é
   * definida como verdadeira, saindo do loop. Caso contrário, uma exceção
   * 'NumberFormatException' é capturada, indicando que a entrada não é um número
   * válido, e uma mensagem de erro é exibida. Por fim, retorna o número lido.
   */
  private BigDecimal lerNumero() {
    BigDecimal numero = BigDecimal.ZERO;
    boolean entradaValida = false;

    while (!entradaValida) {
      System.out.print("Digite um número: ");
      String input = sc.next();

      // Substitui vírgula por ponto
      input = input.replace(",",".");
      
      // Tenta converter a entrada em número
      try {
        numero = new BigDecimal(input);
        entradaValida = true;
      } catch (NumberFormatException e) {
        System.out.println("Erro: Entrada inválida! Digite um número válido.");
      }
    }
    
    return numero;
  }
  
}
