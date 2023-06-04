package controllers;

import java.math.BigDecimal;

import models.CalculadoraModel;

public class CalculadoraController {

  private CalculadoraModel model;
  
  public CalculadoraController(CalculadoraModel model) {
    this.model = model;
  }

  /*
   * adicionarNumero(BigDecimal numero)
   * ==================================================
   * Adiciona um número ao modelo da calculadora.
   */
  public void adicionarNumero(BigDecimal numero) {
    model.adicionarNumero(numero);
  }

  /*
   * Esses métodos realizam as operações de soma, subtração, multiplicação e divisão
   * no modelo da calculadora e retorna o resultado.
   */
  public BigDecimal realizarSoma() {
    return model.realizarSoma();
  }

  public BigDecimal realizarSubtracao() {
    return model.realizarSubtracao();
  }

  public BigDecimal realizarMultiplicacao() {
    return model.realizarMultiplicacao();
  }

  public BigDecimal realizarDivisao() {
    return model.realizarDivisao();
  }

  /*
   * reiniciarCalculadora()
   * ==================================================
   * Reinicia o modelo da calculadora, ou seja, remove todos os números adicionados
   * e reinicia os valores internos.
   */
  public void reiniciarCalculadora() {
    model.reiniciarCalculadora();
  }
  
}
