package org.example.giftservice.controller;

import org.example.giftservice.model.GiftRequest;
import org.example.giftservice.model.GiftResponse;
import org.example.giftservice.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gift")
public class GiftController {

    @Autowired
    private GiftService giftService;

    @PostMapping
    public ResponseEntity<GiftResponse> processGiftRequest(
            @RequestParam String recipientName,
            @RequestParam Integer age,
            @RequestParam String hobbies,
            @RequestParam String budget) {

        GiftRequest request = giftService.processRequest(recipientName, age, hobbies, budget);
        String fullText = String.format(
                "Привет ИИ, я хочу подобрать подарок для %s, ей/ему %d лет, он/она любит/занимается %s, бюджет подарка %s",
                recipientName, age, hobbies, budget);

        GiftResponse response = new GiftResponse();
        response.setId(request.getId());
        response.setFullRequestText(fullText);
        response.setCreatedAt(request.getCreatedAt());

        return ResponseEntity.ok(response);
    }
}