package com.example.demo.controller;

import com.example.demo.model.job.Job;
import com.example.demo.model.Search;
import com.example.demo.service.interservice.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("job")
public class JobController {
    @Autowired
    private IJobService iJobService;

    @GetMapping
    public ResponseEntity<Iterable<Job>> findAll() {
        return new ResponseEntity<>(this.iJobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Job> createNewJob(@RequestBody Job job) {
        job.setPostDate(java.time.LocalDate.now());
        job.setStatus(false);
        this.iJobService.add(job);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Optional<Job>> findById(@PathVariable Long id) {
        this.iJobService.findById(id);
        return new ResponseEntity<>(this.iJobService.findById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job job) {
        if (iJobService.findById(id).isPresent()) {
            iJobService.add(job);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        iJobService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    ResponseEntity<Iterable<Job>> search(@RequestBody Search search) {
        return new ResponseEntity<>(iJobService.findAllByMinSalaryAndMaxSalary(search.getMinSalary(),
                search.getMaxSalary()),
                HttpStatus.OK);
    }

    @PostMapping("/qualification")
    ResponseEntity<Iterable<Job>> searchByQualification(@RequestBody Search search) {
        return new ResponseEntity<>(iJobService.findAllByQualificationAndCityAndSalaryBetweenMinSalaryAndMaxSalary(search.getQualification(),
                search.getCity(),
                search.getMinSalary(),
                search.getMaxSalary()),
                HttpStatus.OK);
    }

    @GetMapping("findAllTrue")
    ResponseEntity<Page<Job>> findAllJobWhichTrue(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(iJobService.findAllJobWhichTrue(pageable), HttpStatus.OK);
    }

    @GetMapping("findAllFalse")
    ResponseEntity<Page<Job>> findAllJobWhichFalse(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(iJobService.findAllJobWhichFalse(pageable), HttpStatus.OK);
    }

    @PostMapping("/browse/{id}")
    ResponseEntity<Optional<Job>> browseAJob(@PathVariable long id) {
        iJobService.browseJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("showTop")
    ResponseEntity<Iterable<Job>> showTopRecruitments() {
        return new ResponseEntity<>(iJobService.findTopByRecruitments(), HttpStatus.OK);
    }

    @PostMapping("selectRandom")
    ResponseEntity<Iterable<Job>> selectRandomFromJob() {
        return new ResponseEntity<>(iJobService.selectRandomFromJob(), HttpStatus.OK);
    }

    @GetMapping("download")
    public ResponseEntity<Void> downloadBeforeUse() {
        String url = "http://localhost:63343/Big%20Project/login/login.html?_ijt=aaaiv3398b984vj2r11ufuqke2&_ij_reload=RELOAD_ON_SAVE";
        String path = "D:\\download.html";

        try {
            Document document = Jsoup.connect(url).get();

            // Lấy danh sách các tệp CSS
            Elements cssLinks = document.select("C:\\Users\\Admin\\WebstormProjects\\Big Project\\template_css");
            StringBuilder cssContentBuilder = new StringBuilder();
            for (Element cssLink : cssLinks) {
                String cssUrl = cssLink.absUrl("href");
                Document cssDocument = Jsoup.connect(cssUrl).get();
                cssContentBuilder.append(cssDocument.html());
            }

            // Gộp nội dung HTML và CSS
            String htmlContent = document.html();
            String finalHtmlContent = htmlContent.replace("</head>", "<style>" + cssContentBuilder.toString() + "</style></head>");

            // Lưu nội dung vào file
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(finalHtmlContent);
            writer.close();

            System.out.println("Download success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
