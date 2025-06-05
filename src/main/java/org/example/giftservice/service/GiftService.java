
package org.example.giftservice.service;

import org.example.giftservice.model.GiftRequest;
import org.example.giftservice.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GiftService {

    private final GiftRepository giftRepository;

    @Autowired
    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
    }

    public GiftRequest processRequest(String recipientName, Integer age, String hobbies, String budget) {
        GiftRequest request = new GiftRequest();
        request.setRecipientName(recipientName);
        request.setAge(age);
        request.setHobbies(hobbies);
        request.setBudget(budget);

        String fullText = String.format(
                "Привет ИИ, я хочу подобрать подарок для %s, ей/ему %d лет, он/она любит/занимается %s, бюджет подарка %s",
                recipientName, age, hobbies, budget);
        request.setFullRequestText(fullText);
        return giftRepository.save(request);
    }
}
