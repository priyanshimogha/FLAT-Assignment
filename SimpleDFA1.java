import java.util.*;

public class SimpleDFA1 {
    private Set<String> states;
    private Set<String> alphabet;
    private Map<String, Map<String, String>> transitionFunction;
    private String startState;
    private Set<String> acceptStates;

    public SimpleDFA1(Set<String> states, Set<String> alphabet, Map<String, Map<String, String>> transitionFunction,
                     String startState, Set<String> acceptStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitionFunction = transitionFunction;
        this.startState = startState;
        this.acceptStates = acceptStates;
    }

    // Minimization logic
    
    public void printTransitionTable() {
        System.out.println("Minimized DFA Transition Table:");
        for (String state : states) {
            System.out.print("State " + state + ": ");
            for (String symbol : alphabet) {
                System.out.print(symbol + " -> " + transitionFunction.get(state).get(symbol) + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for states
        System.out.println("Enter states (comma-separated, e.g., q0,q1,q2): ");
        Set<String> states = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        // Input for alphabet
        System.out.println("Enter alphabet symbols (comma-separated, e.g., 0,1): ");
        Set<String> alphabet = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        // Input for transition function
        Map<String, Map<String, String>> transitionFunction = new HashMap<>();
        for (String state : states) {
            transitionFunction.put(state, new HashMap<>());
            for (String symbol : alphabet) {
                System.out.println("Enter the next state for state " + state + " on symbol " + symbol + ": ");
                String nextState = scanner.nextLine();
                transitionFunction.get(state).put(symbol, nextState);
            }
        }

        // Input for start state
        System.out.println("Enter the start state: ");
        String startState = scanner.nextLine();

        // Input for accept states
        System.out.println("Enter accept states (comma-separated, e.g., q3): ");
        Set<String> acceptStates = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        // Create DFA and minimize
        SimpleDFA dfa = new SimpleDFA(states, alphabet, transitionFunction, startState, acceptStates);
        
        dfa.minimize(); // Minimize the DFA
        dfa.printTransitionTable(); // Print minimized DFA transition table
    }
}
