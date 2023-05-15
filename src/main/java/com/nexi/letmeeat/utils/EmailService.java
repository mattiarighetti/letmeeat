package com.nexi.letmeeat.utils;

import com.nexi.letmeeat.model.Dish;
import com.nexi.letmeeat.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
            String to, String subject, String text) {

        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("noreply@letmeeat.com");
            helper.setText(text, true);
        } catch (Exception e) {

        }

        // use the true flag to indicate the text included is HTML
        emailSender.send(message);
    }

    public void sendEmail(Order order) {

        this.sendSimpleMessage(order.getUser().getEmail(), String.format("Receipt for order n %s", order.getOrderId()), buildReceipt(order));
    }

    public String buildReceipt(Order order) {

        log.debug("Starting receipt build");
        SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss");
        String content = loadHtml();
        content = content.replace("[ORDER_N]", order.getOrderId().toString());
        content = content.replace("[TOTAL]", Double.toString(
                order.getDishes().stream().mapToDouble(Dish::getPrice).reduce(0, Double::sum)));
        content = content.replace("[DATE]", simpleformat.format(new Date()));
        content = content.replace("[RESTAURANT]", order.getSeat().getTables().getRestaurant().getName());
        StringBuilder bodyBuilder = new StringBuilder();
        String el = "<table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=12 class=img style=font-size:0;line-height:0;text-align:left><td width=300 valign=top><div class=text style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:left>[NAME]</div><table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=30 class=content-spacing style=font-size:0;line-height:0;text-align:left><td><div class=text2 style=color:#b0b0b0;font-family:Arial;font-size:14px;line-height:24px;text-align:left></div></table><td valign=top><div class=text-right style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:right;white-space:nowrap>[PRICE]</div><div class=text-right2 style=color:#afafaf;font-family:Arial;font-size:14px;line-height:24px;text-align:right></div><td width=10 class=img style=font-size:0;line-height:0;text-align:left></table>";
        order.getDishes().forEach(d ->
                bodyBuilder.append(el.replace("[NAME]", d.getName()).replace("[PRICE]", d.getPrice().toString())));

        return content.replace("[BODY]", bodyBuilder.toString());
    }

    private String loadHtml() {

        try (InputStream resource = new ClassPathResource(
                "mail.html").getInputStream(); BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource))) {
            return reader.lines()
                    .collect(Collectors.joining("\n"));
        } catch (IOException e) {
            log.error("Error in loading file", e);
            return "";
        }
    }

}