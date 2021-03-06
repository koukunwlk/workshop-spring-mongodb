package com.moaciramaro.workshopmongo.config;

import com.moaciramaro.workshopmongo.domain.Post;
import com.moaciramaro.workshopmongo.domain.User;
import com.moaciramaro.workshopmongo.dto.AuthorDTO;
import com.moaciramaro.workshopmongo.dto.CommentDTO;
import com.moaciramaro.workshopmongo.repository.PostRepository;
import com.moaciramaro.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para Canada", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("22/03/2018"), "Partiu viagem", "Vou viajar para Portugal", new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("23/03/2018"), "Partiu viagem", "Vou viajar para Reino Unido", new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Lula 2023", sdf.parse("22/03/2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Ciro 2023", sdf.parse("22/03/2018"), new AuthorDTO(alex));
        CommentDTO comment3 = new CommentDTO("Maria 2023", sdf.parse("22/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2, comment3));
        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.getPosts().addAll(Arrays.asList(post1, post2, post3));
        userRepository.save(maria);
    }
}
