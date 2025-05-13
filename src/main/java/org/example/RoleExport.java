package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * {@code RoleExport} formats roles in the necessary way for export.
 */
public class RoleExport {
  String name;
  int id;
  BigDecimal avgPay;
  BigDecimal avgRating;
  ArrayList<ReviewExport> reviews;

  /**
   * Constructs a {@code RoleExport} instance necessary for formatting the role information in the desired way.
   * Contains information about the specified role.
   *
   * @param name      the name of the role
   * @param id        a unique integer ID assigned to this specific role at a specific company.
   * @param avgPay    the average pay for the role, calculated using the pay provided by the reviews.
   * @param avgRating the average rating for the role, calculated using the ratings provided.
   * @param reviews   an {@code ArrayList} containing {@link ReviewExport} objects, all the reviews about this specific role formatted as desired for export.
   */
  public RoleExport(String name, int id, float avgPay, float avgRating, ArrayList<ReviewExport> reviews) {
    this.name = name;
    this.id = id;
    this.avgPay = BigDecimal.valueOf(avgPay).setScale(2, RoundingMode.HALF_UP);
    this.avgRating = BigDecimal.valueOf(avgRating).setScale(2, RoundingMode.HALF_UP);
    this.reviews = reviews;
  }

  public String getName() {
    return name;
  }
}
