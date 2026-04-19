package matheval.parser;

import matheval.expression.ExpressionTree;
import matheval.expression.Token;
import matheval.expression.TokenType;
import matheval.tree.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Parser d'expressions mathématiques basé sur l'algorithme Shunting-Yard
 * (Edsger W. Dijkstra, 1961).
 *
 * Cet algorithme lit une expression en notation INFIXE (ex : "3 + 4 * 2")
 * et la convertit en un arbre d'expression binaire, en respectant
 * les priorités des opérateurs et les parenthèses.
 *
 * Opérateurs supportés et leur priorité :
 *   ^  (puissance)    : priorité 3
 *   *  /  (mult/div)  : priorité 2
 *   +  -  (add/sous)  : priorité 1
 *
 * Plusieurs méthodes sont à implémenter (marquées TODO).
 */
public class ShuntingYardParser {

    /**
     * Retourne la priorité d'un opérateur.
     *
     * @param op L'opérateur sous forme de chaîne : "+", "-", "*", "/", "^".
     * @return Un entier représentant la priorité (plus grand = priorité plus haute).
     * @throws IllegalArgumentException si l'opérateur est inconnu.
     */
    public int precedence(String op) {
        // TODO: Retourner la priorité selon la table suivante :
        //   "^" -> 3
        //   "*" ou "/" -> 2
        //   "+" ou "-" -> 1
        //   autre -> lever IllegalArgumentException("Opérateur inconnu : " + op)
        throw new UnsupportedOperationException("À implémenter - precedence()");
    }

    /**
     * Vérifie si un token est un opérateur reconnu.
     *
     * @param token Le token à tester.
     * @return true si le token est de type OPERATOR, false sinon.
     */
    public boolean isOperator(Token token) {
        // TODO: Retourner true si et seulement si token.getType() == TokenType.OPERATOR.
        throw new UnsupportedOperationException("À implémenter - isOperator()");
    }

    /**
     * Construit un ExpressionTree à partir d'une liste de tokens en notation infixe.
     *
     * L'algorithme Shunting-Yard adapté pour construire un arbre utilise :
     *   - Une pile d'opérateurs (operatorStack) : stocke des Token (opérateurs et '(').
     *   - Une pile d'opérandes (operandStack)   : stocke des BinaryTreeNode<Token>
     *     (feuilles pour les nombres/variables, sous-arbres partiels pour les opérations).
     *
     * Algorithme pour chaque token :
     *
     *   1. Si c'est un NUMBER ou VARIABLE :
     *        Créer un nouveau BinaryTreeNode<Token> avec ce token.
     *        L'empiler sur operandStack.
     *
     *   2. Si c'est un OPERATOR :
     *        Tant que operatorStack n'est pas vide,
     *              que le sommet n'est pas '(',
     *              ET que la priorité du sommet >= priorité du token courant :
     *            Appeler buildSubTree() pour dépiler un opérateur
     *            et ses deux opérandes, former un sous-arbre, le remettre dans operandStack.
     *        Empiler le token courant sur operatorStack.
     *
     *   3. Si c'est LEFT_PAREN '(' :
     *        Empiler directement sur operatorStack.
     *
     *   4. Si c'est RIGHT_PAREN ')' :
     *        Tant que le sommet de operatorStack n'est pas '(' :
     *            Appeler buildSubTree().
     *        Dépiler le '(' (le jeter).
     *
     * À la fin de la liste de tokens :
     *   Vider operatorStack en appelant buildSubTree() pour chaque opérateur restant.
     *
     * Retourner un ExpressionTree dont la racine est l'unique noeud restant dans operandStack.
     *
     * @param tokens La liste de tokens de l'expression en notation infixe.
     * @return L'ExpressionTree correspondant à l'expression.
     * @throws IllegalArgumentException si l'expression est mal formée.
     */
    public ExpressionTree parse(List<Token> tokens) {
        // TODO: Implémenter l'algorithme Shunting-Yard décrit ci-dessus.
        //
        // Déclarations utiles :
        //   Deque<Token>                 operatorStack = new ArrayDeque<>();
        //   Deque<BinaryTreeNode<Token>> operandStack  = new ArrayDeque<>();
        //
        // À la fin, operandStack doit contenir exactement 1 élément (la racine).
        // Si ce n'est pas le cas, lever une IllegalArgumentException.
        throw new UnsupportedOperationException("À implémenter - parse()");
    }

    /**
     * Méthode utilitaire fournie — NE PAS MODIFIER.
     *
     * Dépile un opérateur depuis operatorStack et ses deux opérandes depuis
     * operandStack, crée un noeud interne (l'opérateur) avec les deux
     * opérandes comme enfants gauche et droit, et empile le sous-arbre
     * résultant dans operandStack.
     *
     * Hypothèse : l'opérande droite est au sommet de la pile (dernière empilée).
     *
     * @param operatorStack La pile des opérateurs.
     * @param operandStack  La pile des opérandes/sous-arbres.
     */
    private void buildSubTree(Deque<Token> operatorStack,
                               Deque<BinaryTreeNode<Token>> operandStack) {
        Token operator = operatorStack.pop();
        BinaryTreeNode<Token> right = operandStack.pop();
        BinaryTreeNode<Token> left  = operandStack.pop();

        BinaryTreeNode<Token> subTreeRoot = new BinaryTreeNode<>(operator);
        subTreeRoot.setLeft(left);
        subTreeRoot.setRight(right);

        operandStack.push(subTreeRoot);
    }

    // -------------------------------------------------------------------------
    // Méthode utilitaire fournie — NE PAS MODIFIER
    // -------------------------------------------------------------------------

    /**
     * Tokenize une expression mathématique sous forme de chaîne.
     * Gère les entiers, décimaux, noms de variables et opérateurs.
     *
     * Exemples :
     *   "3 + 4 * 2"        -> [NUMBER:3, OP:+, NUMBER:4, OP:*, NUMBER:2]
     *   "(x + 1) * y"      -> [LPAREN, VAR:x, OP:+, NUMBER:1, RPAREN, OP:*, VAR:y]
     *   "2 ^ 3 + pi * r"   -> [NUMBER:2, OP:^, NUMBER:3, OP:+, VAR:pi, OP:*, VAR:r]
     *
     * @param expression L'expression mathématique sous forme de chaîne.
     * @return La liste des tokens correspondants.
     */
    public List<Token> tokenize(String expression) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (Character.isWhitespace(c)) {
                i++;
            } else if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                       (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                tokens.add(new Token(TokenType.NUMBER, sb.toString()));
            } else if (Character.isLetter(c) || c == '_') {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() &&
                       (Character.isLetterOrDigit(expression.charAt(i)) || expression.charAt(i) == '_')) {
                    sb.append(expression.charAt(i++));
                }
                tokens.add(new Token(TokenType.VARIABLE, sb.toString()));
            } else if ("+-*/^".indexOf(c) >= 0) {
                tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                i++;
            } else if (c == '(') {
                tokens.add(new Token(TokenType.LEFT_PAREN, "("));
                i++;
            } else if (c == ')') {
                tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
                i++;
            } else {
                throw new IllegalArgumentException("Caractère non reconnu : '" + c + "'");
            }
        }
        return tokens;
    }
}
