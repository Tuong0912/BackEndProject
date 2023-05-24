package com.example.demo.controller;

import com.example.demo.model.job.Job;
import com.example.demo.model.user.User;
import com.example.demo.service.interservice.IJobService;
import com.example.demo.service.interservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IJobService iJobService;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        List<User> users = (List<User>) userService.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserInformation(@PathVariable Long id, @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        user.setId(userOptional.get().getId());
        return new ResponseEntity<>(userService.add(user), HttpStatus.OK);
    }

    @PostMapping("updateUser/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody User user) {
        if (userService.findById(id).isPresent()) {
            user.setaBoolean(true);
            user.setId(id);
            this.userService.add(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("check/{id}")
    public ResponseEntity<User> checkApplication(@PathVariable Long id) {
        User user = this.userService.checkApplication(id);
        if (user.isaBoolean()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            user.setaBoolean(true);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findAllFalse")
    public ResponseEntity<Page<User>> findAllWhichFalse(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(userService.findAllUserWhichFalse(pageable), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userService.findByUserEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        } else {
            userService.add(user);
            return ResponseEntity.ok().body("User register successfully");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody User userLogin) {
        Map<String, Object> hasMap = new HashMap<>();
        String text;
        User user = userService.findByUserEmail(userLogin.getEmail());
        if (user != null) { //Đúng tài khoản
            if (user.getPassword().equals(userLogin.getPassword())) { // Đúng mật khẩu
                if (user.isaBoolean() == true) { //Trạng thái boolean là true
                    text = "Đăng nhập thành công";
                    hasMap.put("text", text);
                    hasMap.put("user1234567890", user);
                    return new ResponseEntity<>(hasMap, HttpStatus.OK);
                } else { // Trạng thái boolean là false
                    text = "Tài khoản chưa được duyệt";
                    hasMap.put("text", text);
                    hasMap.put("user1234567890", user);
                    return new ResponseEntity<>(hasMap, HttpStatus.OK);
                }
            } else {
                text = "Mật khẩu không đúng";
                hasMap.put("text", text);
                hasMap.put("user1234567890", user);
                return new ResponseEntity<>(hasMap, HttpStatus.OK);
            }
        } else {
            text = "Email Không tồn tại";
            hasMap.put("text", text);
            hasMap.put("user1234567890", user);

            return new ResponseEntity<>(hasMap, HttpStatus.OK);
        }
    }


    @PostMapping("browseUser/{id}")
    public ResponseEntity<Optional<User>> browseAUser(@PathVariable long id) {
        userService.browseAUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PostMapping("/{userId}/jobs/{jobId}")
//    public ResponseEntity<String> applyJob(@PathVariable Long userId, @PathVariable Long jobId) {
//        Optional<User> user = userService.findById(userId);
//        Optional<Job> job = iJobService.findById(jobId) ;
//
//        if (user == null || job == null) {
//            return ResponseEntity.badRequest().body("User or job not found");
//        }
//        List<Job> userJobs = user.get().getJobs();
//        if (!userJobs.contains(job)) {
//            userJobs.add(job);
//            userService.add(user);
//            return ResponseEntity.ok("Job applied successfully");
//        } else {
//            return ResponseEntity.badRequest().body("Job already applied");
//        }
//    }

    @PostMapping("/{userId}/jobs/{jobId}/apply")
    public ResponseEntity<String> applyJob(@PathVariable Long userId, @PathVariable Long jobId) {
        Optional<User> optionalUser = userService.findById(userId);
        Optional<Job> optionalJob = iJobService.findById(jobId);

        if (optionalUser.isPresent() && optionalJob.isPresent()) {
            User user = optionalUser.get();
            Job job = optionalJob.get();

            if (!user.getJobs().contains(job)) {
                user.getJobs().add(job);
                userService.add(user);
                return ResponseEntity.ok("Applied successfully");
            } else {
                return ResponseEntity.badRequest().body("Already applied for this job");
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{userId}/jobs")
    public ResponseEntity<List<Job>> getAppliedJobs(@PathVariable Long userId) {
        User user = userService.findById(userId).orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Job> userJobs = user.getJobs();
        return ResponseEntity.ok(userJobs);
    }
}
