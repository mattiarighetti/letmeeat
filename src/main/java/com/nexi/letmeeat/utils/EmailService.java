package com.nexi.letmeeat.utils;

import com.nexi.letmeeat.model.Dish;
import com.nexi.letmeeat.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
      String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@letmeeat.com");
        message.setTo(to);
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
    }

    public void sendEmail(Order order) {

        String content = loadHtml();
        content = content.replace("[ORDER_N]", order.getOrderId().toString());
        content = content.replace("[TOTAL]", Double.toString(
                order.getDishes().stream().mapToDouble(Dish::getPrice).reduce(0, Double::sum)));
        StringBuilder bodyBuilder = new StringBuilder();
        order.getDishes().forEach(d ->
                bodyBuilder.append(String.format("<table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=12 class=img style=font-size:0;line-height:0;text-align:left><td width=300 valign=top><div class=text style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:left>%s</div><table border=0 cellpadding=0 cellspacing=0 width=100%><tr><td width=30 class=content-spacing style=font-size:0;line-height:0;text-align:left><td><div class=text2 style=color:#b0b0b0;font-family:Arial;font-size:14px;line-height:24px;text-align:left></div></table><td valign=top><div class=text-right style=color:#686868;font-family:Arial;font-size:14px;line-height:24px;text-align:right;white-space:nowrap>%.2f</div><div class=text-right2 style=color:#afafaf;font-family:Arial;font-size:14px;line-height:24px;text-align:right></div><td width=10 class=img style=font-size:0;line-height:0;text-align:left></table>", d.getName(), d.getPrice())));
        this.sendSimpleMessage(order.getUser().getEmail(), String.format("Receipt for order n %s", order.getOrderId()), bodyBuilder.toString());
    }

    private String loadHtml(){

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get("mail.html"), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            //handle exception
        }

        return contentBuilder.toString();
    }
}