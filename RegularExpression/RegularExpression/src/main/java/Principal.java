import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) throws Exception {

        // conjunto de numeros del 1 al 5
        String patronA = "[0-5]";

        // conjunto de letras de "a" a "c"
        String patronB = "[a-c]";

        // conjunto de todas las letras minusculas
        String patronC = "[a-z]";

        // conjunto de numeros
        String patronD = "[0-9]";

        // ejemplo con tipo de dato string
        String textoAlfanumerico = "0123aaaa";
        System.out.println("Texto alfanumerico:" + textoAlfanumerico);

        String replace1 = textoAlfanumerico.replaceAll(patronA, "X");
        System.out.println("Reemplazo de numeros con X: " + replace1);

        String replace2 = textoAlfanumerico.replaceAll(patronB, "X");
        System.out.println("Reemplazo de letras con X: " + replace2);


        //[0-5][a-c];
        //String patronComplejo = patronA + patronB;

        //[a-c]*[0-5]*
        //String patronComplejo = patronA + "*" + patronB + "*";

        //"[a-z]+"

        // + = una coincidencia
        // * = ninguna o muchas

        //String patronComplejo = "(" + patronA + patronC + ")+";
        String patronComplejo = "(" + patronC + ")+";

        String texto = "hola, aacc este bbcc es mi 55222aaa texto 2663aaaa   blah blah";
        System.out.println("patron complejo:" + patronComplejo);
        System.out.println(texto);

        Pattern pattern = Pattern.compile(patronComplejo);
        Matcher matcher = pattern.matcher(texto);

        // buscar ocurrencias
        while (matcher.find()) {
            System.out.println("Encontrado:" + matcher.group());
        }


    }
}
