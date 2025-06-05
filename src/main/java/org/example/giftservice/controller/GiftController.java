package org.example.giftservice.controller;

import org.example.giftservice.model.GiftRequest;
import org.example.giftservice.model.GiftResponse;
import org.example.giftservice.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/gift")
public class GiftController {

    @Autowired
    private GiftService giftService;
    @PostMapping("/{id}")
    public ResponseEntity<GiftResponse> createGiftRequest(@RequestBody GiftRequest request) {
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

    @GetMapping("/{id}")
    public ResponseEntity<String> getFullRequestTextById(@PathVariable Long id) {
        Optional<GiftRequest> giftRequestOptional = giftService.getGiftRequestById(id);
        if (giftRequestOptional.isPresent()) {
            GiftRequest giftRequest = giftRequestOptional.get();
            String fullText = String.format(
                    "Привет ИИ, я хочу подобрать подарок для %s, ей/ему %d лет, он/она любит/занимается %s, бюджет подарка %s",
                    giftRequest.getRecipientName(),
                    giftRequest.getAge(),
                    giftRequest.getHobbies(),
                    giftRequest.getBudget()
            );
            return ResponseEntity.ok(fullText);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gift request with ID " + id + " not found.");
        }
    }
}