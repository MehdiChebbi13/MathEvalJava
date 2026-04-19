package matheval.variables;

/**
 * Représente une variable nommée avec sa valeur numérique.
 * Les variables sont comparées par leur nom (ordre lexicographique),
 * ce qui permet de les stocker dans un BST.
 *
 * Cette classe est fournie complète — ne pas modifier.
 */
public class Variable implements Comparable<Variable> {

    private final String name;
    private double value;

    public Variable(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Comparaison basée sur le nom (ordre alphabétique).
     * Utilisée par le BST pour maintenir la propriété de tri.
     */
    @Override
    public int compareTo(Variable other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " = " + value;
    }
}
