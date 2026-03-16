import java.util.Objects;

public class Estado {
    private int id;
    private boolean esFinal;

    public Estado(int id, boolean esFinal) {
        this.id = id;
        this.esFinal = esFinal;
    }
    public int getId() { return id; }

    public boolean isEsFinal() { return esFinal; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id == estado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "q" + id + (esFinal ? "*" : "");
    }
}
