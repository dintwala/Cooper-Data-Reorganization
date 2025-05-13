package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@code ReviewMapper} processes a list of reviews and users, and produces a mapping of review IDs
 * to their {@link ReviewExport} objects, which are reviews formatted in a manner desired for export.
 */
public class ReviewMapper {
  /**
   * Takes multiple pieces of data to accurately pair reviews with the correct user.
   * Correctly formats reviews as needed in the export.
   *
   * @param users   a list of {@link User} objects that contain information about the users who left ratings
   * @param reviews a list of {@link Review} objects that contains every review made for all roles, in import format.
   * @return a Map of {@link String} reviewIDs keys to {@link ReviewExport} objects, reviews correctly formatted for export.
   */
  public Map<String, ReviewExport> map(List<User> users, List<Review> reviews) {
    Map<Integer, User> userMap = new HashMap<>();
    for (User user : users) {
      userMap.put(user.userId, user);
    }

    Map<String, ReviewExport> reviewExportMap = new HashMap<>();
    for (Review review : reviews) {
      User user = userMap.get(review.userId);
      if (user != null && user.reviews.contains(review.ratingId)) {
        reviewExportMap.put(String.valueOf(review.ratingId), new ReviewExport(user.name, review.overallScore, review.hourlyPay, review.ratingId));
      }
    }
    return reviewExportMap;
  }
}


