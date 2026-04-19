package matheval;

import matheval.expression.ExpressionTree;
import matheval.history.EvaluationHistory;
import matheval.parser.ShuntingYardParser;
import matheval.variables.VariableStore;

import java.util.List;
import matheval.expression.Token;

/**
 * Point d'entrée principal de MathEval.
 * Ce fichier est fourni complet à titre de démonstration et de test.
 * NE PAS MODIFIER.
 *
 * Vous pouvez l'exécuter pour tester vos implémentations au fur et à mesure.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         MathEval — Test général          ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // --- Initialisation ---
        ShuntingYardParser parser = new ShuntingYardParser();
        VariableStore store = new VariableStore();
        EvaluationHistory history = new EvaluationHistory();

        // --- Définition des variables ---
        System.out.println(">> Définition des variables :");
        store.put("x", 3.0);
        store.put("y", 5.0);
        store.put("pi", 3.14159);
        store.put("r", 2.0);
        store.printAll();
        System.out.println();

        // --- Expressions à évaluer ---
        String[] expressions = {
            "3 + 4 * 2",
            "(3 + 4) * 2",
            "x ^ 2 + y",
            "pi * r * r",
            "10 / (x - 1) + y"
        };

        System.out.println(">> Évaluation des expressions :\n");
        for (String expr : expressions) {
            try {
                List<Token> tokens = parser.tokenize(expr);
                ExpressionTree tree = parser.parse(tokens);

                System.out.println("  Expression  : " + expr);
                System.out.println("  Infixe      : " + tree.toInfix());
                System.out.println("  Taille arbre: " + tree.size() + " noeuds");
                System.out.println("  Feuilles    : " + tree.countLeaves());
                System.out.println("  Hauteur     : " + tree.height());
                System.out.println("  Équilibré ? : " + tree.isBalanced());

                double result = tree.evaluate(store);
                System.out.println("  Résultat    : " + result);
                history.record(expr, result);

                System.out.println("\n  Arbre par niveaux :");
                tree.displayGenerations();
                System.out.println();

            } catch (Exception e) {
                System.out.println("  ERREUR : " + e.getMessage());
            }
        }

        // --- Historique ---
        System.out.println("\n>> Historique global :");
        history.printSorted();

        System.out.println("\n>> Résultat minimum : " + history.getMinResult());

        System.out.println("\n>> Purge des résultats < 10 :");
        history.purgeBelow(10.0);
        history.printSorted();

        System.out.println("\n>> Rééquilibrage de l'historique :");
        boolean balanced = history.rebalance();
        System.out.println("  BST équilibré après rééquilibrage : " + balanced);

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          Fin des tests — Bravo !         ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }
}
