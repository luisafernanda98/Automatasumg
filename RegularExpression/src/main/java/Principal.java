import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {
    public static void main(String[] args) throws Exception {

        // conjunto de numeros del 1 al 5
        //String patronA = "[0-5]";
        String patronA = "[0-5]";

        // conjunto de letras de "a" a "c"
        //String patronB = "[a-c]";
        String patronB = "[a-c]";

        // conjunto de todas las letras minusculas
        // String patronC = "[a-z]";
        // String comenzando con ba
        String patronC = "[b][a]+[a-z]";
                // conjunto de numeros
        //ocultado el numero 0
        String patronD = "[0_]";
        
        String patronE = "$1";
        

        // ejemplo con tipo de dato string
        String textoAlfanumerico = "01203  0211 201 2341 aaaacccc";
        
        
        System.out.println("Texto alfanumerico:" + textoAlfanumerico);
       
   
        String replace2 = textoAlfanumerico.replaceAll(patronB, "X");
        System.out.println("Reemplazo de letras con X: " + replace2);
        
        String replace3 = textoAlfanumerico.replaceAll(patronD, "X");
        System.out.println("Numeros del 1 al 9: " + replace3);
        
        String replace4 = textoAlfanumerico.replaceAll(patronE, "X");
        System.out.println("Comienza con 2 y termina con 1: " + replace4);



        //String patronComplejo = "(" + patronA + patronC + ")+";
        String patronComplejo = "(" + patronC + ")+";
 
        
        String texto = "hola, baw aacc este bbcc es mi 55222aaa texto 2663aaaa barbar blah blah bala";
        System.out.println("patron complejo:" + patronComplejo);
        System.out.println(texto);

        Pattern pattern = Pattern.compile(patronComplejo);
        Matcher matcher = pattern.matcher(texto);

        // buscar ocurrencias
        while (matcher.find()) {
            System.out.println("Encontrado Cadena ba:" + matcher.group());
        }


    }
}


