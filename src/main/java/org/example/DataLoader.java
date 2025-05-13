package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * The {@code DataLoader} class is responsible for loading and parsing data
 * from a JSON file into Java objects such as {@link User}, {@link Review}, and {@link Role}.
 */
public class DataLoader {
  private JsonObject json;

  /**
   * Constructs a new {@code DataLoader} and loads the JSON file from the specified file path.
   *
   * @param filePath the path to the JSON file containing the data
   * @throws FileNotFoundException if the file cannot be found at the given path
   */
  public DataLoader(String filePath) throws FileNotFoundException {
    Reader reader = new FileReader(filePath);
    this.json = JsonParser.parseReader(reader).getAsJsonObject();
  }

  /**
   * Retrieves the list of {@link User} objects from the loaded JSON data.
   *
   * @return a {@link List} of {@link User} instances
   */
  public List<User> getUserList() {
    Type userListType = new TypeToken<List<User>>() {
    }.getType();
    return new Gson().fromJson(json.get("users"), userListType);
  }

  /**
   * Retrieves the list of {@link Review} objects from the loaded JSON data.
   *
   * @return a {@link List} of {@link Review} instances
   */
  public List<Review> getReviewList() {
    Type reviewListType = new TypeToken<List<Review>>() {
    }.getType();
    return new Gson().fromJson(json.get("reviews"), reviewListType);
  }

  /**
   * Retrieves the list of {@link Role} objects from the loaded JSON data.
   *
   * @return a {@link List} of {@link Role} instances
   */
  public List<Role> getRoleList() {
    Type roleListType = new TypeToken<List<Role>>() {
    }.getType();
    return new Gson().fromJson(json.get("roles"), roleListType);
  }

}
