package com.socialmedia.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.JSON.CommentResponseJSON;
import com.socialmedia.JSON.LikeCommentJSON;
import com.socialmedia.JSON.LikeResponseJSON;
import com.socialmedia.JSON.PostJSON;
import com.socialmedia.JSON.PostRequestJSON;
import com.socialmedia.JSON.UserJSON;
import com.socialmedia.dao.CommentDAO;
import com.socialmedia.dao.LikeDAO;
import com.socialmedia.dao.PostDAO;
import com.socialmedia.model.CommentModel;
import com.socialmedia.model.FollowerModel;
import com.socialmedia.model.LikeModel;
import com.socialmedia.model.PostModel;
import com.socialmedia.utils.AppUtils;

@Service
public class PostService {
	@Value("${file.upload.dir}")
	private String uploadDir;
	@Autowired
	private PostDAO postDao;
	@Autowired
	private LikeDAO likeDao;
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private UserDetailsService userDetailsService;

	public PostJSON uploadPicture(MultipartFile postImg, PostJSON postJSON) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		File directory = new File(uploadDir);
		if (!directory.exists()) {
		    if (directory.mkdirs()) {
		        System.out.println("Directory created successfully: " + directory.getAbsolutePath());
		    }
		}
		    Path filePath = Paths.get(directory.getAbsolutePath(), postImg.getOriginalFilename());
		    postJSON.setPostImg(AppUtils.MutiPartToBase64(postImg));
		    postJSON.setPostId(AppUtils.getRandomUUID());
		    postJSON.setPostPath(directory.getAbsolutePath()+"/"+postImg.getOriginalFilename());
		    postJSON.setPostOrginalName(postImg.getOriginalFilename().toString());
		    postJSON.setPostType(postImg.getContentType().toString());
		return postJSON;

}


	public void savePost(PostJSON postJSON) {
		// TODO Auto-generated method stub
		PostModel postModel=new PostModel();
		postModel.setPostId(postJSON.getPostId());
		postModel.setPostName(postJSON.getPostOrginalName());
		postModel.setUserId(postJSON.getUserId());
		postModel.setPostPic(postJSON.getPostImg());
		 postDao.save(postModel);
		 System.err.println("executed");
		
	}


	public  List<PostJSON> getPostByFollowingList(List<UserJSON> followList) {
		// TODO Auto-generated method stub
		List<PostJSON> posts = new ArrayList<PostJSON>();
		for (UserJSON oneFollow: followList) {
			List<PostModel> allposts=postDao.getPostByUserId(oneFollow.getUser().getId());
			for (PostModel post : allposts) {
				PostJSON postJson=new PostJSON();
				List<LikeResponseJSON> likeResponse=new ArrayList<LikeResponseJSON>();
				List<CommentResponseJSON> commentResponse=new ArrayList<CommentResponseJSON>();
				long likeCount=0;
				postJson.setPostUser(oneFollow.getUser());
				postJson.setPostUserDetails(oneFollow.getUserdetails());
				postJson.setPostImg(post.getPostPic());
				List<LikeModel>likes=likeDao.getByPostId(post.getPostId());
				if (likes.size()>0) {
					for (LikeModel like : likes) {
						likeCount++;
						LikeResponseJSON likeres=new LikeResponseJSON();
						UserJSON user= userDetailsService.getUserById(like.getUserId());
						likeres.setUser(user);
						likeResponse.add(likeres);
					
					}
				}
				List<CommentModel>comments=commentDAO.getByPostId(post.getPostId());
				if (comments.size()>0) {
					for (CommentModel comment : comments) {
						CommentResponseJSON cmt=new CommentResponseJSON();
						UserJSON user= userDetailsService.getUserById(comment.getUserId());
						cmt.setUser(user);
						cmt.setComment(comment.getComment());
						commentResponse.add(cmt);
					
					}
				}
				postJson.setLikeCount(likeCount);
				postJson.setLike(likeResponse);
				postJson.setComment(commentResponse);
				posts.add(postJson);
				
			}
			
		}
		return posts;
	}


	public void addLikeOrComment(LikeCommentJSON likeCommentJSON) {
		// TODO Auto-generated method stub
		if (likeCommentJSON.isLike()) {
			LikeModel like=new LikeModel();
			like.setId(AppUtils.getRandomUUID());
			like.setPostId(likeCommentJSON.getPostId());
			like.setUserId(likeCommentJSON.getUserId());
			likeDao.save(like);
			
		}
		else {
			CommentModel comment =new CommentModel();
			comment.setId(AppUtils.getRandomUUID());
			comment.setPostId(likeCommentJSON.getPostId());
			comment.setUserId(likeCommentJSON.getUserId());
			comment.setComment(likeCommentJSON.getValue());
			commentDAO.save(comment);
			
			
		}
		
		
	}


	public void updatePostJson(PostRequestJSON postJSON, MultipartFile postImg) throws IOException {
		PostModel postModel=new PostModel();
		postModel.setPostId(AppUtils.getRandomUUID());
		postModel.setPostCaption(postJSON.getPostCaption());
		postModel.setUserId(postJSON.getUserId());
		postModel.setPostPic(AppUtils.MutiPartToBase64(postImg));
		postModel.setPostName(postImg.getOriginalFilename());
		postModel.setPostSize(postImg.getSize());
		postDao.save(postModel);
	}
}