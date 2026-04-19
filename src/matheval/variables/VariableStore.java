package matheval.variables;

import matheval.bst.BST;
import matheval.tree.BinaryTreeNode;

/**
 * Magasin de variables basé sur un BST.
 * Permet de stocker, rechercher et lister des variables par leur nom.
 *
 * Le BST interne stocke des objets Variable, triés par nom (voir Variable.compareTo).
 *
 * Plusieurs méthodes sont à implémenter (marquées TODO).
 */
public class VariableStore {

    /** Le BST interne qui stocke les variables triées par nom. */
    private final BST<Variable> bst;

    public VariableStore() {
        this.bst = new BST<>();
    }

    // =========================================================================
    // PARTIE 3 — Magasin de variables utilisant un BST
    // =========================================================================

    /**
     * Associe un nom à une valeur numérique.
     * Si le nom existe déjà, met à jour sa valeur.
     * Sinon, insère une nouvelle Variable dans le BST.
     *
     * INDICE : Pour la mise à jour, il faut trouver le noeud correspondant
     * dans le BST (en utilisant une recherche) et modifier sa valeur,
     * plutôt que d'insérer un doublon. Vous pouvez vous aider de la méthode
     * privée findNode() fournie ci-dessous.
     *
     * @param name  Le nom de la variable.
     * @param value La valeur numérique à associer.
     */
    public void put(String name, double value) {
        // TODO: Créer un objet Variable temporaire avec le nom donné.
        //       Utiliser findNode() pour chercher si le nom existe déjà.
        //       Si oui : mettre à jour la valeur du noeud existant.
        //       Sinon  : insérer une nouvelle Variable dans bst.
        throw new UnsupportedOperationException("À implémenter - put()");
    }

    /**
     * Récupère la valeur d'une variable par son nom.
     *
     * @param name Le nom de la variable.
     * @return La valeur numérique associée.
     * @throws IllegalArgumentException si le nom n'est pas défini.
     */
    public double get(String name) {
        // TODO: Utiliser findNode() pour trouver le noeud.
        //       Si null -> lever IllegalArgumentException("Variable non définie : " + name).
        //       Sinon   -> retourner la valeur du noeud.
        throw new UnsupportedOperationException("À implémenter - get()");
    }

    /**
     * Vérifie si une variable existe dans le magasin.
     *
     * @param name Le nom de la variable.
     * @return true si la variable est définie, false sinon.
     */
    public boolean contains(String name) {
        // TODO: Utiliser findNode() et retourner true si le noeud n'est pas null.
        throw new UnsupportedOperationException("À implémenter - contains()");
    }

    /**
     * Affiche toutes les variables dans l'ordre alphabétique.
     * Utilise le parcours infixe du BST sous-jacent.
     */
    public void printAll() {
        bst.inOrder(v -> System.out.println("  " + v));
    }

    // -------------------------------------------------------------------------
    // Méthode utilitaire fournie — NE PAS MODIFIER
    // -------------------------------------------------------------------------

    /**
     * Recherche et retourne le noeud BST dont la variable a le nom donné.
     * Retourne null si aucun noeud ne correspond.
     *
     * Cette méthode parcourt le BST en s'appuyant sur la comparaison
     * alphabétique des noms pour optimiser la recherche.
     *
     * @param name Le nom de la variable recherchée.
     * @return Le BinaryTreeNode<Variable> correspondant, ou null.
     */
    private BinaryTreeNode<Variable> findNode(String name) {
        BinaryTreeNode<Variable> current = bst.getRoot();
        while (current != null) {
            int cmp = name.compareTo(current.getValue().getName());
            if (cmp == 0) return current;
            current = cmp < 0 ? current.getLeft() : current.getRight();
        }
        return null;
    }
}
