package matheval.expression;

import matheval.tree.BinaryTree;
import matheval.tree.BinaryTreeNode;
import matheval.variables.VariableStore;

/**
 * Arbre d'expression mathématique.
 * Hérite de BinaryTree<Token>.
 *
 * Dans un arbre d'expression :
 *   - Les FEUILLES sont des NUMBER ou des VARIABLE.
 *   - Les NOEUDS INTERNES sont des OPERATOR.
 *
 * Exemple pour "3 + (4 * 2)" :
 *
 *         [+]
 *        /   \
 *      [3]   [*]
 *            / \
 *          [4] [2]
 *
 * Le parcours POSTFIXE de cet arbre donne : 3  4  2  *  +
 * Ce qui correspond à la notation polonaise inversée (RPN).
 */
public class ExpressionTree extends BinaryTree<Token> {

    public ExpressionTree() {
        super();
    }

    public ExpressionTree(BinaryTreeNode<Token> root) {
        super(root);
    }

    // =========================================================================
    // PARTIE 2 — Évaluation et affichage de l'arbre d'expression
    // =========================================================================

    /**
     * Évalue l'expression représentée par cet arbre.
     * Utilise le parcours POSTFIXE (post-order) pour évaluer de manière
     * récursive : évaluer gauche, évaluer droite, appliquer l'opérateur.
     *
     * @param store Le magasin de variables permettant de résoudre les noms
     *              de variables en valeurs numériques.
     * @return Le résultat numérique (double) de l'expression.
     * @throws IllegalArgumentException si une variable n'est pas définie dans store.
     * @throws ArithmeticException      si une division par zéro est détectée.
     */
    public double evaluate(VariableStore store) {
        // TODO: Appeler evaluateHelper(root, store).
        throw new UnsupportedOperationException("À implémenter - evaluate()");
    }

    /**
     * Méthode auxiliaire récursive pour evaluate().
     *
     * @param node  Le noeud courant de l'arbre d'expression.
     * @param store Le magasin de variables.
     * @return La valeur numérique du sous-arbre.
     */
    private double evaluateHelper(BinaryTreeNode<Token> node, VariableStore store) {
        // TODO: Implémenter selon la logique post-order :
        //
        //   1. Si node.getValue() est de type NUMBER :
        //        Retourner Double.parseDouble(node.getValue().getValue()).
        //
        //   2. Si node.getValue() est de type VARIABLE :
        //        Récupérer la valeur dans store.get(nom).
        //        Si la variable n'existe pas, lever IllegalArgumentException.
        //
        //   3. Si node.getValue() est de type OPERATOR :
        //        a. Évaluer récursivement le sous-arbre GAUCHE -> leftVal
        //        b. Évaluer récursivement le sous-arbre DROIT  -> rightVal
        //        c. Appliquer l'opérateur selon node.getValue().getValue() :
        //             "+" -> leftVal + rightVal
        //             "-" -> leftVal - rightVal
        //             "*" -> leftVal * rightVal
        //             "/" -> si rightVal == 0 : lever ArithmeticException
        //                     sinon : leftVal / rightVal
        //             "^" -> Math.pow(leftVal, rightVal)
        //        d. Retourner le résultat.
        throw new UnsupportedOperationException("À implémenter - evaluateHelper()");
    }

    /**
     * Retourne une représentation infixe de l'expression avec parenthèses.
     * Utilise le parcours INFIXE (in-order) de l'arbre.
     *
     * Exemple : pour l'arbre représentant "3 + 4 * 2",
     * cette méthode retourne la chaîne "(3 + (4 * 2))".
     *
     * INDICE : Pour chaque noeud opérateur, encadrer l'expression de parenthèses.
     *
     * @return La représentation infixe parenthésée de l'expression.
     */
    public String toInfix() {
        // TODO: Appeler toInfixHelper(root) et retourner son résultat.
        throw new UnsupportedOperationException("À implémenter - toInfix()");
    }

    /**
     * Méthode auxiliaire récursive pour toInfix().
     *
     * @param node Le noeud courant.
     * @return La sous-expression infixe sous forme de String.
     */
    private String toInfixHelper(BinaryTreeNode<Token> node) {
        // TODO: Cas de base : node == null -> retourner "".
        //       Si c'est une feuille (NUMBER ou VARIABLE) -> retourner sa valeur.
        //       Si c'est un opérateur :
        //           retourner "(" + toInfixHelper(gauche) + " " + op + " " + toInfixHelper(droite) + ")"
        throw new UnsupportedOperationException("À implémenter - toInfixHelper()");
    }
}
