import java.util.Set;
import java.util.HashSet;

public class Alfabeto {
    private Set<Character> alfabeto;
    private int longitud;

    public Alfabeto(String alfabetoCadena) {
        this.alfabeto = new HashSet<>();
        for (char c : alfabetoCadena.toCharArray()) {
            this.alfabeto.add(c);
        }
        this.longitud = this.alfabeto.size();
    }

    public boolean contiene(char c) {
        return alfabeto.contains(c);
    }

    public int getLongitud() {
        return longitud;
    }
}
