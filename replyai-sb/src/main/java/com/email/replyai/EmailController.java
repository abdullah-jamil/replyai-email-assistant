package com.email.replyai;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/email")
@CrossOrigin(origins = "*")
public class EmailController {
    private final EmailService emailService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailResponse emailResponse) {
        String response = emailService.generateEmailReply(emailResponse);
        return ResponseEntity.ok(response);
    }
}
