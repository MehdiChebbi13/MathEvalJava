package matheval.history;

/**
 * Enregistrement d'une évaluation d'expression.
 * Les enregistrements sont comparés par résultat numérique,
 * ce qui permet de les stocker dans un BST trié par valeur.
 *
 * Cette classe est fournie complète — ne pas modifier.
 */
public class EvaluationRecord implements Comparable<EvaluationRecord> {

    private final String expression;
    private final double result;

    public EvaluationRecord(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    public String getExpression() {
        return expression;
    }

    public double getResult() {
        return result;
    }

    /**
     * Comparaison basée sur le résultat numérique (ordre croissant).
     */
    @Override
    public int compareTo(EvaluationRecord other) {
        return Double.compare(this.result, other.result);
    }

    @Override
    public String toString() {
        return String.format("%-30s = %.4f", expression, result);
    }
}
