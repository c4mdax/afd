import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Configuracion del Alfabeto ---");
        System.out.print("Introduce los caracteres del alfabeto (ejemplo ab01)");
        Alfabeto alfabetoInstancia = new Alfabeto(sc.next());

        System.out.print("\n¿Cuantos estados tiene el AFD?:");
        int n = sc.nextInt();
        Estado[] todosLosEstados = new Estado[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("¿El estado q" + i + " es de aceptación? (true/false): ");
            boolean finalOk = sc.nextBoolean();
            todosLosEstados[i] = new Estado(i, finalOk);
        }

        String[][] matrizAdy = new String[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) matrizAdy[i][j] = "";
        }

        System.out.println("\n--- Configuración de Transiciones---");
        System.out.println("Formato: [Origen] [Destino] [Simbolos] (Ejemplo: 0 1 a)");
        System.out.println("Usa -1 para terminar de capturar");
        
        while(true) {
            int or = sc.nextInt();
            if(or == -1) break;
            int des = sc.nextInt();
            String sym = sc.next();
            matrizAdy[or][des] = sym;
        }

        AFD automataInstancia = new AFD(alfabetoInstancia, todosLosEstados, todosLosEstados[0], 
                                 extraerFinales(todosLosEstados), matrizAdy);
        System.out.print("\nIngresa la palabra a evaluar:");
        String palabra = sc.next();
        
        if (automataInstancia.pertenece(palabra)) {
            System.out.println(">>> LA PALABRA PERTENECE AL LENGUAJE:)");
        } else {
            System.out.println(">>> LA PALABRA NO PERTENECE AL LENGUAJE :(.");
        }
    }
    private static Estado[] extraerFinales(Estado[] todos) {
        int count = 0;
        for (Estado e : todos) if (e.isEsFinal()) count++;
        
        Estado[] finales = new Estado[count];
        int index = 0;
        for (Estado e : todos) {
            if (e.isEsFinal()) finales[index++] = e;
        }
        return finales;
    }
}

