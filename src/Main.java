import controllers.CalculadoraController;
import models.CalculadoraModel;
import views.CalculadoraView;

public class Main {
    /*
     * Esta classe representa o ponto de entrada do programa e cria uma instância da
     * calculadora MVC. Ele instancia a 'CalculadoraView', o 'CalculadoraModel' e o
     * 'CalculadoraController', e conecta-os entre si. Em seguida, define o
     * controlador na visão, exibe o menu da calculadora e permite que o usuário
     * faça operações matemáticas como soma, subtração, multiplicação e divisão, até
     * escolher sair. O controlador coordena as interações entre visão e o modelo,
     * enquanto a visão exibe as informações ao usuário e obtém as entradas do
     * usuário. O modelo contém a lógica da calculadora, realizando as operações
     * matemáticas.
     */
    public static void main(String[] args) throws Exception {
        var view = new CalculadoraView();
        var model = new CalculadoraModel();
        var controller = new CalculadoraController(model);

        view.setController(controller);
        view.exibirMenu();
    }
}
