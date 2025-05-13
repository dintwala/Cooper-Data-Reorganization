package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ReportBuilder class builds the final JSON report based on provided role and rating data.
 * Includes information about companies, roles, ratings and salary.
 */
public class ReportBuilder {

  /**
   * Builds a JSON object from the given lists roles, roleExportMap and companies.
   * Resulting JSON object groups roles by company and contains rating information
   *
   * @param roles         a list of {@link Role} objects, each one in the format of the original imported JSON object
   * @param roleExportMap a Map of role IDs {@link String} to {@link RoleExport} objects, formatted as ready for export.
   * @param companies     an ArrayList of companies to which the roles belong to
   * @return the final JSONObject, complete with correct formatting and structure.
   * @throws IOException if the FileWriter is unable to write file to intended destination.
   */
  public JsonObject build(List<Role> roles, Map<String, RoleExport> roleExportMap, ArrayList<String> companies) throws IOException {
    JsonObject resultObject = new JsonObject();
    JsonObject companiesObject = new JsonObject();
    Gson gson = new Gson();

    // Process each company
    for (String company : companies) {
      JsonObject companyRoles = new JsonObject();

      // Find all roles for this company
      for (Role role : roles) {
        if (role.company.equals(company)) {
          RoleExport roleExport = roleExportMap.get(String.valueOf(role.roleId));
          if (roleExport != null) {
            // Convert RoleExport to JSON object
            JsonObject roleObject = new JsonObject();
            roleObject.addProperty("name", roleExport.name);
            roleObject.addProperty("id", roleExport.id);
            roleObject.addProperty("avgPay", roleExport.avgPay);
            roleObject.addProperty("avgRating", roleExport.avgRating);
            roleObject.add("reviews", new Gson().toJsonTree(roleExport.reviews));

            // Add to company with role name as key
            companyRoles.add(roleExport.name, roleObject);
          }
        }
      }

      // Add company to companiesObject
      companiesObject.add(company, companyRoles);
    }

    // Add companies to result
    resultObject.add("companies", companiesObject);
    // Write file to destination and export
    FileWriter writer = new FileWriter("src/main/java/org/example/final.json");
    gson.toJson(resultObject, writer);
    return resultObject;
  }
}
