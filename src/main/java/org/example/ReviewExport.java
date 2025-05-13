package org.example;

/**
 * {@code ReviewExport} formats reviews in the necessary way for export.
 */
public class ReviewExport {
  String user;
  int rating;
  int pay;
  int review;

  /**
   * Constructs a new {@code ReviewExport} instance with the specified user, rating, pay and review.
   *
   * @param user   the name of the user who created the rating
   * @param rating the numeric rating left by the user
   * @param pay    the pay the user recieved at the role
   * @param review a specific ID for this rating
   */
  public ReviewExport(String user, int rating, int pay, int review) {
    this.user = user;
    this.rating = rating;
    this.pay = pay;
    this.review = review;
  }

  public int getRating() {
    return rating;
  }
}
