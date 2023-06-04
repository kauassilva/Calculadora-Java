package models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CalculadoraModel {

  private List<BigDecimal> numeros;

  public CalculadoraModel() {
    numeros = new ArrayList<>(); 
  }

  /*
   * adicionarNumero(BigDecimal numero)
   * ==================================================
   * Adiciona o número à lista de números da calculadora.
   */
  public void adicionarNumero(BigDecimal numero) {
    numeros.add(numero);
  }

  /*
   * realizarSoma()
   * ==================================================
   * Itera sobre a lista de números e realiza a operação de soma, acumulando o
   * resultado na variável 'resultado'. Ele retorna o resultado final da soma.
   */
  public BigDecimal realizarSoma() {
    BigDecimal resultado = BigDecimal.ZERO;
    for (BigDecimal num : numeros) {
      resultado = resultado.add(num);
    }
    return resultado;
  }

  /*
   * realizarSubtracao()
   * ==================================================
   * Realiza a operação de subtração na lista de números. Ele começa com o primeiro
   * número da lista e itera sobre os demais números, subtraindo-os da variável
   * 'resulado'. Ele retorna o resultado final da subtração.
   */
  public BigDecimal realizarSubtracao() {
    BigDecimal resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {
      resultado = resultado.subtract(numeros.get(i));
    }
    return resultado;
  }

  /*
   * realizarMultiplicacao()
   * ==================================================
   * Itera sobre a lista de números e realiza a operação de multiplicação,
   * acumulando o resultado na variável 'resultado'. Ele retorna o resultado final
   * da multiplicação.
   */
  public BigDecimal realizarMultiplicacao() {
    BigDecimal resultado = BigDecimal.ONE;
    for (BigDecimal num : numeros) {
      resultado = resultado.multiply(num);
    }
    return resultado;
  }

  /*
   * realizarDivisao()
   * ==================================================
   * Realiza a operação de divisão na lista de números. Ele começa com o primeiro
   * número da lista e itera sobre os demais números, dividindo-os pela variável
   * 'resultado'. Se os números após o primeiro número forem zero, uma exceção
   * 'ArithmeticException' é lançada. O método retorna o resultado final da divisão.
   */
  public BigDecimal realizarDivisao() {
    BigDecimal resultado = numeros.get(0);
    for (int i = 1; i < numeros.size(); i++) {
      if (numeros.get(i).compareTo(BigDecimal.ZERO) != 0) {
        resultado = resultado.divide(numeros.get(i), 30, RoundingMode.HALF_EVEN);
      } else {
        return BigDecimal.ZERO;
      }
    }
    return resultado;
  }

  /*
   * reiniciarCalculadora()
   * ==================================================
   * Reinicia a calculadora, limpando a lista de números utilizando o método
   * 'clear()'.
   */
  public void reiniciarCalculadora() {
    numeros.clear();
  }
  
}
