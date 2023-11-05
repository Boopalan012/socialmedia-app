package com.socialmedia.model;

import java.util.Date;

import com.socialmedia.utils.AppUtils;
import com.socialmedia.utils.Gender;
import com.socialmedia.utils.RelationshipStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "sm_user_details")
public class UserDetailsModel {

    @Id
    private String id;

    @Column(name = "profile_pic", nullable = true ,columnDefinition = "BLOB")
    @Lob
    private String profilePic;
   
    
    @Column(name = "cover_pic", nullable = true,columnDefinition = "BLOB")
    @Lob
    private String coverPic;

    @Column(name = "nick_name", nullable = true)
    private String nickName;

    @Column(name = "bio", nullable = true)
    private String bio;

    @Column(name = "live_in", nullable = true)
    private String liveIn;

    @Column(name = "gender", nullable = true)
    private Gender gender;
   
    @Enumerated(EnumType.STRING)
    @Column(name = "relationship_status", nullable = true)
    private RelationshipStatus relationshipStatus;
    
    @Column(name="user_id")
    private String userId;
    @Column(name="created_at")
	private String cretedAt;
	@Column(name ="updated_at")
	private String updatedAt;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public String getNickName() {
		return nickName;
	}

	public String getBio() {
		return bio;
	}

	public String getLiveIn() {
		return liveIn;
	}

	public Gender getGender() {
		return gender;
	}

	public RelationshipStatus getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setLiveIn(String liveIn) {
		this.liveIn = liveIn;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public void setRelationshipStatus(RelationshipStatus relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getCretedAt() {
		return cretedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setCretedAt(String cretedAt) {
		this.cretedAt = cretedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserDetailsModel() {
		cretedAt=AppUtils.formatDate(new Date());
		updatedAt=AppUtils.formatDate(new Date());
	}


    
    
}
