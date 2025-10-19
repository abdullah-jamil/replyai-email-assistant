package com.email.replyai;

import lombok.Data;

@Data
public class EmailResponse {
    private String emailContent;
    private String tone;
}