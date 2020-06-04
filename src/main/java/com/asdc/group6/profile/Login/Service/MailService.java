package com.asdc.group6.Profile.Login.Service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

	Boolean sendMail(String email, String subject, String text);
}
