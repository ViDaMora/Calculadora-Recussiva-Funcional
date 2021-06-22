import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Main {

    static BiFunction<Integer, Integer, Integer> suma = (primerNumero,segundoNumero) -> {
        return primerNumero+segundoNumero;
    };

    static BiFunction<Integer, Integer, Integer> resta = (primerNumero,segundoNumero) -> {
        return primerNumero-segundoNumero;
    };

    static BiFunction<Integer, Integer, Integer> multiplicacionDiscreta = (primerNumero,segundoNumero) -> {
        return IntStream.range(0, segundoNumero+1)
                .reduce((acumulador, numero) -> {
                    return suma.apply(acumulador,primerNumero);
                }).getAsInt();
    };

    static BiFunction<Integer,Integer,Integer> divisionDiscreta = (numerador,denominador) ->{
            return IntStream.range(0, denominador+1)
                    .reduce((acumulador, numero) -> {
                        if (multiplicacionDiscreta.apply(numero,denominador)<=numerador) {
                            return acumulador = acumulador+1;
                        }
                        return acumulador;
                    }).getAsInt();
    };

    public static void main(String[] args) {

        System.out.println("Suma discreta: " + suma.apply(7, 7));
        System.out.println("Resta discreta: " + resta.apply(9, 4));
        System.out.println("Multiplicacion discreta: " + multiplicacionDiscreta.apply(7, 7));
        System.out.println("Division discreta: " + divisionDiscreta.apply(9, 3));
    }

}
