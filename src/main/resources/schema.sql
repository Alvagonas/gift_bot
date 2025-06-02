CREATE TABLE IF NOT EXISTS gift_requests (
                                             id BIGSERIAL PRIMARY KEY,
                                             recipient_name VARCHAR(100) NOT NULL,
                                             age INTEGER NOT NULL,
                                             hobbies TEXT NOT NULL,
                                             budget VARCHAR(50) NOT NULL,
                                             full_request_text TEXT NOT NULL,
                                             created_at TIMESTAMP NOT NULL
);