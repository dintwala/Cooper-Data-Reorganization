package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main class for operation of Cooper data recovery & reorganization.
 */
public class Main {
  /**
   * Main point for project. Reference to JSON file, collects data and provides to objects for further methods, then prints.
   *
   * @param args
   */
  public static void main(String[] args) throws IOException {
    ArrayList<String> companies = new ArrayList<>();
    String filePath = "src/main/java/org/example/data.json";
    DataLoader loadData = new DataLoader(filePath);
    Gson gson = new Gson();

    // Loading data from .json file
    List<User> users = loadData.getUserList();
    List<Review> reviews = loadData.getReviewList();
    List<Role> roles = loadData.getRoleList();

    // Map components into export format
    ReviewMapper reviewMapper = new ReviewMapper();
    Map<String, ReviewExport> reviewExportMap = reviewMapper.map(users, reviews);

    RoleMapper roleMapper = new RoleMapper();
    Map<String, RoleExport> roleExportMap = roleMapper.map(roles, reviews, reviewExportMap, companies);

    ReportBuilder reportBuilder = new ReportBuilder();
    JsonObject output = reportBuilder.build(roles, roleExportMap, companies);
    // output
    System.out.println(new GsonBuilder().create().toJson(output));
  }
}