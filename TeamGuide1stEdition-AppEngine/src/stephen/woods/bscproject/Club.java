package stephen.woods.bscproject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 *  Club.java
 * 
 *  Rev 6
 *
 *  02/05/2013

 * @author Stephen Woods, 09104232
 *
 */


@Entity
public class Club {

// add JPA annotations
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  //create entities
  private Long id;
  private String clubName;
  private String clubColour;
  private String location;
  private Double latitude;
  private Double longitude;
  private String contactName;
  private String contactNum;
  
// assign getter & setters
  public Club() {
  }

  public Long getId() {
	  return id;
  }
  
  public String getClubName() {
	  return clubName;
  }
  
  public void setClubName(String clubName){
	  this.clubName = clubName;
  }

  public String getClubColour() {
	  return clubColour;
  }

  public void setClubColour(String clubColour){
	  this.clubColour = clubColour;
  }

  public String getLocation(){
	  return location;
  }
  
  public void setLocation(String location){
	  this.location = location;
  }
  
  public Double getLatitude(){
	  return latitude;
  }
  
  public void setLatitude(Double latitude){
	  this.latitude = latitude;
  }
  
  public Double getLongitude(){
	  return longitude;
  }
  
  public void setLongitude(Double longitude){
	  this.longitude = longitude;
  }
  
  public String getContactName(){
	  return contactName;
  }
  
  public void setContactName(String contactName){
	  this.contactName = contactName;
  }
  
  public String getContactNum(){
	  return contactNum;
  }
  
  public void setContactNum(String contactNum){
	  this.contactNum = contactNum;
  }
}