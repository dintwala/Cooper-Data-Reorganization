package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@code RoleMapper} processes a list of roles and reviews, and produces a mapping of role IDs
 * to their {@link RoleExport} objects, which contain information about the role and any ratings.
 */
public class RoleMapper {
  /**
   * Takes multiple pieces of data, including lists and reviews, to accurately pair reviews
   * with the correct role. Determines list of companies that exist in the data, and calculate
   * average pay and average rating for each role, based off the information provided in the rating.
   *
   * @param roles           a list of {@link Role} elements, formatted from the input file, representing all possible roles.
   * @param reviews         a list of {@link Review} elements, formatted from the input file representing all available reviews.
   * @param reviewExportMap a Map of {@link String} ratingID keys linked to {@link ReviewExport} objects, correctly formatted for export.
   * @param companies       an ArrayList of companies found by parsing through the roles.
   * @return a Map of {@link String} roleID keys linked to {@link RoleExport} objects, each object containing a list of sorted ratings with user info, average pay and average rating.
   */
  public Map<String, RoleExport> map(List<Role> roles, List<Review> reviews, Map<String, ReviewExport> reviewExportMap, ArrayList<String> companies) {
    Map<String, RoleExport> roleExportMap = new HashMap<>();
    for (Role role : roles) {
      ArrayList<ReviewExport> roleReviews = new ArrayList<>();
      String name = role.role;
      int id = role.roleId;
      float avgPay = 0.00F;
      float avgRating = 0.00F;
      int totalPay = 0;
      int totalRating = 0;

      if (!companies.contains(role.company)) {
        companies.add(role.company);
      }

      for (Review review : reviews) {
        ReviewExport pendingReview = reviewExportMap.get(String.valueOf(review.ratingId));
        if (id == review.roleId) {
          roleReviews.add(pendingReview);
          totalPay += pendingReview.pay;
          totalRating += pendingReview.rating;
        }
      }

      roleReviews.sort(Comparator.comparing(ReviewExport::getRating).reversed());
      avgPay = roleReviews.isEmpty() ? 0 : (float) totalPay / roleReviews.size();
      avgRating = roleReviews.isEmpty() ? 0 : (float) totalRating / roleReviews.size();
      roleExportMap.put(String.valueOf(id), new RoleExport(name, id, avgPay, avgRating, roleReviews));
    }
    return roleExportMap;
  }
}
