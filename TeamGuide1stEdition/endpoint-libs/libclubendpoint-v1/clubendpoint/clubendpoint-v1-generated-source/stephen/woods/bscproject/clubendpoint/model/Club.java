/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-05-13 19:24:21 UTC)
 * on 2013-05-14 at 02:59:06 UTC 
 * Modify at your own risk.
 */

package stephen.woods.bscproject.clubendpoint.model;

/**
 * Model definition for Club.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the . For a detailed explanation see:
 * <a href="http://code.google.com/p/google-api-java-client/wiki/Json">http://code.google.com/p/google-api-java-client/wiki/Json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Club extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String clubColour;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String clubName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String contactName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String contactNum;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double latitude;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String location;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double longitude;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClubColour() {
    return clubColour;
  }

  /**
   * @param clubColour clubColour or {@code null} for none
   */
  public Club setClubColour(java.lang.String clubColour) {
    this.clubColour = clubColour;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClubName() {
    return clubName;
  }

  /**
   * @param clubName clubName or {@code null} for none
   */
  public Club setClubName(java.lang.String clubName) {
    this.clubName = clubName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getContactName() {
    return contactName;
  }

  /**
   * @param contactName contactName or {@code null} for none
   */
  public Club setContactName(java.lang.String contactName) {
    this.contactName = contactName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getContactNum() {
    return contactNum;
  }

  /**
   * @param contactNum contactNum or {@code null} for none
   */
  public Club setContactNum(java.lang.String contactNum) {
    this.contactNum = contactNum;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Club setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLatitude() {
    return latitude;
  }

  /**
   * @param latitude latitude or {@code null} for none
   */
  public Club setLatitude(java.lang.Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLocation() {
    return location;
  }

  /**
   * @param location location or {@code null} for none
   */
  public Club setLocation(java.lang.String location) {
    this.location = location;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLongitude() {
    return longitude;
  }

  /**
   * @param longitude longitude or {@code null} for none
   */
  public Club setLongitude(java.lang.Double longitude) {
    this.longitude = longitude;
    return this;
  }

  @Override
  public Club set(String fieldName, Object value) {
    return (Club) super.set(fieldName, value);
  }

  @Override
  public Club clone() {
    return (Club) super.clone();
  }

}
