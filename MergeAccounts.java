import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeAccounts {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.computeIfAbsent(email, k -> new HashSet<>()).add(name);
                graph.computeIfAbsent(email, k -> new HashSet<>());

                if (i > 1) {
                    String prevEmail = acc.get(i - 1);
                    graph.get(email).add(prevEmail);
                    graph.get(prevEmail).add(email);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : emailToName.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                dfs(email, graph, visited, component);
                Collections.sort(component);
                String name = emailToName.get(email).iterator().next(); // Get the name associated with this email
                component.add(0, name); // Add the name to the beginning of the component
                result.add(component);
            }
        }
        return result;
    }

    private void dfs(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> component) {
        visited.add(email);
        component.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
}
