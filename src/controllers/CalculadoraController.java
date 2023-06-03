package controllers;

import java.math.BigDecimal;

import models.CalculadoraModel;

public class CalculadoraController {

  private CalculadoraModel model;
  
  public CalculadoraController(CalculadoraModel model) {
    this.model = model;
  }

  /*
   * Adiciona um número ao modelo da calculadora. Ele chama o método
   * 'adicionarNumero()' do objeto 'CalculadoraModel'.
   */
  public void adicionarNumero(BigDecimal numero) {
    model.adicionarNumero(numero);
  }

  /*
   * Realiza a operação de soma no modelo da calculadora e retorna o resultado. Ele
   * chama o método 'realizarSoma()' do objeto 'CalculadoraModel'.
   */
  public BigDecimal realizarSoma() {
    return model.realizarSoma();
  }

  /*
   * Realiza a operação de subtração no modelo da calculadora e retorna o resultado.
   * Ele chama o método 'realizarSutracao()' do objeto 'CalculadoraModel'.
   */
  public BigDecimal realizarSubtracao() {
    return model.realizarSubtracao();
  }

  /*
   * Realiza a operação de multiplicação no modelo da calculadora e retorna o
   * resultado. Ele chama o método 'realizarMultiplicacao()' do objeto
   * 'CalculadoraModel'.
   */
  public BigDecimal realizarMultiplicacao() {
    return model.realizarMultiplicacao();
  }

  /*
   * Realiza a operação de divisão no modelo da calculadora e retorna o resultado.
   * Ele chama o método 'realizarDivisao()' do objeto 'CalculadoraModel'.
   */
  public BigDecimal realizarDivisao() {
    return model.realizarDivisao();
  }

  /*
   * Reinicia o modelo da calculadora, ou seja, remove todos os números adicionados
   * e reinicia os valores internos. Ele chama o método 'reiniciarCalculadora()' do
   * objeto 'CalculadoraModel'.
   */
  public void reiniciarCalculadora() {
    model.reiniciarCalculadora();
  }
  
}
