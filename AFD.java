public class AFD {
    private Alfabeto alfabeto;
    private Estado[] estados;
    private Estado estadoInicial;
    private Estado[] estadosFinales;
    private String[][] adyacencias;

    public AFD(Alfabeto alfabeto, Estado[] estados, Estado estadoInicial, 
               Estado[] estadosFinales, String[][] adyacencias) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.estadoInicial = estadoInicial;
        this.estadosFinales = estadosFinales;
        this.adyacencias = adyacencias;
    }
    private Estado obtenerSiguienteEstado(Estado actual, char simbolo) {
        int fila = actual.getId();
        for (int col = 0; col < estados.length; col++) {
            String simbolosEnCelda = adyacencias[fila][col];
            if (simbolosEnCelda != null && simbolosEnCelda.indexOf(simbolo) != -1) {
                return estados[col];
            }
        }
        return null;
    }

    public boolean pertenece(String palabra) {
        Estado actual = this.estadoInicial;
        for (char c : palabra.toCharArray()) {
            if (!alfabeto.contiene(c)) {
                System.out.println("error: El simbolo '" + c + "' no está en el alfabeto");
                return false;
            }
            actual = obtenerSiguienteEstado(actual, c);
            if (actual == null) return false;
        }
        return esFinal(actual);
    }

    private boolean esFinal(Estado estado) {
        for (Estado e : estadosFinales) {
            if (e != null && e.getId() == estado.getId()) return true;
        }
        return false;
    }
}
