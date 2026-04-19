package matheval.expression;

/**
 * Représente un token (unité lexicale) d'une expression mathématique.
 * Cette classe est fournie complète — ne pas modifier.
 *
 * Exemples de tokens pour "3 + x * (2 - y)" :
 *   Token(NUMBER, "3"), Token(OPERATOR, "+"), Token(VARIABLE, "x"),
 *   Token(OPERATOR, "*"), Token(LEFT_PAREN, "("),
 *   Token(NUMBER, "2"), Token(OPERATOR, "-"), Token(VARIABLE, "y"),
 *   Token(RIGHT_PAREN, ")")
 */
public class Token {

    private final TokenType type;
    private final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isOperator() {
        return type == TokenType.OPERATOR;
    }

    public boolean isNumber() {
        return type == TokenType.NUMBER;
    }

    public boolean isVariable() {
        return type == TokenType.VARIABLE;
    }

    @Override
    public String toString() {
        return value;
    }
}
