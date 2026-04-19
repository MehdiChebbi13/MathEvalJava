package matheval.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * Arbre Binaire générique.
 * Plusieurs méthodes sont à implémenter (marquées TODO).
 *
 * @param <T> Le type des valeurs stockées dans l'arbre.
 */
public class BinaryTree<T> {

    protected BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // =========================================================================
    // PARTIE 1 — Métriques sur l'arbre binaire
    // =========================================================================

    /**
     * Retourne le nombre de noeuds dans l'arbre.
     *
     * @return le nombre total de noeuds, 0 si l'arbre est vide.
     */
    public int size() {
        // TODO: Implémenter récursivement.
        //       Cas de base : un arbre vide a une taille de 0.
        //       Cas récursif : 1 + taille(sous-arbre gauche) + taille(sous-arbre droit).
        throw new UnsupportedOperationException("À implémenter - size()");
    }

    /** Méthode auxiliaire récursive pour size(). */
    private int sizeHelper(BinaryTreeNode<T> node) {
        // TODO: Implémenter la récursion ici.
        throw new UnsupportedOperationException("À implémenter - sizeHelper()");
    }

    /**
     * Retourne le nombre de feuilles de l'arbre.
     * Une feuille est un noeud sans enfant gauche ni droit.
     *
     * @return le nombre de feuilles, 0 si l'arbre est vide.
     */
    public int countLeaves() {
        // TODO: Implémenter récursivement.
        //       Cas de base : null -> 0 ; une feuille -> 1.
        //       Cas récursif : compter les feuilles dans les deux sous-arbres.
        throw new UnsupportedOperationException("À implémenter - countLeaves()");
    }

    /** Méthode auxiliaire récursive pour countLeaves(). */
    private int countLeavesHelper(BinaryTreeNode<T> node) {
        // TODO: Implémenter la récursion ici.
        throw new UnsupportedOperationException("À implémenter - countLeavesHelper()");
    }

    /**
     * Retourne la hauteur de l'arbre.
     * La hauteur d'un arbre vide est -1, celle d'une feuille est 0.
     *
     * @return la hauteur de l'arbre.
     */
    public int height() {
        // TODO: Implémenter récursivement.
        //       Cas de base : null -> -1.
        //       Cas récursif : 1 + max(hauteur gauche, hauteur droite).
        throw new UnsupportedOperationException("À implémenter - height()");
    }

    /** Méthode auxiliaire récursive pour height(). */
    protected int heightHelper(BinaryTreeNode<T> node) {
        // TODO: Implémenter la récursion ici.
        throw new UnsupportedOperationException("À implémenter - heightHelper()");
    }

    /**
     * Vérifie si l'arbre est équilibré au sens AVL.
     * Un arbre est équilibré si, pour chaque noeud,
     * |hauteur(gauche) - hauteur(droite)| <= 1,
     * ET les deux sous-arbres sont eux-mêmes équilibrés.
     *
     * ATTENTION : L'approche naïve (appeler height() sur chaque noeud)
     * produit une complexité O(n²). Vous devez implémenter une version
     * en O(n) qui calcule hauteur et équilibre en une seule passe récursive.
     *
     * Indice : définissez une classe interne (ou utilisez un tableau int[])
     * pour retourner simultanément la hauteur et le statut équilibré.
     *
     * @return true si l'arbre est équilibré, false sinon.
     */
    public boolean isBalanced() {
        // TODO: Appeler isBalancedHelper(root) et retourner son résultat.
        throw new UnsupportedOperationException("À implémenter - isBalanced()");
    }

    /**
     * Classe interne représentant le résultat d'une passe récursive.
     * height  : hauteur calculée du sous-arbre.
     * balanced: true si le sous-arbre est équilibré.
     */
    protected static class BalanceResult {
        int height;
        boolean balanced;

        BalanceResult(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    /**
     * Méthode auxiliaire O(n) pour isBalanced().
     * Calcule en une seule passe récursive la hauteur ET l'équilibre.
     */
    protected BalanceResult isBalancedHelper(BinaryTreeNode<T> node) {
        // TODO: Implémenter la logique O(n) :
        //   1. Cas de base : null -> BalanceResult(-1, true)
        //   2. Appeler récursivement sur gauche et droite.
        //   3. Si l'un des deux sous-arbres n'est pas équilibré -> BalanceResult(?, false)
        //   4. Calculer |heightLeft - heightRight|.
        //      Si > 1 -> BalanceResult(?, false)
        //   5. Sinon -> BalanceResult(1 + max(heightLeft, heightRight), true)
        throw new UnsupportedOperationException("À implémenter - isBalancedHelper()");
    }

    // =========================================================================
    // PARTIE 2 — Parcours de l'arbre
    // =========================================================================

    /**
     * Parcours infixe (in-order) : gauche → racine → droite.
     * Applique l'action donnée sur la valeur de chaque noeud visité.
     *
     * @param action Une fonction Consumer<T> à appliquer sur chaque valeur.
     */
    public void inOrder(Consumer<T> action) {
        // TODO: Implémenter le parcours infixe récursif.
        //       L'ordre de visite est : gauche, noeud courant, droite.
        throw new UnsupportedOperationException("À implémenter - inOrder()");
    }

    /** Méthode auxiliaire récursive pour inOrder(). */
    protected void inOrderHelper(BinaryTreeNode<T> node, Consumer<T> action) {
        // TODO: Implémenter la récursion.
        throw new UnsupportedOperationException("À implémenter - inOrderHelper()");
    }

    /**
     * Parcours postfixe (post-order) : gauche → droite → racine.
     * Applique l'action donnée sur la valeur de chaque noeud visité.
     *
     * @param action Une fonction Consumer<T> à appliquer sur chaque valeur.
     */
    public void postOrder(Consumer<T> action) {
        // TODO: Implémenter le parcours postfixe récursif.
        //       L'ordre de visite est : gauche, droite, noeud courant.
        throw new UnsupportedOperationException("À implémenter - postOrder()");
    }

    /** Méthode auxiliaire récursive pour postOrder(). */
    protected void postOrderHelper(BinaryTreeNode<T> node, Consumer<T> action) {
        // TODO: Implémenter la récursion.
        throw new UnsupportedOperationException("À implémenter - postOrderHelper()");
    }

    /**
     * Affiche l'arbre niveau par niveau (parcours en largeur / BFS).
     * Chaque niveau est affiché sur une ligne séparée.
     *
     * Exemple pour un arbre d'expression "3 + (4 * 2)" :
     *   Niveau 0 : +
     *   Niveau 1 : 3  *
     *   Niveau 2 : 4  2
     *
     * INDICE : Utilisez une java.util.Queue (LinkedList) pour stocker
     * les noeuds à visiter. Pour détecter les changements de niveau,
     * vous pouvez utiliser deux queues (niveau courant / niveau suivant),
     * ou stocker un marqueur de fin de niveau.
     */
    public void displayGenerations() {
        // TODO: Implémenter le parcours BFS avec affichage niveau par niveau.
        //   1. Si l'arbre est vide, afficher "Arbre vide." et retourner.
        //   2. Utiliser une Queue<BinaryTreeNode<T>>.
        //   3. Enfiler la racine.
        //   4. Tant que la queue n'est pas vide :
        //      a. Traiter tous les noeuds du niveau courant (taille courante de la queue).
        //      b. Pour chaque noeud, afficher sa valeur et enfiler ses enfants non nuls.
        //      c. Passer à la ligne après chaque niveau.
        throw new UnsupportedOperationException("À implémenter - displayGenerations()");
    }
}
