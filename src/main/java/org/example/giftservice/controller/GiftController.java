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
    public ResponseEntity<GiftResponse> processGiftRequest(@RequestBody GiftRequest request) {
        GiftRequest savedRequest = giftService.processRequest(
                request.getRecipientName(),
                request.getAge(),
                request.getHobbies(),
                request.getBudget()
        );

        String fullText = String.format(
                "Привет ИИ, я хочу подобрать подарок для %s, ей/ему %d лет, он/она любит/занимается %s, бюджет подарка %s",
                savedRequest.getRecipientName(),
                savedRequest.getAge(),
                savedRequest.getHobbies(),
                savedRequest.getBudget()
        );

        GiftResponse response = new GiftResponse();
        response.setId(savedRequest.getId());
        response.setFullRequestText(fullText);
        response.setCreatedAt(savedRequest.getCreatedAt());

        return ResponseEntity.ok(response);
    }
}