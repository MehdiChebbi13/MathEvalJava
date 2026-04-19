package matheval.expression;

/**
 * Enumération des types de tokens reconnus par le parser.
 * Cette classe est fournie complète — ne pas modifier.
 */
public enum TokenType {
    /** Un nombre réel (ex : 3.14, 42, -7) */
    NUMBER,

    /** Un nom de variable (ex : x, result, pi) */
    VARIABLE,

    /** Un opérateur binaire : +, -, *, /, ^ */
    OPERATOR,

    /** Parenthèse ouvrante '(' */
    LEFT_PAREN,

    /** Parenthèse fermante ')' */
    RIGHT_PAREN
}
