/* ***************************************************************
* Autor............: Ana Beatriz Silva e Silva
* Matricula........: 202110226
* Inicio...........: 06/02/2023
* Ultima alteracao.: 17/02/2023
* Nome.............: Sistema de Faturamento
* Funcao...........: Um sistema que retorna o faturamento que voce ganhou ou ainda deseja ganhar 
                     dentro de uma venda                     
****************************************************************** */

package model;

public class Calculo {
  private String item;
  private double faturamento;
  private double venda;
  private double gastos;
  private double compra;
  private int lucro;

  public Calculo(String item, double compra, double venda, double gastos, int lucro) { // construtor
    this.item = item;
    this.compra = compra;
    this.venda = venda;
    this.gastos = gastos;
    this.lucro = lucro;

  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public double getCompra() {
    return compra;
  }

  public void setCompra(double compra) {
    this.compra = compra;
  }

  public double getFaturamento() {
    return faturamento;
  }

  public void setFaturamento(double faturamento) {
    this.faturamento = faturamento;
  }

  public double getVenda() {
    return venda;
  }

  public void setVenda(double venda) {
    this.venda = venda;
  }

  public double getGastos() {
    return gastos;
  }

  public void setGastos(double gastos) {
    this.gastos = gastos;
  }

  /*
   * ***************************************************************
   * Metodo: calcularFaturamento
   * Funcao: calcula o valor do faturamento de acordo o valor de venda menos
   * gastos totais(gastos + valor de compra)
   * Parametros: nao foi necessario passar nada como paramentro
   * Retorno: retorna o valor do faturamento
   */

  public double calcularFaturamento() {

    faturamento = getVenda() - (getGastos() + getCompra()); // valor da venda(ex: 1400) - gastos enquanto teve o item
                                                            // (ex: 200) e o valor que voce comprou (ex: 1000)
                                                            // o faturamento vai ser de 1400 - 1200 = 200

    return faturamento;

  }

  /*
   * ***************************************************************
   * Metodo: analise
   * Funcao: analise se ha ou nao faturamento(ou se o faturamento foi o esperado)
   * de acordo a porcentagem de lucro que o usuario quer
   * Parametros: nao foi necessario passar nada como paramentro
   * Retorno: retorna houve ou nao faturamento, e se foi o esperado ou nao
   */

  public String analise() {

    double mediaLucro = (compra + gastos) * lucro / 100; // o usuario vai escolher quanto deseja faturar ( em
                                                         // porcentagem) com a venda do item de acordo seu preco final
                                                         // o algotirmo vai receber o valor e vai calcular de acordo o
                                                         // que foi selecionado e fazer os seguintes retornos abaixo:

    if (faturamento <= 0) {
      return " Nao houve faturamento nessa venda";

    } else {
      if (faturamento <= mediaLucro) {
        return "O faturamento nao foi o esperado nessa  venda de acordo o que voce esperava!";
      } else {
        return "O faturamento foi o ideal nessa venda de acordo o que voce esperava!";
      }
    }

  }
}
