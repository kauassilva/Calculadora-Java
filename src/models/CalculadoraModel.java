package models;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraModel {

  private List<Double> numeros;

  public CalculadoraModel() {
    numeros = new ArrayList<>(); 
  }

  /*
   * Adiciona o número à lista de números da calculadora. Ele simplesmente adiciona
   * o número à lista 'numeros' usando o método 'add()'.
   */
  public void adicionarNumero(double numero) {
    numeros.add(numero);
  }

  /*
   * Itero sobre a lista de números e realiza a operação de soma, acumulando o
   * resultado na variável 'resultado'. Ele retorna o resultado final da soma.
   */
  public double realizarSoma() {
    double resultado = 0;
    for (double num : numeros) {
      resultado += num;
    }
    return resultado;
  }

  /*
   * Realiza a operação de subtração na lista de números. Ele começa com o primeiro
   * número da lista e itera sobre os demais números, subtraindo-os da variável
   * 'resulado'. Ele retorna o resultado final da subtração.
   */
  public double realizarSubtracao() {
    double resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {
      resultado -= numeros.get(i);
    }
    return resultado;
  }

  /*
   * Itera sobre a lista de números e realiza a operação de multiplicação,
   * acumulando o resultado na variável 'resultado'. Ele retorna o resultado final
   * da multiplicação.
   */
  public double realizarMultiplicacao() {
    double resultado = 1;
    for (double num : numeros) {
      resultado *= num;
    }
    return resultado;
  }

  /*
   * Realiza a operação de divisão na lista de números. Ele começa com o primeiro
   * número da lista e itera sobre os demais números, dividindo-os pela variável
   * 'resultado'. Se os números após o primeiro número forem zero, uma exceção
   * 'ArithmeticException' é lançada. O método retorna o resultado final da divisão.
   */
  public double realizarDivisao() {
    double resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {
      if (numeros.get(i) != 0) {
        resultado /= numeros.get(i);
      } else {
        throw new ArithmeticException("Divisão por zero!");
      }
    }
    return resultado;
  }

  /*
   * Reinicia a calculadora, limpando a lista de números utilizando o método
   * 'clear()'.
   */
  public void reiniciarCalculadora() {
    numeros.clear();
  }
  
}
