
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int lerInteiro(String mensagem, int min, int max) {
        
        while (true) { 
            
            System.out.println(mensagem + " [" + min + ", " + max + "] : ");
            String input = null;

            try {
                
                input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    System.out.println("<Entrada vazia. Digite um número no intervalo ["+ min + ", " + max + "].>");
                    continue;
                } 

                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("<Entrada fora do ontervalo. Digite um número no intervalo ["+ min + ", " + max + "].>");
                    continue;
                }

                return valor;
              
            } 
            catch (NumberFormatException e) { System.out.println("<Entrada fora do ontervalo. Digite um número inteiro>"); }
            catch (NoSuchElementException e) { 
                throw new RuntimeException("<Entrada não disponível.>", e);
            }
        }
    }

    public static String lerString(String mensagem) {
        
        while (true) { 
            
            System.out.println(mensagem);
            String input = null;
            
            try {
                
                input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    continue;
                } 

                return input;
              
            } 
            catch (Exception e) { 
                System.out.println("<Entrada vazia>");
            }
        }
    
    }

    public static boolean lerSimNao(String mensagem) {
        
        while (true) { 
            
            System.out.println(mensagem+ " (s/n) : ");
            String input;
            
            try {
                
                input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    continue;
                } 

                if ("s".equals(input) || "S".equals(input)){
                    return true;
                }
                else if ("n".equals(input) || "N".equals(input)){
                    return false;
                }
                else {
                    System.out.println("<Entrada inválida. Digite s ou n.>");
                    continue;
                }
                
              
            } 
            catch (Exception e) { 
                System.out.println("<Entrada vazia>");
            }
        }

    }

    public static void esperarEnter(String mensagem) {
        
        String input = ".";
        System.out.println(mensagem+"Pressione ENTER para continuar.");
        while (! input.equals("")) {
            input = scanner.nextLine().trim();
        }

    }

    public static void fecharScanner() {
        scanner.close();
    }

}
