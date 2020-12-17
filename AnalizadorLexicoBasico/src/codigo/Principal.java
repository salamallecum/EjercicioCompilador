package codigo;

import java.io.File;

/**
 *
 * @author ALEJO
 */
public class Principal {
    
    public static void main(String [] args){

        //Ruta donde se encuentra el archivo Lexer.flex
        String ruta = "C:/Recursos academicos/mis proyectos/Java/proyectos netbeans Java/1 - COMPILADORES/AnalizadorLexico/src/codigo/Lexer.flex";
        generarLexer(ruta);
        
    }
    
    //Metodo que generael archivo de sintaxis lexer
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
        
        //Una vez creada esta clase, ejecutarla y automaticamente creara el archivo Lexer.java
    }
    
}
