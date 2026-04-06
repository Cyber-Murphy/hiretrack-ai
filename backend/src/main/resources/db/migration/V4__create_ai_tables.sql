CREATE TABLE ai_analyses (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                             user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                             job_id UUID REFERENCES jobs(id) ON DELETE SET NULL,
                             match_score INT CHECK (match_score >= 0 AND match_score <= 100),
                             missing_keywords TEXT,
                             suggestions TEXT,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE interview_questions (
                                     id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                     job_id UUID NOT NULL REFERENCES jobs(id) ON DELETE CASCADE,
                                     question TEXT NOT NULL,
                                     answer TEXT,
                                     difficulty VARCHAR(20) DEFAULT 'MEDIUM',
                                     is_saved BOOLEAN DEFAULT FALSE,
                                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);