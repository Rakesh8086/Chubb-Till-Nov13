import java.util.*;

public class CollectionOperations {
    public static void main(String[] args) {
    	TreeMap<String, List<String>> companyEmployees = new TreeMap<>();

        companyEmployees.put("AAA", Arrays.asList("A", "B", "C"));
        companyEmployees.put("BBB", Arrays.asList("D", "E", "F"));
        companyEmployees.put("CCC", Arrays.asList("G", "H", "I"));
        companyEmployees.put("DDD", Arrays.asList("J", "K", "L"));
        companyEmployees.put("EEE", Arrays.asList("M", "N", "O"));

        for(String company : companyEmployees.keySet()) { 
            System.out.println("Company: " + company);
            System.out.println("Employees:");
            
            for(String employee : companyEmployees.get(company)) {
                System.out.println(" - " + employee);
            }
            
            System.out.println("");
        }
        
        if(!companyEmployees.containsKey("Cognizant")) {
            companyEmployees.put("Cognizant", Arrays.asList("P", "Q", "R"));
        }
        
        boolean ramFound = false;
        for(List<String> employees : companyEmployees.values()) {
            if(employees.contains("Ram")) {
                ramFound = true;
                break;
            }
        }

        if (!ramFound) {
            System.out.println("Ram not found in any company.");
        }

    }
}
