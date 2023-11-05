package com.socialmedia.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.socialmedia.JSON.PostJSON;
import com.socialmedia.JSON.PostRequestJSON;
import com.socialmedia.JSON.UserJSON;
import com.socialmedia.model.FollowerModel;
import com.socialmedia.service.PostService;
import com.socialmedia.service.UserDetailsService;
import com.socialmedia.utils.Response;

@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private UserDetailsService userDetailsService;
	static Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@GetMapping("/")
	public Response fromPosyMethod() {
		Response res=new Response();
		res.setMessage("got it");
		return res;
	}

	@PostMapping(value = "/upload-posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	public Response postPosts(@RequestParam(name = "post") MultipartFile postImg, PostRequestJSON postJSON) throws IllegalStateException, IOException {
	   Response response =new Response();
	   postService.updatePostJson(postJSON,postImg);
	   return response;
	}
		@GetMapping("getPostByUserId")
	public Response getpostById(@RequestParam("user_id")String id ) {
		Response response=new Response();
		List<UserJSON>followList=userDetailsService.getfollowingListBytId(id);
		List<PostJSON> posts=postService.getPostByFollowingList(followList);
		response.getData().add(posts);
		return response;
	}

//    @GetMapping("/generateBase64Image")
//    public ResponseEntity<String> generateBase64Image() {
//        try {
//            // Specify the path to your local image file
//            String imagePath = uploadDir+"/Untitled.jpeg";
//
//            // Read image file from the local filesystem
//            byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
//
//            // Encode image bytes to base64
//            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//            return ResponseEntity.ok(base64Image);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Error generating base64 image");
//        }
//    }
}
//if (postImg.isEmpty()) {
//}
//
//File directory = new File(uploadDir);
//if (!directory.exists()) {
//    if (directory.mkdirs()) {
//        System.out.println("Directory created successfully: " + directory.getAbsolutePath());
//    } else {
//        System.out.println("Failed to create directory: " + directory.getAbsolutePath());
//        return "Failed to create directory";
//    }
//}
//
//// Construct the full file path
//Path filePath = Paths.get(directory.getAbsolutePath(), postImg.getOriginalFilename());
//// Transfer the file to the specified path
//postImg.transferTo(filePath.toFile());
//
//return postImg.getOriginalFilename();
