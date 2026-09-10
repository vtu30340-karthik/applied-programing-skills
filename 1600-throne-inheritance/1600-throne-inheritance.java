import java.util.*;

class ThroneInheritance {

    private String king;
    
    // parent -> list of children
    private Map<String, List<String>> children;
    
    // Stores whether a person is dead
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        children = new HashMap<>();
        dead = new HashSet<>();
        
        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        children.putIfAbsent(parentName, new ArrayList<>());
        children.get(parentName).add(childName);
        
        // Create an empty children list for the new child
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        
        dfs(king, result);
        
        return result;
    }

    private void dfs(String person, List<String> result) {
        
        // Add person if they are alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children from oldest to youngest
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}
