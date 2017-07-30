package org.belchan.service;

import org.belchan.dao.BoardDAO;
import org.belchan.dao.PostDAO;
import org.belchan.entity.Board;
import org.belchan.entity.Post;
import org.belchan.entity.PostPK;
import org.belchan.repository.BoardRepository;
import org.belchan.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardDAO boardDAO;

    @Autowired
    PostDAO postDAO;

    public String addNewPost(String boardName, String threadId, String name, String email, String subj, String text, String file, String embeded, String embededType, String password, String tag, String ip, String tripCode) {
        Board board = boardDAO.get(boardName);
        int thread = 0;
        try {
            thread = Integer.parseInt(threadId);
        } catch (NumberFormatException ignored) {

        }
        Post post = createOrUpdatePost(name, email, subj, text, password, tag, ip, tripCode, board, thread);
        if (thread == 0) {
            int postId /*= post.getPostPK().getId() FIX IT*/;
            Post nemMaxPost = postDAO.getFirstPosts(board,1,0).get(0);
            return String.valueOf(nemMaxPost.getPostPK().getId());
        } else  {
            Post threadPost = postDAO.get(board.getId(),thread);
            threadPost.setBumped(LocalDateTime.now());
            postDAO.saveOrUpdate(threadPost);
            return String.valueOf(thread);
        }

    }

    private Post createOrUpdatePost(String name, String email, String subj, String text, String password, String tag, String ip, String tripCode, Board board, int thread) {
        Post post = new Post();
        PostPK postPK = new PostPK();
        postPK.setBoardid(board.getId());
        post.setPostPK(postPK);
        post.setBumped(LocalDateTime.now());
        post.setEmail(email);
        post.setFile("");
        post.setFileMd5("");
        post.setFileOriginal("");
        post.setFileSize(0);
        post.setFileSizeFormatted("");
        post.setFileType("");
        post.setImageH((short) 0);
        post.setImageW((short) 0);
        post.setIp(ip);
        post.setIpmd5(md5Custom(ip));
        post.setIsDeleted((byte) 0);
        post.setLocked((byte) 0);
        post.setMessage(text);
        post.setName(name);
        post.setParentid(thread);
        post.setPassword(password);
        post.setPosterauthority((byte) 0);
        post.setReviewed((byte) 0);
        post.setStickied((byte) 0);
        post.setSubject(subj);
        post.setTag(tag);
        post.setThumbH(0);
        post.setThumbW(0);
        post.setTimestamp(LocalDateTime.now());
        post.setTripcode(tripCode);
        postDAO.saveOrUpdate(post);
        return post;
    }

    public String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }

    private static Map<Long, LocalDateTime> timeCheck = new HashMap<>();

    public List<Post> getPostsAfter(Long chatId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime previousTimeCheck = timeCheck.get(chatId);
        List<Post> posts;
        if (previousTimeCheck != null) {
        	posts = postDAO.getPostsAfter(previousTimeCheck);
        } else {
        	posts = postDAO.getLastPost();
        }
        timeCheck.put(chatId, now);
        return posts;
        
    }


}
