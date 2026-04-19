package matheval.history;

import matheval.bst.BST;

import java.util.List;

/**
 * Historique des évaluations d'expressions, stocké dans un BST.
 * Les évaluations sont triées par résultat numérique (ordre croissant).
 *
 * Cette classe illustre l'utilisation du BST dans un contexte applicatif concret.
 */
public class EvaluationHistory {

    /** Le BST interne triant les évaluations par résultat. */
    private final BST<EvaluationRecord> bst;

    public EvaluationHistory() {
        this.bst = new BST<>();
    }

    /**
     * Enregistre une nouvelle évaluation dans l'historique.
     *
     * @param expression L'expression mathématique évaluée (ex : "(3 + 4 * 2)").
     * @param result     Le résultat numérique de l'évaluation.
     */
    public void record(String expression, double result) {
        bst.insert(new EvaluationRecord(expression, result));
    }

    /**
     * Affiche toutes les évaluations dans l'ordre croissant des résultats.
     */
    public void printSorted() {
        System.out.println("=== Historique des évaluations (ordre croissant) ===");
        bst.inOrder(rec -> System.out.println("  " + rec));
    }

    /**
     * Retourne la valeur minimale jamais calculée.
     *
     * @return L'EvaluationRecord avec le plus petit résultat.
     * @throws IllegalStateException si l'historique est vide.
     */
    public EvaluationRecord getMinResult() {
        return bst.findMin();
    }

    /**
     * Supprime de l'historique toutes les évaluations dont le résultat
     * est strictement inférieur au seuil donné.
     * Utile pour nettoyer les résultats négatifs ou insignifiants.
     *
     * @param threshold Le seuil (résultats < threshold sont supprimés).
     */
    public void purgeBelow(double threshold) {
        EvaluationRecord sentinel = new EvaluationRecord("__sentinel__", threshold);
        bst.removeLessThan(sentinel);
    }

    /**
     * Reconstruit l'historique interne sous forme d'un BST parfaitement équilibré.
     * Appelée après de nombreuses insertions pour optimiser les performances de recherche.
     *
     * @return true si la reconstruction a réussi et l'arbre est équilibré, false sinon.
     */
    public boolean rebalance() {
        List<EvaluationRecord> sorted = bst.toSortedList();
        bst.populate(sorted);
        return bst.isBalanced();
    }
}
