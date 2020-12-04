package at.svoboda.michael.demo.controllers;

import at.svoboda.michael.demo.entities.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ELKRestController {

    private static final Logger LOG = Logger.getLogger(ELKRestController.class.getName());

    @RequestMapping(value = "/hello")
    public ResponseEntity<String> helloElk() {
        String response = "Hi friend! This is Spring Boot.";
        LOG.log(Level.INFO, response);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/exception")
    public ResponseEntity<String> exception() {
        String response = "";
        try {
            throw new Exception("TestException has occured .... ");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.severe(e.getMessage());
            LOG.severe(stackTraceToString(e));
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/entity")
    public ResponseEntity<Member> entity() {
        Member member = new Member();
        member.setId("123213213-32132132131-3213213123-31321312313");
        member.setFirstname("Michael");
        member.setLastname("Svoboda");

        return ResponseEntity.ok(member);
    }

    public String stackTraceToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stackTrace = sw.toString();
        return stackTrace;
    }
}
